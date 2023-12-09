
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel resultLabel;

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        resultLabel = new JLabel();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginButtonListener());

        setLayout(new GridLayout(4, 2));
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);
        add(new JLabel());
        add(new JLabel("Result:"));
        add(resultLabel);
    }

    public String getEnteredUsername() {
        return usernameField.getText();
    }

    private boolean isValidLogin(String username, String password) {
        
    	for(int i = 0; i<User.list.size(); i++) {
    		if(User.list.get(i).Name.equals(username) && User.list.get(i).password.equals(password)) {
    			return true;
    		}
    	}
        return false;
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String enteredUsername = usernameField.getText();
            char[] enteredPasswordChars = passwordField.getPassword();
            String enteredPassword = new String(enteredPasswordChars);

            if (isValidLogin(enteredUsername, enteredPassword)) {
                resultLabel.setText("Login successful!");
                // create a new JFrame that will navigate through the group selection
                setVisible(false);
                Company Tech = new Company("Tech");
                Tech.SelectHours("10:00 am","11:00 am","12:00 pm","1:00 pm","2:00 pm","3:00 pm","5:00 pm");
                CompanyFrame newFrame = new CompanyFrame(Tech);
                newFrame.setVisible(true);
            } else {
                resultLabel.setText("Login failed. Please check your credentials.");
            }

            passwordField.setText(""); // Clear the password field for security
        }
    }
}
