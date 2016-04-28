package com.agroho.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.agroho.controller.CourseController;
import com.agroho.controller.FacultyController;
import com.agroho.controller.StudentController;
import com.agroho.model.Faculty;
import com.agroho.model.Student;
import com.agroho.model.StudentEnrollment;

public class FacultyHome extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Faculty faculty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultyHome frame = new FacultyHome("");
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
	public FacultyHome(String facultyId) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		FacultyController controller = new FacultyController();
		faculty = controller.getFacultyDetailsById(facultyId);
		
		JLabel lblStudentPanel = new JLabel("Faculty Panel");
		lblStudentPanel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblStudentPanel.setBounds(32, 12, 259, 23);
		contentPane.add(lblStudentPanel);
		
		JLabel lblWelcome = new JLabel("Welcome! ");
		lblWelcome.setBounds(431, 16, 76, 14);
		contentPane.add(lblWelcome);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		setVisible(false);
				new Main().setVisible(true);;
			}
		});
		btnSignOut.setBounds(758, 12, 89, 23);
		contentPane.add(btnSignOut);
		
		JLabel lblStudentName = new JLabel("Hello");
		lblStudentName.setText(faculty.getName());
		lblStudentName.setBounds(517, 16, 117, 14);
		contentPane.add(lblStudentName);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 57, 262, 204);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblStudentDetails = new JLabel("Faculty Details");
		lblStudentDetails.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStudentDetails.setBounds(83, 11, 99, 14);
		panel.add(lblStudentDetails);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setBounds(28, 60, 46, 14);
		panel.add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(28, 99, 46, 14);
		panel.add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(28, 143, 62, 14);
		panel.add(lblPassword);
		
				
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setText(faculty.getFacultyId());
		lblId_1.setBounds(103, 60, 159, 14);
		panel.add(lblId_1);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setText(faculty.getName());
		lblName_1.setBounds(103, 99, 159, 14);
		panel.add(lblName_1);
		
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, faculty.getFacultyPassword());
			}
		});
		btnShow.setBounds(104, 139, 99, 23);
		panel.add(btnShow);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(301, 57, 546, 559);
		contentPane.add(panel_1);
		
		JLabel lblRegisteredCourse = new JLabel("Student List for Enrollment");
		lblRegisteredCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegisteredCourse.setBounds(231, 11, 160, 14);
		panel_1.add(lblRegisteredCourse);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(93, 96, 169, 14);
		panel_1.add(label_7);
		
		CourseController courseController = new CourseController();
		List<StudentEnrollment> enrollments = courseController.getStudentListForEnrollmentByFacultyId(facultyId);
		

		
		
		for (int i = 0; i < enrollments.size(); i++) {
				System.out.println("View: "+enrollments.get(i).getFacultyName());
			}
			
			//Object[][] RegData;
				
			Object[][] RegData = new Object[enrollments.size()][5];
			for (int i = 0; i < enrollments.size(); i++) {
			    StudentEnrollment row = enrollments.get(i);
			    RegData[i][0] = row.getRegistered_course_id();
			    RegData[i][1] = row.getCourseId();
			    RegData[i][2] = row.getStudentName();
			    RegData[i][3] = row.getStudentId();
			    RegData[i][4] = row.getPermitter();
			    
			    //System.out.println(RegData[i][0]+" "+RegData[i][1]+" "+RegData[i][2]+" "+RegData[i][3]+" "+RegData[i][4]+" "+RegData[i][5]+ " "+RegData[i][6]);
			}
			
		
	
		
			 Object[][] data = {
			            {"CSE203", "Pankaj Sharma", "D300", "9-5 Sunday",4, "PENDING"},
			            {"CSE503", "Shah Alam", "D400", "9-5 Sunday", 3,"ACCEPTED"},
			            {"CSE300", "Jamilur Reza Chowdhury", "D300", "9-5 Sunday", 2.5,"ACCEPTED"},
			            {"CSE100", "Jahir Rafiq", "D300", "9-5 Sunday", 3,"REJECTED"}
			        };
			
	        Object[] columnNames = {"Enrollment ID","Course ID","Student Name", "Student ID", "Action"};
	   
	        
	
	        DefaultTableModel model = new DefaultTableModel(RegData, columnNames);
	        getContentPane().setLayout(null);
	        table = new JTable(model) {

	            private static final long serialVersionUID = 1L;

	       
	            @Override
	            public Class getColumnClass(int column) {
	                switch (column) {
	                	case 0:
                        	return Integer.class;
	                	case 1:
                        	return String.class;
	                    case 2:
	                        return String.class;
	                    case 3:
	                        return String.class;
	                   default:
	                        return Boolean.class;
	                   
	                }
	            }
	        };
	        table.setPreferredScrollableViewportSize(table.getPreferredSize());
	      //  table.getColumnModel().getColumn(0).setWidth(0);
	      //  table.getColumnModel().getColumn(0).setMinWidth(0);
	      //  table.getColumnModel().getColumn(0).setMaxWidth(0); 
	        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(10, 36, 526, 515);
	        panel_1.add(scrollPane);
	
		JButton btnEditDetails = new JButton("Edit Details");
		btnEditDetails.setBounds(648, 12, 100, 23);
		contentPane.add(btnEditDetails);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 277, 262, 382);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNotices = new JLabel("Notices");
		lblNotices.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNotices.setBounds(103, 11, 58, 14);
		panel_2.add(lblNotices);
		
		JTextPane txtpnNoNotices = new JTextPane();
		txtpnNoNotices.setText("No Notices");
		txtpnNoNotices.setBounds(10, 36, 242, 335);
		panel_2.add(txtpnNoNotices);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<StudentEnrollment> studentCourseRegistrations = new ArrayList<StudentEnrollment>();
        		for (int i = 0; i < table.getRowCount(); i++) {
        			
        			StudentEnrollment studentRegistrationCourses = new StudentEnrollment();
					Boolean checked = Boolean.valueOf(table.getValueAt(i, 4).toString());
					String col = table.getValueAt(i, 0).toString();
					
					studentRegistrationCourses.setRegistered_course_id(Integer.parseInt(table.getValueAt(i, 0).toString()));
					studentRegistrationCourses.setStudentId(table.getValueAt(i, 3).toString());
					studentRegistrationCourses.setPermitter(Boolean.valueOf(table.getValueAt(i, 7).toString()));
					
					if (studentRegistrationCourses.getPermitter()) {
						
						studentCourseRegistrations.add(studentRegistrationCourses);
					}
				}
        		
        		controller.updateStudentEnrollmentbyFaculty(studentCourseRegistrations);
        		JOptionPane.showMessageDialog(null, "Successful");
        		
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(741, 627, 106, 32);
		contentPane.add(btnNewButton);
		
		
	}

}
