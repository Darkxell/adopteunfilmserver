package adopteunfilmserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import adopteunfilmserver.controller.service.UserService;
import adopteunfilmserver.model.User;

@Controller
public class UserController
{

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/add/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<User> add(@PathVariable String name)
	{
		this.userService.addUser(new User(name));
		return this.userService.listUsers();
	}

	@RequestMapping(value = "/user/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<User> list()
	{
		return this.userService.listUsers();
	}

}
