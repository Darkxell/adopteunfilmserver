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
	private UserService userService;
	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/user/add/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<User> add(@PathVariable String name)
	{
		this.userService.add(new User(name));
		return this.userService.list();
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

	@RequestMapping(value = "/user/update/{id}/{next_movie}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody User update(@PathVariable int id, @PathVariable int next_movie)
	{
		User user = this.userService.get(id);
		user.setNextSuggestion(this.movieService.get(next_movie));
		this.userService.update(user);
		return user;
	}

}
