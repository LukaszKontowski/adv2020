import dayone.DayOne._

object Main {
  def main(args: Array[String]) {
    val result = getResult(findThree(inputToList("1a_input.txt"), 2020))
    println(result)
  }
}
