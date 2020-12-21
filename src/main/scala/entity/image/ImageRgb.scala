package entity.image
import entity.atomic.{PixelGrayscale, PixelRgb, TPixel}
import entity.canvas.PixelGrid

class ImageRgb(override protected val pixelGrid: PixelGrid[PixelRgb]) extends TRasterImage {
  def toGrayscale: ImageGrayscale = {
    val grayGrid = pixelGrid.toGrayscale
    new ImageGrayscale(grayGrid)
  }
}
