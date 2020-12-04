//import dayone.DayOne._
//import daytwo.DayTwo._
//import dayThree.DayThree._
import dayfour.DayFour._

object Main {
  def main(args: Array[String]) {
    //day1 -- val result = getResult(findThree(inputToList("1a_input.txt"), 2020))
    //day2 -- val result = sumValidPasswords(inputToList("2a_input.txt"))
    //day3 -- val result = countTrees(broadenWay(inputToList("3a_input.txt")), (0,0))
    val result = countResult(transformInput(inputToList("4a_input.txt")), List("byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:"))
    println(result)
  }
}
