package adopteunfilmserver.recommendationalgorithm;

/** Stores the score value of the different rules for quick modifications. */
enum ProximityRules {

	MATCHING_KEYWORD(500),
	MATCHING_GENRE(1000),
	MATCHING_TYPE(10),
	MATCHING_ACTOR(15),
	
	YEAR_DIFF_MAX(2500),// year matching score is = MAX - (diff*multiplier)
	YEAR_DIFF_MULTIPLIER(500),
	
	MATCHING_LANGUAGE(20),
	MATCHING_PRODUCER(200),
	MATCHING_DIRECTOR(300),
	MATCHING_COMPANY(400),
	MATCHING_WRITER(400);

	int score;

	private ProximityRules(int score) {
		this.score = score;
	}
}
