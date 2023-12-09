import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class RegisterFrame extends JFrame {
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel resultLabel;

    public RegisterFrame() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        resultLabel = new JLabel();
        setLayout(new GridLayout(4, 2));
        JButton registerButton = new JButton("Register");
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(registerButton);
        add(new JLabel());
        add(new JLabel("Result:"));
        add(resultLabel);
        
        registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User.list.add(new User(usernameField.getName(),passwordField.getName()));
				setVisible(false);
				LoginFrame loginFrame = new LoginFrame();
				loginFrame.setVisible(true);
			}
        });
    }

}
