package entity;

public class Worker {
	private int workerID;
	private String workerName;
	private String department;
	private String workerRole;
		
	public Worker(){
		workerID = 0;
		workerName = "";
		department = "";
		workerRole = "";
	}
	
	public int GetWorkerID(){
		return workerID;
	}
	
	public String GetWorkerName(){
		return workerName;
	}
	
	public String GetDepartment(){
		return department;
	}
	
	public String GetWorkerRole(){
		return workerRole;
	}
	
	public void SetWorkerID(int workerID){
		this.workerID = workerID;
	}
	
	public void SetWorkerName(String workerName){
		this.workerName = workerName;
	}
	
	public void SetDepartment(String department){
		this.department = department;
	}
	
	public void SetWorkerRole(String workerRole){
		this.workerRole = workerRole;
	}
}
