package adopteunfilmserver.controller.service;

import java.util.List;

import org.springframework.stereotype.Service;

import adopteunfilmserver.model.Movie;

@Service("movieService")
public class MovieService extends AFSService<Movie>
{

	public MovieService()
	{
		super(Movie.class);
	}

	public Movie random()
	{
		@SuppressWarnings("unchecked")
		List<Movie> list = this.session().createQuery("from Movie order by RAND()").setMaxResults(1).list();
		if (list.isEmpty()) return null;
		return list.get(0);
	}

}
