
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class WelcomeFrame extends JFrame{
	private JButton login;
	private JButton register;
	public WelcomeFrame() {
		setTitle("Welcome Page");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		login = new JButton("Login");
		register = new JButton("Register");
        setLayout(new GridLayout(4, 2));
        login.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				LoginFrame loginframe = new LoginFrame();
				loginframe.setVisible(true);
			}
        	
        });
        register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				RegisterFrame registerFrame = new RegisterFrame();
				registerFrame.setVisible(true);
				
			}
        	
        });
        
        add(login);
        add(register);
        setVisible(true);
		
	}
}

