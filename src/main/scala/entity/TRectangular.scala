package entity

trait TRectangular extends TCheckable[Int] {
  def width: Int
  def height: Int

  import TRectangular.minIndexValue

  protected def checkInside(rowIndex: Int, columnIndex: Int): Unit = {
    check("Row index", rowIndex, minIndexValue, width - 1);
    check("Column index", columnIndex, minIndexValue, height - 1);
  }
}

object TRectangular {
  val minIndexValue = 0
  val startRowIndex = 0
  val startColumnIndex = 0
}
