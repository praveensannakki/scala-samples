
package com.leetcode.string

import scala.collection.mutable.Stack

/**
 * 20. Valid Parentheses
 *
 */
object ValidParenthesis extends App {

  def isValid(s: String): Boolean = {
    var hm = Map(')' -> '(', ']' -> '[', '}' -> '{')
    var stack = Stack[Char]()

    for (c <- s) {
      if (hm.contains(c)) {
        if (stack.isEmpty || stack.pop() != hm.get(c)) return false
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty
  }

   def isValidScala(s: String): Boolean = {
        val stack = collection.mutable.Stack[Char]()
        for (c <- s) c match {
            case ')' => if (stack.isEmpty || stack.pop() != '(') return false
            case '}' => if (stack.isEmpty || stack.pop() != '{') return false
            case ']' => if (stack.isEmpty || stack.pop() != '[') return false
            case _ => stack.push(c)
        }
        stack.isEmpty
    }
   
  def isValidJava(s: String): Boolean = {
    var hm = new java.util.HashMap[Char, Char]
    hm.put(')', '(')
    hm.put(']', '[')
    hm.put('}', '{')

    var stack = new java.util.Stack[Char]

    for (c <- s) {
      if (hm.containsKey(c)) {
        if (stack.empty() || stack.pop() != hm.get(c))
          return false
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty()
  }

  println(isValid("()[]{}{"))
  println(isValidJava("()[]{}"))
  println(isValidScala("()[]{}"))
  println(isValidScala("({[({})]})"))
  println(isValidScala("())"))

}