//import dayone.DayOne._
import daytwo.DayTwo._

object Main {
  def main(args: Array[String]) {
    //day1 -- val result = getResult(findThree(inputToList("1a_input.txt"), 2020))
    val result = sumValidPasswords(inputToList("2a_input.txt"))
    println(result)
  }
}
