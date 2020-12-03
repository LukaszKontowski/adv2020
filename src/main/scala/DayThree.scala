package dayThree

import scala.io.Source

object DayThree {
  def countTrees(a: Array[String], startAt: Tuple2[Int, Int]): Int = {
    if (startAt._2 >= a.size - 2) 0
    else if (a(2 + startAt._2)(1 + startAt._1) == '#') 1 + countTrees(a, (1 + startAt._1, 2 + startAt._2))
    else countTrees(a, (1 + startAt._1, 2 + startAt._2))
  }

  def broadenWay(input: List[String]): Array[String] = 
    input.map(_ * ((input.size / input(0).size + 1) * 7)).toArray

  def inputToList(fName: String): List[String] = Source.fromResource(fName).getLines.toList

}
