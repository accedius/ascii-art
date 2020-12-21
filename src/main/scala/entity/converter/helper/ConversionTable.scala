package entity.converter.helper

import entity.TBounded

abstract class ConversionTable[FROM, TO](table: String) extends TBounded[Int] {
  checkBound(table.length)

  override def MinValue: Int = MinTableSize
  override def MaxValue: Int = MaxTableSize

  def MinTableSize: Int
  def MaxTableSize: Int

  def converse(value: FROM): TO
}