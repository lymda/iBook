package controller;

import java.util.ArrayList;

import entity.Worker;

public class WorkerController {
	public Worker worker = new Worker();
	
	public boolean SearchWorkerByID(String workerID){
		ArrayList<String> arr_results;
		
		String queryReq = "GET:SELECT * FROM worker WHERE WorkerID=\""+workerID+"\";";
		controller.ClientController.SendQuery(queryReq);
		controller.ClientController.SetResults(queryReq);
		arr_results = ClientController.RecieveQueryResults();
		
		return InsertValsToWorker(arr_results);
	}// end SearchWorkerByName function.
	
	
	private boolean InsertValsToWorker(ArrayList<String> arr_results){
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
			
		worker.SetWorkerID( Integer.parseInt(vals[0]) );
		worker.SetWorkerName(vals[1]);
		worker.SetDepartment(vals[2]);
		worker.SetWorkerRole(vals[3]);
		
		return true;
	}// end InsertValsToWorker function.
	
	
	
	public void UpdateWorkerDetails(String workerID, String workerName, String newDept, String newRole){
		String queryReq = "UPDATE:UPDATE worker SET workerName='"+workerName + "', Department='" + newDept +
				"', workerRole='" + newRole + "'  WHERE WorkerID="+workerID+";";
		controller.ClientController.SendQuery(queryReq);
		
	}// end UpdateWorkerDetails function.
	
	
}// end WorkerController class.
