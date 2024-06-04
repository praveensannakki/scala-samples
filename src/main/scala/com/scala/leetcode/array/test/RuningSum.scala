package com.scala.leetcode.array.test;

object RuningSum {
  def main(args: Array[String]): Unit = {
    val rs = runningSum(Array(1,2,3,4,5))
    rs.foreach(println)
  }
  
  def runningSum(nums : Array[Int]) : Array[Int] = {  
    var ret = new Array[Int](nums.length)
    var temp = 0
    for(i <- 0 until nums.length){
      temp += nums(i)
      ret (i) = temp 
     }
    ret
  }
  
  def runningSumwWithoutVariable(nums: Array[Int]): Array[Int] = {
        val ret: Array[Int] = new Array[Int](nums.length)
        ret(0) = nums(0);
        for(i <- 1 to nums.length -1)
            ret(i) = ret(i-1)+nums(i);
        ret
    }
}