package adopteunfilmserver.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	// @Async
	public void calculateNextRecommendation(User u)
	{
		if (u.getNextSuggestion() == null) u.setNextSuggestion(this.movieService.random());
		u.setCurrentSuggestion(u.getNextSuggestion());
		
		// TODO manage recommendations
		RecommendationMaker rm = new RecommendationMaker(u, this.ratingService, this.movieService);
		u.setNextSuggestion(rm.getOutput());
		this.update(u); // TODO Make Asynchronous
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
