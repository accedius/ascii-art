package entity.atomic

import scala.math.round

/**
 * Type class for conversion some Pixel to Grayscale Pixel (done for practice, no particular reason)
 * Implicitly takes RGB Pixels
 * @tparam T - Class of Pixel to be converted
 */
trait ToGrayscale[T] {
  def grayscale(instance: T): PixelGrayscale
}

object ToGrayscale {
  def apply[T](implicit to_Greyscale: ToGrayscale[T]): ToGrayscale[T] = to_Greyscale

  object ops {
    def grayscale[T: ToGrayscale](a: T) = ToGrayscale[T].grayscale(a)

    implicit class ToGreyscaleOps[T: ToGrayscale](a: T) {
      def grayscale = ToGrayscale[T].grayscale(a)
    }
  }

  implicit val pixelRgbToGreyscale: ToGrayscale[PixelRgb] = (pixel: PixelRgb) => {
    PixelGrayscale(round(0.3 * pixel.red.getValue + 0.59 * pixel.green.getValue + 0.11 * pixel.blue.getValue).toInt)
  }
}
