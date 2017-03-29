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
import adopteunfilmserver.model.Movie;
import adopteunfilmserver.model.User;

@Controller
public class MovieController
{

	@Autowired
	private MovieService movieService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/movie/add/{name}/{type}/{year}/{running}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Movie> add(@PathVariable String name, @PathVariable int year, @PathVariable String type, @PathVariable double running)
	{
		this.movieService.add(new Movie(name, year, type, running));
		return this.movieService.list();
	}

	@RequestMapping(value = "/movie/delete/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Movie> delete(@PathVariable int id)
	{
		this.movieService.delete(id);
		return this.movieService.list();
	}

	@RequestMapping(value = "/movie/get/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Movie get(@PathVariable int id)
	{
		return this.movieService.get(id);
	}

	@RequestMapping(value = "/movie/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Movie> list()
	{
		return this.movieService.list();
	}

	@RequestMapping(value = "/movie/random", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Movie random()
	{
		return this.movieService.random();
	}

	@RequestMapping(value = "/movie/recommend/{user}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Movie recommend(@PathVariable int user)
	{
		User u = this.userService.get(user);
		if (u.getNextSuggestion() == null) this.userService.calculateNextRecommendation(u);
		return u.getCurrentSuggestion();
	}

	@RequestMapping(value = "/movie/search/{param}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Movie> search(@PathVariable String param)
	{
		return this.movieService.search(param);
	}

}
