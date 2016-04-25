package com.agroho.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.agroho.controller.StudentController;
import com.agroho.model.Student;

public class StudentRegistrationUI extends JPanel {

	private JTextField idField;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JTextField courseField;
	private JTextField mobileField;
	private JPasswordField retypePasswordField_1;
	StudentController controller;
	/**
	 * Create the panel.
	 */
	public StudentRegistrationUI() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(386, 11, 137, 20);
		add(lblNewLabel);
		
		JLabel lblIdNumber = new JLabel("ID Number: ");
		lblIdNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdNumber.setBounds(152, 102, 104, 20);
		add(lblIdNumber);
		
		JLabel lblIdName = new JLabel("Name:");
		lblIdName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdName.setBounds(152, 165, 104, 20);
		add(lblIdName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(152, 217, 104, 20);
		add(lblPassword);
		
		JLabel lblIdCourse = new JLabel("Major");
		lblIdCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdCourse.setBounds(152, 331, 104, 20);
		add(lblIdCourse);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMobile.setBounds(152, 383, 104, 20);
		add(lblMobile);
		
		idField = new JTextField();
		idField.setBounds(368, 102, 206, 34);
		add(idField);
		idField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(368, 161, 206, 32);
		add(nameField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(368, 213, 206, 32);
		add(passwordField);
		
		courseField = new JTextField();
		courseField.setColumns(10);
		courseField.setBounds(368, 328, 206, 30);
		add(courseField);
		
		mobileField = new JTextField();
		mobileField.setColumns(10);
		mobileField.setBounds(368, 380, 206, 30);
		add(mobileField);
		
		retypePasswordField_1 = new JPasswordField();
		retypePasswordField_1.setBounds(368, 268, 206, 34);
		add(retypePasswordField_1);
		
		JLabel lblRetypePassword = new JLabel("Retype Password");
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRetypePassword.setBounds(152, 271, 129, 20);
		add(lblRetypePassword);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student student = new Student();
				
				
				student.setStudentId(idField.getText());
				student.setName(nameField.getText());
				student.setMajor(courseField.getText());
				student.setMobile(mobileField.getText());
				student.setPassword(passwordField.getText());
				
				System.out.println("Password in View: "+student.getPassword());
				
				try {
					System.out.println(student.getMajor());
					controller =  new StudentController(student);
					controller.register();
				} catch (ClassNotFoundException | SQLException w) {
					// TODO Auto-generated catch block
//					w.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(400, 489, 104, 37);
		add(btnNewButton);
		
		
		
		
		
		/*
package com.agroho.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.agroho.controller.StudentController;
import com.agroho.model.Student;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentRegistration {

	private JFrame frame;
	private JTextField idField;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JTextField courseField;
	private JTextField mobileField;
	private JPasswordField retypePasswordField_1;
	StudentController controller;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRegistration window = new StudentRegistration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public StudentRegistration() throws ClassNotFoundException, SQLException {
		initialize();
	}


	@SuppressWarnings("deprecation")
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(386, 11, 137, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblIdNumber = new JLabel("ID Number: ");
		lblIdNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdNumber.setBounds(152, 102, 104, 20);
		frame.getContentPane().add(lblIdNumber);
		
		JLabel lblIdName = new JLabel("Name:");
		lblIdName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdName.setBounds(152, 165, 104, 20);
		frame.getContentPane().add(lblIdName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(152, 217, 104, 20);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblIdCourse = new JLabel("Major");
		lblIdCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdCourse.setBounds(152, 331, 104, 20);
		frame.getContentPane().add(lblIdCourse);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMobile.setBounds(152, 383, 104, 20);
		frame.getContentPane().add(lblMobile);
		
		idField = new JTextField();
		idField.setBounds(368, 102, 206, 34);
		frame.getContentPane().add(idField);
		idField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(368, 161, 206, 32);
		frame.getContentPane().add(nameField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(368, 213, 206, 32);
		frame.getContentPane().add(passwordField);
		
		courseField = new JTextField();
		courseField.setColumns(10);
		courseField.setBounds(368, 328, 206, 30);
		frame.getContentPane().add(courseField);
		
		mobileField = new JTextField();
		mobileField.setColumns(10);
		mobileField.setBounds(368, 380, 206, 30);
		frame.getContentPane().add(mobileField);
		
		retypePasswordField_1 = new JPasswordField();
		retypePasswordField_1.setBounds(368, 268, 206, 34);
		frame.getContentPane().add(retypePasswordField_1);
		
		JLabel lblRetypePassword = new JLabel("Retype Password");
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRetypePassword.setBounds(152, 271, 129, 20);
		frame.getContentPane().add(lblRetypePassword);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
Student student = new Student();
				
				
				student.setStudentId(idField.getText());
				student.setName(nameField.getText());
				student.setMajor(courseField.getText());
				student.setMobile(mobileField.getText());
				student.setPassword(passwordField.getText());
				
				System.out.println("Password in View: "+student.getPassword());
				
				try {
					System.out.println(student.getMajor());
					controller =  new StudentController(student);
					controller.register();
				} catch (ClassNotFoundException | SQLException w) {
					// TODO Auto-generated catch block
//					w.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(323, 455, 104, 37);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
	}
}

*
*
*/

	}

}
