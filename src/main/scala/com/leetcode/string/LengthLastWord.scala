package com.leetcode.string

object LengthLastWord extends App {
  def lengthOfLastWord(s: String): Int = {
    s.split(" ").last.length
  }
  print(s"lengthOfLastWord: " + lengthOfLastWord("   fly me   to   the moon  "))
}