package adopteunfilmserver.controller.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/** Each Service class should extend this class. */
@SuppressWarnings("deprecation")
public class AFSService<T>
{

	private Class<T> oClass;

	public AFSService(Class<T> oClass)
	{
		this.oClass = oClass;
	}

	/** Provides easy access to the session. */
	public Session session()
	{
		Configuration con = new Configuration().configure().addAnnotatedClass(this.oClass);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		return sf.openSession();
	}

}
