package com.scala.leetcode.array.test

object ShuffleArray {
  
  def main(args: Array[String]): Unit = {
    val res = shuffle(Array(2,5,1,3,4,7), 3)
    res.foreach(println)
    //[2,3,5,4,1,7] 
  }
  
  def shuffle(nums: Array[Int], n: Int): Array[Int] = {
        var newnums: Array[Int] = new Array[Int](n+n)
        var tempi:Int = 0
        for(i <- 0 to n-1){
            newnums(i+i)=nums(i)
            newnums(i+i+1)=nums(i+n)
        }
        newnums
    }
  
  def shuffle2(nums: Array[Int], n: Int): Array[Int] = {
    var ret = new Array[Int](nums.length)
    var curr = 0
    var i =0
    var j =n
    var ind = n
        for(k <- 0 to n-1){
          ret(curr) = nums(i) 
          curr = curr + 1
          i = i +1
          ret(curr) = nums(j)
          curr = curr + 1
          j = j +1
        }
    ret
    }
}