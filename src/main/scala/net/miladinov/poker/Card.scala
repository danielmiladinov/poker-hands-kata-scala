package net.miladinov.poker

case class Card (value: Value, suit: Suit) {
  override def toString: String = {
    val firstChar = value match {
      case Ten =>   'T'
      case Jack =>  'J'
      case Queen => 'Q'
      case King =>  'K'
      case Ace =>   'A'
      case _ => Character.forDigit(value.intValue, 10)
    }

    val secondChar = suit.letter

    s"$firstChar$secondChar"
  }
}

object Card {
  def apply (cardString: String): Card = {
    val Array(value, suit) = cardString.split("")
    Card(Value(value), Suit(suit))
  }
}

