package net.miladinov.poker.hands

import net.miladinov.poker.models.Value

object FourOfAKind extends CardsOfAKind (4) {
  def buildTitle (v: Value): String = s"Four ${v.plural}"
}
