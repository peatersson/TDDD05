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
 
	@RequestMapping(value="/show")
	public void contactList(Model model) {
		List<Contact> contactList = contactService.findAllContacts();
		model.addAttribute("contactList", contactList);
	}
	
	@RequestMapping(value="/show", method=RequestMethod.POST)
	public void searchSubmit(String name) {
		Contact c = contactService.findContactByName(name);
		
	}
	
	@RequestMapping(value="/add")
	public void add() {
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addSubmit(@ModelAttribute Contact contact) {
		contactService.add(contact);
		//add code for DB-handling here
		
		
		return "redirect:/car/list";
	}
}
