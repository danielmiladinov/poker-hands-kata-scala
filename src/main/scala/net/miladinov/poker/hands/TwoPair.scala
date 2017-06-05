package net.miladinov.poker.hands

import net.miladinov.poker.models.Hand

object TwoPair extends HandSpec {
  val rank = 3
  def evaluate (hand: Hand): Option[String] = {
    val valuesWithCounts = hand.cardsByValueWithCounts.keys

    val pairs = valuesWithCounts.filter({ case (_, cs) => cs == 2 }).toList

    if (pairs.size == 2) {
      Some {
        pairs
          .sortBy({ case (v, _) => v.intValue })(Ordering[Int].reverse)
          .map({ case (v, _) => v.plural })
          .mkString(" and ")
      }
    } else None
  }
}
