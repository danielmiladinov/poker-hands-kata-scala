package net.miladinov.poker.hands

import net.miladinov.poker.models._

object Straight {
  def evaluate (hand: Hand): Option[String] = {
    val sorted = hand.cards.toList.sortBy(_.value.intValue)

    sorted match {
      case
        Card(_, suit1) ::
        Card(_, suit2) ::
        Card(_, suit3) ::
        Card(_, suit4) ::
        Card(_, suit5) :: Nil if Set(suit1, suit2, suit3, suit4, suit5).size == 1 => None

      case
        Card(Two,   _) ::
        Card(Three, _) ::
        Card(Four,  _) ::
        Card(Five,  _) ::
        Card(Ace,   _) :: Nil => Some(buildTitle(Five))

      case
        Card(val1, _) ::
        Card(val2, _) ::
        Card(val3, _) ::
        Card(val4, _) ::
        Card(val5, _) :: Nil if monotonicallyAscending(val1, val2, val3, val4, val5) => Some(buildTitle(val5))

      case _ => None
    }
  }

  private def buildTitle (v: Value): String = s"${v.singular}-high Straight"

  private def monotonicallyAscending (sortedValues: Value*): Boolean = sortedValues.sliding(2).forall({
    case Seq(lesser, greater) => (greater.intValue - 1) == lesser.intValue
    case _ => false
  })
}
