package com.github.unjon.controlapp

import java.io.File
import akka.actor.Actor.registry._
import com.github.unjon.webserver.{DeployOrder, DeployActor}
import akka.actor.{ActorRef, Actor}
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

    val optionFirstDeployActor: Option[ActorRef] = actorsFor[DeployActor].headOption

    optionFirstDeployActor match {
      case Some(actor) => actor ! DeployOrder(f)
      case _ => println("oups, pas d'acteur")
    }
  }

}
