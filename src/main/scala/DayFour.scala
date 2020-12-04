package dayfour

import scala.io.Source

object DayFour {

  def countResult(l: List[String], req: List[String]): Int = l match {
    case Nil => 0
    case x :: xs => if (isValid(l.head, req) && isReallyValid(l.head.split("\\s").toList)) 1 + countResult(l.tail, req) else 0 + countResult(l.tail, req)
  }

  def isReallyValid(l: List[String]): Boolean = l match {
    case Nil => true
    case x :: xs => if (checkRegex(l.head)) isReallyValid(l.tail) else false
  }
    

  def checkRegex(s: String): Boolean = s.substring(0, 3) match {
    case "byr" => if (s.substring(4, s.size).matches("\\d\\d\\d\\d")) (s.substring(4, s.size).toInt >= 1920 && s.substring(4, s.size).toInt <= 2002) else false
    case "iyr" => if (s.substring(4, s.size).matches("\\d\\d\\d\\d")) (s.substring(4, s.size).toInt >= 2010 && s.substring(4, s.size).toInt <= 2020) else false
    case "eyr" => if (s.substring(4, s.size).matches("\\d\\d\\d\\d")) (s.substring(4, s.size).toInt >= 2020 && s.substring(4, s.size).toInt <= 2030) else false
    case "hgt" => if (s.substring(4, s.size).matches("\\d\\d\\d"+"cm")) (s.substring(4, 7).toInt >= 150 && s.substring(4, 7).toInt <= 193) else if (s.substring(4, s.size).matches("\\d\\d"+"in")) (s.substring(4, 6).toInt >= 59 && s.substring(4, 6).toInt <= 76) else false
    case "hcl" => (s(4) == '#') && (s.substring(5, s.size).split("").filter(_.matches("[0-9]")).size + s.substring(5, s.size).split("").filter(_.matches("[a-f]")).size == 6)
    case "ecl" => List("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(s.substring(4, s.size))
    case "pid" => s.substring(4, s.size).matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d")
    case "cid" => true
    case _ => false
  }

  def isValid(s: String, required: List[String]): Boolean = {
    if (!(s.split("\\s").toList.map(x => x.substring(0, x.indexOf(":") + 1)).contains(required.head))) false
    else if ((s.split("\\s").toList.map(x => x.substring(0, x.indexOf(":") + 1)).contains(required.head)) && required.tail == Nil) true
    else isValid(s, required.tail)
  }

  def transformInput(l: List[String]): List[String] = l.map(_.split("\\s")).flatten.map(x => if(x=="") x+"SEPARATOR" else x+" ").mkString.split("SEPARATOR").toList

  def inputToList(fName: String): List[String] = Source.fromResource(fName).getLines.toList
}
