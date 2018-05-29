package co.grandcircus.lab23.springlab23;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Lab23Controller {

	@Autowired
	private ItemDao itemDao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		List<Item> item = itemDao.findAllItems();
		return new ModelAndView("index", "item1", item);
	}
	
	@RequestMapping("/test")
	public ModelAndView index2() {
		return new ModelAndView("index", "coffeeText", "Welcome to GC COFFEE!");
	}
	
}
