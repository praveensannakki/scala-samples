package com.scala.leetcode.array.test

object MonotonicArry {
  
  def main(args: Array[String]): Unit = {
   println(isMonotonic(Array(1,2,4,4,5)))
   println(isMonotonic(Array(3,2,1)))
   println(isMonotonic(Array(3,1,2)))
   
  }
  
  def isMonotonic(A: Array[Int]): Boolean = {
        var increasing = true
        var decreasing = true
        for(i <- 0 to A.length-2){
            if(A{i} > A{i+1}){increasing = false}
                
            if(A{i} < A{i+1}){decreasing = false}
        }
      increasing || decreasing
    }
}