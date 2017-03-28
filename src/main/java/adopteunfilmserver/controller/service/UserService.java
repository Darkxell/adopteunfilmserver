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

	public void deleteUser(int id)
	{
		this.deleteUser(this.getUser(id));
	}

	public User deleteUser(User user)
	{
		Session session = this.session();

		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();

		return user;
	}

	public User getUser(int id)
	{
		@SuppressWarnings("unchecked")
		List<User> list = this.session().createQuery("from User where id='" + id + "'").list();
		if (list.isEmpty()) return null;
		return list.get(0);
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
