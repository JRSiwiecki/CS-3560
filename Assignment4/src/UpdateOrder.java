import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateOrder
{
	public static void updateOrder(Order order)
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
			
			// Retrieve the order from the database using their name
			String hql = "FROM Order WHERE number=:number";
			Order tempOrder = (Order) session.createQuery(hql)
			                                    .setParameter("number", order.getNumber())
			                                    .uniqueResult();
			
			tempOrder = session.get(Order.class, order.getNumber());
					
			// Update the order object with the correct ID
			order.setNumber(tempOrder.getNumber());
			
			hql = "UPDATE Order SET date=:date, item=:item, price=:price, customer_id=:customer_id"
					+ " WHERE number=:number";
			

			session.createQuery(hql)
				.setParameter("date", order.getDate())
				.setParameter("item", order.getItem())
				.setParameter("price", order.getPrice())
				.setParameter("number", order.getNumber())
				.setParameter("customer_id", order.getCustomer().getId())
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
