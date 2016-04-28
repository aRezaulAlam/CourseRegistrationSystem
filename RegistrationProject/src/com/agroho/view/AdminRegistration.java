package com.agroho.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.agroho.controller.AdminController;
import com.agroho.controller.FacultyController;
import com.agroho.model.Admin;
import com.agroho.model.Faculty;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AdminRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField adminIdField;
	private JTextField adminNameField;
	private JPasswordField adminPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setLookAndFeel(Constants.NIMBUS_LF);
					AdminRegistration frame = new AdminRegistration();
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
	public AdminRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		adminIdField = new JTextField();
		adminIdField.setBounds(369, 177, 184, 29);
		contentPane.add(adminIdField);
		adminIdField.setColumns(10);
		
		adminNameField = new JTextField();
		adminNameField.setColumns(10);
		adminNameField.setBounds(369, 317, 184, 29);
		contentPane.add(adminNameField);
		
		JComboBox adminRoleComboBox = new JComboBox();
		adminRoleComboBox.setBounds(369, 396, 184, 29);
		adminRoleComboBox.addItem("Central");
		adminRoleComboBox.addItem("Assistant");
		adminRoleComboBox.addItem("Support");
		contentPane.add(adminRoleComboBox);
		
		adminPasswordField = new JPasswordField();
		adminPasswordField.setBounds(369, 249, 184, 29);
		contentPane.add(adminPasswordField);
		
		JLabel lblAdminRegistration = new JLabel("Admin Registration");
		lblAdminRegistration.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdminRegistration.setBounds(351, 60, 202, 60);
		contentPane.add(lblAdminRegistration);
		
		JLabel lblAdminId = new JLabel("Admin ID: ");
		lblAdminId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdminId.setBounds(230, 171, 101, 29);
		contentPane.add(lblAdminId);
		
		JLabel lblAdminPassword = new JLabel("Admin Password: ");
		lblAdminPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdminPassword.setBounds(230, 243, 109, 29);
		contentPane.add(lblAdminPassword);
		
		JLabel lblAdminName = new JLabel("Admin Name: ");
		lblAdminName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdminName.setBounds(230, 308, 109, 34);
		contentPane.add(lblAdminName);
		
		JLabel lblAdminRole = new JLabel("Admin Role: ");
		lblAdminRole.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdminRole.setBounds(235, 383, 96, 42);
		contentPane.add(lblAdminRole);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String adminName = adminNameField.getText();
				String adminId = adminIdField.getText();
				String adminPassword = adminPasswordField.getText();
				String adminRole = adminRoleComboBox.getSelectedItem().toString();
				System.out.println(adminName+adminId+adminPassword+adminRole);
				
				Admin admin = new Admin(adminName,adminId, adminPassword,adminRole);
				
				AdminController Controller = new AdminController(admin);
				try {
					Controller.register();
				} catch (ClassNotFoundException | SQLException w) {
					// TODO Auto-generated catch block
					w.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(351, 497, 123, 34);
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
