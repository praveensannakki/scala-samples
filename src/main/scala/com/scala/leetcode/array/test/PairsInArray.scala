package com.scala.leetcode.array.test

object PairsInArray extends App {
  
  def sockMerchant(n: Int, ar: Array[Int]): Int = {
        var hm = new java.util.HashMap[Int,Int]()
        ar.foreach(x=>{
            hm.put(x,hm.getOrDefault(x,0)+1)
        })
        var ret=0
        var sockSet = ar.toSet.toArray
//        sockSet.foreach( x => {
//            if( hm.get(x)%2 == 0)  {
//                ret = ret + (hm.get(x)/2)
//            }     
//        })
        
        sockSet.foreach( x => {
            if( hm.get(x) >= 2)  {
                ret = ret + (hm.get(x)/2)
            }     
        })
        ret
    }
  
  //def main(args: Array[String]) {
    println(sockMerchant(9, Array(10,20,20,10,10,30,50,10,20)))
  //}
      
}