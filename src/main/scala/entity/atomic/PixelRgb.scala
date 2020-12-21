package entity.atomic

import entity.atomic.helper.{ColorBlue, ColorGreen, ColorRed, CompositeRgb}
import entity.atomic.ToGrayscale.ops.ToGreyscaleOps

case class PixelRgb (private val redValue: Int, private val greenValue: Int, private val blueValue: Int) extends CompositeRgb with TPixel {
  override val red: ColorRed = new ColorRed(redValue)
  override val green: ColorGreen = new ColorGreen(greenValue)
  override val blue: ColorBlue = new ColorBlue(blueValue)

  override def toString: String = {
    s"""(R:${red},G:${green},B:${blue})"""
  }

  override def toGrayscale: PixelGrayscale = {
    (this).grayscale
  }
}


