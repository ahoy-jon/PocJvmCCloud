package com.github.unjon.webserver

import com.github.unjon.controlapp.Application
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletContextHandler
import org.eclipse.jetty.servlet.ServletHolder
import org.eclipse.jetty.webapp._
import java.io.File

object EmbeddedJettyScalaWithVaadin extends App {
  private final val LISTEN_HOST: String = "localhost"
  private final val LISTEN_PORT: Int = 8888
  private final val WEBAPP_CLASS_NAME: String = classOf[Application].getName
  private var server: Server = null


  server = new Server(LISTEN_PORT)
  var context: ServletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS)
  context.setContextPath("/")
  server.setHandler(context)
  var filterHolder: ServletHolder = new ServletHolder(classOf[com.vaadin.terminal.gwt.server.ApplicationServlet])
  filterHolder.setInitParameter("application", WEBAPP_CLASS_NAME)
  context.addServlet(filterHolder, "/*")
  server.start
  server.join


  final def stop: Unit = {
    try {
      System.out.println("STOOOOPPPPIINNNNG")
      server.stop
    }
    catch {
      case e: Exception => {
        e.printStackTrace
      }
    }
  }


}


case class DeployOrder(war : File)

object DeployActor {

  private var availablePortMap = Map[Int, Boolean]()

  (9900 to 9910).map(port => availablePortMap = availablePortMap + (port -> true))



  def deploy(war:File) {

    val (port, available) = availablePortMap.filter(t => t._2).head
    availablePortMap = availablePortMap + (port -> false)
    this.deploy(war, port)


  }



  private def deploy(dest: File, i: Int): Unit = {

      var server: Server = new Server(i)
      var webapp: WebAppContext = new WebAppContext
      webapp.setContextPath("/")
      webapp.setWar(dest.getAbsolutePath)
      server.setHandler(webapp)
      try {
        server.start
        server.join
      }
      catch {
        case e: Exception => {
          e.printStackTrace
        }
      }


  }
}