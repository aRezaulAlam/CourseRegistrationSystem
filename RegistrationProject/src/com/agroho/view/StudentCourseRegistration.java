package com.agroho.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.agroho.controller.CourseController;
import com.agroho.model.CourseRegistrationData;
import com.agroho.model.StudentRegistrationCourses;

import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class StudentCourseRegistration extends JFrame {

	 private static final long serialVersionUID = 1L;
	    private JTable table;

	    public StudentCourseRegistration() {
			setBounds(100, 100, 873, 726);
			
			CourseController controller = new CourseController();
			List<CourseRegistrationData> courseRegistrationData =  controller.getDataForStudentRegistration();
			
			for (int i = 0; i < courseRegistrationData.size(); i++) {
				System.out.println("View: "+courseRegistrationData.get(i).getFacultyName());
			}
			
			//Object[][] RegData;
				
			Object[][] RegData = new Object[courseRegistrationData.size()][8];
			for (int i = 0; i < courseRegistrationData.size(); i++) {
			    CourseRegistrationData row = courseRegistrationData.get(i);
			    RegData[i][0] = row.getId();
			    RegData[i][1] = row.getCourseId();
			    RegData[i][2] = row.getCourseName();
			    RegData[i][3] = row.getFacultyName();
			    RegData[i][4] = row.getCourseCredit();
			    RegData[i][5] = row.getClassRoom();
			    RegData[i][6] = row.getCourseTimetable();
			    RegData[i][7] = false;
			    
			    System.out.println(RegData[i][0]+" "+RegData[i][1]+" "+RegData[i][2]+" "+RegData[i][3]+" "+RegData[i][4]+" "+RegData[i][5]+ " "+RegData[i][6]);
			}
			
			
			/*
			Object[][] RegData = (Object[][]) courseRegistrationData.toArray();
			
			for (Object[] rowData: RegData){
                for(Object cellData: rowData)
                {
                	System.out.println("the indiviual data is" +cellData);
                }
            }*/
			
			
			
	        Object[] columnNames = {"ID","Course ID", "Course Name", "Faculty", "Credit", "Class Room", "TimeTable", "Enroll"};
	   
	        
	
	        DefaultTableModel model = new DefaultTableModel(RegData, columnNames);
	        getContentPane().setLayout(null);
	        table = new JTable(model) {

	            private static final long serialVersionUID = 1L;

	            /*@Override
	            public Class getColumnClass(int column) {
	            return getValueAt(0, column).getClass();
	            }*/
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
	                    case 4:
	                        return Double.class;
	                    case 5:
	                        return String.class;
	                    case 6:
	                        return String.class;
	                    default:
	                        return Boolean.class;
	                }
	            }
	        };
	        table.setPreferredScrollableViewportSize(table.getPreferredSize());
	        table.getColumnModel().getColumn(0).setWidth(0);
	        table.getColumnModel().getColumn(0).setMinWidth(0);
	        table.getColumnModel().getColumn(0).setMaxWidth(0); 
	        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(31, 29, 796, 606);
	        getContentPane().add(scrollPane);
	        
	        JButton btnCompleteRegistration = new JButton("Complete Registration");
	        btnCompleteRegistration.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		List<StudentRegistrationCourses> studentCourseRegistrations = new ArrayList<StudentRegistrationCourses>();
	        		for (int i = 0; i < table.getRowCount(); i++) {
	        			
	        			StudentRegistrationCourses studentRegistrationCourses = new StudentRegistrationCourses();
						Boolean checked = Boolean.valueOf(table.getValueAt(i, 7).toString());
						String col = table.getValueAt(i, 0).toString();
						
						studentRegistrationCourses.setRegistered_course_id(Integer.parseInt(table.getValueAt(i, 0).toString()));
						studentRegistrationCourses.setStudentId("12201051");
						studentRegistrationCourses.setPermitter(Boolean.valueOf(table.getValueAt(i, 7).toString()));
						
						if (studentRegistrationCourses.getPermitter()) {
							JOptionPane.showMessageDialog(null, col);
							studentCourseRegistrations.add(studentRegistrationCourses);
						}
					}
	        		
	        		controller.saveStudentCourseRegistration(studentCourseRegistrations);
	        		
	        	}
	        });
	        btnCompleteRegistration.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        btnCompleteRegistration.setBounds(636, 646, 191, 30);
	        getContentPane().add(btnCompleteRegistration);
	    }

	    private void getDataForStudentRegistration() {
			// TODO Auto-generated method stub
			
		}

		public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {

	            @Override
	            public void run() {
					try {
						setLookAndFeel(Constants.NIMBUS_LF);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	StudentCourseRegistration frame = new StudentCourseRegistration();
	                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	                //frame.pack();
	                frame.setLocation(150, 150);
	                frame.setVisible(true);
	            }
	        });
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
