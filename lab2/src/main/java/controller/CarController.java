package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Service.CarService;
import domain.Car;

@Controller
public class CarController {
	@Autowired
	private CarService carService;
 
	@RequestMapping("/car/list")
	public void carList(Model model) {
		List<Car> carList = carService.findAll();
		model.addAttribute("carList", carList);
	}
}
