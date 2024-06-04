package com.scala.leetcode.array.test

object SqurtOfNumber extends App {

  def mySqrt(x: Int): Int = {
    var left = 0
    var right = x
    var mid = 0

    while (left <= right) {
      mid = (left + right) / 2

      println(left + ", " + mid + ", " + right)
      if (mid * mid < x) {
        left = mid + 1
      } else if (mid * mid > x) {
        right = mid - 1
      } else {
        return mid
      }
    }

    right
  }

  println(mySqrt(4))
  println("New value ")
  println(mySqrt(17))

}