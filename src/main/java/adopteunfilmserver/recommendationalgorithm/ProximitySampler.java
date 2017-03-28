package adopteunfilmserver.recommendationalgorithm;

import adopteunfilmserver.model.*;

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
		for (Keyword k1 : m1.getKeywords())
			for (Keyword k2 : m2.getKeywords())
				if (k1.equals(k2))
					calculating += ProximityRules.MATCHING_KEYWORD.score;
		// GENRES
		for (Genre g1 : m1.getGenres())
			for (Genre g2 : m2.getGenres())
				if (g1.equals(g2))
					calculating += ProximityRules.MATCHING_GENRE.score;
		// TYPE
		if (m1.getType().equals(m2.getType()))
			calculating += ProximityRules.MATCHING_GENRE.score;
		
		// ACTORS
		for (Person a1 : m1.getActors())
			for (Person a2 : m2.getActors())
				if (a1.equals(a2))
					calculating += ProximityRules.MATCHING_ACTOR.score;

		// YEAR DIFFERENCE SCORE CALCULATION
		calculating += ProximityRules.YEAR_DIFF_MAX.score
				- ((Math.abs(m1.getYear() - m2.getYear())) * ProximityRules.YEAR_DIFF_MULTIPLIER.score);

		// LANGUAGE MATCHING SCORE TEST
		for (Language l1 : m1.getLanguages())
			for (Language l2 : m2.getLanguages())
				if (l1.equals(l2))
					calculating += ProximityRules.MATCHING_LANGUAGE.score;
		// PRODUCER MATCHING SCORE TEST
		// DIRECTOR MATCHING SCORE TEST
		// COMPANY MATCHING SCORE TEST
		// WRITER MATCHING SCORE TEST

		this.proximity = calculating;
	}

}
