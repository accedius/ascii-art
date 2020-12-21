package entity.canvas

import entity.{TComposed, TGrid, TRectangular}
import entity.atomic.{PixelAscii, PixelGrayscale, TPixel}
import TRectangular.startRowIndex
import TRectangular.startColumnIndex

import scala.reflect.ClassTag

class PixelGrid [PIXEL <: TPixel : ClassTag](private val pixels: Array[Array[PIXEL]]) extends TGrid[PIXEL] {
  if(pixels.length == 0 ||
    (pixels.length != 0 && pixels.forall(pixelRow => pixelRow.length == 0))
  ) {
    throw new IllegalArgumentException("Image is empty!")
  }

  if(pixels(startRowIndex).length == 0 ||
    pixels.exists(pixelRow => pixelRow.length != pixels(startRowIndex).length)
  ) {
    throw new IllegalArgumentException("Image is damaged!")
  }

  val height: Int = pixels.length
  val width: Int = pixels(0).length

  override protected def elements: Array[Array[PIXEL]] = pixels

  def toGrayscale: PixelGrid[PixelGrayscale] = {
    new PixelGrid[PixelGrayscale](pixels.map(_.map(pixel => pixel.toGrayscale)))
  }

  def toAscii: PixelGrid[PixelAscii] = {
    new PixelGrid[PixelAscii](pixels.map(_.map(pixel => pixel.toAscii)))
  }

  override def toString: String = {
    pixels.map(_.mkString).mkString("\n")
  }

  override def equals(o: Any): Boolean = {
    if(!o.isInstanceOf[PixelGrid[PIXEL]]) return false
    val other: PixelGrid[PIXEL] = o.asInstanceOf[PixelGrid[PIXEL]]
    this.pixels.flatten[PIXEL].sameElements(other.pixels.flatten[PIXEL])
  }
}
