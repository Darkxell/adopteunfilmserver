package adopteunfilmserver.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import adopteunfilmserver.controller.service.UserService;
import adopteunfilmserver.model.User;

@Controller
public class FollowController
{

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/follow/add/{user}/{followed}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody User add(@PathVariable int user, @PathVariable int followed)
	{
		User u = this.userService.get(user);
		u.getFollowing().add(this.userService.get(followed));
		this.userService.update(u);
		return u;
	}

	@RequestMapping(value = "/user/follow/delete/{user}/{followed}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody User delete(@PathVariable int user, @PathVariable int followed)
	{
		User u = this.userService.get(user);
		u.getFollowing().remove(this.userService.get(followed));
		this.userService.update(u);
		return u;
	}

	@RequestMapping(value = "/user/follow/list/{user}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Set<User> get(@PathVariable int user)
	{
		User u = this.userService.get(user);
		return u.getFollowing();
	}

}
