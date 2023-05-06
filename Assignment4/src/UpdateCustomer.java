import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateCustomer
{
	public static void updateCustomer(Customer customer)
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
			
			tempCustomer = session.get(Customer.class, tempCustomer.getId());
					
			// Update the customer object with the correct ID
			customer.setId(tempCustomer.getId());
			
			hql = "UPDATE Customer SET name=:name, phone=:phone, email=:email WHERE id=:id";
//					+ " street=:street, city=:city, state=:state,"
//					+ " zip_code=:zipCode WHERE id=:id";
			

			session.createQuery(hql)
				.setParameter("name", customer.getName())
				.setParameter("phone", customer.getPhone())
				.setParameter("email", customer.getEmail())
//				.setParameter("street", tempCustomer.getAddress().getStreet())
//				.setParameter("city", tempCustomer.getAddress().getCity())
//				.setParameter("state", tempCustomer.getAddress().getState())
//				.setParameter("zipCode", tempCustomer.getAddress().getZipCode())
				.setParameter("id", customer.getId())
				.executeUpdate();
			
			session.getTransaction().commit();
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
}
