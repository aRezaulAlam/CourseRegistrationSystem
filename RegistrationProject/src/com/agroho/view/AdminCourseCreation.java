package com.agroho.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.agroho.controller.CourseController;
import com.agroho.controller.FacultyController;
import com.agroho.dao.CourseDao;
import com.agroho.model.Course;
import com.agroho.model.Faculty;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminCourseCreation extends JFrame {

	private JPanel contentPane;
	private JTextField claasRoomTextField;
	private JTextField timetableTextField;
	List<String> facultyList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCourseCreation frame = new AdminCourseCreation();
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
	public AdminCourseCreation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddCourseRegistration = new JLabel("Add Course  Registration");
		lblAddCourseRegistration.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddCourseRegistration.setBounds(318, 11, 274, 36);
		contentPane.add(lblAddCourseRegistration);
		
		JLabel lblSelectCourse = new JLabel("Select Course:");
		lblSelectCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectCourse.setBounds(124, 83, 112, 36);
		contentPane.add(lblSelectCourse);
		
		JLabel lblFaculty = new JLabel("Faculty:");
		lblFaculty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFaculty.setBounds(124, 147, 112, 36);
		contentPane.add(lblFaculty);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription.setBounds(124, 215, 112, 36);
		contentPane.add(lblDescription);
		
		JLabel lblClassRoom = new JLabel("Class Room:");
		lblClassRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClassRoom.setBounds(124, 305, 112, 36);
		contentPane.add(lblClassRoom);
		
		JLabel lblTimeTable = new JLabel("Time Table:");
		lblTimeTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTimeTable.setBounds(124, 386, 112, 36);
		contentPane.add(lblTimeTable);
		
		claasRoomTextField = new JTextField();
		claasRoomTextField.setBounds(253, 315, 295, 29);
		contentPane.add(claasRoomTextField);
		claasRoomTextField.setColumns(10);
		
		timetableTextField = new JTextField();
		timetableTextField.setColumns(10);
		timetableTextField.setBounds(253, 393, 295, 29);
		contentPane.add(timetableTextField);
		
		JTextArea descriptionTextArea = new JTextArea();
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setBounds(253, 223, 295, 55);
		contentPane.add(descriptionTextArea);
		
		JComboBox facultyComboBox = new JComboBox();
		facultyComboBox.setBounds(253, 149, 295, 26);
		contentPane.add(facultyComboBox);
		
		CourseController courseController = new CourseController();
		ArrayList<Course> courseList = (ArrayList<Course>) courseController.getCourseDetails();
		ArrayList<String> courses = new ArrayList<String>();
		//ArrayList<String> courseCodes = new ArrayList<String>();
		JComboBox courseComboBox = new JComboBox();
		
		
		courseComboBox.setBounds(253, 85, 295, 26);
		for (int i = 0; i < courseList.size(); i++) {
			//courses.add(courseList.get(i).getCourseName() +"-"+courseList.get(i).getCourseId());
			courseComboBox.addItem(courseList.get(i).getCourseName() +"-"+courseList.get(i).getCourseId());
		}
		
		courseComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facultyComboBox.removeAllItems();
				String courseCode = null;
				String selectedValue = courseComboBox.getSelectedItem().toString();
				StringTokenizer st2 = new StringTokenizer(selectedValue, "-");
				while (st2.hasMoreElements()) {
					System.out.println(st2.nextElement());
					courseCode = (String) st2.nextElement();
					System.out.println("Sending code:"+courseCode);
				}
				facultyList = FacultyController.getFacultyByCourseId(courseCode);
				
				for (int i = 0; i < facultyList.size(); i++) {
					facultyComboBox.addItem(facultyList.get(i));
					System.out.println(facultyList.get(i));
				}
				
			}
		});
		
		contentPane.add(courseComboBox);
		
		
		
		JButton btnNewButton = new JButton("Add Course For Registration");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String course =	(String) courseComboBox.getSelectedItem();
			String faculty = (String) facultyComboBox.getSelectedItem();
			String description = descriptionTextArea.getText();
			String timetable = timetableTextField.getText();
			String classroom = claasRoomTextField.getText();
			String admin = "Central";
			
			CourseController.registerCourse(course,faculty,description,timetable,classroom,admin);
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(295, 470, 216, 36);
		contentPane.add(btnNewButton);
	}
}
