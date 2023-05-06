import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

public class CreateOrder 
{
	public static void createOrder(Customer customer, String item, double price) 
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
			
			Order tempOrder = new Order();
			
			long millis = System.currentTimeMillis();

			tempOrder.setDate(new Date(millis));
			tempOrder.setCustomer(customer);
			tempOrder.setItem(item);
			tempOrder.setPrice(price);
			
			session.save(tempOrder);
			
			session.getTransaction().commit();
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
}
