package entity;

public class User {

	private String userID;
	private String password;
	private boolean connected;
	private int privillage;
	
	public User() {
		this.userID = "";
		this.password = "";
		this.connected = false;
		this.privillage = 0;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isConnected() {
		return connected;
	}
	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	public int getPrivillage() {
		return privillage;
	}
	public void setPrivillage(int privillage) {
		this.privillage = privillage;
	}
	
	
}
