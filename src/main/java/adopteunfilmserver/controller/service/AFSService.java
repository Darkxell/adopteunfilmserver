package adopteunfilmserver.controller.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import adopteunfilmserver.model.*;

/** Each Service class should extend this class. */
@SuppressWarnings("deprecation")
public class AFSService<T>
{

	@SuppressWarnings("rawtypes")
	private static final Class[] classes =
	{ Person.class, Company.class, Language.class, Genre.class, Keyword.class, Movie.class, User.class, Rating.class };
	private static SessionFactory sf;

	private Class<T> oClass;

	public AFSService(Class<T> oClass)
	{
		this.oClass = oClass;
	}

	public T add(T object)
	{
		Session session = this.session();

		session.save(object);
		session.getTransaction().commit();
		if (session.isOpen()) session.close();

		return object;
	}

	private void createSessionFactory()
	{
		Configuration con = new Configuration().configure();
		for (@SuppressWarnings("rawtypes")
		Class c : classes)
			con.addAnnotatedClass(c);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).build();
		sf = con.buildSessionFactory(reg);
	}

	public void delete(int id)
	{
		this.delete(this.get(id));
	}

	public T delete(T object)
	{
		Session session = this.session();

		session.delete(object);
		session.getTransaction().commit();
		if (session.isOpen()) session.close();

		return object;
	}

	public T get(int id)
	{
		@SuppressWarnings("unchecked")
		List<T> list = this.session().createQuery("from " + this.oClass.getName() + " where id='" + id + "'").list();
		if (this.session().isOpen()) this.session().close();
		if (list.isEmpty()) return null;
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<T> list()
	{
		List<T> list = this.session().createQuery("from " + this.oClass.getName()).list();
		if (this.session().isOpen()) this.session().close();
		return list;
	}

	/** Provides easy access to the session. */
	public Session session()
	{
		if (sf == null) createSessionFactory();
		Session s = sf.getCurrentSession();
		if (!s.isOpen()) s = sf.openSession();
		if (!s.getTransaction().isActive()) s.beginTransaction();
		return s;
	}

	public T update(T object)
	{
		Session session = this.session();

		session.update(object);
		session.getTransaction().commit();
		if (session.isOpen()) session.close();

		return object;
	}

}
