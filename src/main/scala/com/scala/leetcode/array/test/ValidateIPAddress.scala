package com.scala.leetcode.array.test

object ValidateIPAddress extends App {
  //Write a program to validate ip address with test cases

  println(validIPAddress("172.16.254.1"))
  println(validIPAddress("172.06.254.1"))
  println(validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"))
  println(validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"))
  println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"))

  println("001:0db8:85a3:::8A2E:0370:7334:".split(":", -1).length)

  def validIPAddress(IP: String): String = {

    //    IP.match {
    //        case "." => "IP4"
    //        case IP.contains(":") => "IP6"
    //        case _ => "neither"
    //    }

    if (IP.contains(".") && IP.split("\\.", -1).length == 4 && validateIP4(IP)) {
      "IPv4"
    } else if (IP.contains(":") && IP.split("\\:", -1).length == 8 && validateIP6(IP)) {
      "IPv6"
    } else {
      "Neither"
    }
  }

  def validateIP4(ip: String): Boolean = {
    var ret: Boolean = false
    ip.split("\\.",-1).foreach { x =>
      try {
        var i = Integer.parseInt(x)
        //println(s" value of x is $x and i is $i, lenght of x is " + x.length() + " length of i is " + i.toString().length() )
        if (x.length() == i.toString().length() && i <= 255 && i >= 0)
          ret = true
        else
          return false
      } catch {
        case e: NumberFormatException =>
          println(s"Can not convert $x to number")
          return false
      }
    }
    ret
  }

  def validateIP6(ip: String): Boolean = {
    var ret: Boolean = false
    ip.split("\\:",-1).foreach { x =>
      try {
        var i = Integer.parseInt(x, 16)
        //        println(x.length)
        if (x.length >= 1 && x.length <= 4)
          ret = true
        else
          return false
      } catch {
        case e: NumberFormatException =>
          println(s"Can not convert $x to hexadecimal number")
          return false
      }
    }
    ret
  }

  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }

}