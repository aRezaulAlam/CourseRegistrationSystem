package com.agroho.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.agroho.controller.StudentController;
import com.agroho.model.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentHome frame = new StudentHome("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param userId 
	 */
	public StudentHome(String userId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		StudentController controller = new StudentController();
		Student student = controller.getStudentDetailsById(userId);
		
		JLabel lblStudentPanel = new JLabel("Student Panel");
		lblStudentPanel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentPanel.setBounds(32, 12, 108, 19);
		contentPane.add(lblStudentPanel);
		
		JLabel lblWelcome = new JLabel("Welcome! ");
		lblWelcome.setBounds(423, 16, 70, 14);
		contentPane.add(lblWelcome);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(596, 11, 89, 23);
		contentPane.add(btnSignOut);
		
		JLabel lblStudentName = new JLabel("Hello");
		lblStudentName.setText(userId);
		lblStudentName.setBounds(485, 16, 108, 14);
		contentPane.add(lblStudentName);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 86, 262, 354);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblStudentDetails = new JLabel("Student Details");
		lblStudentDetails.setBounds(83, 11, 99, 14);
		panel.add(lblStudentDetails);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setBounds(28, 60, 46, 14);
		panel.add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(28, 96, 46, 14);
		panel.add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(28, 129, 62, 14);
		panel.add(lblPassword);
		
		JLabel lblMajor = new JLabel("Major:");
		lblMajor.setBounds(28, 168, 62, 14);
		panel.add(lblMajor);
		
		JLabel lblMobile = new JLabel("Mobile:");
		lblMobile.setBounds(28, 209, 62, 14);
		panel.add(lblMobile);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setText(student.getStudentId());
		lblId_1.setBounds(93, 60, 169, 14);
		panel.add(lblId_1);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setText(student.getName());
		lblName_1.setBounds(93, 96, 169, 14);
		panel.add(lblName_1);
		
		JLabel lblMajor_1 = new JLabel("Major");
		lblMajor_1.setBounds(93, 168, 169, 14);
		lblMajor_1.setText(student.getMajor());
		panel.add(lblMajor_1);
		
		JLabel lblMobile_1 = new JLabel("Mobile");
		lblMobile_1.setBounds(93, 209, 169, 14);
		lblMobile_1.setText(student.getMobile());
		panel.add(lblMobile_1);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, student.getPassword());
			}
		});
		btnShow.setBounds(93, 125, 89, 23);
		panel.add(btnShow);
		
		JButton btnEditDetails = new JButton("Edit Details");
		btnEditDetails.setBounds(151, 320, 89, 23);
		panel.add(btnEditDetails);
		
		
		
	}
}
