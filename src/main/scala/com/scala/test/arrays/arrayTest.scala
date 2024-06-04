package com.scala.test.arrays

object arrayTest {

  def main(args: Array[String]): Unit = {

    val x = List(1, 2, 3)
    var sum = 0
    x.foreach { println }
    x.foreach(sum += _)
    println(sum)
    
    for(i <- "abacabad".zipWithIndex)
      println(i._1 + " " + i._2)
     
    println(nonRepeating("abacaba"))

  }
  
  def nonRepeating(str : String) : Char = {
    var tmp : Char ='_'
    for(c <- str) {
      var isduplicate=false;
      tmp = c
      for(s <-str ) {
        if(tmp.equals(s))
          isduplicate=true
      }
      if(!isduplicate) return tmp
    }
    tmp
  }

}