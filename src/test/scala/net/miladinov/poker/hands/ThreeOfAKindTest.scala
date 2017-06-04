package net.miladinov.poker.hands

import net.miladinov.poker.models.{Card, Hand}
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class ThreeOfAKindTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {

  val threesOfAKind = Table(
    ("Label",        "Valid Two of a Kind"),
    ("Three Twos",   Hand("Player", Set(Card("2H"), Card("2S"), Card("3C"), Card("2D"), Card("KH")))),
    ("Three Threes", Hand("Player", Set(Card("7H"), Card("3S"), Card("3C"), Card("2D"), Card("3H")))),
    ("Three Fours",  Hand("Player", Set(Card("2C"), Card("3C"), Card("4C"), Card("4S"), Card("4H")))),
    ("Three Fives",  Hand("Player", Set(Card("5C"), Card("5H"), Card("AC"), Card("5D"), Card("4H")))),
    ("Three Sixes",  Hand("Player", Set(Card("4H"), Card("6S"), Card("6C"), Card("8D"), Card("6H")))),
    ("Three Sevens", Hand("Player", Set(Card("7H"), Card("7S"), Card("7C"), Card("8D"), Card("6H")))),
    ("Three Eights", Hand("Player", Set(Card("8H"), Card("8S"), Card("6C"), Card("8D"), Card("2H")))),
    ("Three Nines",  Hand("Player", Set(Card("9D"), Card("9H"), Card("JS"), Card("AD"), Card("9C")))),
    ("Three Tens",   Hand("Player", Set(Card("TD"), Card("7H"), Card("TS"), Card("TC"), Card("9C")))),
    ("Three Jacks",  Hand("Player", Set(Card("JD"), Card("TC"), Card("JH"), Card("JC"), Card("6S")))),
    ("Three Queens", Hand("Player", Set(Card("QD"), Card("TC"), Card("QH"), Card("7C"), Card("QS")))),
    ("Three Kings",  Hand("Player", Set(Card("KD"), Card("KC"), Card("KH"), Card("JC"), Card("3D")))),
    ("Three Aces",   Hand("Player", Set(Card("AD"), Card("AH"), Card("KC"), Card("AS"), Card("4D"))))
  )

  val notThreesOfAKind = Table(
    ("Label",               "Invalid Three of a Kind"),
    ("Pair of Twos",        Hand("Player", Set(Card("2H"), Card("2S"), Card("3C"), Card("AD"), Card("KH")))),
    ("Eight-high Straight", Hand("Player", Set(Card("4H"), Card("5S"), Card("6C"), Card("8D"), Card("7H")))),
    ("Flush",               Hand("Player", Set(Card("9D"), Card("TD"), Card("JD"), Card("AD"), Card("3D")))),
    ("Full House",          Hand("Player", Set(Card("TS"), Card("TH"), Card("TC"), Card("AD"), Card("AS")))),
    ("Four Jacks",          Hand("Player", Set(Card("JD"), Card("JC"), Card("JH"), Card("AC"), Card("JS"))))
  )
  
  forAll (threesOfAKind) { (label: String, hand: Hand) => {
    label should s"be able to be evaluated from a `$hand`" in {
      ThreeOfAKind.evaluate(hand) shouldEqual Some(label)
    }
  }}

  forAll (notThreesOfAKind) { (label: String, hand: Hand) => {
    label should s"should not be mistaken for a ThreeOfAKind from `$hand`" in {
      ThreeOfAKind.evaluate(hand) shouldEqual None
    }
  }}
}
