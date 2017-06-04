package net.miladinov.poker.hands

import net.miladinov.poker.models.{Card, Hand}
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class TwoOfAKindTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {

  val twosOfAKind = Table(
    ("Label",          "Valid Two of a Kind"),
    ("Pair of Twos",   Hand("Player", Set(Card("2H"), Card("QS"), Card("3C"), Card("2D"), Card("KH")))),
    ("Pair of Threes", Hand("Player", Set(Card("7H"), Card("QS"), Card("3C"), Card("2D"), Card("3H")))),
    ("Pair of Fours",  Hand("Player", Set(Card("2C"), Card("3C"), Card("4C"), Card("5C"), Card("4H")))),
    ("Pair of Fives",  Hand("Player", Set(Card("2C"), Card("5H"), Card("AC"), Card("5C"), Card("4H")))),
    ("Pair of Sixes",  Hand("Player", Set(Card("4H"), Card("5S"), Card("6C"), Card("8D"), Card("6H")))),
    ("Pair of Sevens", Hand("Player", Set(Card("7H"), Card("5S"), Card("7C"), Card("8D"), Card("6H")))),
    ("Pair of Eights", Hand("Player", Set(Card("8H"), Card("5S"), Card("7C"), Card("8D"), Card("6H")))),
    ("Pair of Nines",  Hand("Player", Set(Card("9D"), Card("TH"), Card("JS"), Card("AD"), Card("9C")))),
    ("Pair of Tens",   Hand("Player", Set(Card("TD"), Card("7H"), Card("TS"), Card("AD"), Card("9C")))),
    ("Pair of Jacks",  Hand("Player", Set(Card("JD"), Card("TC"), Card("JH"), Card("8C"), Card("6S")))),
    ("Pair of Queens", Hand("Player", Set(Card("QD"), Card("TC"), Card("QH"), Card("7C"), Card("2S")))),
    ("Pair of Kings",  Hand("Player", Set(Card("QD"), Card("KC"), Card("KH"), Card("JC"), Card("3D")))),
    ("Pair of Aces",   Hand("Player", Set(Card("JD"), Card("AH"), Card("KC"), Card("AS"), Card("4D"))))
  )

  val notTwosOfAKind = Table(
    ("Label",            "Invalid Two of a Kind"),
    ("Jacks and Threes", Hand("Player", Set(Card("JH"), Card("JS"), Card("KC"), Card("3D"), Card("3H")))),
    ("Three Twos",       Hand("Player", Set(Card("2H"), Card("2S"), Card("3C"), Card("2D"), Card("KH")))),
    ("Straight",         Hand("Player", Set(Card("4H"), Card("5S"), Card("6C"), Card("8D"), Card("7H")))),
    ("Flush",            Hand("Player", Set(Card("9D"), Card("TD"), Card("JD"), Card("AD"), Card("3D")))),
    ("Full House",       Hand("Player", Set(Card("TS"), Card("TH"), Card("TC"), Card("AD"), Card("AS")))),
    ("Four Jacks",       Hand("Player", Set(Card("JD"), Card("JC"), Card("JH"), Card("AC"), Card("JS"))))
  )

  forAll (twosOfAKind) { (label: String, hand: Hand) => {
    label should s"be able to be evaluated from a `$hand`" in {
      TwoOfAKind.evaluate(hand) shouldEqual Some(label)
    }
  }}

  forAll (notTwosOfAKind) { (label: String, hand: Hand) => {
    label should s"should not be mistaken for a TwoOfAKind from `$hand`" in {
      TwoOfAKind.evaluate(hand) shouldEqual None
    }
  }}
}
