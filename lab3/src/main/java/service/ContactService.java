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
		
		DatabaseService db = new DatabaseService();
		if (db.initDB()) {
			System.out.println("db initialized");
		} 
		else {
			System.out.println("failed to initialize");
		}	
	}
 
	public List<Contact> findAllContacts() {
		//add code for DB-fetching here
		
		
		return contactList;
	}
	
	public void add(Contact contact) {
		//add code for DB-updating here
		
		
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
