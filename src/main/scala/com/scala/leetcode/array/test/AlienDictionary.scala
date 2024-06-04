package com.scala.leetcode.array.test

object AlienDictionary extends App {

  def isAlienSorted(words: Array[String], order: String): Boolean = {
    var index = new Array[Int](26)
    for (i <- 0 to order.length - 1) {
      index { order.charAt(i) - 'a' } = i
    }

    import scala.util.control._
    val loop = new Breaks

    loop.breakable {
      for (i <- 0 until words.length - 1) {
        var w1 = words(i)
        var w2 = words(i + 1)
        for (j <- 0 until Math.min(w1.length, w2.length)) {
          if (w1.charAt(j) != w2.charAt(j)) {
            if (index(w1.charAt(j) - 'a') > index(w2.charAt(j) - 'a')) return false
            loop.break
          }
          if (j == Math.min(w1.length, w2.length)-1 && w1.length > w2.length) return false
        }
      }
    }
    return true
  }

  def isAlienSorted1(words: Array[String], order: String): Boolean = {
    var index = new Array[Int](26)
    for (i <- 0 to order.length - 1) {
      index { order.charAt(i) - 'a' } = i
    }

    import scala.util.control._
    val loop = new Breaks

    loop.breakable {
      for (i <- 0 until words.length; j <- i + 1 until words.length) {
       // println(words.length)
        var min = Math.min(words(i).length, words(j).length)
        for (k <- 0 until min) {
          var iChar = words(i).charAt(k)
          var jChar = words(j).charAt(k)
          if (index(iChar - 'a') < index(jChar - 'a')) {
            loop.break
          } else if (index(iChar - 'a') > index(jChar - 'a')) {
            return false
          } else if (k == min-1 && words(i).length > words(j).length) {
            return false
          }
        }
      }
    }
    return true
  }

  println(isAlienSorted(Array("hello", "hello"), "abcdefghijklmnopqrstuvwxyz")) // true
  println(isAlienSorted(Array("apap", "app"), "abcdefghijklmnopqrstuvwxyz")) // true
  println(isAlienSorted(Array("apple", "app"), "abcdefghijklmnopqrstuvwxyz") + "\n") // false
  
  println(isAlienSorted1(Array("hello", "hello"), "abcdefghijklmnopqrstuvwxyz")) // true
  println(isAlienSorted1(Array("apap", "app"), "abcdefghijklmnopqrstuvwxyz")) // true
  println(isAlienSorted1(Array("apple", "app"), "abcdefghijklmnopqrstuvwxyz")) // false

}