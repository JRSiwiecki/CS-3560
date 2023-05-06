import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCustomer 
{
	public static void createCustomer(String name, String phone, String email, 
			String street, String city, String state, int zipCode) 
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
			tempCustomer.setPhone(phone);
			tempCustomer.setEmail(email);
			
			Address tempAddress = new Address();
			
			tempAddress.setStreet(street);
			tempAddress.setCity(city);
			tempAddress.setState(state);
			tempAddress.setZipCode(zipCode);
			
			tempCustomer.setAddress(tempAddress);
			
			session.save(tempCustomer);
			session.save(tempAddress);
			
			session.getTransaction().commit();
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
}
