package dayone

import scala.io.Source

object DayOne {
  
  def getResult(a: List[Int]): Int = a.product
  
  def findThree(a: List[Int], expected: Int): List[Int] = {
    try {
      List(a.head) ++ findTwo(a.tail, expected - a.head)
    } catch {
      case e: UnsupportedOperationException => findThree(a.tail, expected)
    }
  }

  def findTwo(a: List[Int], expected: Int): List[Int] = {
    a.tail.find((x: Int) => a.head + x == expected) match {
      case Some(i) => List(a.head, i)
      case None => findTwo(a.tail, expected)
    }
  }

  def inputToList(fName: String): List[Int] = Source.fromResource(fName).getLines.toList.map(x => x.toInt)
}
