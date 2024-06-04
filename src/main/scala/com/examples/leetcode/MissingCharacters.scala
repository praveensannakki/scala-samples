package com.examples.leetcode

object MissingCharacters {

  def singleMissingCharacter(c : Array[Char]) : Char ={
    //generate characters from a-z
    val alphabets: Array[Char] = ('a' to 'z').toArray
    //total sum of ASCII values from alphabets
    val totalSum = alphabets.map(_.toInt).sum

    //lower case the given array to avoid edge case
    val given = c.map(_.toLower)
    //sum of given array
    val givenSum = given.map(_.toInt).sum

    // The missing character is the difference between the total sum and the given sum
    val missingCharAscii = totalSum - givenSum

    // Convert the ASCII value back to a character
    missingCharAscii.toChar
  }

  def findMultipleMissing(arr: Array[Char]) : Set[Char] = {
    val alphabets = ('a' to 'z').toSet

    // Create a set from the given array
    val givenSet = arr.toSet

    // Find the difference between the complete alphabet and the given set
    alphabets.diff(givenSet)
  }

  def main(args: Array[String]): Unit = {
    val mixedArray = Array('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'Y') // Missing 'z'
    val missingChar = singleMissingCharacter(mixedArray)
    println(s"The missing character is: $missingChar")

    val mixedMultipleArray = Array('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's', 't', 'u', 'w', 'x', 'y') // Missing 'n', 'v', 'z'
    val missingMultipleChars = findMultipleMissing(mixedMultipleArray)
    println(s"The missing characters are: ${missingMultipleChars.mkString(", ")}")
  }

}
