package net.miladinov.poker.models

case class Hand (player: String, cards: Set[Card]) { }

object Hand {
  def apply (handString: String): Hand = {
    val Array(player, cardsString) = handString.split(": ")
    Hand(player, cardsString.split(" ").map(Card.apply).toSet)
  }
}
