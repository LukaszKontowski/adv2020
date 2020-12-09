package dayseven

import scala.io.Source

object DaySeven {

  def countInters(wantedBags: List[String], m: Map[String, List[String]]): Int = 
    if (m.size == 0) 0
    else if (m.head._2.intersect(wantedBags).size > 0) 1 + countInters(wantedBags, m.tail)
    else 0 + countInters(wantedBags, m.tail)

  def collectWantedBags(m: Map[String, List[String]]): List[String] = 
    if (m.size == 0) Nil
    else if (m.head._2.contains("shiny gold")) m.head._1 :: collectWantedBags(m.tail)
    else collectWantedBags(m.tail)

  def countOutermosts(m: Map[String, List[String]]): Int = 
    if (m.size == 0) 0
    else if (m.head._2.contains("shiny gold")) 1 + countOutermosts(m.tail)
    else 0 + countOutermosts(m.tail)

  def collectAll(l: List[String], m: Map[String, List[String]]): Map[String, List[String]] = l match {
    case Nil => m
    case x :: xs => m ++ Map(getOuterBag(l.head) -> getInterBags(l.head)) ++ collectAll(l.tail, m ++ Map(getOuterBag(l.head) -> getInterBags(l.head)))
  }

  def getInterBags(s: String): List[String] = 
    s.substring(s.indexOf("contain") + 7).split(",").toList.map(x => x.replaceAll("\\d\\s", "").replaceAll("bags", "").replaceAll("bag","").replaceAll("\\.","")).map(_.trim)
  
  def getOuterBag(s: String): String = s.split(" ")(0) + " " + s.split(" ")(1)
  
  def inputToList(fName: String): List[String] = Source.fromResource(fName).getLines.toList
}
