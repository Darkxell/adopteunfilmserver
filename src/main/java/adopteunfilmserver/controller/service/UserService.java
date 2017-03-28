package adopteunfilmserver.controller.service;

import org.springframework.stereotype.Service;

import adopteunfilmserver.model.User;

@Service("userService")
public class UserService extends AFSService<User>
{

	public UserService()
	{
		super(User.class);
	}

}
