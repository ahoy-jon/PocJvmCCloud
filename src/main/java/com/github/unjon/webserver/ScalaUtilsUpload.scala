package com.github.unjon.webserver

import java.io.File
import scala.Option

/**
 * Created by IntelliJ IDEA.
 * User: Jon
 * Date: 2/11/12
 * Time: 5:22 PM
 * To change this template use File | Settings | File Templates.
 */

object ScalaUtilsUpload {

  def deploy(f: File, p: Int): Unit = {
      DeployActor.deploy(f)
  }

}
