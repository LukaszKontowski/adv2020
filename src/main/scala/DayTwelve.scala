package daytwelve

import scala.io.Source

object DayTwelve {
  
  def secondCalculate(list: List[String], position: Tuple2[Int, Int], wayPoint: Tuple2[Int, Int]): Int = list match {
    case Nil => position._1.abs + position._2.abs
    case x :: xs => secondCalculate(list.tail, getNewPosition(position, getNewWaypoint(wayPoint, list.head), list.head), getNewWaypoint(wayPoint, list.head))
  }

  def getNewPosition(currentPosition: Tuple2[Int, Int], wayPoint: Tuple2[Int, Int], currentLine: String): Tuple2[Int, Int] = currentLine(0) match {
    case 'F' => (currentPosition._1 + (currentLine.substring(1).toInt * wayPoint._1), currentPosition._2 + (currentLine.substring(1).toInt * wayPoint._2))
    case _ => currentPosition
  }

  def getNewWaypoint(currentWaypoint: Tuple2[Int, Int], currentLine: String): Tuple2[Int, Int] = currentLine(0) match {
    case 'N' => (currentWaypoint._1, currentWaypoint._2 + currentLine.substring(1).toInt)
    case 'E' => (currentWaypoint._1 + currentLine.substring(1).toInt, currentWaypoint._2)
    case 'S' => (currentWaypoint._1, currentWaypoint._2 - currentLine.substring(1).toInt)
    case 'W' => (currentWaypoint._1 - currentLine.substring(1).toInt, currentWaypoint._2)
    case 'R' => currentLine.substring(1).toInt match {
      case 90 => (currentWaypoint._2, -currentWaypoint._1)
      case 180 => (-currentWaypoint._1, -currentWaypoint._2)
      case 270 => (-currentWaypoint._2, currentWaypoint._1)
    }
    case 'L' => currentLine.substring(1).toInt match {
      case 90 => (-currentWaypoint._2, currentWaypoint._1)
      case 180 => (-currentWaypoint._1, -currentWaypoint._2)
      case 270 => (currentWaypoint._2, -currentWaypoint._1)
    }
    case _ => currentWaypoint
  }

  def calculate(list: List[String], position: Tuple2[Int, Int], direction: String): Int = list match {
    case Nil => position._1.abs + position._2.abs
    case x :: xs => calculate(list.tail, calculatePosition(position, getNewDirection(list.head(0), list.head.substring(1).toInt, direction), list.head(0), list.head.substring(1).toInt), getNewDirection(list.head(0), list.head.substring(1).toInt, direction))
  }

  def calculatePosition(currentPosition: Tuple2[Int, Int], direction: String, forwardOrCardinal: Char, number: Int): Tuple2[Int, Int] = {
    if (forwardOrCardinal == 'F') direction match {
      case "N" => (currentPosition._1, currentPosition._2 + number)
      case "E" => (currentPosition._1 + number, currentPosition._2)
      case "S" => (currentPosition._1, currentPosition._2 - number)
      case "W" => (currentPosition._1 - number, currentPosition._2)
    } else forwardOrCardinal match {
      case 'N' => (currentPosition._1, currentPosition._2 + number)
      case 'E' => (currentPosition._1 + number, currentPosition._2)
      case 'S' => (currentPosition._1, currentPosition._2 - number)
      case 'W' => (currentPosition._1 - number, currentPosition._2)
      case _ => currentPosition
    }
  }

  def getNewDirection(rightOrLeftOrNone: Char, degrees: Int, currentDirection: String): String = {
    if (rightOrLeftOrNone == 'R') degrees match {
      case 90 => if (currentDirection == "N") "E" else if (currentDirection == "E") "S" else if (currentDirection == "S") "W" else "N"
      case 180 => if (currentDirection == "N") "S" else if (currentDirection == "E") "W" else if (currentDirection == "S") "N" else "E"
      case 270 => if (currentDirection == "N") "W" else if (currentDirection == "E") "N" else if (currentDirection == "S") "E" else "S"
    } else if (rightOrLeftOrNone == 'L') degrees match {
        case 90 => if (currentDirection == "N") "W" else if (currentDirection == "E") "N" else if (currentDirection == "S") "E" else "S"
        case 180 => if (currentDirection == "N") "S" else if (currentDirection == "E") "W" else if (currentDirection == "S") "N" else "E"
        case 270 => if (currentDirection == "N") "E" else if (currentDirection == "E") "S" else if (currentDirection == "S") "W" else "N"
      } else currentDirection
  }

  def inputToList(fName: String): List[String] = Source.fromResource(fName).getLines.toList
}
