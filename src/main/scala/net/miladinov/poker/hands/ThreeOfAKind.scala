package net.miladinov.poker.hands

import net.miladinov.poker.models.Hand

object ThreeOfAKind {
  def evaluate (hand: Hand): Option[String] = {
    val valuesWithCounts = hand.cardsByValueWithCounts

    if (valuesWithCounts.forall({ case ((_, numCards), _) => numCards == 3 || numCards == 1})) {
      valuesWithCounts.keys.collectFirst({
        case (value, 3) => s"Three ${value.plural}"
      })
    } else {
      None
    }
  }
}
