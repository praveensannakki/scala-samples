package com.examples.leetcode

import scala.collection.mutable

class LRUCache(_capacity: Int) {
  val cache: mutable.LinkedHashMap[Int, Int] = mutable.LinkedHashMap()

  def get(key: Int): Int = {
    cache.remove(key) match {
      case Some(value) =>
        cache.put(key, value) // Move the key-value pair to the end to denote it as most recently used
        value
      case None => -1
    }
  }

  def put(key: Int, value: Int): Unit = {
    cache.remove(key)
    if (cache.size == _capacity)
      cache.remove(cache.head._1)
    cache.put(key,value)
  }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * val obj = new LRUCache(capacity)
 * val param_1 = obj.get(key)
 * obj.put(key,value)
 */
