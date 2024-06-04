package com.scala.leetcode.array.test

object AddBinary extends App {

  def addBinary(a: String, b: String): String = {
    var aDer = a.reverse
    var bDer = b.reverse
    val aLen = a.length()
    val bLen = b.length()
    val len = if (a.length() > b.length()) a.length() else b.length()

    println(aDer + ", " + bDer)

    for (i <- 0 until len) {

    }
    a + b
  }

  def addBinaryChar(a: String, b: String): String = {

    var res = new StringBuilder();
    var carry = 0;
    var p1 = a.length() - 1;
    var p2 = b.length() - 1;

    println(s"p1=$p1,p2=$p2")
    println(a.charAt(p1) + ", " + b.charAt(p2))

    while (p1 >= 0 || p2 >= 0) {
      var x1 = if (p1 >= 0) a.charAt(p1) - '0' else 0
      var x2 = if (p2 >= 0) b.charAt(p2) - '0' else 0

      println(s"x1=$x1,x2=$x2")
      var value = (x1 + x2 + carry) % 2;
      carry = (x1 + x2 + carry) / 2;

      //      var value = if(x1+x2+carry==3){
      //        carry = 1
      //        1.toString()
      //      } else if(x1+x2+carry==2) {
      //        carry = 1
      //        0.toString()
      //      } else {
      //
      //        x1+x2.toString()
      //      }
      res.append(value);
      p1 -= 1;
      p2 -= 1;
    }
    if (carry != 0) res.append(carry).reverse.toString() else res.reverse.toString()
  }

  println("Binary Sum : " + addBinaryChar("11", "1"))
}