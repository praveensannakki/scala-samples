package com.scala.leetcode.array.test
import scala.collection.mutable.HashSet

object LikedListProblems {

  //Definition for singly-linked list.
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def reverseList(head: ListNode): ListNode = {
    var p: ListNode = null
    var c: ListNode = head
    while (c != null) {
      var nTmp: ListNode = c.next
      c.next = p
      p = c
      c = nTmp
    }
    p
  }

  def reverseListRecurrsion(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
    var p: ListNode = reverseListRecurrsion(head.next)
    head.next.next = head
    head.next = null
    return p
  }

  def detectLoop(head: ListNode): Boolean = {
    //val hashSet1: HashSet[String] = HashSet("Plain Donut","Strawberry Donut","Chocolate Donut")

    var current = head
    var nodeSeen: HashSet[ListNode] = HashSet.empty[ListNode];
    while (current != null) {
      if (nodeSeen.contains(current)) {
        return true;
      }
      nodeSeen.add(current);
      current = current.next
    }
    return false;
  }

  def detectLoop2Pointer(head: ListNode): Boolean = {
    if (head == null) return false

    var slow = head
    var fast = head.next
    while (slow != fast) {
      if (fast == null || fast.next == null) return false

      slow = slow.next
      fast = fast.next.next
    }

    return true
  }

  def getKthElement(head: ListNode, index: Int): Int = {

    var current = head
    var count = 0
    while (current != null) {
      if (count == index) return current.x
      count += 1
      current = current.next
    }
    0
  }

  def deleteNode(head: ListNode, key: Int): ListNode = {
    var h = head
    var temp: ListNode = head
    var prev: ListNode = null
    // If head node itself holds the key to be deleted
    if (temp != null && temp.x == key) {
      h = temp.next; // Changed head
      return h
    }

    // Search for the key to be deleted, keep track of
    // the previous node as we need to change temp.next
    while (temp != null && temp.x != key) {
      prev = temp;
      temp = temp.next;
    }

    if (temp == null)
      return new ListNode
      
      // Unlink the node from linked list
    prev.next = temp.next;

    prev
  }
  
  def deleteNode(n: ListNode): Unit = {
        var node = n
        var temp : ListNode = node.next;
        node.x = node.next.x;
        node.next = node.next.next;
        temp.next = null;
    }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var head = new ListNode()
    var p: ListNode = l1
    var q: ListNode = l2
    
    var curr = head
    var carry = 0

    while (p != null || q != null) {
      var x = if (p != null) p.x else 0
      var y = if (q != null) q.x else 0
      var sum = x + y + carry
      carry = sum / 10
      curr.next = new ListNode(sum % 10);
      curr = curr.next
      
      if (p != null) p = p.next
      if (q != null) q = q.next

    }
    if (carry > 0) curr.next = new ListNode(carry)

    return head.next
  }

  def display(head: ListNode): Unit = {
    var node = head
    while (node != null) {
      print(node.x)
      node = node.next
    }
    println()
  }

  def main(args: Array[String]): Unit = {
    var head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(3);
    //head.next.next.next = new ListNode(4);
    //head.next.next.next.next = new ListNode(5);

    var a = new ListNode(5);
    a.next = new ListNode(6);
    a.next.next = new ListNode(4);
    //a.next.next.next = new ListNode(4);
    //a.next.next.next.next = new ListNode(5);

    //    while (head != null) {
    //      println(head.x)
    //      head = head.next
    //    }
    //println("Input 1 ")
    display(head)
    //println("Input 2 ")
    display(a)

    var sum = addTwoNumbers(head, a)
    //println("output of addTwoNumbers ")
    display(addTwoNumbers(head, a))

    //println("output reverseList ")
    display(reverseList(head))
    
    display(deleteNode(a,4))

  }

}