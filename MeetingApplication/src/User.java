import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class User {
String Name;
String password;
HashMap<String,Integer> timeAvailable = new HashMap<>();
static JTextField usernameField;
static JPasswordField passwordField;
static JLabel resultLabel;

static List<User> list = new ArrayList<>();

public User() {
	
}
public User(String firstName, String password) {
	this.Name = firstName;
	this.password = password;
}
public String getFirstName() {
	return Name;
}
public void setFirstName(String firstName) {
	this.Name = firstName;
}


public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}








}
