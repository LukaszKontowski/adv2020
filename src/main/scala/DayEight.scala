package dayeight

import scala.io.Source

object DayEight {

  def findCorruptedIndex(l: List[String], indexes: List[Int]): Int = {
    if (indexes.reverse.tail.contains(indexes.reverse.head) && indexes.size > 1) indexes.reverse.head
    else if (l(indexes(indexes.size - 1)).matches("jmp\\s[+,-]\\d+")) calculate(l, indexes ++ List(indexes(indexes.size - 1) + l(indexes(indexes.size - 1)).substring(4).toInt))
    else calculate(l, indexes ++ List(indexes(indexes.size - 1) + 1))
  }

  def calculate(l: List[String], indexes: List[Int]): Int = {
    if (indexes.reverse.tail.contains(indexes.reverse.head) && indexes.size > 1) 0
    else if (l(indexes(indexes.size - 1)).matches("acc\\s[+,-]\\d+")) l(indexes(indexes.size - 1)).substring(4).toInt + calculate(l, indexes ++ List(indexes(indexes.size - 1) + 1))
    else if (l(indexes(indexes.size - 1)).matches("jmp\\s[+,-]\\d+")) 0 + calculate(l, indexes ++ List(indexes(indexes.size - 1) + l(indexes(indexes.size - 1)).substring(4).toInt))
    else 0 + calculate(l, indexes ++ List(indexes(indexes.size - 1) + 1))
  }

  def inputToList(fName: String): List[String] = Source.fromResource(fName).getLines.toList  

}
