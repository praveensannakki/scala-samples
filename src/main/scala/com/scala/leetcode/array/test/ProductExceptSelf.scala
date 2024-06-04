package com.scala.leetcode.array.test

object ProductExceptSelf extends App {

  def productExceptSelf(nums: Array[Int]): Array[Int] = {

    var ret = new Array[Int](nums.length)
    ret(0) = 1
    for (i <- 1 to nums.length - 1) {
      ret(i) = nums(i - 1) * ret(i - 1)
    }

    ret.foreach(x => print(x+" "))
    println("\n")
    var rightProd = 1
    for (i <- nums.length - 1 to 0 by -1) {
      ret(i) = rightProd * ret(i)
      rightProd *= nums(i)
    }
    
    ret
  }

  productExceptSelf(Array(1, 2, 3, 4)).foreach(x=>print(x+" "))
  println()
  productExceptSelfDevide(Array(1, 2, 3, 4)).foreach(x=>print(x+" "))
  
  def productExceptSelfDevide(nums: Array[Int]): Array[Int] = {

    var ret = new Array[Int](nums.length)
    var prod = 1
    nums.foreach(x=> prod*=x)
    
    println("\nproduct of array is " +prod + "\n")
    for (i <- nums.length - 1 to 0 by -1) {
      ret(i) = prod / nums(i)
    }
    
    ret
  }
  
}