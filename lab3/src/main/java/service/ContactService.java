package service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Contact;

@Service
public class ContactService {
	private List<Contact> contactList = new LinkedList<Contact>();
	private DatabaseService db = new DatabaseService();
 
	ContactService() {
		if (this.db.initDB()) {
			System.out.println("db initialized");
		} 
		else {
			System.out.println("failed to initialize");
		}	
	}
 
	public List<Contact> findAllContacts() {
		this.contactList = this.db.getContacts();
		return this.contactList;
	}
	
	public boolean add(Contact contact) {
		return this.db.addContact(contact);		
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
	
	public boolean edit(Contact contact){
		return this.db.editContact(contact);
	}
}
