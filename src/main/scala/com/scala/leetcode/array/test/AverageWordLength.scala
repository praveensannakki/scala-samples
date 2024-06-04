package com.scala.leetcode.array.test

object AverageWordLength {
  def main(args: Array[String]): Unit = {
    println(findAvglength(Array("hey", "am" , "try")))
    println(avgLenght(Array("hey", "am" , "try")))
    println(findAvgLen(Array("hey", "am" , "try")))
  }
  def findAvglength(words : Array[String]) : Double = {
    var sum : Double = 0
    for(i<-0 to words.length-1) {
      sum += words(i).length()
    }
    println(sum + " " + words.length)
    sum/words.length
  }
  
  def avLen(words:Array[String]) : Double = {
    
    var sum : Double =0
    words.foreach(word=>sum=sum+word.length())
    sum/words.length
  }
  
  def avgLenght(words : Array[String]) : Double = {
    var sum =0.0
    words.foreach( x => sum=sum+x.length())
    sum/words.length
  }
  
  def findAvgLen(words:Array[String]) : Double = {
    words.mkString("").length().toDouble/words.length
  }
  
}