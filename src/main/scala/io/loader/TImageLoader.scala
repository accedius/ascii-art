package io.loader

import java.awt.image.BufferedImage

import entity.atomic.PixelRgb
import entity.canvas.PixelGrid
import entity.image.ImageRgb

/**
 * Base trait for all image loaders, describing loading operation
 */
trait TImageLoader {
  /**
   * Loads the image using given parameters
   * @param loadParameters - parameters, describing the way of obtaining the image (i.e. path or url)
   * @return - rgb image loaded as ImageRgb object
   */
  def load(loadParameters: String*): ImageRgb

  protected def convertToImageRgb(image: BufferedImage): ImageRgb = {
    val imageWidth = image.getWidth
    val imageHeight = image.getHeight

    val imagePixels: Array[Array[PixelRgb]] = Array.ofDim(imageHeight, imageWidth)
    for(x <- 0 until imageHeight; y <- 0 until imageWidth) {
      val rgbValue = image.getRGB(y, x)
      val redValue = (rgbValue & 0xFF0000) >> 16
      val greenValue = (rgbValue & 0xFF00) >> 8
      val blueValue = rgbValue & 0xFF
      imagePixels(x)(y) = new PixelRgb(redValue, greenValue, blueValue)
    }

    val pixelGrid = new PixelGrid[PixelRgb](imagePixels)
    new ImageRgb(pixelGrid)
  }
}
