package dayfive

import scala.io.Source

object DayFive {
  
  def findMissingIds(l: List[Int], range: List[Int]): List[Int] = range match {
    case Nil => Nil
    case x :: xs => if (!l.contains(range.head)) (range.head :: findMissingIds(l, range.tail)) else findMissingIds(l, range.tail)
  }

  def getRange(l: List[Int]): List[Int] = (l.min to l.max).toList

  def findGreatestId(l: List[Int]): Int = l.max

  def collectIds(l: List[String]): List[Int] = l match {
    case Nil => Nil
    case x :: xs => calculateId(calculateRow(l.head), calculateColumn(l.head)) :: collectIds(l.tail)
  } 

  def calculateId(row: Int, column: Int): Int = (8 * row) + column

  def calculateColumn(s: String): Int = Integer.parseInt(s.substring(7, s.size), 2)

  def calculateRow(s: String): Int = Integer.parseInt(s.substring(0, 7), 2)

  def transformLines(l: List[String]): List[String] = l match {
    case Nil => Nil
    case x :: xs => l.head.replaceAll("F","0").replaceAll("B","1").replaceAll("L","0").replaceAll("R","1") :: transformLines(l.tail)
  }

  def inputToList(fName: String): List[String] = Source.fromResource(fName).getLines.toList

}
