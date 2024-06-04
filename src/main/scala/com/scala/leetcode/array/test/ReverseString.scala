package com.scala.leetcode.array.test

object ReverseString {
  def main(args: Array[String]): Unit = {
    reverseString(Array('H','E','L','L','O','S','f'))
    reverseString(Array('A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'))
  }
  
  def reverseString(s: Array[Char]): Unit = {
      println(s.length/2)
      s.foreach(c => print("'" + c +","))
      println()
        for (i <- Range(0, s.length/2)) {
            val temp = s(i)
            s(i) = s(s.length-i-1)
            s(s.length-i-1) = temp
        }
        s.foreach(c => print("'" + c +","))
    }
}