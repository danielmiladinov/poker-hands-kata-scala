package net.miladinov.poker.hands

import net.miladinov.poker.models.{Card, Hand}
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks

class TwoPairTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {

  val twoPairs = Table(
    ("Label",        "Valid Two of a Kind"),
    ("Threes and Twos",   Hand("Player", Set(Card("3C"), Card("3H"), Card("AH"), Card("2C"), Card("2D")))),
    
    ("Fours and Twos",    Hand("Player", Set(Card("4D"), Card("4S"), Card("3H"), Card("2H"), Card("2C")))),
    ("Fours and Threes",  Hand("Player", Set(Card("4D"), Card("4S"), Card("3H"), Card("3C"), Card("7D")))),
    
    ("Fives and Twos",    Hand("Player", Set(Card("5S"), Card("2C"), Card("2D"), Card("5C"), Card("4H")))),
    ("Fives and Threes",  Hand("Player", Set(Card("5S"), Card("3H"), Card("3S"), Card("5C"), Card("4H")))),
    ("Fives and Fours",   Hand("Player", Set(Card("5S"), Card("3C"), Card("4C"), Card("5C"), Card("4H")))),
    
    ("Sixes and Twos",    Hand("Player", Set(Card("6S"), Card("6C"), Card("2C"), Card("5C"), Card("2H")))),
    ("Sixes and Threes",  Hand("Player", Set(Card("6S"), Card("6C"), Card("3C"), Card("3D"), Card("2H")))),
    ("Sixes and Fours",   Hand("Player", Set(Card("6S"), Card("6C"), Card("3C"), Card("4C"), Card("4H")))),
    ("Sixes and Fives",   Hand("Player", Set(Card("6S"), Card("6C"), Card("5H"), Card("5C"), Card("4D")))),

    ("Sevens and Twos",   Hand("Player", Set(Card("7H"), Card("7S"), Card("2C"), Card("2D"), Card("3H")))),
    ("Sevens and Threes", Hand("Player", Set(Card("7H"), Card("7S"), Card("3C"), Card("2D"), Card("3H")))),
    ("Sevens and Fours",  Hand("Player", Set(Card("7H"), Card("7S"), Card("4C"), Card("2D"), Card("4H")))),
    ("Sevens and Fives",  Hand("Player", Set(Card("7H"), Card("7S"), Card("5C"), Card("5D"), Card("4H")))),
    ("Sevens and Sixes",  Hand("Player", Set(Card("7H"), Card("7S"), Card("5C"), Card("6D"), Card("6H")))),

    ("Eights and Twos",   Hand("Player", Set(Card("8H"), Card("8S"), Card("2C"), Card("2D"), Card("3H")))),
    ("Eights and Threes", Hand("Player", Set(Card("8H"), Card("8S"), Card("3C"), Card("2D"), Card("3H")))),
    ("Eights and Fours",  Hand("Player", Set(Card("8H"), Card("8S"), Card("4C"), Card("2D"), Card("4H")))),
    ("Eights and Fives",  Hand("Player", Set(Card("8H"), Card("8S"), Card("5C"), Card("5D"), Card("4H")))),
    ("Eights and Sixes",  Hand("Player", Set(Card("8H"), Card("8S"), Card("5C"), Card("6D"), Card("6H")))),
    ("Eights and Sevens", Hand("Player", Set(Card("8H"), Card("8S"), Card("5C"), Card("7D"), Card("7H")))),

    ("Nines and Twos",    Hand("Player", Set(Card("9H"), Card("9S"), Card("2C"), Card("2D"), Card("3H")))),
    ("Nines and Threes",  Hand("Player", Set(Card("9H"), Card("9S"), Card("3C"), Card("2D"), Card("3H")))),
    ("Nines and Fours",   Hand("Player", Set(Card("9H"), Card("9S"), Card("4C"), Card("2D"), Card("4H")))),
    ("Nines and Fives",   Hand("Player", Set(Card("9H"), Card("9S"), Card("5C"), Card("5D"), Card("4H")))),
    ("Nines and Sixes",   Hand("Player", Set(Card("9H"), Card("9S"), Card("5C"), Card("6D"), Card("6H")))),
    ("Nines and Sevens",  Hand("Player", Set(Card("9H"), Card("9S"), Card("5C"), Card("7D"), Card("7H")))),
    ("Nines and Eights",  Hand("Player", Set(Card("9H"), Card("9S"), Card("8C"), Card("8D"), Card("6H")))),

    ("Tens and Twos",     Hand("Player", Set(Card("TH"), Card("TS"), Card("2C"), Card("2D"), Card("3H")))),
    ("Tens and Threes",   Hand("Player", Set(Card("TH"), Card("TS"), Card("3C"), Card("2D"), Card("3H")))),
    ("Tens and Fours",    Hand("Player", Set(Card("TH"), Card("TS"), Card("4C"), Card("2D"), Card("4H")))),
    ("Tens and Fives",    Hand("Player", Set(Card("TH"), Card("TS"), Card("5C"), Card("5D"), Card("4H")))),
    ("Tens and Sixes",    Hand("Player", Set(Card("TH"), Card("TS"), Card("6C"), Card("8D"), Card("6H")))),
    ("Tens and Sevens",   Hand("Player", Set(Card("TH"), Card("TS"), Card("5C"), Card("7D"), Card("7H")))),
    ("Tens and Eights",   Hand("Player", Set(Card("TH"), Card("TS"), Card("8C"), Card("8D"), Card("6H")))),
    ("Tens and Nines",    Hand("Player", Set(Card("TD"), Card("TH"), Card("7S"), Card("9D"), Card("9C")))),

    ("Jacks and Twos",    Hand("Player", Set(Card("JH"), Card("JS"), Card("2C"), Card("2D"), Card("3H")))),
    ("Jacks and Threes",  Hand("Player", Set(Card("JH"), Card("JS"), Card("3C"), Card("2D"), Card("3H")))),
    ("Jacks and Fours",   Hand("Player", Set(Card("JH"), Card("JS"), Card("4C"), Card("2D"), Card("4H")))),
    ("Jacks and Fives",   Hand("Player", Set(Card("JH"), Card("JS"), Card("5C"), Card("5D"), Card("4H")))),
    ("Jacks and Sixes",   Hand("Player", Set(Card("JH"), Card("JS"), Card("6C"), Card("8D"), Card("6H")))),
    ("Jacks and Sevens",  Hand("Player", Set(Card("JH"), Card("JS"), Card("7C"), Card("2D"), Card("7H")))),
    ("Jacks and Eights",  Hand("Player", Set(Card("JH"), Card("JS"), Card("8C"), Card("8D"), Card("6H")))),
    ("Jacks and Nines",   Hand("Player", Set(Card("JD"), Card("JH"), Card("TS"), Card("9D"), Card("9C")))),
    ("Jacks and Tens",    Hand("Player", Set(Card("JD"), Card("JH"), Card("TS"), Card("TD"), Card("9C")))),
    
    ("Queens and Twos",   Hand("Player", Set(Card("QH"), Card("QS"), Card("2C"), Card("2D"), Card("KH")))),
    ("Queens and Threes", Hand("Player", Set(Card("QH"), Card("QS"), Card("3C"), Card("2D"), Card("3H")))),
    ("Queens and Fours",  Hand("Player", Set(Card("QH"), Card("QS"), Card("4C"), Card("2D"), Card("4H")))),
    ("Queens and Fives",  Hand("Player", Set(Card("QH"), Card("QS"), Card("5C"), Card("5D"), Card("4H")))),
    ("Queens and Sixes",  Hand("Player", Set(Card("QH"), Card("QS"), Card("6C"), Card("8D"), Card("6H")))),
    ("Queens and Sevens", Hand("Player", Set(Card("QH"), Card("QS"), Card("7C"), Card("2D"), Card("7H")))),
    ("Queens and Eights", Hand("Player", Set(Card("QH"), Card("QS"), Card("8C"), Card("8D"), Card("6H")))),
    ("Queens and Nines",  Hand("Player", Set(Card("QD"), Card("QH"), Card("TS"), Card("9D"), Card("9C")))),
    ("Queens and Tens",   Hand("Player", Set(Card("QD"), Card("QH"), Card("TS"), Card("TD"), Card("9C")))),
    ("Queens and Jacks",  Hand("Player", Set(Card("QD"), Card("QH"), Card("TS"), Card("JD"), Card("JC")))),

    ("Kings and Twos",    Hand("Player", Set(Card("KH"), Card("KS"), Card("2C"), Card("2D"), Card("3H")))),
    ("Kings and Threes",  Hand("Player", Set(Card("KH"), Card("KS"), Card("3C"), Card("2D"), Card("3H")))),
    ("Kings and Fours",   Hand("Player", Set(Card("KH"), Card("KS"), Card("4C"), Card("2D"), Card("4H")))),
    ("Kings and Fives",   Hand("Player", Set(Card("KH"), Card("KS"), Card("5C"), Card("5D"), Card("4H")))),
    ("Kings and Sixes",   Hand("Player", Set(Card("KH"), Card("KS"), Card("6C"), Card("8D"), Card("6H")))),
    ("Kings and Sevens",  Hand("Player", Set(Card("KH"), Card("KS"), Card("7C"), Card("2D"), Card("7H")))),
    ("Kings and Eights",  Hand("Player", Set(Card("KH"), Card("KS"), Card("8C"), Card("8D"), Card("6H")))),
    ("Kings and Nines",   Hand("Player", Set(Card("KD"), Card("KH"), Card("TS"), Card("9D"), Card("9C")))),
    ("Kings and Tens",    Hand("Player", Set(Card("KD"), Card("KH"), Card("TS"), Card("TD"), Card("9C")))),
    ("Kings and Jacks",   Hand("Player", Set(Card("KD"), Card("KC"), Card("JH"), Card("JC"), Card("7S")))),
    ("Kings and Queens",  Hand("Player", Set(Card("KD"), Card("KC"), Card("QH"), Card("TC"), Card("QD")))),

    ("Aces and Twos",     Hand("Player", Set(Card("AH"), Card("AS"), Card("2C"), Card("2D"), Card("3H")))),
    ("Aces and Threes",   Hand("Player", Set(Card("AH"), Card("AS"), Card("3C"), Card("2D"), Card("3H")))),
    ("Aces and Fours",    Hand("Player", Set(Card("AH"), Card("AS"), Card("4C"), Card("2D"), Card("4H")))),
    ("Aces and Fives",    Hand("Player", Set(Card("AH"), Card("AS"), Card("5C"), Card("5D"), Card("4H")))),
    ("Aces and Sixes",    Hand("Player", Set(Card("AH"), Card("AS"), Card("6C"), Card("8D"), Card("6H")))),
    ("Aces and Sevens",   Hand("Player", Set(Card("AH"), Card("AS"), Card("7C"), Card("2D"), Card("7H")))),
    ("Aces and Eights",   Hand("Player", Set(Card("AH"), Card("AS"), Card("8C"), Card("8D"), Card("6H")))),
    ("Aces and Nines",    Hand("Player", Set(Card("AD"), Card("AH"), Card("TS"), Card("9D"), Card("9C")))),
    ("Aces and Tens",     Hand("Player", Set(Card("AD"), Card("AH"), Card("TS"), Card("TD"), Card("9C")))),
    ("Aces and Jacks",    Hand("Player", Set(Card("AD"), Card("AC"), Card("JH"), Card("JC"), Card("7S")))),
    ("Aces and Queens",   Hand("Player", Set(Card("AD"), Card("AC"), Card("QH"), Card("TC"), Card("QS")))),
    ("Aces and Kings",    Hand("Player", Set(Card("AD"), Card("AC"), Card("KH"), Card("2C"), Card("KD"))))
  )
  
  val notTwoPairs = Table(
    ("Label",      "Invalid Two of a Kind"),
    ("Three Twos", Hand("Player", Set(Card("2H"), Card("2S"), Card("3C"), Card("2D"), Card("KH")))),
    ("Straight",   Hand("Player", Set(Card("4H"), Card("5S"), Card("6C"), Card("8D"), Card("7H")))),
    ("Flush",      Hand("Player", Set(Card("9D"), Card("TD"), Card("JD"), Card("AD"), Card("3D")))),
    ("Full House", Hand("Player", Set(Card("TS"), Card("TH"), Card("TC"), Card("AD"), Card("AS")))),
    ("Four Jacks", Hand("Player", Set(Card("JD"), Card("JC"), Card("JH"), Card("AC"), Card("JS"))))
  )

  forAll (twoPairs) { (label: String, hand: Hand) => {
    label should s"be able to be evaluated from a `$hand`" in {
      TwoPair.evaluate(hand) shouldEqual Some(label)
    }
  }}

  forAll (notTwoPairs) { (label: String, hand: Hand) => {
    label should s"not be mistaken for a TwoPair from `$hand`" in {
      TwoPair.evaluate(hand) shouldEqual None
    }
  }}
}
