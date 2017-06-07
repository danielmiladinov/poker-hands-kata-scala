package net.miladinov.poker

import net.miladinov.poker.models.Hand
import net.miladinov.poker.ranks.{Ranker, Tie, Winner}

object PokerHands {
  def playGame (input: String): String = {
    val Array(hand1, hand2) = input.split("  ").map(Hand.apply)
    Ranker.rank(hand1, hand2) match {
      case Winner(hand, title) => s"${hand.player} wins, with $title"
      case Tie => Tie.toString
    }
  }
}
