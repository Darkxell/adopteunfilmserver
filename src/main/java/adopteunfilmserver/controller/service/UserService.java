package adopteunfilmserver.controller.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import adopteunfilmserver.model.User;

@Service("userService")
public class UserService extends AFSService<User>
{

	public UserService()
	{
		super(User.class);
	}

	public User addUser(User user)
	{
		Session session = this.session();

		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();

		return user;
	}

	public User deleteUser(User user)
	{
		Session session = this.session();

		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();

		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> listUsers()
	{
		// Transaction tx = session.beginTransaction();
		return this.session().createQuery("from User").list();
		// tx.commit();
	}

	public User updateUser(User user)
	{
		Session session = this.session();

		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();

		return user;
	}

}
