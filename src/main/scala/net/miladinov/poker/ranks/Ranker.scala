package net.miladinov.poker.ranks

import net.miladinov.poker.hands._
import net.miladinov.poker.models.{Card, Hand, Value}

object Ranker {
  val specs: List[HandSpec] = List(
    RoyalFlush,
    StraightFlush,
    FourOfAKind,
    FullHouse,
    Flush,
    Straight,
    ThreeOfAKind,
    TwoPair,
    TwoOfAKind,
    HighCard
  )

  private case class Identified (hand: Hand, title: String, rank: Int)

  def rank (hand1: Hand, hand2: Hand): Outcome = {
    val id1 = identify(hand1).get
    val id2 = identify(hand2).get

    if (id1.rank == id2.rank) {
      rankHighCards(id1, id2)
    } else {
      if (id1.rank > id2.rank) {
        Winner(hand1, id1.title)
      } else {
        Winner(hand2, id2.title)
      }
    }
  }

  private def identify (hand: Hand): Option[Identified] = {
    def firstSatisfiedSpec (hss: List[HandSpec]): Option[Identified] = hss match {
      case spec :: rest =>
        spec.evaluate(hand)
          .map(title => Identified(hand, title, spec.rank))
          .orElse(firstSatisfiedSpec(rest))

      case Nil => None // Should never get here, HighCard identifies all hands
    }
    firstSatisfiedSpec(specs)
  }

  private def rankHighCards (id1: Identified, id2: Identified): Outcome = {
    val hand1 = id1.hand
    val hand2 = id2.hand

    val hand1CardsDescending = hand1.cards.toList.sortBy(_.value.intValue)(Ordering[Int].reverse)
    val hand2CardsDescending = hand2.cards.toList.sortBy(_.value.intValue)(Ordering[Int].reverse)

    val zipped = hand1CardsDescending.zip(hand2CardsDescending)

    zipped.dropWhile({ case (card1, card2) => card1.value == card2.value }) match {
      case (Card(value1, _), Card(value2, _)) :: _ =>
        if (value1.intValue > value2.intValue)
          Winner(hand1, chooseTitle(id1, value1))
        else
          Winner(hand2, chooseTitle(id2, value2))
      case Nil => Tie
    }
  }

  private def chooseTitle (id: Identified, v: Value): String =
    if (id.rank == HighCard.rank) s"High Card: ${v.singular}" else id.title
}
