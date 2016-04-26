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

import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
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
				
			Object[][] RegData = new Object[courseRegistrationData.size()][7];
			for (int i = 0; i < courseRegistrationData.size(); i++) {
			    CourseRegistrationData row = courseRegistrationData.get(i);
			    RegData[i][0] = row.getCourseId();
			    RegData[i][1] = row.getCourseName();
			    RegData[i][2] = row.getFacultyName();
			    RegData[i][3] = row.getCourseCredit();
			    RegData[i][4] = row.getClassRoom();
			    RegData[i][5] = row.getCourseTimetable();
			    RegData[i][6] = false;
			    
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
			
			
			
	        Object[] columnNames = {"Course ID", "Course Name", "Faculty", "Credit", "Class Room", "TimeTable", "Enroll"};
	        Object[][] data = {
	            {"CSE101", "C++", "Morshed Hasan", new Double(80.50),"Test","Test", false},
	            {"CSE201", "Java", "Tom Podi", new Double(80.50), "Class Room", "TimeTable",false},
	            {"CSE205", "Data Structure","Morshed Hasan", new Double(6.25),"Class Room", "TimeTable", true},
	            {"CSE308", "Apple", "Shah Alam", new Double(7.35),"Class Room", "TimeTable", true},
	            {"CSE300", "IBM", "", new Double(80.50),"Class Room", "TimeTable", false},
	            {"CSE405", "MicroSoft", "", new Double(6.25), "Class Room", "TimeTable",true},
	            {"CSE308", "Apple", "Morshed Hasan", new Double(7.35), "Class Room", "TimeTable",true},
	            {"CSE407", "IBM", "", new Double(80.50),"Class Room", "TimeTable", false},
	            {"CSE450", "MicroSoft", "Shah Alam", new Double(6.25), "Class Room", "TimeTable",true},
	            {"CSE300", "IBM", "", new Double(80.50), "Class Room", "TimeTable",false},
	            {"CSE405", "MicroSoft", "", new Double(6.25), "Class Room", "TimeTable",true},
	            {"CSE308", "Apple", "Morshed Hasan", new Double(7.35), "Class Room", "TimeTable",true},
	            {"CSE101", "C++", "Morshed Hasan", new Double(80.50),"Class Room", "TimeTable", false},
	            {"CSE201", "Java", "Tom Podi", new Double(80.50), "Class Room", "TimeTable",false},
	            {"CSE205", "Data Structure","Morshed Hasan", new Double(6.25), "Class Room", "TimeTable",true},
	            {"CSE308", "Apple", "Shah Alam", new Double(7.35), "Class Room", "TimeTable",true},
	            {"CSE300", "IBM", "", new Double(80.50), "Class Room", "TimeTable",false},
	            {"CSE405", "MicroSoft", "", new Double(6.25), "Class Room", "TimeTable",true},
	            {"CSE308", "Apple", "Morshed Hasan", new Double(7.35),"Class Room", "TimeTable", true},
	            {"CSE407", "IBM", "", new Double(80.50), "Class Room", "TimeTable",false},
	            {"CSE450", "MicroSoft", "Shah Alam", new Double(6.25), "Class Room", "TimeTable",true},
	            {"CSE300", "IBM", "", new Double(80.50),"Class Room", "TimeTable", false},
	            {"CSE405", "MicroSoft", "", new Double(6.25),"Class Room", "TimeTable", true},
	            {"CSE308", "Apple", "Morshed Hasan", new Double(7.35),"Class Room", "TimeTable", true},
	            {"CSE101", "C++", "Morshed Hasan", new Double(80.50),"Class Room", "TimeTable", false},
	            {"CSE201", "Java", "Tom Podi", new Double(80.50),"Class Room", "TimeTable", false},
	            {"CSE205", "Data Structure","Morshed Hasan", new Double(6.25),"Class Room", "TimeTable", true},
	            {"CSE308", "Apple", "Shah Alam", new Double(7.35),"Class Room", "TimeTable", true},
	            {"CSE300", "IBM", "", new Double(80.50),"Class Room", "TimeTable", false},
	            {"CSE405", "MicroSoft", "", new Double(6.25),"Class Room", "TimeTable", true},
	            {"CSE308", "Apple", "Morshed Hasan", new Double(7.35),"Class Room", "TimeTable", true},
	            {"CSE407", "IBM", "", new Double(80.50),"Class Room", "TimeTable", false},
	            {"CSE450", "MicroSoft", "Shah Alam", new Double(6.25), "Class Room", "TimeTable",true},
	            {"CSE300", "IBM", "", new Double(80.50),"Class Room", "TimeTable", false},
	            {"CSE405", "MicroSoft", "", new Double(6.25),"Class Room", "TimeTable", true},
	            {"CSE308", "Apple", "Morshed Hasan", new Double(7.35), "Class Room", "TimeTable",true},
	            {"CSE101", "C++", "Morshed Hasan", new Double(80.50),"Class Room", "TimeTable", false},
	            {"CSE201", "Java", "Tom Podi", new Double(80.50),"Class Room", "TimeTable", false},
	            {"CSE205", "Data Structure","Morshed Hasan", new Double(6.25),"Class Room", "TimeTable", true},
	            {"CSE308", "Apple", "Shah Alam", new Double(7.35),"Class Room", "TimeTable", true},
	            {"CSE300", "IBM", "", new Double(80.50),"Class Room", "TimeTable", false},
	            {"CSE405", "MicroSoft", "", new Double(6.25),"Class Room", "TimeTable", true},
	            {"CSE308", "Apple", "Morshed Hasan", new Double(7.35),"Class Room", "TimeTable", true},
	            {"CSE407", "IBM", "", new Double(80.50),"Class Room", "TimeTable", false},
	            {"CSE450", "MicroSoft", "Shah Alam", new Double(6.25),"Class Room", "TimeTable", true},
	            {"CSE300", "IBM", "", new Double(80.50),"Class Room", "TimeTable", false},
	            {"CSE405", "MicroSoft", "", new Double(6.25),"Class Room", "TimeTable", true},
	            {"CSE308", "Apple", "Morshed Hasan", new Double(7.35),"Class Room", "TimeTable", true},
	            {"CSE407", "IBM", "", new Double(80.50),"Class Room", "TimeTable", false},
	            {"CSE450", "MicroSoft", "Shah Alam", new Double(6.25),"Class Room", "TimeTable", true},
	            {"CSE433", "Apple", "Nitesh Ahmed", new Double(7.35),"Class Room", "TimeTable", true}      };
	        
	        for (Object[] rowData: data){
                for(Object cellData: rowData)
                {
                	System.out.println("the indiviual data is" +cellData);
                }
            }
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
	                        return String.class;
	                    case 1:
	                        return String.class;
	                    case 2:
	                        return String.class;
	                    case 3:
	                        return Double.class;
	                    case 4:
	                        return String.class;
	                    case 5:
	                        return String.class;
	                    default:
	                        return Boolean.class;
	                }
	            }
	        };
	        table.setPreferredScrollableViewportSize(table.getPreferredSize());
	        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(31, 29, 796, 606);
	        getContentPane().add(scrollPane);
	        
	        JButton btnCompleteRegistration = new JButton("Complete Registration");
	        btnCompleteRegistration.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		for (int i = 0; i < table.getRowCount(); i++) {
						Boolean checked = Boolean.valueOf(table.getValueAt(i, 6).toString());
						String col = table.getValueAt(i, 0).toString();
						
						if (checked) {
							JOptionPane.showMessageDialog(null, col);
						}
					}
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
