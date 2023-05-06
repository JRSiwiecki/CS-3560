import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ReadCustomers
{
	public static List<Customer> readCustomers()
	{
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(Address.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try
		{
			session.beginTransaction();
			
			// need to use the Class name, not table name
			// ie uppercase Customer like the class
			// not lowercase customers like the table in pgAdmin
			String hql = "FROM Customer";
			
			
			@SuppressWarnings("unchecked")
			List<Customer> customers = session.createQuery(hql)
					.list();
			
			session.getTransaction().commit();
			
			return customers;
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
}
