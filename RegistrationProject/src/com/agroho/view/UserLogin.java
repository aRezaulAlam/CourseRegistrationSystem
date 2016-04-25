package com.agroho.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.agroho.controller.LoginController;
import com.agroho.controller.StudentController;
import com.agroho.model.Student;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class UserLogin {
	LoginController controller;
	private JFrame frame;
	private JTextField studentUserNameTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin window = new UserLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentLogin = new JLabel("Student Login");
		lblStudentLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentLogin.setBounds(171, 11, 109, 34);
		frame.getContentPane().add(lblStudentLogin);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(79, 108, 74, 24);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(79, 161, 74, 24);
		frame.getContentPane().add(lblPassword);
		
		studentUserNameTextField = new JTextField();
		studentUserNameTextField.setBounds(173, 104, 132, 34);
		frame.getContentPane().add(studentUserNameTextField);
		studentUserNameTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		
		btnNewButton.setBounds(181, 223, 99, 34);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblRegister = new JLabel("Register");
		
		lblRegister.setForeground(Color.BLUE);
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRegister.setBounds(307, 227, 61, 24);
		frame.getContentPane().add(lblRegister);
		
		JComboBox userTypeComboBox = new JComboBox();
		userTypeComboBox.setBounds(171, 58, 134, 24);
		userTypeComboBox.addItem("Student");
		userTypeComboBox.addItem("Admin");
		userTypeComboBox.addItem("Faculty");
		
		frame.getContentPane().add(userTypeComboBox);
		
		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserType.setBounds(79, 56, 74, 24);
		frame.getContentPane().add(lblUserType);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 158, 134, 34);
		frame.getContentPane().add(passwordField);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String userType = (String) userTypeComboBox.getSelectedItem();
				String userId = studentUserNameTextField.getText();
				String password = passwordField.getText();
				System.out.println(userType);
				boolean loginChecked = false;
				
					
					
					System.out.println(password);
					
					controller =  new LoginController();
					
					try {
						
						if (userType.equals("Student")) {
						loginChecked = controller.studentLogin(userId, password);
						} else if (userType.equals("Faculty")) {
							loginChecked = controller.facultyLogin(userId, password);
							System.out.println("Faculty");
						} else if(userType.equals("Admin")){
							loginChecked = controller.adminLogin(userId, password);
							System.out.println("Admin");
						}
						if (loginChecked==true) {
							 JOptionPane.showMessageDialog(null, "Login success");
						} else {
							JOptionPane.showMessageDialog(null, "Login failed");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				
			}
		});
		
		
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String userType = (String) userTypeComboBox.getSelectedItem();
		
				System.out.println(userType);			
				
					if (userType.equals("Student")) {
						
						frame.setVisible(false);
						new StudentRegistration().setVisible(true);;
						

					} else if (userType.equals("Faculty")) {
						frame.setVisible(false);
						new FacultyRegistration().setVisible(true);;
						
						System.out.println("Faculty");
					} else if(userType.equals("Admin")){
					
						frame.setVisible(false);
						new AdminRegistration().setVisible(true);;
						System.out.println("Admin");
					}
				
				
			}
		});
	}
}
