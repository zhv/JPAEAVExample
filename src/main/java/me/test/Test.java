package me.test;

import java.util.Arrays;

import me.domain.MEEntity;
import me.domain.MEParameter;
import me.domain.MEParameterValue;
import me.domain.MEValue;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Configuration c = createConfiguration();
		SessionFactory sf = null;
		try {
			sf = c.buildSessionFactory();
			openSession(sf);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (sf != null) {
				sf.close();
			}
		}
	}

	private static Configuration createConfiguration() {
		Configuration c = new Configuration();
		c.addAnnotatedClass(MEEntity.class);
		c.addAnnotatedClass(MEParameter.class);
		c.addAnnotatedClass(MEParameterValue.class);
		c.addAnnotatedClass(MEValue.class);
		return c;
	}

	private static void openSession(SessionFactory sf) {
		Session s = null;
		try {
			s = sf.openSession();
			saveEntity(s);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}

	private static void saveEntity(Session session) {
		MEParameter p = new MEParameter("Text Parameter", "TEXT", true);
		session.save(p);

		MEEntity e = new MEEntity("Test Entity", "test entity description", "test entity type");
		e.setValues(Arrays.asList(new MEParameterValue(p, "A", null), new MEParameterValue(p, "B", null)));
		session.save(e);
	}
}
