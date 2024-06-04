package com.scala.leetcode.array.test

object FirstUniqueChar {
  def main(args: Array[String]): Unit = {
    println(firstUniqChar("com/examples/leetcode"))
    println(firstUniqChar("loveleetcode"))
    println(firstUniqChar("z"))
  }

  def firstUniqChar(s: String): Int = {
    var hm = new java.util.HashMap[Char, Int]
    println(s.length + " " + s.size)
    if (s.length > 0) {
      for (c <- s) {
        hm.put(c, hm.getOrDefault(c, 0) + 1)
      }
      for (i <- 0 to s.length() - 1) {
        if (hm.get(s.charAt(i)) == 1)
          return i
      }
    }
    -1
  }

  def firstUniqChar1(s: String): Int = {
    var ret = -1
    var isUnique = false
    for (i <- 0 to s.length() - 1) {
      for (j <- i + 1 to s.length() - 1) {
        //          println(s.charAt(i) + " " + s.charAt(j))
        if (s.charAt(i) == s.charAt(j)) {
          return -1
        }
      }
      if (isUnique)
        return i
    }
    ret
  }

  def firstUniq2Char(s: String): Int = {
    for (i <- 0 to s.toCharArray().length - 1) {
      if (!s.substring(i + 1, s.length() - 1).contains(s.charAt(i))) {
        return i
      }
    }
    -1
  }
}