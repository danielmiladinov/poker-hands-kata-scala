package net.miladinov.poker.models

case class Hand (player: String, cards: Set[Card]) {
  def cardsByValueWithCounts: Map[(Value, Int), Set[Card]] = by(_.value)

  def cardsBySuitWithCounts: Map[(Suit, Int), Set[Card]] = by(_.suit)

  private def by [K] (keyFn: Card => K): Map[(K, Int), Set[Card]] = {
    cards.groupBy(keyFn).map({ case (k, cs) => ((k, cs.size), cs) })
  }
}

object Hand {
  def apply (handString: String): Hand = {
    val Array(player, cardsString) = handString.split(": ")
    Hand(player, cardsString.split(" ").map(Card.apply).toSet)
  }
}
