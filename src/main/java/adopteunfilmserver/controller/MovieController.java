package adopteunfilmserver.controller;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import adopteunfilmserver.controller.service.AFSService;
import adopteunfilmserver.controller.service.MovieService;
import adopteunfilmserver.controller.service.RatingService;
import adopteunfilmserver.controller.service.UserService;
import adopteunfilmserver.model.Movie;
import adopteunfilmserver.model.Rating;
import adopteunfilmserver.model.User;

@Controller
public class MovieController
{

	@Autowired
	private MovieService movieService;
	@Autowired
	private RatingService ratingService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/movie/add/{name}/{type}/{year}/{running}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Movie> add(@PathVariable String name, @PathVariable int year, @PathVariable String type, @PathVariable double running)
	{
		this.movieService.add(new Movie(name, year, type, running));
		List<Movie> movies = this.movieService.list();
		AFSService.closeSession();
		return movies;
	}

	@RequestMapping(value = "/movie/delete/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Movie> delete(@PathVariable int id)
	{
		this.movieService.delete(id);
		List<Movie> movies = this.movieService.list();
		AFSService.closeSession();
		return movies;
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

	@RequestMapping(value = "/user/recommend/{user}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Movie recommend(@PathVariable int user)
	{
		User u = this.userService.get(user);
		Hibernate.initialize(u.getNextSuggestion());
		Hibernate.initialize(u.getCurrentSuggestion());
		if (u.getCurrentSuggestion() == null || u.getNextSuggestion() == null)
		{
			if (u.getCurrentSuggestion() == null) u.setCurrentSuggestion(this.movieService.random());
			if (u.getNextSuggestion() == null) u.setNextSuggestion(this.movieService.random());
			this.userService.update(u);
		}
		AFSService.closeSession();
		return u.getCurrentSuggestion();
	}

	@RequestMapping(value = "/movie/search/{param}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Movie> search(@PathVariable String param)
	{
		return this.movieService.search(param);
	}

	@RequestMapping(value = "/vote/{user}/{note}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Movie vote(@PathVariable int user, @PathVariable int note)
	{
		User u = this.userService.get(user);
		Hibernate.initialize(u.getCurrentSuggestion());
		Hibernate.initialize(u.getNextSuggestion());
		this.ratingService.add(new Rating(u, u.getCurrentSuggestion(), note));
		u.setCurrentSuggestion(u.getNextSuggestion());
		this.userService.calculateNextRecommendation(u);
		AFSService.closeSession(); //TODO move this to end of calculation
		return u.getCurrentSuggestion();
	}

}
