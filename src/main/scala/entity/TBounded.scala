package entity

/**
 * Trait for classes, that need to be checked against some bound
 * @tparam NUM - class of value, which is bounded (i.e. Int, Long etc.)
 */
trait TBounded [NUM <: AnyVal] extends TCheckable[NUM] {
  def BoundName: String
  def MinValue: NUM
  def MaxValue: NUM

  def checkBound(wantedValue: NUM)(implicit ev: NUM => Ordered[NUM]): Unit = {
    check(BoundName, wantedValue, MinValue, MaxValue)
  }
}
