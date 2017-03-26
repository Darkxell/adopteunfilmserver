package adopteunfilmserver.controller.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import adopteunfilmserver.model.User;

@Repository
@Transactional
public class UserDAO
{

	@Autowired
	private SessionFactory sessionFactory;

	public User add(User user)
	{
		this.session().persist(user);
		return user;
	}

	public void delete(User user)
	{
		this.session().delete(user);
	}

	public User get(int id)
	{
		return (User) this.session().load(User.class, new Integer(id));
	}

	/** @param conditions - additional conditions on SQL selection */
	public List<User> list(String conditions)
	{
		@SuppressWarnings("unchecked")
		List<User> users = this.session().createQuery("from user" + conditions).list();
		return users;
	}

	protected Session session()
	{
		return this.sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory = sf;
	}

	public void update(User user)
	{
		this.session().update(user);
	}

}
