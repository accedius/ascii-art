package entity.atomic

trait TPixel {
  def toGrayscale: PixelGrayscale = throw new UnsupportedOperationException(this.getClass.getName + " cannot be transformed to grayscale pixel!")
  def toAscii: PixelAscii = throw new UnsupportedOperationException(this.getClass.getName + " cannot be transformed to ASCII pixel!")
}
