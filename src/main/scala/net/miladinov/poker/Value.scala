package net.miladinov.poker

sealed abstract class Value (val intValue: Int) { }
case object Two   extends Value(2)
case object Three extends Value(3)
case object Four  extends Value(4)
case object Five  extends Value(5)
case object Six   extends Value(6)
case object Seven extends Value(7)
case object Eight extends Value(8)
case object Nine  extends Value(9)
case object Ten   extends Value(10)
case object Jack  extends Value(11)
case object Queen extends Value(12)
case object King  extends Value(13)
case object Ace   extends Value(14)

object Value {
  def apply (valueString: String): Value = {
    valueString match {
      case "2" => Two
      case "3" => Three
      case "4" => Four
      case "5" => Five
      case "6" => Six
      case "7" => Seven
      case "8" => Eight
      case "9" => Nine
      case "T" => Ten
      case "J" => Jack
      case "Q" => Queen
      case "K" => King
      case "A" => Ace
    }
  }

  def apply (value: Int): Value = {
    val stringValue: String = value match {
      case 10 => "T"
      case 11 => "J"
      case 12 => "Q"
      case 13 => "K"
      case 14 => "A"
      case _ => value.toString
    }
    apply(stringValue)
  }
}
