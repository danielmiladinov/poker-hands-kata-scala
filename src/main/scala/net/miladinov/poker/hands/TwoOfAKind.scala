package net.miladinov.poker.hands

import net.miladinov.poker.models.Hand

object TwoOfAKind {
  def evaluate (hand: Hand): Option[String] = {
    val valuesWithCounts = hand.cardsByValueWithCounts

    if (valuesWithCounts.forall({ case ((_, numCards), _) => numCards <= 2 })) {
      valuesWithCounts.keys.collectFirst({
        case (value, 2) => s"Pair of ${value.plural}"
      })
    } else {
      None
    }
  }
}
