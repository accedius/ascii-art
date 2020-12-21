package entity

/**
 * Trait for classes composed from another Elements
 * @tparam ELEMENT - class type of Elements
 * @tparam INDEX - class type of Value to index with (i.e. Int, Long, etc.)
 */
trait TComposed[ELEMENT, INDEX <: AnyVal] {
  def getAt(pixelIndex: INDEX): ELEMENT
}
