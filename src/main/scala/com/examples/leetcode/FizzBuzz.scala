package com.examples.leetcode

object FizzBuzz {

  def findFizzBuzz(n : Int) : Unit = {
    for(i <- 1 to n) {
      if (i%3 == 0 &&  i%5 == 0) {
        println(i + " FizzBuzz")
      } else if ( i%3 == 0) {
        println(i + " Fizz")
      } else if (i%5 == 0) {
        println(i + " Buzz")
      } else {
        println(i)
      }
    }
  }

  def fizzBuzzCase(n: Int) : Unit = {
    for(i<- 1 until n) {
      i match {
        case i: Int if (i%3 ==0 && i%5 == 0) => println("FizzBuzz")
        case i: Int if (i%3 == 0) => println("Fizz")
        case i: Int if (i%5 == 0) => println("Buzz")
        case _ => println(i)
      }
    }
  }

  private def fizzBuzzRevised(n: Int): Unit = {
    for (i <- 1 to n) {
      val result = (i % 3, i % 5) match {
        case (0, 0) => "FizzBuzz"
        case (0, _) => "Fizz"
        case (_, 0) => "Buzz"
        case _      => i.toString
      }
      println(result)
    }
  }

  def main(args: Array[String]) : Unit ={
    val sTime = System.currentTimeMillis()
    fizzBuzzRevised(10)
    val eTime = System.currentTimeMillis()
    println("Time taken in milliSec " + (eTime -sTime))
  }
}
