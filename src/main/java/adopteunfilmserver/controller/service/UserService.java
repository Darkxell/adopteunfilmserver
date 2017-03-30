package adopteunfilmserver.controller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import adopteunfilmserver.model.Movie;
import adopteunfilmserver.model.User;
import adopteunfilmserver.recommendationalgorithm.RecommendationMaker;

@Service("userService")
public class UserService extends AFSService<User>
{
	@Autowired
	private MovieService movieService;
	@Autowired
	private RatingService ratingService;

	public UserService()
	{
		super(User.class);
	}

	@Async
	public void calculateNextRecommendation(int id)
	{
		User u = this.get(id);
		List<Movie> recommended = new ArrayList<Movie>();
		for (User follow : u.getFollowing())
			recommended.addAll(follow.getRecommended());
		
		recommended.removeAll(this.ratingService.getRatedMovies(u));
		recommended.remove(u.getCurrentSuggestion());
		if (!recommended.isEmpty()) u.setNextSuggestion(recommended.get(0));
		else
		{
			RecommendationMaker rm = new RecommendationMaker(u, this.ratingService, this.movieService);
			u.setNextSuggestion(rm.getOutput());
		}
		try
		{
			this.update(u);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		AFSService.closeSession();
	}

	public User get(String name)
	{
		@SuppressWarnings("unchecked")
		List<User> list = this.session().createQuery("from User where pseudo='" + name + "'").list();
		if (list.isEmpty()) return null;
		return list.get(0);
	}

	public List<User> search(String param)
	{
		@SuppressWarnings("unchecked")
		List<User> list = this.session().createQuery("from User where pseudo like '%" + param + "%'").setMaxResults(50).list();
		return list;
	}

}
