import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JTextField;

import java.sql.*;

//registration class inheriting the funcions of jframe class
public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField email;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection con =null;
	public Registration() {
		con = JDBC.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrationPage = new JLabel("REGISTRATION PAGE");
		lblRegistrationPage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegistrationPage.setBounds(139, 11, 252, 34);
		contentPane.add(lblRegistrationPage);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(30, 91, 113, 24);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(30, 126, 113, 26);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(30, 163, 113, 30);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(30, 204, 113, 30);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String first = firstname.getText();
					String last = lastname.getText();
					String pass  = password.getText();
					String emaill = email.getText();
					
					PreparedStatement pst = con.prepareStatement("INSERT INTO quiz(fName, lName, password,email)values(?,?,?,?)");
					
					pst.setString(1, first);
					pst.setString(2, last);
					pst.setString(3, pass);
					pst.setString(4, emaill);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"User registration successfull!");
					LogIn login = new LogIn();
					login.setVisible(true);
					
				}catch(Exception e1){
					e1.printStackTrace();
				}			
				
					
					
						
				
				
			}
		});
		btnNewButton.setBounds(54, 299, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LogIn");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogIn login =new LogIn();
				login.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(363, 299, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblHaveAAccount = new JLabel("Have a account?");
		lblHaveAAccount.setBounds(363, 278, 113, 14);
		contentPane.add(lblHaveAAccount);
		
		firstname = new JTextField();
		firstname.setBounds(172, 91, 158, 24);
		contentPane.add(firstname);
		firstname.setColumns(10);
		
		lastname = new JTextField();
		lastname.setBounds(172, 126, 158, 25);
		contentPane.add(lastname);
		lastname.setColumns(10);
		
		email = new JTextField();
		email.setBounds(172, 170, 158, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		password = new JTextField();
		password.setBounds(172, 211, 158, 20);
		contentPane.add(password);
		password.setColumns(10);
	}
}
