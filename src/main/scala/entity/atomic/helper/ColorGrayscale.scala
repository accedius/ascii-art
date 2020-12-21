package entity.atomic.helper

import entity.atomic.helper.ColorGrayscale.boundName

class ColorGrayscale(grayValue: Int) extends Color(grayValue) {
  override def BoundName: String = boundName
}

object ColorGrayscale {
  final val boundName = "Grayscale value"
}
