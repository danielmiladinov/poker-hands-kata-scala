package net.miladinov.poker.hands

import net.miladinov.poker.models.Hand

object FullHouse {
  def evaluate (hand: Hand): Option[String] = {
    val valuesWithCounts = hand.cardsByValueWithCounts.keys

    for {
      over  <- valuesWithCounts.find({ case (_, cs) => cs == 3 })
      under <- valuesWithCounts.find({ case (_, cs) => cs == 2 })
    } yield s"Full House: ${Array(over._1.plural, under._1.plural).mkString(" over ")}"
  }
}
