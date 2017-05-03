package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping("hi")
	@ResponseBody
	public String hi() {
		return "Hello, world. Ive come to help you";
	}
}