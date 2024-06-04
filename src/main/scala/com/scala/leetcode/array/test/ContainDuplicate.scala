package com.scala.leetcode.array.test

object ContainDuplicate {
  def main(args: Array[String]): Unit = {
    println(containsDuplicate(Array(1, 2, 3, 1)))
    println(containsDuplicate2(Array(1, 2, 3, 1)))
  }

  def containsDuplicate(nums: Array[Int]): Boolean = {
    val hm = new java.util.HashMap[Int, Int]()
    for (i <- 0 to nums.length - 1) {
      if (hm.keySet().contains(nums { i }))
        return true
      hm.put(nums { i }, i)
    }
    false
  }

  def containsDuplicate2(nums: Array[Int]): Boolean = {
    if (nums.size == nums.toSet.size)
      return false
    true
  }
  
  def containsDuplicate3(nums: Array[Int]): Boolean = {
        val numsS = nums.sorted
        for (i <- 1 until numsS.length ){
            if(numsS(i) == numsS(i-1)){
                return true
            }
        }
        false
    }
}