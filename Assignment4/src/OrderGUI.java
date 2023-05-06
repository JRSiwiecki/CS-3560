import javax.swing.*;
import java.util.List;

public class OrderGUI
{
	private JFrame frame;
	private static final int WINDOW_WIDTH = 1000;
	private static final int WINDOW_HEIGHT = 600;
	
	JTextField numberField;
    JTextField dateField;
    
    @SuppressWarnings("rawtypes")
	JComboBox customerField;
    
    @SuppressWarnings("rawtypes")
	JComboBox itemField;
    
    JTextField priceField;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public OrderGUI()
	{
		frame = new JFrame("Order");
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create components and add them to the JFrame
		JPanel panel = new JPanel();
		panel.setLayout(null);
        
        // Create labels
        JLabel numberLabel = new JLabel("Number");
        JLabel dateLabel = new JLabel("Date");
        JLabel customerLabel = new JLabel("Customer");
        JLabel itemLabel = new JLabel("Item");
        JLabel priceLabel = new JLabel("Price ($)");
        
        // Create text fields
        numberField = new JTextField(20);
        dateField = new JTextField(20);
        priceField = new JTextField(20);
        
        // Create combo boxes
        customerField = new JComboBox();
        customerField.addItem("");
        populateCustomerBox();
        
        itemField = new JComboBox();
        itemField.addItem("");
        itemField.addItem("Caesar Salad");
        itemField.addItem("Greek Salad");
        itemField.addItem("Cobb Salad");
        
        // Create buttons
        JButton searchButton = new JButton("Search");
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        // Add number components
        numberLabel.setBounds(25, 25, 100, 25);
        numberField.setBounds(25, 50, 100, 25);
        panel.add(numberLabel);
        panel.add(numberField);
        
        // Add date components
        dateLabel.setBounds(800, 25, 100, 25);
        dateField.setBounds(800, 50, 150, 25);
        panel.add(dateLabel);
        panel.add(dateField);
        
        // Add customer components
        customerLabel.setBounds(25, 100, 100, 25);
        customerField.setBounds(25, 125, 925, 25);
        panel.add(customerLabel);
        panel.add(customerField);
        
        // Add item components
        itemLabel.setBounds(25, 175, 100, 25);
        itemField.setBounds(25, 200, 225, 25);
        panel.add(itemLabel);
        panel.add(itemField);
        
        // Add price components
        priceLabel.setBounds(800, 175, 100, 25);
        priceField.setBounds(800, 200, 150, 25);
        panel.add(priceLabel);
        panel.add(priceField);
        
        // Add buttons to panel
        searchButton.setBounds(500, 500, 75, 30);
        addButton.setBounds(600, 500, 75, 30);
        updateButton.setBounds(700, 500, 75, 30);
        deleteButton.setBounds(800, 500, 75, 30);
        panel.add(searchButton);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        
        frame.getContentPane().add(panel);

        
        // Search order
        searchButton.addActionListener(e -> {
        	
            clearFields();
            
            JOptionPane.showMessageDialog(null, "Order successfully found.");
        });
        
        // Add order
        addButton.addActionListener(e -> {
        	
            clearFields();
            
            JOptionPane.showMessageDialog(null, "Order successfully placed.");
        });
        
        // Update order
        updateButton.addActionListener(e -> {
        	
            clearFields();
            
            JOptionPane.showMessageDialog(null, "Order successfully updated.");
        });
        
        // Delete order
        deleteButton.addActionListener(e -> {
        	
            clearFields();
            
            JOptionPane.showMessageDialog(null, "Order successfully deleted.");
        });

    }
	
	public void showWindow()
	{
		frame.setVisible(true);
	}
	
	public void clearFields()
	{
		numberField.setText("");
        dateField.setText("");
        customerField.setSelectedIndex(0);
        itemField.setSelectedIndex(0);
        priceField.setText("");

	}
	
	public void populateCustomerBox()
	{
		List<Customer> customers = ReadCustomers.readCustomers();
		
		for (int i = 0; i < customers.size(); i++)
		{
			customerField.addItem(customers.get(i).getName());
		}
		
	}

	
	public static void main(String[] args)
	{
		OrderGUI orderGUI = new OrderGUI();
		orderGUI.showWindow();
	}
}
