package com.examples.leetcode

/**
 * 198. House Robber
 *
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing
 * each of them is that adjacent houses have security systems connected and it will automatically
 * contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Example 2:
 * Input: nums  [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * /Users/praveensannakki/workspace/leetcode-2024/scala/src/com/example/leetcode/ArrayToBCD.scala
 */
object HouseRobber {
  private def rob(nums: Array[Int]): Int = {
    val length = nums.length
    if (length == 1) {
      nums(0)
    } else if (length == 2) {
      math.max(nums(0), nums(1))
    } else {
      val haul = new Array[Int](length)
      haul(0) = nums(0)
      haul(1) = math.max(nums(0), nums(1))
      for (n <- 2 until length) {
        haul(n) = math.max(nums(n) + haul(n-2), haul(n-1))
      }
      haul.last
    }
  }

  def main(args: Array[String]) : Unit = {
    println(rob(Array(1,2,3,1)))
    println(rob(Array(2,7,9,3,1)))
  }

}
