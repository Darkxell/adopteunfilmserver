package adopteunfilmserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import adopteunfilmserver.controller.service.MovieService;
import adopteunfilmserver.controller.service.UserService;
import adopteunfilmserver.model.User;

@Controller
public class UserController
{

	@Autowired
	private MovieService movieService;
	@Autowired
	private UserService userService;

	/** Creates a new User.
	 * 
	 * @param name - The pseudo of the new User.
	 * @return The ID of the registered User. */
	@RequestMapping(value = "/user/add/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody int add(@PathVariable String name)
	{
		this.userService.add(new User(name));
		return this.userService.get(name).getId();
	}

	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<User> delete(@PathVariable int id)
	{
		this.userService.delete(id);
		return this.userService.list();
	}

	@RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody User get(@PathVariable int id)
	{
		return this.userService.get(id);
	}

	@RequestMapping(value = "/user/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<User> list()
	{
		return this.userService.list();
	}

	@RequestMapping(value = "/user/search/{param}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<User> search(@PathVariable String param)
	{
		return this.userService.search(param);
	}

	/** Changes the User's pseudo.
	 * 
	 * @param id - User ID
	 * @param pseudo - New pseudo */
	@RequestMapping(value = "/user/update/{id}/{pseudo}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody void update(@PathVariable int id, @PathVariable String pseudo)
	{
		User user = this.userService.get(id);
		user.setPseudo(pseudo);
		this.userService.update(user);
	}

}
