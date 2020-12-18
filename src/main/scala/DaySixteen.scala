package daysixteen

import scala.io.Source

object DaySixteen {

  def collectRuleIndexPossibilities(nearbyTickets: List[List[Int]], rules: List[List[Int]], index: Int): List[(Int, List[Int])] = rules match {
    case Nil => Nil
    case x :: xs => List((index, findAllPossibleIndexesOfOneField(nearbyTickets, List(x, xs.head), (0 to 19).toList))) ++ collectRuleIndexPossibilities(nearbyTickets, rules.tail.tail, index + 1)
  }

  def findAllPossibleIndexesOfOneField(nearbyTickets: List[List[Int]], oneRule: List[List[Int]], resultList: List[Int]): List[Int] = nearbyTickets match {
    case Nil => resultList
    case x :: xs => findAllPossibleIndexesOfOneField(nearbyTickets.tail, oneRule, resultList.intersect(getIndexesForOneTicket(x, oneRule, 0)))
  }

  def getIndexesForOneTicket(ticket: List[Int], oneRule: List[List[Int]], currentIndex: Int): List[Int] = ticket match {
    case Nil => Nil
    case x :: xs => if (oneRule.flatten.contains(x)) currentIndex :: getIndexesForOneTicket(ticket.tail, oneRule, currentIndex + 1) else getIndexesForOneTicket(ticket.tail, oneRule, currentIndex + 1)
  }

  def removeInvalidTickets(nearbyTickets: List[List[Int]], rules: List[List[Int]]): List[List[Int]] = nearbyTickets match {
    case Nil => Nil
    case x :: xs => if (sumInvalidValues(x, rules) == 0) List(x) ++ removeInvalidTickets(nearbyTickets.tail, rules) else removeInvalidTickets(nearbyTickets.tail, rules)
  }

  def sumInvalidValues(intsToCheck: List[Int], rules: List[List[Int]]): Int = intsToCheck match {
    case Nil => 0
    case x :: xs => if (!rules.flatten.contains(x)) x + sumInvalidValues(intsToCheck.tail, rules) else 0 + sumInvalidValues(intsToCheck.tail, rules)
  }

  def rulesAsNested(lines: List[String]): List[List[Int]] = lines match {
    case Nil => Nil
    case x :: xs => { 
      val ind1 = x.indexOf(":") + 2
      val ind2 = x.indexOf("-") + 1
      val ind3 = x.substring(ind2).indexOf("o") - 1 + (x.length - x.substring(ind2).length)
      val ind4 = x.substring(ind3).indexOf("o") + 3 + (x.length - x.substring(ind3).length)
      val ind5 = x.substring(ind3).indexOf("-") + 1 + (x.length - x.substring(ind3).length)
      List((x.substring(ind1, ind2 - 1).toInt to x.substring(ind2, ind3).toInt).toList, (x.substring(ind4, ind5 - 1).toInt to x.substring(ind5).toInt).toList) ++ rulesAsNested(lines.tail)
    }
  }

  def collectRules(fName: String): List[String] = Source.fromResource(fName).getLines.toList.takeWhile(_ != "")

  def collectNearbyTickets(fName: String): List[List[Int]] = Source.fromResource(fName).getLines.toList.reverse.takeWhile(_ != "nearby tickets:").map(_.split(",").toList.map(_.toInt))

}
