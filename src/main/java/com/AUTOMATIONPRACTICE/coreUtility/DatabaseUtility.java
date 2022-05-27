package com.AUTOMATIONPRACTICE.coreUtility;

	


	 

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;

	import com.mysql.cj.jdbc.Driver;

	/**
	 * This class contains all common action related to database
	 * @author Roopa
	 *
	 */

public class DatabaseUtility {
	
	 static Connection connt;
	 static Statement stmnt; 
	 /**
	  * This method is used to fetch the records from the database//dql
	  * @param dBurl
	  * @param dBun
	  * @return
	  * @throws SQLException
	  */
		public static ArrayList<String> getDataFromDatabase(String query,String cName) throws SQLException
		{
			
		  ArrayList <String> list=new ArrayList<>();
			ResultSet res = stmnt.executeQuery(query);
			while(res.next())
			{
				list.add(res.getString(cName));
			}
			return list;
		}
		
		
		/**
		 * This method is used to validate the data whether it is present in database or not
		 * @param dBurl
		 * @param dBun
		 * @param dBpwd
		 * @param query
		 * @param cName
		 * @param data
		 * @param excpectedData
		 * @return
		 * @throws SQLException
		 */
		public static boolean validateData(String query,String cName,String excpectedData) throws SQLException
		{
			ArrayList<String> list = getDataFromDatabase(query,cName);
			/*Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			Connection connt = DriverManager.getConnection(dBurl, dBun, dBpwd);
			Statement stmnt = connt.createStatement();
			ResultSet res = stmnt.executeQuery(query);*/
			boolean flag=false;
			for(String actaulData:list)
			{
			   if(actaulData.equalsIgnoreCase(excpectedData))
			   {
				   flag=true;
				   break;
			   }
			}
			return flag;
		
		}
		
		
		/**
		 * This method is used to update or insert the records into the database
		 * @param dBurl
		 * @param dBun
		 * @param dBpwd
		 * @param query
		 * @param cName
		 * @throws SQLException
		 */
		public static void setDataIntoDatabase(String query) throws SQLException
		{
			int res = stmnt.executeUpdate(query);
			if(res>=1)
			{
				System.out.println("data entered sucessufully");
			}
		}
		
		
		public static void openDbConnection(String dBurl,String dBun,String dBpwd) throws SQLException
		{
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			 connt = DriverManager.getConnection(dBurl, dBun, dBpwd);
			stmnt = connt.createStatement();
		}
		
		public static void closeDbConnection()
		{
			try {
				connt.close();
			    } 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
				System.out.println("while closing database connection we got exception");
			}
		}
		

	



}
