package com.examples.leetcode

import scala.collection.mutable.HashMap
import scala.util.control.Breaks.break
import scala.util.control.Breaks.breakable

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
object TwoSum {
  private def twoSumRevised(nums: Array[Int], target: Int): Array[Int] = {
    val map: HashMap[Int, Int] = HashMap() // Maps value -> index
    var result: Array[Int] = Array(0, 0)
    breakable {
      for (i <- 0 until nums.length) {
        val value = nums(i)
        if (map.contains(target - value)) {
          result = Array(map(target - value), i)
          break
        }
        map(value) = i
      }
    }
    result
  }

  private def findTwoSumWithHashMap(nums: Array[Int], target: Int): Array[Int] = {
    var hm = HashMap[Int, Int]()
    var result = new Array[Int](2)
    breakable {
      for (i <- nums.indices) {
        val diff = target - nums {i}
        if (hm.contains(diff)) {
          result(0) = hm.getOrElse(diff, 0)
          result(1) = i
          break
        }
        hm.put(nums {i}, i)
      }
    }
    result
  }

  private def findIndexOfTwoSum(nums: Array[Int], target: Int): Array[Int] = {
    for (i <- 0 until nums.length) {
      for (j <- i + 1 until nums.length) {
        if (target == nums(i) + nums(j)) {
          return Array(i, j)
        }
      }
    }
    Array(Integer.MAX_VALUE)
  }

  def main(args: Array[String]): Unit = {
    println("With bruteforce -> " + findIndexOfTwoSum(Array(3, 2, 4), 6).mkString(","))
    println("With HashMap ----> " + findTwoSumWithHashMap(Array(3, 2, 4), 6).mkString(","))
    println("With HashMap ----> " + twoSumRevised(Array(3, 2, 4), 6).mkString(","))
  }

}
