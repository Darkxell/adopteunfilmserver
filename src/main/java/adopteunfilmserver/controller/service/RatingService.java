package adopteunfilmserver.controller.service;

import java.util.List;

import org.springframework.stereotype.Service;

import adopteunfilmserver.model.Rating;
import adopteunfilmserver.model.User;

@Service("ratingService")
public class RatingService extends AFSService<Rating>
{

	public RatingService()
	{
		super(Rating.class);
	}

	@SuppressWarnings("unchecked")
	public List<Rating> list(User user)
	{
		return this.session().createQuery("from Rating where id_user = '" + user.getId() + "'").list();
	}

}
