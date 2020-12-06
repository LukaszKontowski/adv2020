package daysix

import scala.io.Source

object DaySix {

  def calculate(l: List[String]): Int = l match {
    case Nil => 0
    case x :: xs => countNew(l.head) + calculate(l.tail)
  }

  def countNew(s: String): Int = findForAll(s.split(" ").toList).size

  def findForAll(l: List[String]): List[String] =
    if (l.tail != List())  l.head.split("").toList.intersect(findForAll(l.tail))
    else l.head.split("").toList

  def countResultForGroup(s: String): Int = s.split("").toList.distinctBy(_.toString).size

  def transformInput(l: List[String]): List[String] = l.map(x => if(x=="") x+"SEPARATOR" else x+" ").mkString.split("SEPARATOR").toList

  def inputToList(fName: String): List[String] = Source.fromResource(fName).getLines.toList

}
