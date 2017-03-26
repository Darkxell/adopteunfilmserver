package adopteunfilmserver.controller.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adopteunfilmserver.controller.dao.UserDAO;
import adopteunfilmserver.model.User;

@Service("userService")
@Transactional
public class UserService
{

	@Autowired
	UserDAO userDao;

	@Transactional
	public User addUser(User user)
	{
		return this.userDao.add(user);
	}

	@Transactional
	public void deleteUser(int id)
	{
		User user = this.getUser(id);
		if (user != null) this.userDao.delete(user);
	}

	@Transactional
	public void deleteUser(User user)
	{
		this.userDao.delete(user);
	}

	@Transactional
	public User getUser(int id)
	{
		return this.userDao.get(id);
	}

	@Transactional
	public List<User> listUsers()
	{
		return this.userDao.list("");
	}

	@Transactional
	public void updateUser(User user)
	{
		this.userDao.update(user);
	}

}
