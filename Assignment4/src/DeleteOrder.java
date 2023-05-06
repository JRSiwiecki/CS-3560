import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteOrder
{
	public static void deleteOrder(int orderNumber)
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
			String hql = "FROM Order WHERE number=:number";
			Order tempOrder = (Order) session.createQuery(hql)
			                                    .setParameter("number", orderNumber)
			                                    .uniqueResult();

			// Update the customer object with the correct ID
//			tempOrder.setId(tempOrder.getNumber());
			
			session.delete(session.get(Order.class, tempOrder.getNumber()));
			
			session.getTransaction().commit();
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
}
