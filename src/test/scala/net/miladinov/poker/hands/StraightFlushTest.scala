package net.miladinov.poker.hands

import net.miladinov.poker.models.{Card, Hand}
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class StraightFlushTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {
  val straightFlushes = Table(
    ("Label",                     "Valid Straight Flush"),
    ("Five-high Straight Flush",  Hand("Player", Set(Card("AS"), Card("2S"), Card("3S"), Card("4S"), Card("5S")))),
    ("Six-high Straight Flush",   Hand("Player", Set(Card("6H"), Card("2H"), Card("3H"), Card("4H"), Card("5H")))),
    ("Seven-high Straight Flush", Hand("Player", Set(Card("6C"), Card("7C"), Card("3C"), Card("4C"), Card("5C")))),
    ("Eight-high Straight Flush", Hand("Player", Set(Card("6D"), Card("7D"), Card("8D"), Card("4D"), Card("5D")))),
    ("Nine-high Straight Flush",  Hand("Player", Set(Card("6S"), Card("7S"), Card("8S"), Card("9S"), Card("5S")))),
    ("Ten-high Straight Flush",   Hand("Player", Set(Card("6H"), Card("7H"), Card("8H"), Card("9H"), Card("TH")))),
    ("Jack-high Straight Flush",  Hand("Player", Set(Card("JC"), Card("7C"), Card("8C"), Card("9C"), Card("TC")))),
    ("Queen-high Straight Flush", Hand("Player", Set(Card("JD"), Card("QD"), Card("8D"), Card("9D"), Card("TD")))),
    ("King-high Straight Flush",  Hand("Player", Set(Card("JS"), Card("QS"), Card("KS"), Card("9S"), Card("TS"))))
  )

  val notStraightFlushes = Table(
    ("Label",               "Invalid Straight Flush"),
    ("Jacks and Threes",    Hand("Player", Set(Card("JH"), Card("JS"), Card("KC"), Card("3D"), Card("3H")))),
    ("Three Twos",          Hand("Player", Set(Card("2H"), Card("2S"), Card("3C"), Card("2D"), Card("KH")))),
    ("Eight-high Straight", Hand("Player", Set(Card("4H"), Card("5S"), Card("6C"), Card("8D"), Card("7H")))),
    ("Royal Flush",         Hand("Player", Set(Card("AS"), Card("KS"), Card("QS"), Card("JS"), Card("TS")))),
    ("Full House",          Hand("Player", Set(Card("TS"), Card("TH"), Card("TC"), Card("AD"), Card("AS")))),
    ("Four Jacks",          Hand("Player", Set(Card("JD"), Card("JC"), Card("JH"), Card("AC"), Card("JS"))))
  )
  
  forAll (straightFlushes) { (label: String, hand: Hand) => {
    label should s"be able to be evaluated from a `$hand`" in {
      StraightFlush.evaluate(hand) shouldEqual Some(label)
    }
  }}

  forAll (notStraightFlushes) { (label: String, hand: Hand) => {
    label should s"should not be mistaken for a Straight Flush from `$hand`" in {
      StraightFlush.evaluate(hand) shouldEqual None
    }
  }}
}
