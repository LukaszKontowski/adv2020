//import dayone.DayOne._
//import daytwo.DayTwo._
//import dayThree.DayThree._
//import dayfour.DayFour._
//import dayfive.DayFive._
//import daysix.DaySix._
//import dayseven.DaySeven._
//import dayeight.DayEight._
//import daynine.DayNine._
//import dayten.DayTen._
//import daytwelve.DayTwelve._
//import daythirteen.DayThirteen._
//import dayfourteen.DayFourteen._
//import dayfifteen.DayFifteen._
import daysixteen.DaySixteen._

object Main {
  def main(args: Array[String]) {
    //day1 -- val result = getResult(findThree(inputToList("1a_input.txt"), 2020))
    //day2 -- val result = sumValidPasswords(inputToList("2a_input.txt"))
    //day3 -- val result = countTrees(broadenWay(inputToList("3a_input.txt")), (0,0))
    //day4 -- val result = countResult(transformInput(inputToList("4a_input.txt")), List("byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:"))
    //da5 -- val result = findMissingIds(collectIds(transformLines(inputToList("5a_input.txt"))), getRange(collectIds(transformLines(inputToList("5a_input.txt")))))
    //day6 -- val result = calculate(transformInput(inputToList("6a_input.txt")))
    //day7 -- val inMap = collectAll(inputToList("7a_input.txt"), Map())
    //day7 -- val result = countOutermosts(inMap) + countInters(collectWantedBags(inMap), inMap)
    //day 8 -- val result = findCorruptedIndex(inputToList("8a_input.txt"), List(0))
    //day 9 -- val result = findWrongNumber(inputToList("9a_input.txt"))
    //day 9 -- val set = findSet(inputToList("9a_input.txt"), inputToList("9a_input.txt"), List(), result, BigInt(0)) 
    //day10 -- val differences = countDifferences(0, inputToList("10a_input.txt").sorted, inputToList("10a_input.txt").max + 3, 0, 0)
    //day10 -- val result = differences._1 * differences._2
    //day12 -- val result = secondCalculate(inputToList("12a_input.txt"), (0,0), (10,1))
    //day13 -- val result = getResult(getTimestamp("13a_input.txt"), inputToList("13a_input.txt"), List(getTimestamp("13a_input.txt")), getTimestamp("13a_input.txt"))
    //day13 -- val ids = collectIds(inputToListTwo("13a_input.txt"), List(), 0)
    //day13 -- val result = findTimestamp(ids(0)._1, ids.tail, BigInt("378708"))
    //day14 -- val result = sumValues(collectAllValues(inputToList("14a_input.txt"), Map(), "anyString"))
    //day15 -- val startingNumbers = Map(13 -> (1,1), 0 -> (2,2), 10 -> (3,3), 12 -> (4,4), 1-> (5,5), 5 -> (6,6), 8 -> (7,7))
    //day15 -- val result = findNumber(startingNumbers, 30000000, 8, 8)
    val result = sumInvalidValues(collectNearbyTickets("16a_input.txt").flatten, rulesAsNested(collectRules("16a_input.txt")))
    println(result)
  }
}
