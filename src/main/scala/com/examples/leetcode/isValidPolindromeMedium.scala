package com.examples.leetcode

object isValidPolindromeMedium extends App {
  
  /**
   * brute force approach
   * O(n2) O(N)
   */
  def validPalindrome(s: String): Boolean = {
    if(!isPalindrome(s)) {
      var sb = new StringBuilder(s)
        for(i <-0 until s.length){
            var c = s.charAt(i)
            if(isPalindrome(sb.deleteCharAt(i))) return true;
            sb.insert(i,c)
        }
        return false
    }
    true
  }
    
     def isPalindrome(s: CharSequence): Boolean = {
        for(i<-0 until s.length/2){
            if(s.charAt(i) !=s.charAt(s.length-1-i)) 
                return false
        }
        return true
    }
     
     println("With Brute Force      -> " +validPalindrome("aba"))
     println("With Brute Force      -> " +validPalindrome("dcabacd"))
     
     println("With range comparison -> " + validPalindromeEnhanced("malayalam"))
     
     /**
      * O(N) & O(1)
      */
     def validPalindromeEnhanced(s: String): Boolean = {
       for(i <- 0 to s.length/2) {
         if(s.charAt(i) != s.charAt(s.length() -1 -i)) {
           println(i + " " + s.charAt(i) + " " + (s.length() - 1 - i) +" " + s.charAt(s.length() -1 -i))
             var j = s.length() - 1 - i
             return (isPalindromeRange(s, i+1, j) || isPalindromeRange(s, i, j-1))
             //return (isPalindrome(s.subSequence(i+1, j)) || isPalindrome(s.subSequence(i, j-1)))
         }
       }
       true
     }
     
     def isPalindromeRange(s:String, i:Int, j:Int) : Boolean = {
         //for (i <- 1 to 2; j <- 1 to 2)
       println(s"i is $i, and j is $j and "+ (i+(j-i)/2))
       for( k <- i to i+(j-i)/2) {
         println(s.charAt(k) +" "+ s.charAt(j - k + i))
         if (s.charAt(k) != s.charAt(j - k + i)) return false
       }
       return true
     }
     
}