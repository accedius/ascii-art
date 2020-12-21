package entity.atomic.helper

trait CompositeRgb {
  val red: ColorRed
  val green: ColorGreen
  val blue: ColorBlue

  def getRedValue: Int = red.getValue
  def getGreenValue: Int = green.getValue
  def getBlueValue: Int = blue.getValue
}
