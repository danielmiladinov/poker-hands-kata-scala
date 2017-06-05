package net.miladinov.poker.hands

import net.miladinov.poker.models._

object RoyalFlush {
  def evaluate (hand: Hand): Option[String] = {
    val sorted = hand.cards.toList.sortBy(_.value.intValue)
    
    sorted match {
      case 
        Card(Ten,   s1) ::
        Card(Jack,  s2) ::
        Card(Queen, s3) ::
        Card(King,  s4) ::
        Card(Ace,   s5) :: Nil if Set(s1, s2, s3, s4, s5).size == 1 => Some("Royal Flush")
      case _ => None
    }
  }
}
