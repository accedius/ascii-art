package entity.image

import entity.atomic.PixelGrayscale
import entity.canvas.PixelGrid

class ImageGrayscale(override protected val pixelGrid: PixelGrid[PixelGrayscale]) extends TRasterImage {
  def toAscii: ImageAscii = {
    val asciiGrid = pixelGrid.toAscii
    new ImageAscii(asciiGrid)
  }
}
