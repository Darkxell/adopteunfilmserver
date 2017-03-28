package adopteunfilmserver.recommendationalgorithm;

import java.util.List;

import adopteunfilmserver.controller.service.MovieService;
import adopteunfilmserver.controller.service.RatingService;
import adopteunfilmserver.model.Movie;
import adopteunfilmserver.model.Rating;
import adopteunfilmserver.model.User;

/** This object */
public class RecommendationMaker {

	public RecommendationMaker(User user, RatingService ratings, MovieService movies) {
		List<Rating> uservotes = ratings.list(user);

		if (uservotes.size() < 5) {
			this.output = movies.random();
			return;
		}

		// A list of ~50 films the user haven't rated yet.
		List<Movie> randoms = movies.random(50);
		Movie best = null;
		long bestmoviescore = 0;

		for (int i = 0; i < randoms.size(); ++i) {
			long score = 0;
			for (Rating r : uservotes)
			{
				if (r.getNote() != 3) {
					ProximitySampler sampler = new ProximitySampler(r.getMovie(), randoms.get(i));
					score += sampler.proximity * voteToMultiplier(r.getNote());
				}
			}
			if (score > bestmoviescore) {
				best = randoms.get(i);
				bestmoviescore = score;
			}
		}

		this.output = best;
	}

	private int voteToMultiplier(int i) {
		switch (i) {
		case 1:
			return -2;
		case 2:
			return -1;
		case 4:
			return 1;
		case 5:
			return 2;
		default:
			return 0;
		}
	}

	/** The output movie. Can be null if the calculations are not over yet. */
	private Movie output;

	/** Returns the recommended movie for the user. */
	public Movie getOutput() {
		return this.output;
	}
}
