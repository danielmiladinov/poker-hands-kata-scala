package net.miladinov.poker.models

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class ValueTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {
  val values = Table(
    ("Int Value", "String Value", "Case Object", "Singular Name", "Plural Name"),
    (2,           "2",            Two,           "Two",           "Twos"),
    (3,           "3",            Three,         "Three",         "Threes"),
    (4,           "4",            Four,          "Four",          "Fours"),
    (5,           "5",            Five,          "Five",          "Fives"),
    (6,           "6",            Six,           "Six",           "Sixes"),
    (7,           "7",            Seven,         "Seven",         "Sevens"),
    (8,           "8",            Eight,         "Eight",         "Eights"),
    (9,           "9",            Nine,          "Nine",          "Nines"),
    (10,          "T",            Ten,           "Ten",           "Tens"),
    (11,          "J",            Jack,          "Jack",          "Jacks"),
    (12,          "Q",            Queen,         "Queen",         "Queens"),
    (13,          "K",            King,          "King",          "Kings"),
    (14,          "A",            Ace,           "Ace",           "Aces")
  )

  forAll (values) { (intValue: Int, stringValue: String, valueObject: Value, singularName: String, pluralName: String) => {
    valueObject.toString should "be able to be applied from its string representation" in {
      Value(stringValue) shouldEqual valueObject
    }

    it should "be able to be applied from its int value" in {
      Value(intValue) shouldEqual valueObject
    }

    it should "know its singular name" in {
      valueObject.singular shouldEqual singularName
    }

    it should "know its plural name" in {
      valueObject.plural shouldEqual pluralName
    }
  }}
}
