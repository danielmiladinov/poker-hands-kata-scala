package net.miladinov.poker.models

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class SuitTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {
  val suits = Table(
    ("Letter", "String",   "Object"),
    ("D",      "Diamonds", Diamonds),
    ("C",      "Clubs",    Clubs),
    ("H",      "Hearts",   Hearts),
    ("S",      "Spades",   Spades)
  )

  forAll (suits) { (letterValue: String, stringValue: String, objValue: Suit) => {
    stringValue should "be able to be applied from its letter value" in {
      Suit(letterValue) shouldEqual objValue
    }

    it should "have a correct string representation" in {
      objValue.toString shouldEqual stringValue
    }
  }}
}
