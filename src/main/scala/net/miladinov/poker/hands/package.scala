package net.miladinov.poker

import net.miladinov.poker.models.Value

package object hands {
  def monotonicallyAscending (sortedValues: Value*): Boolean = sortedValues.sliding(2).forall({
    case Seq(lesser, greater) => (greater.intValue - 1) == lesser.intValue
    case _ => false
  })
}
