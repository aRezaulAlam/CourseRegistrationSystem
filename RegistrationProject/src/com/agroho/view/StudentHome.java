package com.agroho.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.agroho.controller.CourseController;
import com.agroho.controller.StudentController;
import com.agroho.model.CourseRegistrationData;
import com.agroho.model.Student;
import com.agroho.model.StudentEnrollment;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextPane;

public class StudentHome extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		setBounds(100, 100, 873, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		StudentController controller = new StudentController();
		Student student = controller.getStudentDetailsById(userId);
		
		JLabel lblStudentPanel = new JLabel("Student Panel");
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
		lblStudentName.setText(userId);
		lblStudentName.setBounds(517, 16, 117, 14);
		contentPane.add(lblStudentName);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 57, 262, 204);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblStudentDetails = new JLabel("Student Details");
		lblStudentDetails.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStudentDetails.setBounds(83, 11, 99, 14);
		panel.add(lblStudentDetails);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setBounds(28, 60, 46, 14);
		panel.add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(28, 85, 46, 14);
		panel.add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(28, 114, 62, 14);
		panel.add(lblPassword);
		
		JLabel lblMajor = new JLabel("Major:");
		lblMajor.setBounds(28, 144, 62, 14);
		panel.add(lblMajor);
		
		JLabel lblMobile = new JLabel("Mobile:");
		lblMobile.setBounds(28, 169, 62, 14);
		panel.add(lblMobile);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setText(student.getStudentId());
		lblId_1.setBounds(103, 60, 159, 14);
		panel.add(lblId_1);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setText(student.getName());
		lblName_1.setBounds(103, 85, 159, 14);
		panel.add(lblName_1);
		
		JLabel lblMajor_1 = new JLabel("Major");
		lblMajor_1.setBounds(103, 144, 159, 14);
		lblMajor_1.setText(student.getMajor());
		panel.add(lblMajor_1);
		
		JLabel lblMobile_1 = new JLabel("Mobile");
		lblMobile_1.setBounds(103, 169, 159, 14);
		lblMobile_1.setText(student.getMobile());
		panel.add(lblMobile_1);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, student.getPassword());
			}
		});
		btnShow.setBounds(103, 110, 99, 23);
		panel.add(btnShow);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(301, 91, 546, 568);
		contentPane.add(panel_1);
		
		JLabel lblRegisteredCourse = new JLabel("Registered Courses");
		lblRegisteredCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegisteredCourse.setBounds(231, 11, 121, 14);
		panel_1.add(lblRegisteredCourse);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(93, 96, 169, 14);
		panel_1.add(label_7);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(93, 209, 169, 14);
		panel_1.add(label_9);
		
		CourseController courseController = new CourseController();
		List<StudentEnrollment> coursesEnrolled = courseController.getStudentEnrollInfoById(userId);
		
		
		for (int i = 0; i < coursesEnrolled.size(); i++) {
				System.out.println("View: "+coursesEnrolled.get(i).getFacultyName());
			}
			
			//Object[][] RegData;
				
			Object[][] RegData = new Object[coursesEnrolled.size()][8];
			for (int i = 0; i < coursesEnrolled.size(); i++) {
			    StudentEnrollment row = coursesEnrolled.get(i);
			    RegData[i][0] = row.getCourseId();
			    RegData[i][1] = row.getFacultyName();
			    RegData[i][2] = row.getRoom();
			    RegData[i][3] = row.getTime();
			    RegData[i][4] = row.getCourseCredit();
			    RegData[i][5] = row.getAcceptedStatus();
			    
			    //System.out.println(RegData[i][0]+" "+RegData[i][1]+" "+RegData[i][2]+" "+RegData[i][3]+" "+RegData[i][4]+" "+RegData[i][5]+ " "+RegData[i][6]);
			}
			
		
	
		
			 Object[][] data = {
			            {"CSE203", "Pankaj Sharma", "D300", "9-5 Sunday",4, "PENDING"},
			            {"CSE503", "Shah Alam", "D400", "9-5 Sunday", 3,"ACCEPTED"},
			            {"CSE300", "Jamilur Reza Chowdhury", "D300", "9-5 Sunday", 2.5,"ACCEPTED"},
			            {"CSE100", "Jahir Rafiq", "D300", "9-5 Sunday", 3,"REJECTED"}
			        };
			
	        Object[] columnNames = {"Course ID","Faculty", "Room", "Time", "Credit", "Status"};
	   
	        
	
	        DefaultTableModel model = new DefaultTableModel(RegData, columnNames);
	        getContentPane().setLayout(null);
	        table = new JTable(model) {

	            private static final long serialVersionUID = 1L;

	       
	            @Override
	            public Class getColumnClass(int column) {
	                switch (column) {
	                	case 0:
                        	return String.class;
	                    case 1:
	                        return String.class;
	                    case 2:
	                        return String.class;
	                    case 3:
	                        return String.class;
	                    case 4:
	                        return Double.class;
	                    default:
	                        return String.class;
	                }
	            }
	        };
	        table.setPreferredScrollableViewportSize(table.getPreferredSize());
	      //  table.getColumnModel().getColumn(0).setWidth(0);
	      //  table.getColumnModel().getColumn(0).setMinWidth(0);
	      //  table.getColumnModel().getColumn(0).setMaxWidth(0); 
	        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(10, 36, 526, 521);
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
		
		JButton btnEnrollCourse = new JButton("Enroll Course");
		btnEnrollCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new StudentHome(userId).setVisible(true);
				setVisible(false);
				new StudentCourseRegistration(userId).setVisible(true);
			}
		});
		btnEnrollCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEnrollCourse.setBounds(301, 57, 107, 23);
		contentPane.add(btnEnrollCourse);
		
		
		
	}
}
