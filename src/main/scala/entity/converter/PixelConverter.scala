package entity.converter

import entity.atomic.ToGrayscale.ops.ToGreyscaleOps
import entity.atomic.{PixelAscii, PixelGrayscale, PixelRgb}
import entity.converter.helper.ConversionTableToAscii

class PixelConverter {
}

object PixelConverter {
  lazy val conversionTableToAscii = new ConversionTableToAscii

  def rgbToGreyscale(pixelRgb: PixelRgb): PixelGrayscale = {
    pixelRgb.grayscale
  }

  def greyscaleToAscii(pixelGreyscale: PixelGrayscale): PixelAscii = {
    val asciiChar = conversionTableToAscii.converse(pixelGreyscale.grayscale)
    PixelAscii(asciiChar)
  }
}
