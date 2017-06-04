package net.miladinov.poker.hands

import net.miladinov.poker.models.{Ace, Card, Hand, Two}

object Straight {
  def evaluate (hand: Hand): Option[String] = {
    val sorted = hand.cards.toList.sortBy(_.value.intValue)
    
    if (monotonicallyAscending(sorted) && hand.cardsBySuitWithCounts.size > 1) {
      Some(buildTitle(sorted.last))
    } else {
      if (sorted.last.value == Ace) {
        val withoutAce = sorted.init
        if (withoutAce.head.value == Two && monotonicallyAscending(withoutAce)) {
          Some(buildTitle(withoutAce.last))
        } else None
      } else None
    }
  }
  
  private def buildTitle (c: Card): String = s"${c.value.singular}-high Straight"
  
  private def monotonicallyAscending (sortedCards: List[Card]): Boolean = sortedCards.sliding(2).forall({ 
    case lesser :: greater :: Nil => (greater.value.intValue - 1) == lesser.value.intValue
    case _ => false
  })
}
