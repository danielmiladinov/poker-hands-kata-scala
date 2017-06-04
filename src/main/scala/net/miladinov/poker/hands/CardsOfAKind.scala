package net.miladinov.poker.hands

import net.miladinov.poker.models.{Hand, Value}

protected abstract class CardsOfAKind (numCards: Int) {
  def evaluate (hand: Hand): Option[String] = {
    val valuesWithCounts = hand.cardsByValueWithCounts

    if (valuesWithCounts.forall({ case ((_, ncs), _) => ncs == numCards || ncs == 1 })) {
      valuesWithCounts.keys.collectFirst({
        case (v, n) if n == numCards => buildTitle(v)
      })
    } else None
  }

  def buildTitle (v: Value): String
}
