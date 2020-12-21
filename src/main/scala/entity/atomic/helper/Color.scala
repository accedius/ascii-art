package entity.atomic.helper

import entity.TBounded
import entity.atomic.helper.Color.{maxValue, minValue}

abstract class Color(private val value: Int) extends TBounded[Int] {
  checkBound(value)

  override def MinValue: Int = minValue
  override def MaxValue: Int = maxValue

  def getValue: Int = value
}

object Color {
  final val minValue = 0
  final val maxValue = 255
}
