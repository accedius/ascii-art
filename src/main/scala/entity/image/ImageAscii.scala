package entity.image

import entity.atomic.PixelAscii
import entity.canvas.PixelGrid

class ImageAscii(override protected val pixelGrid: PixelGrid[PixelAscii]) extends TRasterImage {
}
