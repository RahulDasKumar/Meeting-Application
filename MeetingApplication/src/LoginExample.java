import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginExample {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Login Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JLabel resultLabel = new JLabel();

        // Set layout manager
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Add components to the frame
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(resultLabel);

        // Add ActionListener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the entered username and password
                String enteredUsername = usernameField.getText();
                char[] enteredPasswordChars = passwordField.getPassword();
                String enteredPassword = new String(enteredPasswordChars);

                // Validate the login (you can replace this with your authentication logic)
                if (isValidLogin(enteredUsername, enteredPassword)) {
                    resultLabel.setText("Login successful!");
                } else {
                    resultLabel.setText("Login failed. Please check your credentials.");
                }

                // Clear the password field for security
                passwordField.setText("");
            }
        });

        // Set the main frame visible
        frame.setVisible(true);
    }

    // Dummy method for login validation (replace with your authentication logic)
    private static boolean isValidLogin(String username, String password) {
        // This is a dummy validation; replace it with your authentication logic
    	
        return username.equals("Rahul Das") && password.equals("password");
    }
}
