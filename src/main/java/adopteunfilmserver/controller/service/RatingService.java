package adopteunfilmserver.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import adopteunfilmserver.model.Movie;
import adopteunfilmserver.model.Rating;
import adopteunfilmserver.model.User;

@Service("ratingService")
public class RatingService extends AFSService<Rating>
{

	public RatingService()
	{
		super(Rating.class);
	}

	public List<Movie> getRatedMovies(User user)
	{
		List<Rating> ratings = this.list(user);
		List<Movie> movies = new ArrayList<Movie>();
		for (Rating rating : ratings)
			movies.add(rating.getMovie());
		return movies;
	}

	@SuppressWarnings("unchecked")
	public List<Rating> list(User user)
	{
		return this.session().createQuery("from Rating where id_user = '" + user.getId() + "'").list();
	}

}
