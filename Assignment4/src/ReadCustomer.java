import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ReadCustomer
{
	public static Customer readCustomer(String name)
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
			
			Customer tempCustomer = new Customer();
			
			tempCustomer.setName(name);
			
			// need to use the Class name, not table name
			// ie uppercase Customer like the class
			// not lowercase customers like the table in pgAdmin
			String hql = "FROM Customer WHERE name=:name";
			
			
			@SuppressWarnings("unchecked")
			List<Customer> customers = session.createQuery(hql)
					.setParameter("name", tempCustomer.getName())
					.list();
			
			tempCustomer = (customers.isEmpty()) ? null : customers.get(0);
			
			session.getTransaction().commit();
			
			return tempCustomer;
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
}
