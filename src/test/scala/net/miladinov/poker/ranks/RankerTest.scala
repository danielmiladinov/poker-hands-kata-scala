package net.miladinov.poker.ranks

import net.miladinov.poker.hands._
import net.miladinov.poker.models._
import org.scalatest.prop.{TableDrivenPropertyChecks, TableFor2, TableFor4}
import org.scalatest.{FlatSpec, Matchers}

import scala.util.Random

class RankerTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {
  type Player = String
  type HandTitle = String
  type Cards = Set[Card]
  type ExpectedHand = (Player, Cards, HandTitle)
  type OutcomeSelector = (ExpectedHand, ExpectedHand) => Outcome

  val player1: OutcomeSelector = (w: ExpectedHand, _: ExpectedHand) => Winner(Hand(w._1, w._2), w._3)
  val player2: OutcomeSelector = (_: ExpectedHand, w: ExpectedHand) => Winner(Hand(w._1, w._2), w._3)
  val tie: OutcomeSelector = (_: ExpectedHand, _: ExpectedHand) => Tie

  val random = new Random

  val scenarios: TableFor4[String, ExpectedHand, ExpectedHand, OutcomeSelector] = Table(
    ("Title",                                "First Hand",                  "Second Hand",                 "Expected Outcome"),
    ("Two Royal Flushes",                    aRoyalFlush("P1"),             aRoyalFlush("P2"),             tie),
    ("Royal Flush vs. Straight Flush",       aRoyalFlush("P1"),             aStraightFlush("P2"),          player1),
    ("Straight Flush vs. Royal Flush",       aStraightFlush("P1"),          aRoyalFlush("P2"),             player2),

    ("Two Straight Flushes: King vs. King",  straightFlush(King)("P1"),     straightFlush(King) ("P2"),    tie),
    ("Two Straight Flushes: Nine vs. Ten",   straightFlush(Nine)("P1"),     straightFlush(Ten)  ("P2"),    player2),
    ("Two Straight Flushes: Jack vs. Eight", straightFlush(Jack)("P1"),     straightFlush(Eight)("P2"),    player1),

    ("Two High Cards: P2 Wins on Last Card", aHand("KS TC 7C 6D 3H")("P1"), aHand("KD TD 7S 6H 4H")("P2"), player2(winsWith = "High Card: Four")),
    ("Two High Cards: P1 Wins on Last Card", aHand("KD 9S 7H 4C 3D")("P1"), aHand("KS 9H 7C 4D 2S")("P2"), player1(winsWith = "High Card: Three")),
    ("Two High Cards: Absolute Tie",         aHand("KD 9C 7D 4S 2H")("P1"), aHand("KC 9D 7S 4H 2C")("P2"), tie)
  )

  forAll (scenarios) { (title: String, eh1: ExpectedHand, eh2: ExpectedHand, selector: OutcomeSelector) => {
    val expectedOutcome: Outcome = selector(eh1, eh2)
    val hand1 = Hand(eh1._1, eh1._2)
    val hand2 = Hand(eh2._1, eh2._2)

    s"$title, `$hand1` against `$hand2`" should s"have an outcome of `$expectedOutcome`" in {
      val actualOutcome = Ranker.rank(hand1, hand2)
      actualOutcome shouldEqual expectedOutcome
    }
  }}

  private def aRoyalFlush (playerName: Player): ExpectedHand =
    randomHandFrom(new RoyalFlushTest().royalFlushes)(playerName)

  private def aStraightFlush (playerName: Player): ExpectedHand =
    randomHandFrom(new StraightFlushTest().straightFlushes)(playerName)

  private def aHand (cardString: String) (player: Player, handTitle: HandTitle = "HighCard"): ExpectedHand = {
    val hand: Hand = Hand(s"$player: $cardString")
    (hand.player, hand.cards, handTitle)
  }

  private def straightFlush (highCard: Value) (playerName: Player): ExpectedHand =
    handFrom(new StraightFlushTest().straightFlushes)(highCard)(playerName)

  private def randomHandFrom (hands: TableFor2[String, Hand]) (playerName: Player): ExpectedHand = {
    val expected = hands(random.nextInt(hands.size))
    (playerName, expected._2.cards, expected._1)
  }

  private def handFrom (hands: TableFor2[String, Hand]) (highCard: Value) (playerName: Player): ExpectedHand = {
    val expected = hands.filter({ case (label, _) => label.contains(highCard.singular) }).head
    (playerName, expected._2.cards, expected._1)
  }

  private def player1 (winsWith: HandTitle): OutcomeSelector =
    (w: ExpectedHand, _: ExpectedHand) => Winner(Hand(w._1, w._2), winsWith)

  private def player2 (winsWith: HandTitle): OutcomeSelector =
    (_: ExpectedHand, w: ExpectedHand) => Winner(Hand(w._1, w._2), winsWith)
}
