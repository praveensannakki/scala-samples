package com.leetcode.string

import scala.util.control.Breaks.{break, breakable}

object LongCommonPrefix {

  def main(args: Array[String]): Unit = {
    println("LongestCommonPrefix is : " + longestCommonPrefix(Array("flower", "flow", "flight")))
    println("LongestCommonPrefix with sort is : " + findCommonPrefixWithSort(Array("flower", "flow", "flight")))
    println("LongestCommonPrefix is : " + longestCommonPrefix(Array("dog", "racecar", "car")))
    println("LongestCommonPrefix is : " + longestCommonPrefix(Array("a")))
    println("LongestCommonPrefix is : " + longestCommonPrefix(Array("flower","flower","flower","flower")))
    println("LongestCommonPrefix is : " + longestCommonPrefix(Array("aac","aa","ccc")))
  }

  def findCommonPrefixWithSort(arr: Array[String]): String = {
    if(arr.length == 0) return "";
    val sortedArr = arr.sortBy(_.length)
    //sortedArr.foreach(word => println(word))
    var result = sortedArr {0};
    for(i<- 0 until sortedArr{0}.length) {
      if (i == sortedArr{1}.length || sortedArr {0}.charAt(i) != sortedArr {1}.charAt(i)) {
        result = sortedArr {0}.substring(0, i);
      }
    }
    result;
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

  def longestCommonPrefixWithBreak(strs: Array[String]): String = {
    if (strs == null || strs.length == 0) return ""
    var result = strs{0}
    breakable{
      for (i <- 0 until strs(0).length; j <- 1 until strs.length) {
        if (i == strs(j).length() || strs{j}.charAt{i} != strs{0}.charAt(i)) {
          result = strs{0}.substring(0,i)
          break
        }
      }
    }
    result
  }

}