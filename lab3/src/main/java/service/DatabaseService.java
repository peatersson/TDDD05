package service;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseService {
	String dbName = "TDDD05/TDDD05/lab3/src/main/resources/contacts.db";

	
	/**
	 * Check whether the database already exists or not.
	 */
	public boolean checkDataBase(String dbName){
		File file = new File (dbName);
		
		if (file.length() > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	 * Initialize the database by creating a new one or opening it if already created.
	 * The function opens the connection and closes it, returning true/false depending on outcome. 
	 */
	public boolean initDB(){
		if(checkDataBase(dbName)){
			return true;
		} 
		else {
			Connection c = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:TDDD05/TDDD05/lab3/src/main/resources/contacts.db");
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      return false;
		    }
		    
		    return createContactTable();
		 }	
	}
	
	
	/**
	 * Creates a table for the contacts in the database.
	 * Returns true indicating the success of the creation, exits the session otherwise.
	 */
	public boolean createContactTable(){
		Connection c = null;
	    Statement stmt = null;
	    
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:TDDD05/TDDD05/lab3/src/main/resources/contacts.db");

	      stmt = c.createStatement();
	      String sql = "CREATE TABLE CONTACTS " +
	                   "(ID INT PRIMARY KEY     NOT NULL," +
	                   " NAME           TEXT    NOT NULL, " + 
	                   " MAIL           TEXT    NOT NULL, " + 
	                   " NUMBER        	TEXT	NOT NULL, " + 
	                   " INFO         	TEXT	NOT NULL)"; 
	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    return true;
	}
}
