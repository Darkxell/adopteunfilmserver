package adopteunfilmserver.controller.service;

import org.springframework.stereotype.Service;

import adopteunfilmserver.model.Movie;

@Service("movieService")
public class MovieService extends AFSService<Movie>
{

	public MovieService()
	{
		super(Movie.class);
	}

}
