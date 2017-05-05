package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddContactController {
	@RequestMapping("/add")
	public String menu() {
		return "AddView";
	}

}
