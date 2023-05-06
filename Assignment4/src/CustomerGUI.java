import javax.swing.*;

public class CustomerGUI
{
	private JFrame frame;
	private static final int WINDOW_WIDTH = 1000;
	private static final int WINDOW_HEIGHT = 600;
	
	JTextField nameField;
    JTextField phoneField;
    JTextField emailField;
    JTextField streetField;
    JTextField cityField;
    JTextField stateField;
    JTextField zipCodeField;
	
	public CustomerGUI()
	{
		frame = new JFrame("Customer");
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create components and add them to the JFrame
		JPanel panel = new JPanel();
		panel.setLayout(null);
        
        // Create labels
        JLabel nameLabel = new JLabel("Name");
        JLabel phoneLabel = new JLabel("Phone");
        JLabel emailLabel = new JLabel("Email");
        JLabel addressLabel = new JLabel("Address");
        JLabel streetLabel = new JLabel("Street");
        JLabel cityLabel = new JLabel("City");
        JLabel stateLabel = new JLabel("State");
        JLabel zipCodeLabel = new JLabel("Zip Code");
        
        // Create text fields
        nameField = new JTextField(20);
        phoneField = new JTextField(20);
        emailField = new JTextField(20);
        streetField = new JTextField(20);
        cityField = new JTextField(20);
        stateField = new JTextField(20);
        zipCodeField = new JTextField(20);
        
        // Create buttons
        JButton searchButton = new JButton("Search");
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        // Add name components
        nameLabel.setBounds(25, 25, 100, 25);
        nameField.setBounds(25, 50, 925, 25);
        panel.add(nameLabel);
        panel.add(nameField);
        
        // Add phone components
        phoneLabel.setBounds(25, 100, 100, 25);
        phoneField.setBounds(25, 125, 300, 25);
        panel.add(phoneLabel);
        panel.add(phoneField);
        
        // Add email components
        emailLabel.setBounds(350, 100, 100, 25);
        emailField.setBounds(350, 125, 600, 25);
        panel.add(emailLabel);
        panel.add(emailField);
        
        // Add address label
        addressLabel.setBounds(25, 200, 100, 25);
        panel.add(addressLabel);
        
        // Add street components
        streetLabel.setBounds(50, 250, 100, 25);
        streetField.setBounds(50, 275, 300, 25);
        panel.add(streetLabel);
        panel.add(streetField);
        
        // Add city components
        cityLabel.setBounds(450, 250, 100, 25);
        cityField.setBounds(450, 275, 300, 25);
        panel.add(cityLabel);
        panel.add(cityField);
        
        // Add state components
        stateLabel.setBounds(50, 350, 100, 25);
        stateField.setBounds(50, 375, 300, 25);
        panel.add(stateLabel);
        panel.add(stateField);
        
        // Add zip code components
        zipCodeLabel.setBounds(450, 350, 100, 25);
        zipCodeField.setBounds(450, 375, 300, 25);
        panel.add(zipCodeLabel);
        panel.add(zipCodeField);
        
        
        
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

        
        // Get customer
        searchButton.addActionListener(e -> {
        	String name = nameField.getText();
        	
        	Customer tempCustomer = ReadCustomer.readCustomer(name);
        	
        	if (tempCustomer == null)
        	{
        		JOptionPane.showMessageDialog(null, "No customer found!");
        		return;
        	}
        	
        	nameField.setText(tempCustomer.getName());
        	phoneField.setText(tempCustomer.getPhone());
        	emailField.setText(tempCustomer.getEmail());
        	
        	Address tempAddress = tempCustomer.getAddress();
        	
        	streetField.setText(tempAddress.getStreet());
        	cityField.setText(tempAddress.getCity());
        	stateField.setText(tempAddress.getState());
        	zipCodeField.setText(String.valueOf(tempAddress.getZipCode()));
        	
        });
        
        // Add customer
        addButton.addActionListener(e -> {
        	String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String street = streetField.getText();
            String city = cityField.getText();
            String state = stateField.getText();
            int zipCode =  Integer.parseInt(zipCodeField.getText());
            
            CreateCustomer.createCustomer(name,  phone,  email, 
        			 street,  city,  state, zipCode);
            
            clearFields();
            
            JOptionPane.showMessageDialog(null, "Customer: [" + name + "] successfully added.");
        });
        
        // Update customer
        updateButton.addActionListener(e -> {
        	Customer tempCustomer = new Customer();
            
            tempCustomer.setName(nameField.getText());
            tempCustomer.setPhone(phoneField.getText());
            tempCustomer.setEmail(emailField.getText());
            
            Address tempAddress = new Address();
            
            tempAddress.setStreet(streetField.getText());
            tempAddress.setCity(cityField.getText());
            tempAddress.setState(stateField.getText());
            
            tempAddress.setZipCode( 
            		(zipCodeField.getText().equals(""))
          				? -1 : Integer.parseInt(zipCodeField.getText()));
            
            tempCustomer.setAddress(tempAddress);
            
            UpdateCustomer.updateCustomer(tempCustomer);
            
            clearFields();
            
            JOptionPane.showMessageDialog(null, "Customer: [" + tempCustomer.getName() + "] successfully updated.");
        });
        
        // Delete customer
        deleteButton.addActionListener(e -> {
            Customer tempCustomer = new Customer();
            
            tempCustomer.setName(nameField.getText());
            tempCustomer.setPhone(phoneField.getText());
            tempCustomer.setEmail(emailField.getText());
            
            Address tempAddress = new Address();
            
            tempAddress.setStreet(streetField.getText());
            tempAddress.setCity(cityField.getText());
            tempAddress.setState(stateField.getText());
            
            tempAddress.setZipCode( 
            		(zipCodeField.getText().equals(""))
          				? -1 : Integer.parseInt(zipCodeField.getText()));
            
            tempCustomer.setAddress(tempAddress);
            
            DeleteCustomer.deleteCustomer(tempCustomer);
            
            clearFields();
            
            JOptionPane.showMessageDialog(null, "Customer: [" + tempCustomer.getName() + "] successfully deleted.");
        });
    }
	
	public void showWindow()
	{
		frame.setVisible(true);
	}
	
	public void clearFields()
	{
		nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
        streetField.setText("");
        cityField.setText("");
        stateField.setText("");
        zipCodeField.setText("");
	}

	
	public static void main(String[] args)
	{
		CustomerGUI customerGui = new CustomerGUI();
		customerGui.showWindow();
	}
}
