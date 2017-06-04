package net.miladinov.poker.models

case class Hand (player: String, cards: Set[Card]) {
  def cardsByValueWithCounts: Map[(Value, Int), Set[Card]] = {
    cards.groupBy(_.value).map({ case (v, cs) => ((v, cs.size), cs) })
  }

  def cardsBySuitWithCounts: Map[(Suit, Int), Set[Card]] = {
    cards.groupBy(_.suit).map({ case (s, cs) => ((s, cs.size), cs) })
  }
}

object Hand {
  def apply (handString: String): Hand = {
    val Array(player, cardsString) = handString.split(": ")
    Hand(player, cardsString.split(" ").map(Card.apply).toSet)
  }
}
