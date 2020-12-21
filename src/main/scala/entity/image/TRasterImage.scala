package entity.image

import entity.{TComposed, TRectangular}
import entity.atomic.TPixel
import entity.canvas.PixelGrid

/**
 * Base trait for Raster Images
 */
trait TRasterImage extends TRectangular {
  protected val pixelGrid: PixelGrid[_ <: TPixel]

  override def width: Int = pixelGrid.width
  override def height: Int = pixelGrid.height

  def getPixelAt(rowIndex: Int, columnIndex: Int) = pixelGrid.getAt(rowIndex, columnIndex)
  def getPixelAt(pixelIndex: Int) = pixelGrid.getAt(pixelIndex)

  def prepareForExport: String = toString

  override def toString: String = {
    pixelGrid.toString;
  }

  override def equals(o: Any): Boolean = {
    if(!o.isInstanceOf[TRasterImage]) return false
    val other: TRasterImage = o.asInstanceOf[TRasterImage]
    this.pixelGrid == other.pixelGrid
  }
}
