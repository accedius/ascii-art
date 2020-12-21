package entity

trait TTransformable[TRANSFORMABLE, TRANSFORMED, OUTPUT] {
  def transform(operator: TRANSFORMABLE => TRANSFORMED): OUTPUT
}
