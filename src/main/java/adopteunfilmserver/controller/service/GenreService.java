package adopteunfilmserver.controller.service;

import org.springframework.stereotype.Service;

import adopteunfilmserver.model.Genre;

@Service("genreService")
public class GenreService extends AFSService<Genre>
{

	public GenreService()
	{
		super(Genre.class);
	}

}
