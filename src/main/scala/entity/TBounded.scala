package entity

trait TBounded [NUM <: AnyVal] extends TCheckable[NUM] {
  def BoundName: String
  def MinValue: NUM
  def MaxValue: NUM

  def checkBound(wantedValue: NUM)(implicit ev: NUM => Ordered[NUM]): Unit = {
    check(BoundName, wantedValue, MinValue, MaxValue)
  }
}
