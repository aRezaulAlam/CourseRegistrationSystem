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
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import com.agroho.controller.StudentController;
import com.agroho.model.Student;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentRegistration extends JFrame{
	private JPanel contentPane;

	private JFrame frame;
	private JTextField idField;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JTextField courseField;
	private JTextField mobileField;
	private JPasswordField retypePasswordField_1;
	StudentController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setLookAndFeel(Constants.NIMBUS_LF);
					StudentRegistration frame = new StudentRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public StudentRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(336, 30, 188, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblIdNumber = new JLabel("ID Number: ");
		lblIdNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdNumber.setBounds(152, 102, 104, 20);
		contentPane.add(lblIdNumber);
		
		JLabel lblIdName = new JLabel("Name:");
		lblIdName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdName.setBounds(152, 165, 104, 20);
		contentPane.add(lblIdName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(152, 217, 104, 20);
		contentPane.add(lblPassword);
		
		JLabel lblIdCourse = new JLabel("Major");
		lblIdCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdCourse.setBounds(152, 338, 104, 20);
		contentPane.add(lblIdCourse);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMobile.setBounds(152, 401, 104, 20);
		contentPane.add(lblMobile);
		
		idField = new JTextField();
		idField.setBounds(368, 102, 206, 34);
		contentPane.add(idField);
		idField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(368, 161, 206, 32);
		contentPane.add(nameField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(368, 213, 206, 32);
		contentPane.add(passwordField);
		
		courseField = new JTextField();
		courseField.setColumns(10);
		courseField.setBounds(368, 335, 206, 30);
		contentPane.add(courseField);
		
		mobileField = new JTextField();
		mobileField.setColumns(10);
		mobileField.setBounds(368, 398, 206, 30);
		contentPane.add(mobileField);
		
		retypePasswordField_1 = new JPasswordField();
		retypePasswordField_1.setBounds(368, 271, 206, 34);
		contentPane.add(retypePasswordField_1);
		
		JLabel lblRetypePassword = new JLabel("Retype Password");
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRetypePassword.setBounds(152, 276, 129, 20);
		contentPane.add(lblRetypePassword);
		
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
		btnNewButton.setBounds(387, 480, 104, 37);
		contentPane.add(btnNewButton);
		
		
		
		
	}
	
	public static void setLookAndFeel(String lf) throws Exception {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if (lf.equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If the given lf is not available, you can set the GUI the system
			// default L&F.
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
	}
}
