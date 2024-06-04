package com.scala.leetcode.array.test

object isPalindrome extends App {
  def isPalindrome(x: Int): Boolean = {
        if(x<0){
            return false
        }else if(x.toString().reverse.equals(x.toString())) {
            return true
        }else {
          return false
        }
    }
  
  
  def isPalindromeInt(x: Int): Boolean = {
    
    var ret = false
        if(x<0){
            return false
        }
        
        var num=x; var reverse = 0; var rem=0;
        
        while(num!=0) {
          rem = num%10;
          reverse = reverse*10 + rem
          num=num/10
        }
        
        if(x==reverse){
          ret = true
        }
        
        ret;
    }
  
}