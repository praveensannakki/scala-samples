package com.scala.leetcode.array.test

object StringToInt {
  def main(args: Array[String]): Unit = {
    println("String to Int : " + convertToInt("123"))
    println("Int to String : " + convertToString(123))
    println("Int to String : " + intToStrig(123))
  }

  def convertToInt(s: String): Int = {
    var num = 0
    if (s.length() != 0) {
      for (c <- s) {
        num = num * 10 + (c - 48) //num = num * 10 + (c - '0') // this also works
      }
    } else {
      num = Integer.MIN_VALUE
    }
    num
  }

  def convertToString(num: Int): String = {
    var n = num
    if (n == 0) return "0";

    var sb = new StringBuilder()
    while (n > 0) {
      var curr = n % 10
      n = n / 10
      sb.append(curr)
    }
    
    println(sb)
    
    return sb.reverse.toString()
    
    var s = sb.substring(0)
    println(s)
    sb = new StringBuilder()
    for (i <- s.length() - 1 to 0 by -1) {
      sb.append(s.charAt(i));
    }
    return sb.substring(0);
  }

  def intToStrig(n: Int): String = {
    var num = n
    var b = new StringBuilder()
    while (num != 0) {
      b.insert(0, ('0' + num % 10).toChar)
      num = num / 10;
    }
    b.toString()
  }

}