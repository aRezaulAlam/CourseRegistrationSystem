package com.agroho.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.agroho.controller.LoginController;

public class Main extends JFrame {

	LoginController controller;
	private JTextField studentUserNameTextField;
	private JPasswordField passwordField;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setBounds(100, 100, 450, 320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 873, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentLogin = new JLabel("Student Login");
		lblStudentLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentLogin.setBounds(171, 11, 109, 34);
		contentPane.add(lblStudentLogin);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(79, 108, 74, 24);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(79, 161, 74, 24);
		contentPane.add(lblPassword);
		
		studentUserNameTextField = new JTextField();
		studentUserNameTextField.setBounds(171, 113, 132, 34);
		contentPane.add(studentUserNameTextField);
		studentUserNameTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		
		btnNewButton.setBounds(181, 226, 99, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblRegister = new JLabel("Register");
		
		lblRegister.setForeground(Color.BLUE);
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRegister.setBounds(305, 236, 61, 24);
		contentPane.add(lblRegister);
		
		JComboBox userTypeComboBox = new JComboBox();
		userTypeComboBox.setBounds(171, 58, 134, 34);
		userTypeComboBox.addItem("Student");
		userTypeComboBox.addItem("Admin");
		userTypeComboBox.addItem("Faculty");
		
		contentPane.add(userTypeComboBox);
		
		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserType.setBounds(79, 56, 74, 24);
		contentPane.add(lblUserType);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(172, 172, 134, 34);
		contentPane.add(passwordField);
		
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
						if (loginChecked==true) {
							setVisible(false);
							new TestProgress(userId,userType);

						} else {
							JOptionPane.showMessageDialog(null, "Login failed");
						}
					
						} else if (userType.equals("Faculty")) {
							loginChecked = controller.facultyLogin(userId, password);
							new TestProgress(userId,userType);
						} else if(userType.equals("Admin")){
							loginChecked = controller.adminLogin(userId, password);
							System.out.println("Admin");
						}
					/*	if (loginChecked==true) {
							 JOptionPane.showMessageDialog(null, "Login success");
						} else {
							JOptionPane.showMessageDialog(null, "Login failed");
						}*/
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
						
						setVisible(false);
						new StudentRegistration().setVisible(true);;
						

					} else if (userType.equals("Faculty")) {
						setVisible(false);
						new FacultyRegistration().setVisible(true);;
						
						System.out.println("Faculty");
					} else if(userType.equals("Admin")){
					
						setVisible(false);
						new AdminRegistration().setVisible(true);;
						System.out.println("Admin");
					}
				
				
			}
		});;
	}

}
