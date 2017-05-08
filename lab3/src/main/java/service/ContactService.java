package service;

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
	}
 
	public List<Contact> findAllContacts() {
		return contactList;
	}
	
	public void add(Contact contact) {
		contactList.add(contact);
	}
}
