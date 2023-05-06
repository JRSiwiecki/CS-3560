import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ReadOrder
{
	public static Order readOrder(int orderNumber)
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
			
			tempOrder.setNumber(orderNumber);
			
			// need to use the Class name, not table name
			// ie uppercase Customer like the class
			// not lowercase customers like the table in pgAdmin
			String hql = "FROM Order WHERE number=:number";
			
			
			@SuppressWarnings("unchecked")
			List<Order> orders = session.createQuery(hql)
					.setParameter("number", tempOrder.getNumber())
					.list();
			
			tempOrder = (orders.isEmpty()) ? null : orders.get(0);
			
			session.getTransaction().commit();
			
			return tempOrder;
		}
		
		finally
		{
			session.close();
			factory.close();
		}
	}
}
