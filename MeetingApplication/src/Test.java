import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create and display the login frame
        	List<User> users = Arrays.asList(new User("Rahul","password"),
        			new User("Bob","password"), new User("Adam","password"));
        	User.list.addAll(users);
        	Company charlotteTech = new Company("Charlotte Tech");
            WelcomeFrame welcome = new WelcomeFrame();
            welcome.setVisible(true);
                     
        });
        
    }
}
