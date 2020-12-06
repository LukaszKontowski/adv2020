//import dayone.DayOne._
//import daytwo.DayTwo._
//import dayThree.DayThree._
//import dayfour.DayFour._
//import dayfive.DayFive._
import daysix.DaySix._

object Main {
  def main(args: Array[String]) {
    //day1 -- val result = getResult(findThree(inputToList("1a_input.txt"), 2020))
    //day2 -- val result = sumValidPasswords(inputToList("2a_input.txt"))
    //day3 -- val result = countTrees(broadenWay(inputToList("3a_input.txt")), (0,0))
    //day5 -- val result = countResult(transformInput(inputToList("4a_input.txt")), List("byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:"))
    //day6 -- val result = findMissingIds(collectIds(transformLines(inputToList("5a_input.txt"))), getRange(collectIds(transformLines(inputToList("5a_input.txt")))))
    val result = calculate(transformInput(inputToList("6a_input.txt")))
    println(result)
  }
}
