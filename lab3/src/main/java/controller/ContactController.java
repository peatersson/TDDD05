package controller;


import service.ContactService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Contact;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
 
	@RequestMapping("/show")
	public void contactList(Model model) {
		List<Contact> contactList = contactService.findAllContacts();
		model.addAttribute("contactList", contactList);
	}
	
	@RequestMapping("/add")
	public void carAdd() {
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void contactAddSubmit(@ModelAttribute Contact contact) {
		contactService.add(contact);
	}
}
