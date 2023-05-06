import javax.swing.*;

public class CustomerGUI
{
	private JFrame frame;
	private static final int WINDOW_WIDTH = 1000;
	private static final int WINDOW_HEIGHT = 600;
	
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
        JTextField nameField = new JTextField(20);
        JTextField phoneField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JTextField streetField = new JTextField(20);
        JTextField cityField = new JTextField(20);
        JTextField stateField = new JTextField(20);
        JTextField zipCodeField = new JTextField(20);
        
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

        // Add customer with address
        searchButton.addActionListener(e -> {
        	String name = nameField.getText();
            
            JOptionPane.showMessageDialog(null, "Hello, " + name + "!");
        });
        
        // Add event listeners and handlers
        addButton.addActionListener(e -> {
        	String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String street = streetField.getText();
            String city = cityField.getText();
            String state = stateField.getText();
            int zipCode =  Integer.parseInt(zipCodeField.getText());
            
            CreateCustomer.createCustomer( name,  phone,  email, 
        			 street,  city,  state, zipCode);
            
            JOptionPane.showMessageDialog(null, "Customer: [" + name + "] successfully added.");
        });
        
        // Add event listeners and handlers
        updateButton.addActionListener(e -> {
            String name = nameField.getText();
            JOptionPane.showMessageDialog(null, "Hello, " + name + "!");
        });
        
        // Add event listeners and handlers
        deleteButton.addActionListener(e -> {
            String name = nameField.getText();
            JOptionPane.showMessageDialog(null, "Hello, " + name + "!");
        });
    }
	
	public void showWindow()
	{
		frame.setVisible(true);
	}

	
	public static void main(String[] args)
	{
		CustomerGUI customerGui = new CustomerGUI();
		customerGui.showWindow();
	}
}
