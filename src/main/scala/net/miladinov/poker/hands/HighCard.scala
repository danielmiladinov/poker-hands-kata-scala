package net.miladinov.poker.hands

import net.miladinov.poker.models.Hand

object HighCard extends HandSpec {
  val rank: Int = 1
  def evaluate (hand: Hand): Option[String] = Some {
    s"High Card: ${hand.cards.toList.maxBy(_.value.intValue).value.singular}"
  }
}
