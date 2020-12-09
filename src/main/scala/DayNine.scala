package daynine

import scala.io.Source

object DayNine {

  def findSet(realList: List[BigInt], realListCopy: List[BigInt], accList: List[BigInt], number: BigInt, sum: BigInt): List[BigInt] =
    if (sum > number) findSet(realList.tail, realList.tail, List(), number, BigInt(0))
    else if (sum == number && accList.size > 1) accList
    else findSet(realList, realListCopy.tail, accList :+ realListCopy.head, number, accList.sum + realListCopy.head)

  def findWrongNumber(list: List[BigInt]): BigInt = list match {
    case Nil => BigInt(0)
    case x :: xs => if (isCorrect(list.take(25), list(25))) findWrongNumber(list.tail) else list(25)
  }

  def isCorrect(l: List[BigInt], number: BigInt): Boolean = l match {
    case Nil => true
    case x :: xs => if (xs.filter((num: BigInt) => (x + num == number)).size > 0) true else if (xs.filter((num: BigInt) => (x + num == number)).size == 0 && l.size == 2) false else isCorrect(l.tail, number)
  }

  def inputToList(fName: String): List[BigInt] = Source.fromResource(fName).getLines.toList.map(x => BigInt(x))

}
