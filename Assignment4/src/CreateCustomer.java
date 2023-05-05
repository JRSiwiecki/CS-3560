import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCustomer 
{
	public static void main(String[] args) 
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
			
			tempCustomer.setName("Joseph");
			tempCustomer.setPhone("626-333-1804");
			tempCustomer.setEmail("JRSiwiecki@gmail.com");
			
			Address tempAddress = new Address();
			
			tempAddress.setStreet("1037 S Caraway Dr");
			tempAddress.setCity("Whittier");
			tempAddress.setState("California");
			tempAddress.setZipCode(90601);
			
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
