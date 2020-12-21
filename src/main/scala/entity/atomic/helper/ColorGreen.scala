package entity.atomic.helper

import entity.atomic.helper.ColorGreen.boundName

class ColorGreen(private val green: Int) extends Color(green) {
  override def BoundName: String = boundName
}

object ColorGreen {
  final val boundName = "Green value"
}