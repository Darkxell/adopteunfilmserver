package adopteunfilmserver.controller.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/** Each Service class should extend this class. */
@SuppressWarnings("deprecation")
public class AFSService<T>
{

	@SuppressWarnings("rawtypes")
	private static final Set<Class> classes = new HashSet<Class>();

	private Class<T> oClass;

	public AFSService(Class<T> oClass)
	{
		this.oClass = oClass;
		classes.add(this.oClass);
	}

	public T add(T object)
	{
		Session session = this.session();

		Transaction tx = session.beginTransaction();
		session.save(object);
		tx.commit();

		return object;
	}

	public void delete(int id)
	{
		this.delete(this.get(id));
	}

	public T delete(T object)
	{
		Session session = this.session();

		Transaction tx = session.beginTransaction();
		session.delete(object);
		tx.commit();

		return object;
	}

	public T get(int id)
	{
		@SuppressWarnings("unchecked")
		List<T> list = this.session().createQuery("from " + this.oClass.getName() + " where id='" + id + "'").list();
		if (list.isEmpty()) return null;
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<T> list()
	{
		return this.session().createQuery("from " + this.oClass.getName()).list();
	}

	/** Provides easy access to the session. */
	public Session session()
	{
		Configuration con = new Configuration().configure();
		for (@SuppressWarnings("rawtypes") Class c : classes)
			con.addAnnotatedClass(c);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		return sf.openSession();
	}

	public T update(T object)
	{
		Session session = this.session();

		Transaction tx = session.beginTransaction();
		session.update(object);
		tx.commit();

		return object;
	}

}
