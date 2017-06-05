package net.miladinov.poker.hands

import net.miladinov.poker.models._

object Flush {
  def evaluate (hand: Hand): Option[String] = {
    if (hand.cardsBySuitWithCounts.size == 1) {
      val sorted = hand.cards.toList.sortBy(_.value.intValue)

      sorted match {
        case
          Card(Two,   _) ::
          Card(Three, _) ::
          Card(Four,  _) ::
          Card(Five,  _) ::
          Card(Ace,   _) :: Nil => None

        case
          Card(val1, _) ::
          Card(val2, _) ::
          Card(val3, _) ::
          Card(val4, _) ::
          Card(val5, _) :: Nil if monotonicallyAscending(val1, val2, val3, val4, val5) => None

        case _ => Some(buildTitle(sorted.last.value))
      }
    } else None
  }
    
  private def buildTitle (v: Value): String = s"${v.singular}-high Flush"
}
