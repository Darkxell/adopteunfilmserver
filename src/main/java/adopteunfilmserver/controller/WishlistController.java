package adopteunfilmserver.controller;

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
public class WishlistController
{

	@Autowired
	private MovieService movieService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/wishlist/add/{user}/{movie}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody User add(@PathVariable int user, @PathVariable int movie)
	{
		User u = this.userService.get(user);
		u.getWishlist().add(this.movieService.get(movie));
		this.userService.update(u);
		return u;
	}

	@RequestMapping(value = "/user/wishlist/delete/{user}/{movie}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody User delete(@PathVariable int user, @PathVariable int movie)
	{
		User u = this.userService.get(user);
		u.getWishlist().remove(this.movieService.get(movie));
		this.userService.update(u);
		return u;
	}

}
