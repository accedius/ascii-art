package entity

/**
 * Trait for classes with grid-like structure
 * @tparam ELEMENT - class type of Elements
 */
trait TGrid[ELEMENT] extends TRectangular with TComposed[ELEMENT, Int] {
  protected def elements: Array[Array[ELEMENT]]

  def getAt(rowIndex: Int, columnIndex: Int): ELEMENT = {
    checkInside(rowIndex, columnIndex)

    elements(rowIndex)(columnIndex)
  }

  override def getAt(pixelIndex: Int): ELEMENT = {
    val pixelRowIndex = pixelIndex / width;
    val pixelColumnIndex = pixelIndex % width - 1;

    getAt(pixelRowIndex, pixelColumnIndex)
  }
}
