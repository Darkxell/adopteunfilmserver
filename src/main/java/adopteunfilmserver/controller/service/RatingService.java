package adopteunfilmserver.controller.service;

import org.springframework.stereotype.Service;

import adopteunfilmserver.model.Rating;

@Service("ratingService")
public class RatingService extends AFSService<Rating>
{

	public RatingService()
	{
		super(Rating.class);
	}

}
