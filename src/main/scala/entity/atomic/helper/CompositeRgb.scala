package entity.atomic.helper

/**
 * Trait for pixel classes, which are composed from RGB values
 */
trait CompositeRgb {
  val red: ColorRed
  val green: ColorGreen
  val blue: ColorBlue

  def getRedValue: Int = red.getValue
  def getGreenValue: Int = green.getValue
  def getBlueValue: Int = blue.getValue
}
