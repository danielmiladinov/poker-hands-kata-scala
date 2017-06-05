package net.miladinov.poker.hands

import net.miladinov.poker.models.Value

object TwoOfAKind extends CardsOfAKind (2) with HandSpec {
  val rank = 2
  def buildTitle (v: Value): String = s"Pair of ${v.plural}"
}
