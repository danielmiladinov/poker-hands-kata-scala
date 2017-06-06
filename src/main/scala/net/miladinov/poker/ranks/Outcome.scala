package net.miladinov.poker.ranks

import net.miladinov.poker.models.Hand

sealed trait Outcome
case class Winner (hand: Hand, handTitle: String) extends Outcome
case object Tie extends Outcome
