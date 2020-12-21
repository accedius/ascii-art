package entity.converter.helper

import ConversionTableToAscii.{boundName, maxAsciiTableSize, minAsciiTableSize, table}
import entity.atomic.helper.ColorGrayscale

class ConversionTableToAscii extends ConversionTable[ColorGrayscale, Char](table) {
  override def MinTableSize: Int = minAsciiTableSize
  override def MaxTableSize: Int = maxAsciiTableSize
  override def BoundName: String = boundName

  override def converse(grayscale: ColorGrayscale): Char = {
    val correspondingAsciiIndex = (grayscale.getValue.toFloat * table.length.toFloat / 256).toInt
    table(correspondingAsciiIndex)
  }
}

object ConversionTableToAscii {
  val minAsciiTableSize = 1
  val maxAsciiTableSize = 256
  val boundName = "Conversion table from grayscale to ascii size"

  val table: String = "@%#*+=-:. "
}
