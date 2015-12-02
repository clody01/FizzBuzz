/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.ws.rs.core.MediaType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tv.spideo.recruitment.FizzBuzzWs;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.codehaus.jackson.map.ObjectMapper;
import tv.spideo.recruitment.ObjetJson;

/**
 *
 * @author Clody
 */
public class ServicesTest {
    private static Server jettyServer;
    
    
    @BeforeClass
        public static void startJetty() throws Exception{
           
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/*");
        jettyServer = new Server(8080);
        jettyServer.setHandler(context);
        ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);
        jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", FizzBuzzWs.class.getCanonicalName());
        jettyServer.start();
    }

    
    @AfterClass
	    public static void stopJetty(){
	        try
	        {
	        	jettyServer.stop();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }

            @Test
	public void testGetService() throws Exception {
		int number = 5;
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/fizz-buzz/" + number);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		String output = response.getEntity(String.class);
		assertEquals(200, response.getStatus());		 
		assertEquals("{\"resultat\":\"Buzz\"}", output); 
	}

	@Test
	public void testPostService() throws Exception { 
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/fizz-buzz");	
                ObjetJson objetJson = new ObjetJson();
                objetJson.to="33";
		ObjectMapper mapper = new ObjectMapper();
		ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class,mapper.writeValueAsString(objetJson));
		String output = clientResponse.getEntity(String.class);                
		assertEquals(200, clientResponse.getStatus());
                String expected="{\"resultats\":[\"1\", \"2\", \"Fizz\", \"4\", \"Buzz\", \"Fizz\", \"Quxx\", \"8\", \"Fizz\", \"Buzz\", \"Vitt\", \"Fizz\", \"13\", \"Quxx\", \"Fizz\", \"16\", \"17\", \"Fizz\", \"19\", \"Buzz\", \"Fizz\", \"Vitt\", \"23\", \"Fizz\", \"Buzz\", \"26\", \"Fizz\", \"Quxx\", \"29\", \"Fizz\", \"31\", \"32\", \"Fizz\"]}"; 	
                assertEquals(expected, output);
	}
    
    
 
}
