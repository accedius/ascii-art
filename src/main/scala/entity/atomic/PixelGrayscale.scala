package entity.atomic

import entity.atomic.helper.ColorGrayscale
import entity.converter.PixelConverter

case class PixelGrayscale(private val grayscaleValue: Int) extends TPixel {
  val grayscale: ColorGrayscale = new ColorGrayscale(grayscaleValue)

  override def toAscii: PixelAscii = {
    PixelConverter.greyscaleToAscii(this)
  }

  override def toGrayscale: PixelGrayscale = {
    new PixelGrayscale(grayscaleValue)
  }

  override def toString: String = {
    s"""(G:${grayscale.getValue})"""
  }
}

object PixelGrayscale {
  final val minGrayValue = 0
  final val maxGrayValue = 255
}
