package adopteunfilmserver.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import adopteunfilmserver.controller.service.AFSService;
import adopteunfilmserver.controller.service.MovieService;
import adopteunfilmserver.controller.service.UserService;
import adopteunfilmserver.model.Movie;
import adopteunfilmserver.model.User;

@Controller
public class WishlistController
{

	@Autowired
	private MovieService movieService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/wishlist/add/{user}/{movie}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody User add(@PathVariable int user, @PathVariable int movie)
	{
		User u = this.userService.get(user);
		u.getWishlist().add(this.movieService.get(movie));
		this.userService.update(u);
		AFSService.closeSession();
		return u;
	}

	@RequestMapping(value = "/wishlist/delete/{user}/{movie}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody User delete(@PathVariable int user, @PathVariable int movie)
	{
		User u = this.userService.get(user);
		u.getWishlist().remove(this.movieService.get(movie));
		this.userService.update(u);
		AFSService.closeSession();
		return u;
	}

	@RequestMapping(value = "/wishlist/list/{user}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Set<Movie> get(@PathVariable int user)
	{
		User u = this.userService.get(user);
		return u.getWishlist();
	}

	@RequestMapping(value = "/wishlist/update/{user}/{movie}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody void update(@PathVariable int user, @PathVariable int movie)
	{
		User u = this.userService.get(user);
		boolean add = true;
		for (Movie m : u.getWishlist())
			if (m.getId() == movie)
			{
				add = false;
				break;
			}

		if (add) u.getWishlist().add(this.movieService.get(movie));
		else u.getWishlist().remove(this.movieService.get(movie));

		this.userService.update(u);
		AFSService.closeSession();
	}

}
