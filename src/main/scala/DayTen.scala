package dayten

import scala.io.Source

object DayTen {

  def countDifferences(currentInt: Int, sortedAdapters: List[Int], deviceAdapter: Int, oneJolts: Int, threeJolts: Int): Tuple2[Int, Int] = sortedAdapters match {
    case Nil => (oneJolts, threeJolts + 1)
    case x :: xs => if (sortedAdapters.head - currentInt == 1) countDifferences(sortedAdapters.head, sortedAdapters.tail, deviceAdapter, oneJolts + 1, threeJolts) else countDifferences(sortedAdapters.head, sortedAdapters.tail, deviceAdapter, oneJolts, threeJolts + 1)
  }

  def inputToList(fName: String): List[Int] = Source.fromResource(fName).getLines.toList.map(_.toInt)

}
