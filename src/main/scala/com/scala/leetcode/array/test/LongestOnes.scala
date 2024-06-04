package com.scala.leetcode.array.test

object LongestOnes extends App {

  def longestOnes(A: Array[Int], K: Int): Int = {
    var left: Int = 0; var right = 0; var w = K

    for (i <- 0 until A.length) {

      // If we included a zero in the window we reduce the value of K.
      // Since K is the maximum zeros allowed in a window.
      if (A { i } == 0) w -= 1

      // A negative K denotes we have consumed all allowed flips and window has
      // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
      if (w < 0) {
        // If the left element to be thrown out is zero we increase K.
        if (A { left } == 0) w += 1
        left += 1
      }
      right = i
    }
    return right - left + 1
  }

  print(longestOnes(Array(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2))
}