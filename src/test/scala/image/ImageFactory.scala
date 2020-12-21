package image

import entity.atomic.{PixelAscii, PixelGrayscale, PixelRgb}
import entity.canvas.PixelGrid
import entity.image.{ImageAscii, ImageGrayscale, ImageRgb}
import io.loader.FileLoader

trait ImageFactory {
  def makeImageFromFile(path: String): ImageRgb =
    FileLoader.load(path)

  def makeImageGrayscaleFromArray(pixels: Array[Array[Int]]): ImageGrayscale =
    new ImageGrayscale(makeGridGrayscaleFromArray(pixels))

  def makeGridGrayscaleFromArray(pixels: Array[Array[Int]]): PixelGrid[PixelGrayscale] =
    new PixelGrid[PixelGrayscale](pixels.map(_.map(i => PixelGrayscale(i))))

  def makeImageAsciiFromArray(pixels: Array[Array[Char]]): ImageAscii =
    new ImageAscii(makeGridAsciiFromArray(pixels))

  def makeGridAsciiFromArray(pixels: Array[Array[Char]]): PixelGrid[PixelAscii] =
    new PixelGrid[PixelAscii](pixels.map(_.map(i => PixelAscii(i))))

  def makeImageRgbFromArray(pixels: Array[Array[(Int, Int, Int)]]): ImageRgb =
    new ImageRgb(makeGridRgbFromArray(pixels))

  def makeGridRgbFromArray(pixels: Array[Array[(Int, Int, Int)]]): PixelGrid[PixelRgb] =
    new PixelGrid[PixelRgb](pixels.map(_.map(depths => PixelRgb(depths._1, depths._2, depths._3))))
}
