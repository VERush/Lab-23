package co.grandcircus.lab23.springlab23;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Lab23Controller {

	@Autowired
	private ItemDao itemDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	User user;

	@RequestMapping("/")
	public ModelAndView index() {
		List<Item> item = itemDao.findAllItems();
		return new ModelAndView("index", "item1", item);
	}

	@RequestMapping("/regform")
	public ModelAndView testing() {
		return new ModelAndView("regform");
	}

	@RequestMapping("/register")
	public ModelAndView addUser(@RequestParam("fName") String firstName, @RequestParam("lName") String lastName,
			@RequestParam("email") String email, @RequestParam("phone") String phone,
			@RequestParam("password") String password) {
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		userDao.addUser(user);

		return new ModelAndView("welcome", "user", user);
	}

	@RequestMapping("/test")
	public ModelAndView index2() {
		return new ModelAndView("index", "coffeeText", "Welcome to GC COFFEE!");
	}

}
