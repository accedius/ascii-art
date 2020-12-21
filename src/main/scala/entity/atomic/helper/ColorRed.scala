package entity.atomic.helper

import entity.atomic.helper.ColorRed.boundName

class ColorRed(private val red: Int) extends Color(red) {
  override def BoundName: String = boundName
}

object ColorRed {
  final val boundName = "Red value"
}
