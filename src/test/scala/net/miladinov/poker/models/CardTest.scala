package net.miladinov.poker.models

import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

class CardTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {
  val cards = Table(
    ("String Representation", "Value", "Suit"),
    ("2D",                    Two,     Diamonds),
    ("3D",                    Three,   Diamonds),
    ("4D",                    Four,    Diamonds),
    ("5D",                    Five,    Diamonds),
    ("6D",                    Six,     Diamonds),
    ("7D",                    Seven,   Diamonds),
    ("8D",                    Eight,   Diamonds),
    ("9D",                    Nine,    Diamonds),
    ("TD",                    Ten,     Diamonds),
    ("JD",                    Jack,    Diamonds),
    ("QD",                    Queen,   Diamonds),
    ("KD",                    King,    Diamonds),
    ("AD",                    Ace,     Diamonds),

    ("2C",                    Two,     Clubs),
    ("3C",                    Three,   Clubs),
    ("4C",                    Four,    Clubs),
    ("5C",                    Five,    Clubs),
    ("6C",                    Six,     Clubs),
    ("7C",                    Seven,   Clubs),
    ("8C",                    Eight,   Clubs),
    ("9C",                    Nine,    Clubs),
    ("TC",                    Ten,     Clubs),
    ("JC",                    Jack,    Clubs),
    ("QC",                    Queen,   Clubs),
    ("KC",                    King,    Clubs),
    ("AC",                    Ace,     Clubs),

    ("2H",                    Two,     Hearts),
    ("3H",                    Three,   Hearts),
    ("4H",                    Four,    Hearts),
    ("5H",                    Five,    Hearts),
    ("6H",                    Six,     Hearts),
    ("7H",                    Seven,   Hearts),
    ("8H",                    Eight,   Hearts),
    ("9H",                    Nine,    Hearts),
    ("TH",                    Ten,     Hearts),
    ("JH",                    Jack,    Hearts),
    ("QH",                    Queen,   Hearts),
    ("KH",                    King,    Hearts),
    ("AH",                    Ace,     Hearts),

    ("2S",                    Two,     Spades),
    ("3S",                    Three,   Spades),
    ("4S",                    Four,    Spades),
    ("5S",                    Five,    Spades),
    ("6S",                    Six,     Spades),
    ("7S",                    Seven,   Spades),
    ("8S",                    Eight,   Spades),
    ("9S",                    Nine,    Spades),
    ("TS",                    Ten,     Spades),
    ("JS",                    Jack,    Spades),
    ("QS",                    Queen,   Spades),
    ("KS",                    King,    Spades),
    ("AS",                    Ace,     Spades)
  )

  forAll (cards) { (stringRepresentation: String, value: Value, suit: Suit) => {
    val testName = s"$value of $suit"
    val card = Card(value, suit)

    testName should "be equal to another card of the same value" in {
      val card2 = Card(value, suit)
      card2 shouldEqual card
    }

    it should s"be able to be applied to its card string: $stringRepresentation" in {
      val applied = Card(stringRepresentation)
      applied shouldEqual card
    }

    it should "have a sensible toString representation" in {
      card.toString shouldEqual stringRepresentation
    }
  }}
}
