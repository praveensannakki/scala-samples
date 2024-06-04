package com.examples.leetcode

object SumOf2String extends App {
  println(sumOf2Strings("10", "30"))
  println(sumOf2Strings("66", "55"))
  println(sumOf2StringsCasting("66", "55"))
  
  println(4 % 10 + " " + 4 / 10)

  def sumOf2Strings(num1: String, num2: String): String = {

    var res = new StringBuilder();
    var carry = 0;
    var p1 = num1.length() - 1;
    var p2 = num2.length() - 1;

    println(s"p1=$p1,p2=$p2")
    println(num1.charAt(p1))

    while (p1 >= 0 || p2 >= 0) {
      var x1 = if (p1 >= 0) num1.charAt(p1) - '0' else 0
      var x2 = if (p2 >= 0) num2.charAt(p2) - '0' else 0

      println(s"x1=$x1,x2=$x2")
      var value = (x1 + x2 + carry) % 10;
      carry = (x1 + x2 + carry) / 10;
      res.append(value);
      p1 -= 1;
      p2 -= 1;
    }
    if (carry != 0) res.append(carry).reverse.toString() else res.reverse.toString()
  }

  def sumOf2StringsCasting(num1: String, num2: String): String = {
    (num1.toInt+num2.toInt).toString()
  }

}