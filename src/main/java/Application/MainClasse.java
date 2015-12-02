/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import tv.spideo.recruitment.FizzBuzzWs;

/**
 *
 * @author Clody
 */
public class MainClasse {
    public static void main(String[] args) throws Exception{          
         
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/*");
        Server jettyServer = new Server(8080);
        jettyServer.setHandler(context);
        ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);
        jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", FizzBuzzWs.class.getCanonicalName());
        jettyServer.start();
    }
    
}
