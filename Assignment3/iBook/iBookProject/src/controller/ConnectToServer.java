package controller;

import java.io.IOException;
import common.ChatIF;
import client.ChatClient;
import boundry.Login;
import boundry.WorkerWindow;


/**
 * This class constructs the UI for a chat client.  It implements the
 * chat interface in order to activate the display() method.
 * Warning: Some of the code here is cloned in ServerConsole 
 */
public class ConnectToServer implements ChatIF{
	
	  /**
	   * The default port to connect on.
	   */
	  final public static int DEFAULT_PORT = 5555;
	  
	  /**
	   * The instance of the client that created this ConsoleChat.
	   */
	  public static ChatClient client;
	  

	//  public static String queryResult="";
	  
	  /**
	   * Constructs an instance of the ProjectMain UI.
	   *
	   * @param host The host to connect to.
	   * @param port The port to connect on.
	   */
	  public ConnectToServer(String host, int port) 
	  {
	    try 
	    {
	      client= new ChatClient(host, port, this);
	      new Login();
	    } 
	    catch(IOException exception) 
	    {
	      System.out.println("Error: Can't setup connection!"
	                + " Terminating client.");
	      System.exit(1);
	    }
	  }
	  
	  
	  
	  /**
	   * This method overrides the method in the ChatIF interface.  It
	   * displays a message onto the screen.
	   *
	   * @param message The string to be displayed.
	   */
	  public void display(String message) 
	  {
	    System.out.println(message);
	  }
	  
	  
	  /**
	   * This method is responsible for the creation of the Client UI.
	   *
	   * @param args[0] The host to connect to.
	   */
	  public static void ServerConnection(String ip)
	  {
	    String host = "";
	    
	    try
	    {
	    	host = ip;
	    }
	    catch(ArrayIndexOutOfBoundsException e)
	    {
	      host = "localhost";
	    }
	    new ConnectToServer(host, DEFAULT_PORT);
	    System.out.println("Connection to " + host + " succeeded.");
	  }
}
