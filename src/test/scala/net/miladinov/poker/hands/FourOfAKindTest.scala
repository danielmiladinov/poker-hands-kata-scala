package net.miladinov.poker.hands

import net.miladinov.poker.models.{Card, Hand}
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class FourOfAKindTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {

  val foursOfAKind = Table(
    ("Label",        "Valid Two of a Kind"),
    ("Four Twos",   Hand("Player", Set(Card("2H"), Card("2S"), Card("3C"), Card("2C"), Card("2D")))),
    ("Four Threes", Hand("Player", Set(Card("7H"), Card("3S"), Card("3C"), Card("3D"), Card("3H")))),
    ("Four Fours",  Hand("Player", Set(Card("4D"), Card("3C"), Card("4C"), Card("4S"), Card("4H")))),
    ("Four Fives",  Hand("Player", Set(Card("5C"), Card("5H"), Card("AC"), Card("5D"), Card("5S")))),
    ("Four Sixes",  Hand("Player", Set(Card("4H"), Card("6S"), Card("6C"), Card("6D"), Card("6H")))),
    ("Four Sevens", Hand("Player", Set(Card("7H"), Card("7S"), Card("7C"), Card("7D"), Card("5C")))),
    ("Four Eights", Hand("Player", Set(Card("8H"), Card("8S"), Card("8C"), Card("8D"), Card("2H")))),
    ("Four Nines",  Hand("Player", Set(Card("9D"), Card("9H"), Card("9S"), Card("AD"), Card("9C")))),
    ("Four Tens",   Hand("Player", Set(Card("TD"), Card("7H"), Card("TS"), Card("TC"), Card("TH")))),
    ("Four Jacks",  Hand("Player", Set(Card("JD"), Card("JH"), Card("JS"), Card("JC"), Card("6S")))),
    ("Four Queens", Hand("Player", Set(Card("QD"), Card("QC"), Card("QH"), Card("7C"), Card("QS")))),
    ("Four Kings",  Hand("Player", Set(Card("KD"), Card("KC"), Card("KH"), Card("KS"), Card("3D")))),
    ("Four Aces",   Hand("Player", Set(Card("AD"), Card("AH"), Card("AC"), Card("AS"), Card("4D"))))
  )

  val notFoursOfAKind = Table(
    ("Label",        "Invalid Three of a Kind"),
    ("Pair of Twos", Hand("Player", Set(Card("2H"), Card("2S"), Card("3C"), Card("AD"), Card("KH")))),
    ("Straight",     Hand("Player", Set(Card("4H"), Card("5S"), Card("6C"), Card("8D"), Card("7H")))),
    ("Flush",        Hand("Player", Set(Card("9D"), Card("TD"), Card("JD"), Card("AD"), Card("3D")))),
    ("Full House",   Hand("Player", Set(Card("TS"), Card("TH"), Card("TC"), Card("AD"), Card("AS"))))
  )
  
  forAll (foursOfAKind) { (label: String, hand: Hand) => {
    label should s"be able to be evaluated from a `$hand`" in {
      FourOfAKind.evaluate(hand) shouldEqual Some(label)
    }
  }}

  forAll (notFoursOfAKind) { (label: String, hand: Hand) => {
    label should s"should not be mistaken for a FourOfAKind from `$hand`" in {
      FourOfAKind.evaluate(hand) shouldEqual None
    }
  }}
}
