package adopteunfilmserver.controller.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Service;

import adopteunfilmserver.model.User;

@SuppressWarnings("deprecation")
@Service("userService")
public class UserService {

	public User addUser(User user) {
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();

		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();

		// Transaction tx = session.beginTransaction();
		return session.createQuery("from user").list();
		// tx.commit();
	}

}
