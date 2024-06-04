package com.scala.leetcode.array.test

object isValidPolindrome {
   def main(args: Array[String]): Unit = {
    println(isPalindrome1("race a car"))
    println(isPalindrome1("A man, a plan, a canal: Panama"))
    println(isPalindrome2("A man, a plan, a canal: Panama"))
    println(isPalindrome("A man, a plan, a canal: Panama"))
  }
   
    def isPalindrome2(s: String): Boolean = {
        val str = s.replaceAll("[^a-zA-Z0-9]", "")
        if (str.equalsIgnoreCase(str.reverse)) {
          return true
        }
        return false
    }
    
    def isPalindrome(s: String): Boolean = {
        val str = s.filter(_.isLetterOrDigit).map(_.toLower)
        str.equalsIgnoreCase(str.reverse)
    }
   
   def isPalindrome1(s: String): Boolean = {
        val str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase()
        println(str)
        var i =0
        var j = str.length -1
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
              return false
                //return isPolindrome(str, i+1, j) || isPolindrome(str, i, j-1)
            }
            i+=1;
            j-=1;
        }
        return true;
    }
   
   def isPolindrome(str : String, i : Int, j : Int) :  Boolean = {
     var a =i
     var b=j
        while(a < b) {
          if(str.charAt(a)!= str.charAt(b))
            return false
        }
       a+=1
       b-=1
     return true
   }
}