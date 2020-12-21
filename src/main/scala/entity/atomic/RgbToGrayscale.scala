package entity.atomic

import scala.math.round

trait RgbToGrayscale[T] {
  def grayscale(instance: T): PixelGrayscale
}

object RgbToGrayscale {
  def apply[T](implicit to_Greyscale: RgbToGrayscale[T]): RgbToGrayscale[T] = to_Greyscale

  object ops {
    def grayscale[T: RgbToGrayscale](a: T) = RgbToGrayscale[T].grayscale(a)

    implicit class ToGreyscaleOps[T: RgbToGrayscale](a: T) {
      def grayscale = RgbToGrayscale[T].grayscale(a)
    }
  }

  implicit val pixelRgbToGreyscale: RgbToGrayscale[PixelRgb] = (pixel: PixelRgb) => {
    PixelGrayscale(round(0.3 * pixel.red.getValue + 0.59 * pixel.green.getValue + 0.11 * pixel.blue.getValue).toInt)
  }
}
