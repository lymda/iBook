package controller;

import java.util.ArrayList;

import entity.User;

public class AccountController {
	public User usr = new User();
	
	public boolean Login(String userID, String password){
		ArrayList<String> arr_results;
		
		String queryReq = "GET:SELECT * FROM users WHERE userID=\""+userID+"\";";
		controller.ClientController.SendQuery(queryReq);
		controller.ClientController.SetResults(queryReq);
		arr_results = ClientController.RecieveQueryResults();
		
		System.out.println("AccountController-Login-arrRes::");
		for(int i=0; i<arr_results.size(); i++)
			System.out.println(arr_results.get(i));
		
		return InsertValsToUser(arr_results);
	}
	
	private boolean InsertValsToUser(ArrayList<String> arr_results){
		
		if(arr_results.isEmpty())
			return false;
		
		String[] vals = new String[4];
		String[] res = arr_results.get(0).split(",");

		for(int ind=0; ind<vals.length; ind++)
		{
			if(ind<res.length)
				vals[ind] = res[ind];
			else
				vals[ind] = "";
		}

		usr.setUserID( vals[0] );
		usr.setPassword(vals[1]);
		usr.setConnected(!(Integer.parseInt(vals[2])==0)); // 0 disconnected
		usr.setPrivillage(Integer.parseInt(vals[3]));
		
		return true;
	}// end InsertValsToWorker function.
	
	
	public void UpdateConnected(String userID, boolean isConnect){
		int connected = (isConnect)? 1 : 0 ;
		String queryReq = "UPDATE:UPDATE users SET connected="+connected +
				" WHERE userID='"+userID+"';";
		controller.ClientController.SendQuery(queryReq);
		
	}
	
	
	
	public void Logout(){
		
	}
	
	
	
	
	public void Regist(){
		
	}
}
