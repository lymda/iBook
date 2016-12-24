package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;

public class mysqlConnection {
	private static Connection conn = null;
	
	public static void ConnectToDB(){
		try
		{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {/* handle the error*/}
        
        try
        {
        	conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ibook","root","1234");
            System.out.println("SQL connection succeed");
     	}
        catch (SQLException ex) 
     	{/* handle any errors*/
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
	}// end ConnectToDB function.
	
	
	
	/**
	 * Pulls out the query result from the DB.
	 * @param query - Full query for the DB.
	 * @return ArrayList: each cell represents a whole row in the DB.
	 */
	public static ArrayList<String> GetFromDB(String query){
		int n_row, n_colsAmnt;
		Statement stmt;
		
		// Defined as String for presenting.
		ArrayList<String> arr_res = new ArrayList<String>();
		if(!arr_res.isEmpty())
			arr_res.clear();
		try
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// Save each record from the resulted DB table, to an ArrayList.
	 		while(rs.next())
	 		{
	 			// Get the table's columns amount.
	 			ResultSetMetaData mData = rs.getMetaData();
				n_colsAmnt = mData.getColumnCount();

				// Get the the current record number ('getRow' Starts with 1).
				n_row = rs.getRow() - 1;
				
				// Runs across all the recored's fields and uniting them to 1 string.
				String colStr = "";
				for(int col=1; col<=n_colsAmnt; col++)
				{
					// Unit all fields of each record, to one string.
					colStr+=rs.getString(col);

					// Add comma(,) to separate between the fields.
					if(col<n_colsAmnt)
						colStr+=",";
				}
				
				// Add the string of the current record the the resulted ArrayList.
				arr_res.add(n_row, colStr);
	 		}
	 		
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}

		return arr_res;
	}// end GetFromDB function.
	
	
	
	public static void UpdateDB(String query){
		System.out.println("UpdateDB-query= " + query);
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// end UpdateDB function.
	
	
}// end mysqlConnection class.




/*	public void addToDB(Object obj){
		
	}
	
	
	public void removeFromDB(Object obj){
			
	}
	
	
	public void searchInDB(Object obj){
		
	}
	
	
	public void updateDB(Object obj){
		
	}
*/
