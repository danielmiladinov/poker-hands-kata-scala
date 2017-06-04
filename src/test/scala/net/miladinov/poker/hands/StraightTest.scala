package net.miladinov.poker.hands

import net.miladinov.poker.models.{Card, Hand}
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class StraightTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {

  val straights = Table(
    ("Label", "Valid Straight"),
    ("Five-high Straight",  Hand("Player", Set(Card("5S"), Card("AH"), Card("3C"), Card("4D"), Card("2S")))),
    ("Six-high Straight",   Hand("Player", Set(Card("5H"), Card("6C"), Card("3D"), Card("4S"), Card("2H")))),
    ("Seven-high Straight", Hand("Player", Set(Card("5C"), Card("6D"), Card("3S"), Card("4H"), Card("7C")))),
    ("Eight-high Straight", Hand("Player", Set(Card("5D"), Card("6S"), Card("8H"), Card("4C"), Card("7D")))),
    ("Nine-high Straight",  Hand("Player", Set(Card("5S"), Card("6H"), Card("8C"), Card("9D"), Card("7S")))),
    ("Ten-high Straight",   Hand("Player", Set(Card("TH"), Card("6C"), Card("8D"), Card("9S"), Card("7H")))),
    ("Jack-high Straight",  Hand("Player", Set(Card("TC"), Card("JD"), Card("8S"), Card("9H"), Card("7C")))),
    ("Queen-high Straight", Hand("Player", Set(Card("TD"), Card("JS"), Card("8H"), Card("9C"), Card("QD")))),
    ("King-high Straight",  Hand("Player", Set(Card("TS"), Card("JH"), Card("KC"), Card("9D"), Card("QS")))),
    ("Ace-high Straight",   Hand("Player", Set(Card("TH"), Card("JC"), Card("KD"), Card("AS"), Card("QH"))))
  )
  
  val notStraights = Table(
    ("Label",                     "Invalid Straight"),
    ("Three Twos",                Hand("Player", Set(Card("2H"), Card("2S"), Card("3C"), Card("2D"), Card("KH")))),
    ("Eight-high Straight Flush", Hand("Player", Set(Card("4H"), Card("5H"), Card("6H"), Card("8H"), Card("7H")))),
    ("Royal Flush",               Hand("Player", Set(Card("TC"), Card("AC"), Card("QC"), Card("JC"), Card("KC")))),
    ("Flush",                     Hand("Player", Set(Card("9D"), Card("TD"), Card("JD"), Card("AD"), Card("3D")))),
    ("Full House",                Hand("Player", Set(Card("TS"), Card("TH"), Card("TC"), Card("AD"), Card("AS")))),
    ("Four Jacks",                Hand("Player", Set(Card("JD"), Card("JC"), Card("JH"), Card("AC"), Card("JS"))))
  )
  
  forAll (straights) { (label: String, hand: Hand) => {
    label should s"be able to be evaluated from a `$hand`" in {
      Straight.evaluate(hand) shouldEqual Some(label)
    }
  }}
  
  forAll (notStraights) { (label: String, hand: Hand) => {
    label should s"not be mistaken for a Straight from `$hand`" in {
      Straight.evaluate(hand) shouldEqual None
    }
  }}
}
