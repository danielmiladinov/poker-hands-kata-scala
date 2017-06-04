package net.miladinov.poker.hands

import net.miladinov.poker.models.{Card, Hand, Value}

object ThreeOfAKind {
  def evaluate (hand: Hand): Option[String] = {
    def addCounts (kvp: (Value, Set[Card])): ((Value, Int), Set[Card]) = ((kvp._1, kvp._2.size), kvp._2)

    val valuesAndCounts = hand.cardsGroupedByValue.map(addCounts)

    if (valuesAndCounts.forall({ case ((_, numCards), _) => numCards == 3 || numCards == 1})) {
      valuesAndCounts.keys.collectFirst({
        case (value, 3) => s"Three ${value.plural}"
      })
    } else {
      None
    }
  }
}
