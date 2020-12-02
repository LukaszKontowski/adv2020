package daytwo

import scala.io.Source

object DayTwo {

  def sumValidPasswords(l: List[Array[String]]): Int = l match {
    case Nil => 0
    case x :: xs => countLine(x) + sumValidPasswords(l.tail)
  }

  def countLine(x: Array[String]): Int = {
    val min = x(0).split("-").map(_.toInt).head
    val max = x(0).split("-").map(_.toInt).tail.head
    val letter = x(1)(0).toString
    val pass = x(2)
    if (isPasswordValid(min, max, letter, pass)) 1 else 0
  }
  
  /* def getNums(l: List[Array[String]]): List[Array[Int]] = l match {
    case Nil => Nil
    case x :: xs => x(0).split("-").map(_.toInt) :: getNums(l.tail)
  }*/
 
  def isPasswordValid(min: Int, max: Int, letter: String, pass: String): Boolean =
    (pass(min - 1).toString == letter) != (pass(max - 1).toString == letter)
    //(pass.split("").filter(_ == letter).size >= min) && (pass.split("").filter(_ == letter).size <= max)

  def inputToList(fName: String): List[Array[String]] = Source.fromResource(fName).getLines.toList.map(x => x.split("\\s"))

}
