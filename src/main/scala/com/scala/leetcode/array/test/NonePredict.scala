package com.scala.leetcode.array.test

object NonePredict {
  def main(args: Array[String]): Unit = {
    println(addElelemntToNone(Array(1, None, 2, None,None,3, "as")).foreach(x => print(x + ",")))
    println(addElelemntToNoneAny(Array(1, None, 2, None,None,3, "as",None)).foreach(x => print(x + ",")))
    
    println(addElementToNull(List(null,1, null, 2, null,null,3,null)).foreach(x => print(x)))
    println(addElementToNull(List()).foreach(x => print(x)))
  }
  
  /**
   * got in the coding round 
   */
  def addElementToNull(list: List[Integer] ) : List[Integer] = {
    var ret = new Array[Integer](list.length)
    if(list.size >0){
      ret(0) = list(0)
      for(i<-1 to list.size -1){
        if(list(i)!=null){
          ret(i) = list(i)
        }else{
          ret(i)=ret(i-1)
        }
      }
    }
    ret.toList
  }

  def addElelemntToNone(arr: Array[Any]): Array[Int] = {
    var ret = new Array[Int](arr.length)

    for (i <- 0 to arr.length - 1) {
      if (arr(i) == None) {
        ret(i) = toInt(arr(i - 1).toString())
      } else {
        ret(i) = toInt(arr(i).toString())
      }
    }

    ret
  }
  
  def addElelemntToNoneAny(arr: Array[Any]): Array[Any] = {
    for (i <- 0 to arr.length - 1) {
      if (arr(i) == None) {
        arr(i) = arr(i - 1)
      } else {
        arr(i) = arr(i)
      }
    }
    arr
  }

  def toInt(s: String): Int = {
    try {
      Integer.parseInt(s.trim)
    } catch {
      case e: Exception => 0
    }
  }
  
  
  
}