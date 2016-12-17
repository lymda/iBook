package controller;

import java.util.ArrayList;

public class ClientController {

	private static ArrayList<String> qResult = new ArrayList<String>();

		
	public static void SendQuery(String queryReq){
		ConnectToServer.client.handleMessageFromClientUI(queryReq);
		System.out.println("Sending query to server...");
	
	}

	public static void SetResults(String queryReq){
		try {
			Thread.sleep(600); //msec
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		qResult.clear();
		qResult = client.ChatClient.GetQueryResult();
	}

	
	
	public static ArrayList<String> RecieveQueryResults(){
		return qResult;
	}
	
	
	
	
	
	
	
	
}
