package com.github.unjon.webserver;


import com.github.unjon.controlapp.Application;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.*;

import java.io.File;

public class EmbeddedJettyWithVaadin {
    // change these accordingly:
    private static final String LISTEN_HOST = "localhost";
    private static final int LISTEN_PORT = 8888;
    private static final String WEBAPP_CLASS_NAME = Application.class.getName();
    private static Server server;

    public static final void main(String[] args) throws Exception {
        server = new Server(LISTEN_PORT);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.setContextPath("/");
        server.setHandler(context);


        ServletHolder filterHolder = new ServletHolder(com.vaadin.terminal.gwt.server.ApplicationServlet.class);
        filterHolder.setInitParameter("application", WEBAPP_CLASS_NAME);
        context.addServlet(filterHolder, "/*");
        server.start();
        server.join();


    }

    public static final void stop() {

        try {
            System.out.println("STOOOOPPPPIINNNNG");
            server.stop();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public static void deploy(File dest, int i) {
        Server server = new Server(i);
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");

        webapp.setWar(dest.getAbsolutePath());
        server.setHandler(webapp);

        try {
            server.start();

            server.join();

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}