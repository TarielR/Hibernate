package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

public class HibernateUtils {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new Configuration();
            configuration.configure();

            //StandartServiceRegistryBuilder builder = null;

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void shutdown() {
        StandardServiceRegistryBuilder.destroy(ourSessionFactory.getSessionFactoryOptions().getServiceRegistry());
    }
}
