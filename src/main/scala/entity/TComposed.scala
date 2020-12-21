package entity

trait TComposed[ELEMENT, INDEX <: AnyVal] {
  def getAt(pixelIndex: INDEX): ELEMENT
}
