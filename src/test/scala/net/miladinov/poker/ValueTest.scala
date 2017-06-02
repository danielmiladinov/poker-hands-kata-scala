package net.miladinov.poker

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class ValueTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {
  val values = Table(
    ("Int Value", "String Value", "Case Object"),
    (2, "2", Two),
    (3, "3", Three),
    (4, "4", Four),
    (5, "5", Five),
    (6, "6", Six),
    (7, "7", Seven),
    (8, "8", Eight),
    (9, "9", Nine),
    (10, "T", Ten),
    (11, "J", Jack),
    (12, "Q", Queen),
    (13, "K", King),
    (14, "A", Ace)
  )

  forAll (values) { (intValue: Int, stringValue: String, valueObject: Value) => {
    valueObject.toString should "be able to be applied from its string representation" in {
      Value(stringValue) shouldEqual valueObject
    }

    it should "be able to be applied from its int value" in {
      Value(intValue) shouldEqual valueObject
    }
  }}
}
