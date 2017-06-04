package net.miladinov.poker.hands

import net.miladinov.poker.models.{Hand, Value}

protected abstract class CardsOfAKind (numCards: Int) {
  def evaluate (hand: Hand): Option[String] = {
    val valuesWithCounts = hand.cardsByValueWithCounts.keys

    if (valuesWithCounts.forall({ case (_, cs) => cs == numCards || cs == 1 }) &&
        valuesWithCounts.count ({ case (_, cs) => cs == numCards }) == 1) {
      valuesWithCounts.collectFirst({
        case (v, n) if n == numCards => buildTitle(v)
      })
    } else None
  }

  def buildTitle (v: Value): String
}
