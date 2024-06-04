package com.scala.leetcode.array.test

object PlusOne extends App {

  def plusOne(digits: Array[Int]): Array[Int] = {

    val plusRes = (BigInt(digits.mkString) + 1).toString()
    //println(plusRes + " lenght of plusRes : " + plusRes.length())

    var ret = new Array[Int](plusRes.length())

    for (i <- 0 until plusRes.length()) {

      // println(plusRes.charAt(i))
      ret { i } = Character.getNumericValue(plusRes.charAt(i))
    }
    ret
  }

  def plusOneNew(digits: Array[Int]): Array[Int] = {
    (BigInt(digits.mkString) + 1).toString.map(_.asDigit).toArray
  }

  val ret = plusOne(Array(1, 2, 3, 4))
  ret.foreach(x => print(x + " "))

  println()

  val ret1 = plusOneNew(Array(9, 8, 7, 6, 5, 4, 3, 2, 1, 0))
  ret1.foreach(x => print(x + " "))

  def plusOneBasic(digits: Array[Int]): Array[Int] = {

    for (i <- digits.length - 1 to 0 by -1) {
      if (digits { i } < 9) {
        digits { i } = digits { i } + 1
        return digits
      } else {
        digits { i } = 0
      }
    }

    Array(1) ++ digits
  }

  import scala.util.control.Breaks._

  def plusOneBreak(digits: Array[Int]): Array[Int] = {
    var result = digits
    breakable {
      for (i <- (digits.size - 1) to 0 by -1) {
        if (digits(i) != 9) {
          result(i) += 1
          break
        } else {
          result(i) = 0
          if (i == 0) {
            // case [9] need to convert to [1,0]
            result = Array(1) ++ result
          }
        }
      }
    }
    result
  }
}