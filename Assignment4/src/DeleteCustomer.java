import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCustomer
{
	public static void deleteCustomer(Customer customer)
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
			
			// Retrieve the customer from the database using their name
			String hql = "FROM Customer WHERE name=:name";
			Customer tempCustomer = (Customer) session.createQuery(hql)
			                                    .setParameter("name", customer.getName())
			                                    .uniqueResult();

			// Update the customer object with the correct ID
			customer.setId(tempCustomer.getId());
			
			session.delete(session.get(Customer.class, customer.getId()));
			
			session.getTransaction().commit();
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
}
