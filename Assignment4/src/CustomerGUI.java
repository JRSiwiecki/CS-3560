import javax.swing.*;
import java.awt.*;

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
		JPanel panel = new JPanel(new FlowLayout());
        
        // Create labels
        JLabel nameLabel = new JLabel("Name");
        JLabel phoneLabel = new JLabel("Phone");
        JLabel emailLabel = new JLabel("Email");
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
        panel.add(nameLabel);
        panel.add(nameField);
        
        // Add phone components
        panel.add(phoneLabel);
        panel.add(phoneField);
        
        // Add email components
        panel.add(emailLabel);
        panel.add(emailField);
        
        // Add street components
        panel.add(streetLabel);
        panel.add(streetField);
        
        // Add city components
        panel.add(cityLabel);
        panel.add(cityField);
        
        // Add state components
        panel.add(stateLabel);
        panel.add(stateField);
        
        // Add zip code components
        panel.add(zipCodeLabel);
        panel.add(zipCodeField);
        
        
        
        // Add buttons to panel
        panel.add(searchButton);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        
        frame.getContentPane().add(panel);

        // Add event listeners and handlers
        searchButton.addActionListener(e -> {
            String name = nameField.getText();
            JOptionPane.showMessageDialog(null, "Hello, " + name + "!");
        });
        
     // Add event listeners and handlers
        searchButton.addActionListener(e -> {
            String name = nameField.getText();
            JOptionPane.showMessageDialog(null, "Hello, " + name + "!");
        });
        
     // Add event listeners and handlers
        searchButton.addActionListener(e -> {
            String name = nameField.getText();
            JOptionPane.showMessageDialog(null, "Hello, " + name + "!");
        });
        
     // Add event listeners and handlers
        searchButton.addActionListener(e -> {
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
