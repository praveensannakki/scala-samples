package com.leetcode.array

object TwoSums {
  def main(args: Array[String]): Unit = {
    val res = findIndexIteration(Array(2,3,4,5,6), 11)
    res.foreach(x=>print(x + " "))
    
    println()
    
    val res1 = findIndex(Array(2,3,4,5,6), 11)
    res1.foreach(x=>print(x + " "))
    
    println()
     
    val res2 = findIndexOfSum(Array(2,3,4,5,6), 11)
    res2.foreach(x=>print(x + " "))
  }
  
  def findIndexIteration(nums : Array[Int], target : Int) : Array[Int] = {
    for(i <-0 until nums.length) {
      for(j<-1 until nums.length) {
        if(nums(j) == target -nums(i)){
          return Array(i,j)
        }
      }
    }
    
   Array(Integer.MAX_VALUE)
   
  }
  
  def findIndexOfSum(nums:Array[Int], target:Int) : Array[Int] = {
    
    for(i<- 0 until nums.length; j<-1 until nums.length){
      if(nums(j)==target-nums(i)){
        return Array(i,j)
      }
    }
    Array(Integer.MAX_VALUE)
  }
  
  def findIndex (nums : Array[Int], target : Int) : Array[Int] = {
    
    var hm = new java.util.HashMap[Integer,Integer]()
    for(i <-0 until nums.length){
      var t = target - nums(i)
      if(hm.keySet.contains(t)){
        return Array(hm.get(t),i)
      }
      hm.put(nums(i), i)
    }
    
    Array(Integer.MAX_VALUE)
    
  }
  
}