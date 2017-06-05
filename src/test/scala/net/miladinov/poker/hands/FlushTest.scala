package net.miladinov.poker.hands

import net.miladinov.poker.models.{Card, Hand}
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class FlushTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {

  val flushes = Table(
    ("Label",            "Valid Flush"),
    ("Seven-high Flush", Hand("Player", Set(Card("2S"), Card("3S"), Card("4S"), Card("5S"), Card("7S")))),
    ("Eight-high Flush", Hand("Player", Set(Card("8H"), Card("3H"), Card("4H"), Card("5H"), Card("7H")))),
    ("Nine-high Flush",  Hand("Player", Set(Card("8C"), Card("3C"), Card("9C"), Card("5C"), Card("7C")))),
    ("Ten-high Flush",   Hand("Player", Set(Card("8D"), Card("3D"), Card("9D"), Card("TD"), Card("7D")))),
    ("Jack-high Flush",  Hand("Player", Set(Card("8S"), Card("JS"), Card("9S"), Card("6S"), Card("7S")))),
    ("Queen-high Flush", Hand("Player", Set(Card("8H"), Card("6H"), Card("9H"), Card("TH"), Card("QH")))),
    ("King-high Flush",  Hand("Player", Set(Card("8C"), Card("JC"), Card("KC"), Card("TC"), Card("7C")))),
    ("Ace-high Flush",   Hand("Player", Set(Card("9D"), Card("TD"), Card("JD"), Card("AD"), Card("3D"))))
  )
  
  val notFlushes = Table(
    ("Label",                    "Invalid Flush"),
    ("Jacks and Threes",         Hand("Player", Set(Card("JH"), Card("JS"), Card("KC"), Card("3D"), Card("3H")))),
    ("Three Twos",               Hand("Player", Set(Card("2H"), Card("2S"), Card("3C"), Card("2D"), Card("KH")))),
    ("Eight-high Straight",      Hand("Player", Set(Card("4H"), Card("5S"), Card("6C"), Card("8D"), Card("7H")))),
    ("Jack-high Straight Flush", Hand("Player", Set(Card("9D"), Card("TD"), Card("JD"), Card("8D"), Card("7D")))),
    ("Five-high Straight Flush", Hand("Player", Set(Card("5S"), Card("4S"), Card("3S"), Card("2S"), Card("AS")))),
    ("Full House",               Hand("Player", Set(Card("TS"), Card("TH"), Card("TC"), Card("AD"), Card("AS")))),
    ("Four Jacks",               Hand("Player", Set(Card("JD"), Card("JC"), Card("JH"), Card("AC"), Card("JS"))))
  )
  
  forAll (flushes) { (label: String, hand: Hand) => {
    label should s"be able to be evaluated from a `$hand`" in {
      Flush.evaluate(hand) shouldEqual Some(label)
    }
  }}

  forAll (notFlushes) { (label: String, hand: Hand) => {
    label should s"should not be mistaken for a Flush from `$hand`" in {
      Flush.evaluate(hand) shouldEqual None
    }
  }}
}
