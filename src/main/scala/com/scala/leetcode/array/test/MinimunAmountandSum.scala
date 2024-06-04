package com.scala.leetcode.array.test

object MinimunAmountandSum {
  def main(args: Array[String]): Unit = {
    println(findTotalAmountAfterDiscount(Array(2, 5, 1, 4)))
    println(findTotalAmountAfterDiscount(Array(4, 9, 2, 3)))
  }

  def findTotalAmountAfterDiscount(prices: Array[Int]): Long = {
    var total = 0
    if (prices.length != 0) {
      var maxDiscount = prices { 0 }
      total = prices { 0 }
      var min = prices { 0 }
      for (i <- 1 to prices.length - 1) {
        println(" i " + i + " total " + total + " discount " + maxDiscount)
        if (prices { i } > maxDiscount) {
          total = total + (prices { i } - maxDiscount)
          maxDiscount = Math.min(prices { i }, prices { i - 1 })
        } else {
          maxDiscount = Math.min(prices { i }, prices { i - 1 })
        }
      }
    } else {
      total = -1
    }
    total
  }

}