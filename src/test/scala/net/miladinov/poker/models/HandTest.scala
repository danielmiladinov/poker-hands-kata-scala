package net.miladinov.poker.models

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class HandTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {
  val inputsAndOutputs = Table(
    ("Hand String",           "Expected Hand"),
    ("Black: 2H 3D 5S 9C KD", Hand("Black", Set(Card("2H"), Card("3D"), Card("5S"), Card("9C"), Card("KD")))),
    ("Black: 2H 4S 4C 2D 4H", Hand("Black", Set(Card("2H"), Card("4S"), Card("4C"), Card("2D"), Card("4H")))),
    ("White: 2C 3H 4S 8C AH", Hand("White", Set(Card("2C"), Card("3H"), Card("4S"), Card("8C"), Card("AH")))),
    ("White: 2S 8S AS QS 3S", Hand("White", Set(Card("2S"), Card("8S"), Card("AS"), Card("QS"), Card("3S")))),
    ("White: 2C 3H 4S 8C KH", Hand("White", Set(Card("2C"), Card("3H"), Card("4S"), Card("8C"), Card("KH")))),
    ("White: 2D 3H 5C 9S KH", Hand("White", Set(Card("2D"), Card("3H"), Card("5C"), Card("9S"), Card("KH"))))
  )

  forAll (inputsAndOutputs) { (handString: String, expectedHand: Hand) => {
    s"Hand.apply($handString)" should s"return `$expectedHand`" in {
      Hand(handString) shouldEqual expectedHand
    }
  }}

  val handsAndValueGroupings = Table(
    ("Hand", "Grouped by Value"),

    (Hand("Player", Set(Card("2D"), Card("2C"), Card("2S"), Card("2H"), Card("AC"))), Map[(Value, Int), Set[Card]] (
      (Two, 4) -> Set(Card("2D"), Card("2C"), Card("2S"), Card("2H")),
      (Ace, 1) -> Set(Card("AC"))
    )),

    (Hand("Player", Set(Card("2H"), Card("3D"), Card("5S"), Card("9C"), Card("KD"))), Map[(Value, Int), Set[Card]] (
      (Two,   1) -> Set(Card("2H")),
      (Three, 1) -> Set(Card("3D")),
      (Five,  1) -> Set(Card("5S")),
      (Nine,  1) -> Set(Card("9C")),
      (King,  1) -> Set(Card("KD"))
    )),

    (Hand("Player", Set(Card("2D"), Card("2C"), Card("2S"), Card("KS"), Card("QD"))), Map[(Value, Int), Set[Card]] (
      (Two,   3) -> Set(Card("2D"), Card("2C"), Card("2S")),
      (King,  1) -> Set(Card("KS")),
      (Queen, 1) -> Set(Card("QD"))
    )),

    (Hand("Player", Set(Card("KD"), Card("KC"), Card("KS"), Card("AS"), Card("AD"))), Map[(Value, Int), Set[Card]] (
      (King, 3) -> Set(Card("KD"), Card("KC"), Card("KS")),
      (Ace,  2) -> Set(Card("AS"), Card("AD"))
    ))
  )

  forAll (handsAndValueGroupings) { (hand: Hand, expectedGrouping: Map[(Value, Int), Set[Card]]) => {
    s"$hand.cardsByValueWithCounts" should s"return `$expectedGrouping`" in {
      hand.cardsByValueWithCounts shouldEqual expectedGrouping
    }
  }}

  val handsAndSuitGroupings = Table(
    ("Hand", "Grouped by Suit"),

    (Hand("Player", Set(Card("2D"), Card("2C"), Card("2S"), Card("2H"), Card("AC"))), Map[(Suit, Int), Set[Card]] (
      (Clubs, 2)    -> Set(Card("2C"), Card("AC")),
      (Diamonds, 1) -> Set(Card("2D")),
      (Spades, 1)   -> Set(Card("2S")),
      (Hearts, 1)   -> Set(Card("2H"))
    )),

    (Hand("Player", Set(Card("3H"), Card("5H"), Card("7H"), Card("AC"), Card("QC"))), Map[(Suit, Int), Set[Card]] (
      (Hearts, 3) -> Set(Card("3H"), Card("5H"), Card("7H")),
      (Clubs, 2)  -> Set(Card("AC"), Card("QC"))
    )),

    (Hand("Player", Set(Card("AD"), Card("3D"), Card("4D"), Card("5D"), Card("6D"))), Map[(Suit, Int), Set[Card]] (
      (Diamonds, 5) -> Set(Card("AD"), Card("3D"), Card("4D"), Card("5D"), Card("6D"))
    ))
  )

  forAll (handsAndSuitGroupings) { (hand: Hand, expectedGrouping: Map[(Suit, Int), Set[Card]]) => {
    s"$hand.cardsBySuitWithCounts" should s"return `$expectedGrouping`" in {
      hand.cardsBySuitWithCounts shouldEqual expectedGrouping
    }
  }}
}
