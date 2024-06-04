package com.examples.leetcode

object LongestPalindrome {

  private def findLongestPalindrome(s: String) : String = {
    val strArr : Array[String] = s.split(" ")
    var result = strArr(0)
    var len = strArr(0).length
    for (i <- 1 to strArr.length -1) {
      if(isPalindrome(strArr(i)) && len < strArr(i).length){
        result = strArr(i)
        len = strArr(i).length
      }
    }
    result
  }

  private def isPalindrome(s: String) : Boolean ={
    s.equalsIgnoreCase(s.reverse)
  }

  def main(args: Array[String]): Unit = {
    println(findLongestPalindrome("nota bab racecar bb malayalam notapalindrome"))
  }
}
