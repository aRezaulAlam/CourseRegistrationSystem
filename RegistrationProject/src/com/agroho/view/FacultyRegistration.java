package com.agroho.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.agroho.controller.CourseController;
import com.agroho.controller.FacultyController;
import com.agroho.model.Course;
import com.agroho.model.Faculty;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

public class FacultyRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField facultyNameField;
	private JTextField facultyIdField;
	private JPasswordField facultyPasswordField;
	private JTable table;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultyRegistration frame = new FacultyRegistration();
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
	public FacultyRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFacultyRegistration = new JLabel("Faculty Registration");
		lblFacultyRegistration.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFacultyRegistration.setBounds(217, 11, 175, 32);
		contentPane.add(lblFacultyRegistration);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(103, 78, 92, 32);
		contentPane.add(lblName);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(103, 131, 92, 32);
		contentPane.add(lblId);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(103, 188, 92, 32);
		contentPane.add(lblPassword);
		
		JLabel lblSkill = new JLabel("Skills: ");
		lblSkill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSkill.setBounds(103, 251, 92, 32);
		contentPane.add(lblSkill);
		
		facultyNameField = new JTextField();
		facultyNameField.setBounds(217, 86, 229, 24);
		contentPane.add(facultyNameField);
		facultyNameField.setColumns(10);
		
		facultyIdField = new JTextField();
		facultyIdField.setColumns(10);
		facultyIdField.setBounds(217, 139, 229, 24);
		contentPane.add(facultyIdField);
		
		facultyPasswordField = new JPasswordField();
		facultyPasswordField.setBounds(217, 196, 229, 24);
		contentPane.add(facultyPasswordField);
		CourseController courseController = new CourseController();
		ArrayList<Course> courseList = (ArrayList<Course>) courseController.getCourseDetails();
		ArrayList<String> courses = new ArrayList<String>();
		//ArrayList<String> courseCodes = new ArrayList<String>();
		
		for (int i = 0; i < courseList.size(); i++) {
			courses.add(courseList.get(i).getCourseName() +"-"+courseList.get(i).getCourseId());
		}
		list = new JList(courses.toArray());
		list.setBounds(217, 255, 190, 50);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		list.setSelectionModel(new DefaultListSelectionModel() {
		    @Override
		    public void setSelectionInterval(int index0, int index1) {
		        if(super.isSelectedIndex(index0)) {
		            super.removeSelectionInterval(index0, index1);
		        }
		        else {
		            super.addSelectionInterval(index0, index1);
		        }
		    }
		});

		javax.swing.JScrollPane list_scroll = new javax.swing.JScrollPane(list);
		list_scroll.setBounds(217, 255, 235, 160);
		contentPane.add(list_scroll);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String facultName = facultyNameField.getText();
				String facultyId = facultyIdField.getText();
				String facultyPassword = facultyPasswordField.getText();
				List<String> skilledCourseList = new ArrayList<String>();
				List<String> skilledCourseCodeList = new ArrayList<String>();
				
				skilledCourseList = list.getSelectedValuesList();
	
				
				for (int i = 0; i < skilledCourseList.size(); i++) {
					//System.out.println(skilledCourseList.get(i));
					StringTokenizer st2 = new StringTokenizer(skilledCourseList.get(i), "-");
					while (st2.hasMoreElements()) {
						System.out.println(st2.nextElement());
						skilledCourseCodeList.add((String) st2.nextElement());
					}
				}
				
				Faculty faculty = new Faculty(facultyId,facultyPassword,facultName, skilledCourseCodeList);
				
				FacultyController facultyRegistrationController = new FacultyController(faculty);
				try {
					facultyRegistrationController.register();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		registerButton.setBounds(254, 453, 100, 23);
		contentPane.add(registerButton);
		
		
		
		
		
		
	}
}
