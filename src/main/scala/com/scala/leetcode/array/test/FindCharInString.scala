package com.scala.leetcode.array.test

object FindCharInString {
  def main(args: Array[String]): Unit = {
    println(findNumOfTimesChar("missisipi", 's'))
    println("fb code " + findNumOfTimesChar("missisipi", "s"))
    println(findNumOfTimesCharIndex("missisipi", 's').foreach(x => print(x + " ")))
  }

  def findNumOfTimesChar(str: String, char: Char): Int = {
    var count = 0
    for (c <- str) {
      if (char.equals(c))
        count += 1
    }
    count
    
    str.count(_ == char) //str.count(_.equals(char))
  }
  
  /***
   * facebook interview code
   */
  def findNumOfTimesChar(str: String, char: String): Int = {
    var ret =0 
    if(null!=char && null!= str && str.length()>0 && char.length()>0){
      ret = str.count(_ == char.charAt(0))
    }
    ret
  }

  def findNumOfTimesCharIndex(str: String, char: Char): Array[Int] = {
    var ret = new Array[Int](str.length())
    var count = 0
    for (i <- 0 until str.length()) {
      if (char.equals(str.charAt(i))) {
        ret(count) = i
        count += 1
      }
    }
    ret
  }

}