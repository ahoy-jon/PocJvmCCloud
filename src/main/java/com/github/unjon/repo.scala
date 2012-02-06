package com.github.unjon

/**
 * Created by IntelliJ IDEA.
 * User: Jon
 * Date: 2/5/12
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */


object MyRepository {

  var i: Int = 0


  def inc() {
    i = i + 1
  }

  def value() : Int = i

}



