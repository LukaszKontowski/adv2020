package dayfifteen

import scala.io.Source

object DayFifteen {


  def findNumber(numbers: Map[Int, (Int,Int)], finalIndex: Int, currentIndex: Int, lastNumber: Int): Int = (currentIndex == finalIndex) match { 
    case true => getNextNumber(numbers, lastNumber) 
    case false => if (numbers.keys.toList.contains(getNextNumber(numbers, lastNumber))) {
                    findNumber(numbers ++ Map(getNextNumber(numbers, lastNumber) -> (numbers.apply(getNextNumber(numbers, lastNumber))._2, currentIndex)), finalIndex, currentIndex + 1, getNextNumber(numbers, lastNumber))
                    } else {
                        findNumber(numbers ++ Map(getNextNumber(numbers, lastNumber) -> (currentIndex, currentIndex)), finalIndex, currentIndex + 1, getNextNumber(numbers, lastNumber)) 
    }
  }

  def getNextNumber(numbers: Map[Int, (Int, Int)], lastNumber: Int): Int =
    if (numbers.apply(lastNumber)._1 == numbers.apply(lastNumber)._2) 0 else (numbers.apply(lastNumber)._2 - numbers.apply(lastNumber)._1)

}
