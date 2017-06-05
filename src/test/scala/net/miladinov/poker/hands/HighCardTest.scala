package net.miladinov.poker.hands

import net.miladinov.poker.models.{Card, Hand}
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class HighCardTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {
  val highCards = Table(
    ("Label", "Valid High Card"),
    ("High Card: Ace",   Hand("Player", Set(Card("AD"), Card("3C"), Card("8H"), Card("JH"), Card("5S")))),
    ("High Card: King",  Hand("Player", Set(Card("2D"), Card("KC"), Card("8H"), Card("7S"), Card("5C")))),
    ("High Card: Queen", Hand("Player", Set(Card("7D"), Card("2C"), Card("QH"), Card("JD"), Card("5H")))),
    ("High Card: Jack",  Hand("Player", Set(Card("7D"), Card("2C"), Card("3S"), Card("JH"), Card("5D")))),
    ("High Card: Ten",   Hand("Player", Set(Card("TD"), Card("2C"), Card("3C"), Card("4C"), Card("5S")))),
    ("High Card: Nine",  Hand("Player", Set(Card("9S"), Card("2C"), Card("3H"), Card("4H"), Card("5H")))),
    ("High Card: Eight", Hand("Player", Set(Card("4S"), Card("2C"), Card("3D"), Card("8C"), Card("5C")))),
    ("High Card: Seven", Hand("Player", Set(Card("4S"), Card("7C"), Card("3S"), Card("6C"), Card("5D")))),
    ("High Card: Seven", Hand("Player", Set(Card("4S"), Card("7C"), Card("2D"), Card("6C"), Card("5S"))))
  )

  forAll (highCards) { (label: String, hand: Hand) => {
    label should s"be able to be evaluated from a `$hand`" in {
      HighCard.evaluate(hand) shouldEqual Some(label)
    }
  }}
}
