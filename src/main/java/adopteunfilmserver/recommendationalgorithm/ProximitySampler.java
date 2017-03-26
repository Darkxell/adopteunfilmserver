package adopteunfilmserver.recommendationalgorithm;

import adopteunfilmserver.model.Movie;

/** This class contains the proximity calculated between two movies. */
class ProximitySampler {

	int movie1;
	int movie2;
	/**
	 * The effective proximity between the two movies. Higher means more
	 * matching. -1 means it's not yet calculated.
	 */
	long proximity = -1;

	/**
	 * Create an instance of this object, effectively calculating the proximity.
	 * This is a "lenghty" process.
	 */
	public ProximitySampler(Movie m1, Movie m2) {
		long calculating = 0l;
		movie1 = m1.getId();
		movie2 = m2.getId();

		// TODO : change "pseudocode" to code, HUH.

		// KEYWORDS
		for (int i = 0; movie1.keywords.length; ++i)
			for (int j = i; movie2.keywords.length; ++j)
				if (m1.keywords[i].equals(m2.keywords[j]))
					calculating += ProximityRules.MATCHING_KEYWORD.score;
		// GENRES
		for (int i = 0; movie1.genres.length; ++i)
			for (int j = i; movie2.genres.length; ++j)
				if (m1.genres[i].equals(m2.genres[j]))
					calculating += ProximityRules.MATCHING_GENRE.score;
		// TYPE
		if (m1.getType().equals(m2.getType()))
			calculating += ProximityRules.MATCHING_GENRE.score;
		// GENRES
		for (int i = 0; movie1.actors.length; ++i)
			for (int j = i; movie2.actors.length; ++j)
				if (m1.actors[i].equals(m2.actors[j]))
					calculating += ProximityRules.MATCHING_ACTOR.score;

		// YEAR DIFFERENCE SCORE CALCULATION
		calculating += ProximityRules.YEAR_DIFF_MAX.score
				- ((Math.abs(m1.getYear() - m2.getYear())) * ProximityRules.YEAR_DIFF_MULTIPLIER.score);

		// LANGUAGE MATCHING SCORE TEST
		for (int i = 0; movie1.languages.length; ++i)
			for (int j = i; movie2.languages.length; ++j)
				if (m1.languages[i].equals(m2.language[j]))
					calculating += ProximityRules.MATCHING_LANGUAGE.score;
		// PRODUCER MATCHING SCORE TEST
		// DIRECTOR MATCHING SCORE TEST
		// COMPANY MATCHING SCORE TEST
		// WRITER MATCHING SCORE TEST

		this.proximity = calculating;
	}

}
