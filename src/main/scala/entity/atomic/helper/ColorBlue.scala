package entity.atomic.helper

import entity.atomic.helper.ColorBlue.boundName

class ColorBlue(private val blue: Int) extends Color(blue) {
  override def BoundName: String = boundName
}

object ColorBlue {
  final val boundName = "Blue value"
}
