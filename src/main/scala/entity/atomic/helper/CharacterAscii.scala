package entity.atomic.helper

import entity.TBounded
import entity.atomic.helper.CharacterAscii.{boundName, maxValue, minValue}

class CharacterAscii(private val char: Char) extends TBounded[Char] {
  checkBound(char)

  override def BoundName: String = boundName
  override def MinValue: Char = minValue
  override def MaxValue: Char = maxValue

  def getAscii: Char = char
}

object CharacterAscii {
  final val boundName = "ASCII value"
  final val minValue = 0.toChar
  final val maxValue = 255.toChar
}
