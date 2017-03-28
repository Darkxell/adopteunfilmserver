package adopteunfilmserver.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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

	@Async
	public void calculateNextRecommendation(User u)
	{
		RecommendationMaker rm = new RecommendationMaker(u, this.ratingService, this.movieService);
		u.setNextSuggestion(rm.getOutput());
		System.out.println("updating...");
		this.update(u);
		System.out.println("database updated");
	}

}
