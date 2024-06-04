package com.scala.leetcode.array.test

import scala.collection.mutable.ArrayBuffer

object CommonWords {

  def main(args: Array[String]): Unit = {
    val str1 = "Firstly this is the first string"
    val str2: String = "Next is the second string"
    
    //val str1 = "A blue whale is whale which is blue"
    //val str2: String = "The blue ocean has whales which are blue"

    println(findCommonWords(str1, str2))
    println(findCommonWordsArray(str1.split(" "), str2.split(" ")).foreach(x=>print(x+" ")))

  }

  def findCommonWordsArray(arr1: Array[String], arr2: Array[String]): Array[String] = {

    //var ret = new Array[String](arr1.length + arr2.size)
    var ret = ArrayBuffer[String]()
    
    for (i <- 0 until arr1.length) {
      if (!arr2.contains(arr1(i))) {
        ret+= arr1(i)
      }
    }
    
    for (i <- 0 until arr2.length) {
      if (!ret.contains(arr2(i)) && !arr1.contains(arr2(i))) {
        ret+= arr2(i)
      }
    }
    
    ret.toArray
  }

  def findCommonWords(str1: String, str2: String): String = {
    var list = (str1.concat(" ").concat(str2)).split(" ")
    var list2 = (str1 + " " + str2).split(" ").toSet.toList
    var hm = new java.util.HashMap[String, Int]

    for (i <- 0 to list.length - 1) {
      hm.put(list(i), hm.getOrDefault(list(i), 0) + 1)
    }
    var ret = ""
    for (i <- 0 to list.size - 1) {
      if (hm.get(list(i)) ==1 ) {
        ret = ret + " " + list(i)
      }
    }
    ret
  }
}