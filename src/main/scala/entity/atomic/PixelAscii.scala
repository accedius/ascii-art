package entity.atomic

import entity.atomic.helper.CharacterAscii

case class PixelAscii (private val asciiValue: Char) extends TPixel {
  val characterAscii: CharacterAscii = new CharacterAscii(asciiValue)

  def getAscii: Char = characterAscii.getAscii

  override def toString: String = {
    asciiValue.toString
  }
}
