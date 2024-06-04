package com.examples.leetcode

import scala.collection.immutable.HashMap

object RomanToInteger extends App {

  /**
   * put('I', 1);
   * put('V',5);
   * put('X',10);
   * put('L',50);
   * put('C',100);
   * put('D',500);
   * put('M',1000);
   *
   * @param s
   * @return
   */
  private def romanToInteger(s : String) : Int = {
    val map : HashMap[Char, Int] = HashMap[Char, Int](
      'I' -> 1,
      'V' -> 5,
      'X' -> 10,
      'L' -> 50,
      'C' -> 100,
      'D' -> 500,
      'M' -> 1000
    )
    var i =0;
    var sum = 0
    while ( i< s.length) {
      val currentValue = map(s.charAt(i))
      if (i+1 < s.length && currentValue < map.getOrElse(s.charAt(i+1), 0)) {
        sum = sum + (s.charAt(i+1) - currentValue)
      } else {
        sum = sum + currentValue
        i+=1
      }
    }
    sum
  }

  println("roman to int of LVIII is : " + RomanToInteger.romanToInteger("LVIII"))
}
