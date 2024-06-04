package com.scala.leetcode.array.test

object LongestPolindrome extends App {
  
  def validPalindrome(s: String): String = {
    if(!isPalindrome(s)) {
      var sb = new StringBuilder(s)
        for(i <-0 until s.length){
            var c = s.charAt(i)
            if(isPalindrome(sb.deleteCharAt(i))) return sb.toString();
            sb.insert(i,c)
        }
       // return false
    }
    s
  }
    
     def isPalindrome(s: CharSequence): Boolean = {
        for(i<-0 until s.length/2){
            if(s.charAt(i) !=s.charAt(s.length-1-i)) 
                return false
        }
        return true
    }
     
     println("With Brute Force      -> " +validPalindrome("babad"))//abazxyzzyxf
     println("With Brute Force      -> " +validPalindrome("abamalayalam"))
     
}