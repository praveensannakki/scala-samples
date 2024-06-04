package com.scala.leetcode.array.test

object LongestCommonPrefix {

  def main(args: Array[String]): Unit = {
    println("LongestCommonPrefix is : " + longestCommonPrefix(Array("flower", "flow", "flight")))
    println("LongestCommonPrefix is : " + longestCommonPrefix(Array("dog", "racecar", "car")))
    println("LongestCommonPrefix is : " + longestCommonPrefix(Array("a")))
    println("LongestCommonPrefix is : " + longestCommonPrefix(Array("flower","flower","flower","flower")))
    println("LongestCommonPrefix is : " + longestCommonPrefix(Array("aac","aa","ccc")))
  }

  def findCommonPrfixNew(arr: Array[String]): String = {

    var ret = ""
    var charLen = 0
    var endLen = 0
    
    if(arr.toSet.size == 1) return arr { 0 }
    
    
//        for (i <- 1 until arr.length) {
//          println(arr { 0 } +", " +arr{i})
//        }
      
    
    try {
      for (i <- 1 until arr.length) {
        println(arr { 0 }.charAt(charLen) + ", " + arr { i }.charAt(charLen))
        if (arr { 0 }.charAt(charLen) == arr { i }.charAt(charLen)) {
          charLen = charLen + 1
        }
      }
      

     if (endLen < charLen) {
        endLen = charLen
      }
      
      charLen = 0
      
      println("charLen " + charLen + ", endLen " + endLen)
    } catch {
      case e: StringIndexOutOfBoundsException => 
        println("StringIndexOutOfBoundsException")
        return ret
    }
    arr { 0 }.substring(0, endLen)
  }

  def findCommonPrfix(arr: Array[String]): String = {

    var ret = ""
    var aSet = arr
    try {
      for (i <- 0 until aSet.length; j <- 1 until aSet.length) {
        //println(aSet { i })
        for (in <- 0 until 3) {
          if (aSet { i }.charAt(in) == aSet { j }.charAt(in)) {
            // println(aSet { i }.charAt(in))
            ret = ret + aSet { i }.charAt(in)
          }
        }
      }
    } catch {
      case e: StringIndexOutOfBoundsException => return ret
    }
    ret
  }
  
  def longestCommonPrefix(strs : Array[String]) : String ={
    
    if(strs == null || strs.length ==0)  return ""
    
    for(i<- 0 until strs{0}.length(); j<-1 until strs.length){
      var c = strs{0}.charAt(i)
      if (i == strs{j}.length() || strs{j}.charAt(i) != c)
                return strs{0}.substring(0, i); 
    }
    return strs{0}
  }

}