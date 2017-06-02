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
    s"Hand string `$handString`" should s"be able to be applied to produce Hand object `$expectedHand`" in {
      Hand(handString) shouldEqual expectedHand
    }
  }}
}
