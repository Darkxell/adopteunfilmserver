package adopteunfilmserver.controller;

import java.util.List;

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
import adopteunfilmserver.model.Rating;

@Controller
public class RatingController
{

	@Autowired
	private MovieService movieService;
	@Autowired
	private RatingService ratingService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/rating/add/{user}/{movie}/{note}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Rating> add(@PathVariable int user, @PathVariable int movie, @PathVariable int note)
	{
		this.ratingService.add(new Rating(this.userService.get(user), this.movieService.get(movie), note));
		List<Rating> ratings = this.ratingService.list();
		AFSService.closeSession();
		return ratings;
	}

	@RequestMapping(value = "/rating/delete/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Rating> delete(@PathVariable int id)
	{
		this.ratingService.delete(id);
		List<Rating> ratings = this.ratingService.list();
		AFSService.closeSession();
		return ratings;
	}

	@RequestMapping(value = "/rating/get/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Rating get(@PathVariable int id)
	{
		return this.ratingService.get(id);
	}

	@RequestMapping(value = "/rating/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Rating> list()
	{
		return this.ratingService.list();
	}

	@RequestMapping(value = "/rating/update/{id}/{note}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Rating update(@PathVariable int id, @PathVariable int note)
	{
		Rating rating = this.ratingService.get(id);
		rating.setNote(note);
		this.ratingService.update(rating);
		AFSService.closeSession();
		return rating;
	}

}
