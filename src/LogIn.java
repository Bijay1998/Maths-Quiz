import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.cj.xdevapi.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import java.sql.SQLException;
import javax.swing.JPasswordField;


public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("LOGIN PAGE");
		lblLoginPage.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblLoginPage.setBounds(119, 11, 279, 39);
		contentPane.add(lblLoginPage);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(44, 89, 228, 26);
		contentPane.add(lblUsername);
		
		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.PLAIN, 15));
		user.setBounds(42, 126, 310, 39);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(44, 186, 233, 26);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/quiz", "root", "");
					java.sql.Statement stmt =con.createStatement();
					String sql = "Select * from Quiz where email='"+user.getText()+"' and password='"+pass.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "Successful");
						Quiz quiz  = new Quiz();
						
						
					
					}else
						JOptionPane.showMessageDialog(null, "Username or password incorrect");
					con.close();
				}catch(Exception e){
					System.out.print(e);
					
				}
				
			
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(168, 313, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnBack = new JButton("<Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registration register = new Registration();
				register.setVisible(true);
			}
		});
		btnBack.setBounds(24, 396, 89, 23);
		contentPane.add(btnBack);
		
		pass = new JPasswordField();
		pass.setBounds(44, 219, 308, 39);
		contentPane.add(pass);
	}
}
