package daythirteen

import scala.io.Source

object DayThirteen {

  def findTimestamp(firstId: Int, otherIds: List[Tuple2[Int, Int]], currentInt: BigInt): BigInt = 
    if (currentInt % firstId == 0 && otherIds.forall(x => (((currentInt + x._2) % x._1) == 0))) currentInt else findTimestamp(firstId, otherIds, currentInt + 109953)

  def collectIds(list: List[String], resultList: List[Tuple2[Int, Int]], currentInt: Int): List[Tuple2[Int, Int]] = list match {
    case Nil => Nil
    case x :: xs => if (list.head == "x") collectIds(list.tail, resultList, currentInt + 1) else (list.head.toInt, currentInt) :: collectIds(list.tail, resultList ++ List((list.head.toInt, currentInt)), currentInt + 1)
  }

  def getFirstPossible(bigint: BigInt, firstId: Int): BigInt = {
    if (bigint % firstId == 0) bigint else getFirstPossible(bigint + 1, firstId)
  }

  def getResult(timestamp: Int, ids: List[Int], times: List[Int], bestId: Int): Int = ids match {
    case Nil => bestId * times.min
    case x :: xs => if (calculateWaitTime(timestamp, ids.head, ids.head) < times.min) getResult(timestamp, ids.tail, times ++ List(calculateWaitTime(timestamp, ids.head, ids.head)), ids.head) else getResult(timestamp, ids.tail, times ++ List(calculateWaitTime(timestamp, ids.head, ids.head)), bestId)
  }

  def calculateWaitTime(timestamp: Int, idImmutable: Int, idAcc: Int): Int =
    if (idAcc >= timestamp) (idAcc - timestamp) else calculateWaitTime(timestamp, idImmutable, idAcc + idImmutable)

  def getTimestamp(fName: String): Int = Source.fromResource(fName).getLines.toList(0).toInt

  def inputToListTwo(fName: String): List[String] = Source.fromResource(fName).getLines.toList(1).split(",").toList

  def inputToList(fName: String): List[Int] = Source.fromResource(fName).getLines.toList(1).split(",").toList.filter(_ != "x").map(_.toInt)

}
