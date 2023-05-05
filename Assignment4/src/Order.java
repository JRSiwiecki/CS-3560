import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="order")
public class Order 
{
	@Id
	@Column(name="number")
	private int number;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="item")
	private String item;
	
	@Column(name="price")
	private double price;
	
	private Customer customer;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
