package com.examples.leetcode

import scala.util.control.Breaks.{break, breakable}

object DevideArray {

  def devideArray(nums: Array[Int]) : Boolean = {
    var counts : Array[Int] = new Array[Int](nums.max+1)
    nums.foreach(num => counts(num) +=1)
    counts.forall(x => x%2 == 0)
  }

  def devideArrayBasic(nums: Array[Int]) : Boolean = {
    var counts: Array[Int] = new Array[Int](501)
    for(i<- nums.indices){
      counts(nums(i)) += 1
    }
    for(i <- 0 to counts.length-1) { // use length -1 when using "to" to iterate over
      if(counts(i)%2!=0) return false
    }
    true
  }

  def devideArrayBreakable(nums: Array[Int]) : Boolean = {
    var result: Boolean = false
    var counts: Array[Int] = new Array[Int](501)
    for(i<- nums.indices) {
      counts(nums(i)) += 1
    }
    breakable {
      for(i <- 0 until counts.length) {
        if(counts(i)%2==0) {
          result = true
        } else {
          result = false
          break
        }
      }
    }
    result
  }

  def main(args : Array[String]) : Unit = {
    println(devideArrayBreakable(Array(3,2,3,2,8,8)))
    println(devideArrayBreakable(Array(1,2,3,4)))
  }
}
