package net.miladinov.poker.models

case class Hand (player: String, cards: Set[Card]) {
  def cardsGroupedByValue: Map[Value, Set[Card]] = cards.groupBy(_.value)
}

object Hand {
  def apply (handString: String): Hand = {
    val Array(player, cardsString) = handString.split(": ")
    Hand(player, cardsString.split(" ").map(Card.apply).toSet)
  }
}
