package service;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.Contact;

public class DatabaseService {
	String dbName = "TDDD05/TDDD05/lab3/src/main/resources/contacts.db";

	
	public boolean checkDataBase(String dbName){
		File file = new File (dbName);
		
		if (file.length() > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean initDB(){
		if(checkDataBase(dbName)){
			return true;
		} 
		else {
			Connection c = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:" + dbName);
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      return false;
		    }
		    
		    return createContactTable();
		 }	
	}
	
	
	public boolean createContactTable(){
		Connection c = null;
	    Statement stmt = null;
	    
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:" + dbName);

	      stmt = c.createStatement();
	      String sql = "CREATE TABLE CONTACTS " +
	                   "(ID 	integer PRIMARY KEY," +
	                   "NAME    TEXT, " + 
	                   "MAIL    TEXT, " + 
	                   "NUMBER  TEXT, " + 
	                   "INFO    TEXT)"; 
	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    return true;
	}
	
	
	public int getMaxId(){
		Connection c = null;
	    Statement stmt = null;
	    int maxId = -1;
	    try {
			Class.forName("org.sqlite.JDBC");
		    c = DriverManager.getConnection("jdbc:sqlite:" + dbName);
		    stmt = c.createStatement();
		    String sql = "SELECT MAX(id) AS maxId FROM CONTACTS";
		    ResultSet rs = stmt.executeQuery(sql);
		    maxId = rs.getInt("maxId");
		    stmt.close();
		    c.close();
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	    return maxId;
	}
	
	
	public boolean addContact(Contact contact){	
		int maxId = getMaxId();
		contact.setId(maxId+1);
		
		Connection c = null;
	    
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:" + dbName);
	      
	      String sql = "INSERT INTO CONTACTS (ID,NAME,MAIL,NUMBER,INFO) VALUES(?,?,?,?,?)"; 
	      PreparedStatement prep = c.prepareStatement(sql);
	      
	      prep.setInt(1,  contact.getId());
	      prep.setString(2, contact.getName());
	      prep.setString(3, contact.getMail());
	      prep.setString(4, contact.getNumber());
	      prep.setString(5, contact.getInfo());
	      
	      prep.executeUpdate();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
		return true;
	}
	
	
	public List<Contact> getContacts(){
		List<Contact> cL = new LinkedList<Contact>();
		Connection c = null;
	    
	    try {
	    	Class.forName("org.sqlite.JDBC");
	    	c = DriverManager.getConnection("jdbc:sqlite:" + dbName);
			  
			String sql = "SELECT ID,NAME, MAIL, NUMBER, INFO FROM CONTACTS";   
			Statement stmt  = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			 
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getInt("ID"));
				contact.setName(rs.getString("NAME"));
				contact.setMail(rs.getString("MAIL"));
				contact.setNumber(rs.getString("NUMBER"));
				contact.setInfo(rs.getString("INFO"));
				
				cL.add(contact);
			}
			c.close();
			
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	System.exit(0);
	    }	
	    return cL;
	}
	
	
	public boolean editContact(Contact contact){
		Connection c = null;
	    
	    try {
	    	Class.forName("org.sqlite.JDBC");
	    	c = DriverManager.getConnection("jdbc:sqlite:" + dbName);
	    	
	    	System.out.println("1");
	    	String sql = "UPDATE CONTACTS SET NAME = '" + contact.getName()
	    			+ "', MAIL = '" + contact.getMail()
	    			+ "', NUMBER = '" + contact.getNumber()
	    			+ "', INFO = '" + contact.getInfo()
	    			+ "' WHERE ID = " + Integer.toString(contact.getId());
	    	
	    	System.out.println(sql);
	    	
			Statement stmt  = c.createStatement();
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
