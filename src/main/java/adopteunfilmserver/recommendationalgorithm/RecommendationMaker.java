package adopteunfilmserver.recommendationalgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import adopteunfilmserver.model.Movie;
import adopteunfilmserver.model.User;

/** This object */
public class RecommendationMaker {

	@SuppressWarnings("rawtypes")
	public RecommendationMaker(User user) {
		// Hashmap containing the movies voted by the user.
		HashMap<Movie, Integer> uservotes = null;// TODO : get them!
		// A list of ~50 films the user haven't rated yet.
		ArrayList<Movie> randoms = null;// TODO : get them!
		Movie best = null;
		long bestmoviescore = 0;

		for (int i = 0; i < randoms.size(); ++i) {
			long score = 0;
			Iterator it = uservotes.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				if ((int) pair.getValue() != 3) {
					ProximitySampler sampler = new ProximitySampler((Movie) pair.getKey(), randoms.get(i));
					score += sampler.proximity * voteToMultiplier((int) pair.getValue());
				}
				it.remove();
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
