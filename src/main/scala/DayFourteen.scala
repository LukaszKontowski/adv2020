package dayfourteen

import scala.io.Source

object DayFourteen {

  def sumValues(addressesValues: Map[Int, Long]) = addressesValues.values.sum

  def collectAllValues(input: List[String], resultMap: Map[Int, Long], currentMask: String): Map[Int, Long] = input match {
    case Nil => resultMap
    case x :: xs => input.head(1) match {
      case 'a' => collectAllValues(input.tail, resultMap, getMask(input.head))
      case 'e' => collectAllValues(input.tail, resultMap ++ Map(getValueAndAdress(input.head)._2 -> binToInt(updateValue(makeStringLong(getValueAndAdress(input.head)._1), currentMask, 0))), currentMask)
    }
  }

  def binToInt(binary: String): Long = java.lang.Long.parseLong(binary, 2)

  def updateValue(binaryValue: String, mask: String, index: Int): String = index match {
    case 36 => binaryValue
    case _ => mask(index) match {
      case 'X' => updateValue(binaryValue, mask, index + 1)
      case '1' => if (index < 35) updateValue(binaryValue.substring(0, index) + "1" + binaryValue.substring(index + 1), mask, index + 1) else (binaryValue.substring(0, index) + "1")
      case '0' => if (index < 35) updateValue(binaryValue.substring(0, index) + "0" + binaryValue.substring(index + 1), mask, index + 1) else (binaryValue.substring(0, index) + "0")
    }
  }

  def makeStringLong(bin: String): String = 
    if (bin.length == 36) bin else makeStringLong("0" + bin)

  def getMask(line: String): String = line.substring(7)

  def getValueAndAdress(line: String): Tuple2[String, Int] = (line.substring(line.indexOf('=') + 2).toInt.toBinaryString, line.substring(4, line.indexOf(']')).toInt)

  def inputToList(fName: String): List[String] = Source.fromResource(fName).getLines.toList

}
