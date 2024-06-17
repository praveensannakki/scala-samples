package com.leetcode.array

object ContainDuplicate {
  def main(args: Array[String]): Unit = {
    println(containsDuplicate(Array(1, 2, 3, 1)))
    println(containsDuplicateSizeCheck(Array(1, 2, 3)))
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

  def containsDuplicateSizeCheck(nums: Array[Int]): Boolean = {
    if (nums.size == nums.toSet.size)
      return false
    true
  }

}