package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Contact;

@Service
public class ContactService {
	private List<Contact> contactList = new LinkedList<Contact>();
 
	ContactService() {
		Contact c1 = new Contact();
		c1.setName("Niklas Pettersson");
		c1.setMail("nikpe353@student.liu.se");
		c1.setNumber("0705320076");
		c1.setInfo("Student");
		contactList.add(c1);
		
		Connection c = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:contacts.db");
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    }
	    System.out.println("Opened database successfully");
	}
 
	public List<Contact> findAllContacts() {
		//add code for DB-fetching here
		
		
		return contactList;
	}
	
	public void add(Contact contact) {
		//add code for DB-updating here
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:TDDD05/lab3/src/main/resources/contacts.db");
	      System.out.println("Opened database successfully");

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
	    System.out.println("Table created successfully");
		
		contactList.add(contact);
	}
	
	public Contact findContactByName(String name){
		//add code for DB-searching here
		
		
		//temporary solution (only locally)
	    for(int i = 0; i < contactList.size(); ++i){
	    	if (contactList.get(i).getName() == name){
	    		return contactList.get(i);
	    	}
	    }
	    return null;
	}
}
