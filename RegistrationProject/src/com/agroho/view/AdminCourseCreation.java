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
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
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
					setLookAndFeel(Constants.NIMBUS_LF);
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
		setBounds(100, 100, 873, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddCourseRegistration = new JLabel("Add Course  Registration");
		lblAddCourseRegistration.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddCourseRegistration.setBounds(332, 26, 274, 36);
		contentPane.add(lblAddCourseRegistration);
		
		JLabel lblSelectCourse = new JLabel("Select Course:");
		lblSelectCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectCourse.setBounds(199, 97, 112, 36);
		contentPane.add(lblSelectCourse);
		
		JLabel lblFaculty = new JLabel("Faculty:");
		lblFaculty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFaculty.setBounds(199, 161, 112, 36);
		contentPane.add(lblFaculty);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription.setBounds(199, 229, 112, 36);
		contentPane.add(lblDescription);
		
		JLabel lblClassRoom = new JLabel("Class Room:");
		lblClassRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClassRoom.setBounds(199, 319, 112, 36);
		contentPane.add(lblClassRoom);
		
		JLabel lblTimeTable = new JLabel("Time Table:");
		lblTimeTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTimeTable.setBounds(199, 400, 112, 36);
		contentPane.add(lblTimeTable);
		
		claasRoomTextField = new JTextField();
		claasRoomTextField.setBounds(328, 329, 295, 29);
		contentPane.add(claasRoomTextField);
		claasRoomTextField.setColumns(10);
		
		timetableTextField = new JTextField();
		timetableTextField.setColumns(10);
		timetableTextField.setBounds(328, 407, 295, 29);
		contentPane.add(timetableTextField);
		
		JTextArea descriptionTextArea = new JTextArea();
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setBounds(328, 237, 295, 55);
		contentPane.add(descriptionTextArea);
		
		JComboBox facultyComboBox = new JComboBox();
		facultyComboBox.setBounds(328, 163, 295, 26);
		contentPane.add(facultyComboBox);
		
		CourseController courseController = new CourseController();
		ArrayList<Course> courseList = (ArrayList<Course>) courseController.getCourseDetails();
		ArrayList<String> courses = new ArrayList<String>();
		//ArrayList<String> courseCodes = new ArrayList<String>();
		JComboBox courseComboBox = new JComboBox();
		
		
		courseComboBox.setBounds(328, 99, 295, 26);
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
		btnNewButton.setBounds(407, 486, 216, 36);
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
