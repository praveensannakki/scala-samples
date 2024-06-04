package com.scala.leetcode.array.test

object SecondMaxFromMap extends App {
  
  println(findMaxValue(Map("fname" -> 2, "lname" -> 3, "mname"->1)))
  println(findMaxFor(Map("fname" -> 2, "lname" -> 3, "mname"->1)))
  println(secondMax(Map("fname" -> 2, "lname" -> 3, "mname"->1)))
  
  def findMaxValue(map : Map[String,Int]) : Int ={
    var max = 0
    map foreach(x=>{
      max = Math.max(max, x._2)
    })
    max
  }
  
  def findMaxFor(map : Map[String,Int]) : Int ={
    var max =0
    for ((k,v) <- map) {
      max = Math.max(max, v)
    }
    max
  }

  def secondMax[K](map: Map[K, Int]): Option[Int] = {
    if (map.size < 2) return None // Return None if there are less than 2 elements

    // Convert map values to a sequence, sort in descending order, and get the second element
    val sortedValues = map.values.toSeq.sorted(Ordering[Int].reverse)
    Some(sortedValues(1))
  }
}