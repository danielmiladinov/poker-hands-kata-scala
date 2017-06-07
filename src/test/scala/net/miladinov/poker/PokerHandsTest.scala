package net.miladinov.poker

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class PokerHandsTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {
  val inputsAndExpectedOutputs = Table(
    ("Input",                                        "Expected Output"),
    ("Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH", "White wins, with High Card: Ace"),
    ("Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S", "Black wins, with Full House: Fours over Twos"),
    ("Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH", "Black wins, with High Card: Nine"),
    ("Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH", "Tie")
  )

  forAll (inputsAndExpectedOutputs) { (input: String, expectedOutput: String) => {
    it should s"produce the expected output of `$expectedOutput` when given input of `$input`" in {
      PokerHands.playGame(input) shouldEqual expectedOutput
    }
  }}
}
