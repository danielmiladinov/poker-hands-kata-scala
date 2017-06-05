package net.miladinov.poker.hands

import net.miladinov.poker.models.Hand

trait HandSpec {
  val rank: Int
  def evaluate (hand: Hand): Option[String]
}
