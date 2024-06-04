package com.examples.leetcode

object CountOfAlphabets {

  def countAlphabets(s: String) : Int = {
    var count = 0
    for(char <-s) {
      if(char.isLetter)
        count +=1
    }
    count
  }

  def countAlphabetsEnhanced(s: String) : Int = {
    s.filter(_.isLetter).size
  }

  def main(args: Array[String]): Unit = {
    println("countAlphabets: "+ countAlphabets("Praveen1234Sannakki"))
    println("countAlphabetsEnhanced: " + countAlphabetsEnhanced("Praveen1234Sannakki"))
  }
}
