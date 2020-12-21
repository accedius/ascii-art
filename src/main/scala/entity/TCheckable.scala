package entity

trait TCheckable[CHECKABLE] {
  protected def check(checkName: String, wantedValue: CHECKABLE, minValue: CHECKABLE, maxValue: CHECKABLE)(implicit ev: CHECKABLE => Ordered[CHECKABLE]): Unit = {
    if(minValue > maxValue) {
      throw new IllegalArgumentException(checkName + ": minimal value can't be greater than the maximum value")
    }

    if(wantedValue > maxValue || wantedValue < minValue) {
      throw new IllegalArgumentException(checkName + ": argument is out of bounds. Wanted value: " + wantedValue + ". Available values: " + minValue + " to " + maxValue + ".")
    }
  }
}
