package net.miladinov.poker.hands

import net.miladinov.poker.models.{Card, Hand}
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class FullHouseTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {
  
  val fullHouses = Table(
    ("Label", "Valid Full House"),
    ("Full House: Aces over Kings",    Hand("Player", Set(Card("AS"), Card("KS"), Card("AH"), Card("KH"), Card("AC")))),
    ("Full House: Aces over Queens",   Hand("Player", Set(Card("AH"), Card("QH"), Card("AC"), Card("QC"), Card("AD")))),
    ("Full House: Aces over Jacks",    Hand("Player", Set(Card("AC"), Card("JC"), Card("AD"), Card("JD"), Card("AS")))),
    ("Full House: Aces over Tens",     Hand("Player", Set(Card("AD"), Card("TD"), Card("AS"), Card("TS"), Card("AH")))),
    ("Full House: Aces over Nines",    Hand("Player", Set(Card("AS"), Card("9S"), Card("AH"), Card("9H"), Card("AC")))),
    ("Full House: Aces over Eights",   Hand("Player", Set(Card("AH"), Card("8H"), Card("AC"), Card("8C"), Card("AD")))),
    ("Full House: Aces over Sevens",   Hand("Player", Set(Card("AC"), Card("7C"), Card("AD"), Card("7D"), Card("AS")))),
    ("Full House: Aces over Sixes",    Hand("Player", Set(Card("AD"), Card("6D"), Card("AS"), Card("6S"), Card("AH")))),
    ("Full House: Aces over Fives",    Hand("Player", Set(Card("AS"), Card("5S"), Card("AH"), Card("5H"), Card("AC")))),
    ("Full House: Aces over Fours",    Hand("Player", Set(Card("AH"), Card("4H"), Card("AC"), Card("4C"), Card("AD")))),
    ("Full House: Aces over Threes",   Hand("Player", Set(Card("AC"), Card("3C"), Card("AD"), Card("3D"), Card("AS")))),
    ("Full House: Aces over Twos",     Hand("Player", Set(Card("AD"), Card("2D"), Card("AS"), Card("2S"), Card("AH")))),

    ("Full House: Kings over Queens",  Hand("Player", Set(Card("KD"), Card("QD"), Card("KS"), Card("QS"), Card("KH")))),
    ("Full House: Kings over Jacks",   Hand("Player", Set(Card("KC"), Card("JC"), Card("KD"), Card("JD"), Card("KS")))),
    ("Full House: Kings over Tens",    Hand("Player", Set(Card("KD"), Card("TD"), Card("KS"), Card("TS"), Card("KH")))),
    ("Full House: Kings over Nines",   Hand("Player", Set(Card("KS"), Card("9S"), Card("KH"), Card("9H"), Card("KC")))),
    ("Full House: Kings over Eights",  Hand("Player", Set(Card("KH"), Card("8H"), Card("KC"), Card("8C"), Card("KD")))),
    ("Full House: Kings over Sevens",  Hand("Player", Set(Card("KC"), Card("7C"), Card("KD"), Card("7D"), Card("KS")))),
    ("Full House: Kings over Sixes",   Hand("Player", Set(Card("KD"), Card("6D"), Card("KS"), Card("6S"), Card("KH")))),
    ("Full House: Kings over Fives",   Hand("Player", Set(Card("KS"), Card("5S"), Card("KH"), Card("5H"), Card("KC")))),
    ("Full House: Kings over Fours",   Hand("Player", Set(Card("KH"), Card("4H"), Card("KC"), Card("4C"), Card("KD")))),
    ("Full House: Kings over Threes",  Hand("Player", Set(Card("KC"), Card("3C"), Card("KD"), Card("3D"), Card("KS")))),
    ("Full House: Kings over Twos",    Hand("Player", Set(Card("KD"), Card("2D"), Card("KS"), Card("2S"), Card("KH")))),

    ("Full House: Queens over Jacks",  Hand("Player", Set(Card("QC"), Card("JC"), Card("QD"), Card("JD"), Card("QS")))),
    ("Full House: Queens over Tens",   Hand("Player", Set(Card("QD"), Card("TD"), Card("QS"), Card("TS"), Card("QH")))),
    ("Full House: Queens over Nines",  Hand("Player", Set(Card("QS"), Card("9S"), Card("QH"), Card("9H"), Card("QC")))),
    ("Full House: Queens over Eights", Hand("Player", Set(Card("QH"), Card("8H"), Card("QC"), Card("8C"), Card("QD")))),
    ("Full House: Queens over Sevens", Hand("Player", Set(Card("QC"), Card("7C"), Card("QD"), Card("7D"), Card("QS")))),
    ("Full House: Queens over Sixes",  Hand("Player", Set(Card("QD"), Card("6D"), Card("QS"), Card("6S"), Card("QH")))),
    ("Full House: Queens over Fives",  Hand("Player", Set(Card("QS"), Card("5S"), Card("QH"), Card("5H"), Card("QC")))),
    ("Full House: Queens over Fours",  Hand("Player", Set(Card("QH"), Card("4H"), Card("QC"), Card("4C"), Card("QD")))),
    ("Full House: Queens over Threes", Hand("Player", Set(Card("QC"), Card("3C"), Card("QD"), Card("3D"), Card("QS")))),
    ("Full House: Queens over Twos",   Hand("Player", Set(Card("QD"), Card("2D"), Card("QS"), Card("2S"), Card("QH")))),

    ("Full House: Jacks over Tens",    Hand("Player", Set(Card("JD"), Card("TD"), Card("JS"), Card("TS"), Card("JH")))),
    ("Full House: Jacks over Nines",   Hand("Player", Set(Card("JS"), Card("9S"), Card("JH"), Card("9H"), Card("JC")))),
    ("Full House: Jacks over Eights",  Hand("Player", Set(Card("JH"), Card("8H"), Card("JC"), Card("8C"), Card("JD")))),
    ("Full House: Jacks over Sevens",  Hand("Player", Set(Card("JC"), Card("7C"), Card("JD"), Card("7D"), Card("JS")))),
    ("Full House: Jacks over Sixes",   Hand("Player", Set(Card("JD"), Card("6D"), Card("JS"), Card("6S"), Card("JH")))),
    ("Full House: Jacks over Fives",   Hand("Player", Set(Card("JS"), Card("5S"), Card("JH"), Card("5H"), Card("JC")))),
    ("Full House: Jacks over Fours",   Hand("Player", Set(Card("JH"), Card("4H"), Card("JC"), Card("4C"), Card("JD")))),
    ("Full House: Jacks over Threes",  Hand("Player", Set(Card("JC"), Card("3C"), Card("JD"), Card("3D"), Card("JS")))),
    ("Full House: Jacks over Twos",    Hand("Player", Set(Card("JD"), Card("2D"), Card("JS"), Card("2S"), Card("JH")))),

    ("Full House: Tens over Nines",    Hand("Player", Set(Card("TS"), Card("9S"), Card("TH"), Card("9H"), Card("TC")))),
    ("Full House: Tens over Eights",   Hand("Player", Set(Card("TH"), Card("8H"), Card("TC"), Card("8C"), Card("TD")))),
    ("Full House: Tens over Sevens",   Hand("Player", Set(Card("TC"), Card("7C"), Card("TD"), Card("7D"), Card("TS")))),
    ("Full House: Tens over Sixes",    Hand("Player", Set(Card("TD"), Card("6D"), Card("TS"), Card("6S"), Card("TH")))),
    ("Full House: Tens over Fives",    Hand("Player", Set(Card("TS"), Card("5S"), Card("TH"), Card("5H"), Card("TC")))),
    ("Full House: Tens over Fours",    Hand("Player", Set(Card("TH"), Card("4H"), Card("TC"), Card("4C"), Card("TD")))),
    ("Full House: Tens over Threes",   Hand("Player", Set(Card("TC"), Card("3C"), Card("TD"), Card("3D"), Card("TS")))),
    ("Full House: Tens over Twos",     Hand("Player", Set(Card("TD"), Card("2D"), Card("TS"), Card("2S"), Card("TH")))),

    ("Full House: Nines over Eights",  Hand("Player", Set(Card("9H"), Card("8H"), Card("9C"), Card("8C"), Card("9D")))),
    ("Full House: Nines over Sevens",  Hand("Player", Set(Card("9C"), Card("7C"), Card("9D"), Card("7D"), Card("9S")))),
    ("Full House: Nines over Sixes",   Hand("Player", Set(Card("9D"), Card("6D"), Card("9S"), Card("6S"), Card("9H")))),
    ("Full House: Nines over Fives",   Hand("Player", Set(Card("9S"), Card("5S"), Card("9H"), Card("5H"), Card("9C")))),
    ("Full House: Nines over Fours",   Hand("Player", Set(Card("9H"), Card("4H"), Card("9C"), Card("4C"), Card("9D")))),
    ("Full House: Nines over Threes",  Hand("Player", Set(Card("9C"), Card("3C"), Card("9D"), Card("3D"), Card("9S")))),
    ("Full House: Nines over Twos",    Hand("Player", Set(Card("9D"), Card("2D"), Card("9S"), Card("2S"), Card("9H")))),

    ("Full House: Eights over Sevens", Hand("Player", Set(Card("8C"), Card("7C"), Card("8D"), Card("7D"), Card("8S")))),
    ("Full House: Eights over Sixes",  Hand("Player", Set(Card("8D"), Card("6D"), Card("8S"), Card("6S"), Card("8H")))),
    ("Full House: Eights over Fives",  Hand("Player", Set(Card("8S"), Card("5S"), Card("8H"), Card("5H"), Card("8C")))),
    ("Full House: Eights over Fours",  Hand("Player", Set(Card("8H"), Card("4H"), Card("8C"), Card("4C"), Card("8D")))),
    ("Full House: Eights over Threes", Hand("Player", Set(Card("8C"), Card("3C"), Card("8D"), Card("3D"), Card("8S")))),
    ("Full House: Eights over Twos",   Hand("Player", Set(Card("8D"), Card("2D"), Card("8S"), Card("2S"), Card("8H")))),

    ("Full House: Sevens over Sixes",  Hand("Player", Set(Card("7D"), Card("6D"), Card("7S"), Card("6S"), Card("7H")))),
    ("Full House: Sevens over Fives",  Hand("Player", Set(Card("7S"), Card("5S"), Card("7H"), Card("5H"), Card("7C")))),
    ("Full House: Sevens over Fours",  Hand("Player", Set(Card("7H"), Card("4H"), Card("7C"), Card("4C"), Card("7D")))),
    ("Full House: Sevens over Threes", Hand("Player", Set(Card("7C"), Card("3C"), Card("7D"), Card("3D"), Card("7S")))),
    ("Full House: Sevens over Twos",   Hand("Player", Set(Card("7D"), Card("2D"), Card("7S"), Card("2S"), Card("7H")))),

    ("Full House: Sixes over Fives",   Hand("Player", Set(Card("6S"), Card("5S"), Card("6H"), Card("5H"), Card("6C")))),
    ("Full House: Sixes over Fours",   Hand("Player", Set(Card("6H"), Card("4H"), Card("6C"), Card("4C"), Card("6D")))),
    ("Full House: Sixes over Threes",  Hand("Player", Set(Card("6C"), Card("3C"), Card("6D"), Card("3D"), Card("6S")))),
    ("Full House: Sixes over Twos",    Hand("Player", Set(Card("6D"), Card("2D"), Card("6S"), Card("2S"), Card("6H")))),

    ("Full House: Fives over Fours",   Hand("Player", Set(Card("5H"), Card("4H"), Card("5C"), Card("4C"), Card("5D")))),
    ("Full House: Fives over Threes",  Hand("Player", Set(Card("5C"), Card("3C"), Card("5D"), Card("3D"), Card("5S")))),
    ("Full House: Fives over Twos",    Hand("Player", Set(Card("5D"), Card("2D"), Card("5S"), Card("2S"), Card("5H")))),

    ("Full House: Fours over Threes",  Hand("Player", Set(Card("4C"), Card("3C"), Card("4D"), Card("3D"), Card("4S")))),
    ("Full House: Fours over Twos",    Hand("Player", Set(Card("4D"), Card("2D"), Card("4S"), Card("2S"), Card("4H")))),

    ("Full House: Threes over Twos",   Hand("Player", Set(Card("3D"), Card("2D"), Card("3S"), Card("2S"), Card("3H")))),
  )

  val notFullHouses = Table(
    ("Label",               "Invalid Full House"),
    ("Jacks and Threes",    Hand("Player", Set(Card("JH"), Card("JS"), Card("KC"), Card("3D"), Card("3H")))),
    ("Three Twos",          Hand("Player", Set(Card("2H"), Card("2S"), Card("3C"), Card("2D"), Card("KH")))),
    ("Eight-high Straight", Hand("Player", Set(Card("4H"), Card("5S"), Card("6C"), Card("8D"), Card("7H")))),
    ("Flush",               Hand("Player", Set(Card("9D"), Card("TD"), Card("JD"), Card("AD"), Card("3D")))),
    ("Four Jacks",          Hand("Player", Set(Card("JD"), Card("JC"), Card("JH"), Card("AC"), Card("JS"))))
  )
  
  forAll (fullHouses) { (label: String, hand: Hand) => {
    label should s"be able to be evaluated from a `$hand`" in {
      FullHouse.evaluate(hand) shouldEqual Some(label)
    }
  }}

  forAll (notFullHouses) { (label: String, hand: Hand) => {
    label should s"should not be mistaken for a Full House from `$hand`" in {
      FullHouse.evaluate(hand) shouldEqual None
    }
  }}
}
