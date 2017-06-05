package net.miladinov.poker.hands

import net.miladinov.poker.models.{Card, Hand}
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class RoyalFlushTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {
  val royalFlushes = Table(
    ("Label",       "Valid Royal Flush"),
    ("Royal Flush", Hand("Player", Set(Card("AS"), Card("KS"), Card("QS"), Card("JS"), Card("TS")))),
    ("Royal Flush", Hand("Player", Set(Card("AH"), Card("KH"), Card("QH"), Card("JH"), Card("TH")))),
    ("Royal Flush", Hand("Player", Set(Card("AC"), Card("KC"), Card("QC"), Card("JC"), Card("TC")))),
    ("Royal Flush", Hand("Player", Set(Card("AD"), Card("KD"), Card("QD"), Card("JD"), Card("TD"))))
  )
  
  val notRoyalFlushes = Table(
    ("Label",               "Invalid Royal Flush"),
    ("Jacks and Threes",    Hand("Player", Set(Card("JH"), Card("JS"), Card("KC"), Card("3D"), Card("3H")))),
    ("Three Twos",          Hand("Player", Set(Card("2H"), Card("2S"), Card("3C"), Card("2D"), Card("KH")))),
    ("Eight-high Straight", Hand("Player", Set(Card("4H"), Card("5S"), Card("6C"), Card("8D"), Card("7H")))),
    ("Full House",          Hand("Player", Set(Card("TS"), Card("TH"), Card("TC"), Card("AD"), Card("AS")))),
    ("Four Jacks",          Hand("Player", Set(Card("JD"), Card("JC"), Card("JH"), Card("AC"), Card("JS"))))
  )
  
  forAll (royalFlushes) { (label: String, hand: Hand) => {
    label should s"be able to be evaluated from a `$hand`" in {
      RoyalFlush.evaluate(hand) shouldEqual Some(label)
    }
  }}

  forAll (notRoyalFlushes) { (label: String, hand: Hand) => {
    label should s"should not be mistaken for a Royal Flush from `$hand`" in {
      RoyalFlush.evaluate(hand) shouldEqual None
    }
  }}
}
