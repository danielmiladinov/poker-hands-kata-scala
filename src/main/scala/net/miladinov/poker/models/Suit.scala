package net.miladinov.poker.models

sealed trait Suit { val letter: String = toString.substring(0, 1) }
case object Diamonds extends Suit
case object Clubs    extends Suit
case object Hearts   extends Suit
case object Spades   extends Suit

object Suit {
  def apply (letter: String): Suit = letter match {
    case "D" => Diamonds
    case "C" => Clubs
    case "H" => Hearts
    case "S" => Spades
  }
}
