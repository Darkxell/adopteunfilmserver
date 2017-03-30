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
		return this.random(1).get(0);
	}

	public List<Movie> random(int amount)
	{
		@SuppressWarnings("unchecked")
		List<Movie> list = this.session().createQuery("from Movie order by RAND()").setMaxResults(50).list();
		if (this.session().isOpen()) this.session().close();
		return list;
	}

	public List<Movie> search(String param)
	{
		@SuppressWarnings("unchecked")
		List<Movie> list = this.session().createQuery("from Movie where title like '%" + param + "%'").setMaxResults(50).list();
		if (this.session().isOpen()) this.session().close();
		return list;
	}

}
