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
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentCourseRegistration extends JFrame {

	 private static final long serialVersionUID = 1L;
	    private JTable table;

	    public StudentCourseRegistration() {
			setBounds(100, 100, 873, 726);

	        Object[] columnNames = {"Course ID", "Course Name", "Faculty", "Credit", "Enroll"};
	        Object[][] data = {
	            {"CSE101", "C++", "Morshed Hasan", new Double(80.50), false},
	            {"CSE201", "Java", "Tom Podi", new Double(80.50), false},
	            {"CSE205", "Data Structure","Morshed Hasan", new Double(6.25), true},
	            {"CSE308", "Apple", "Shah Alam", new Double(7.35), true},
	            {"CSE300", "IBM", "", new Double(80.50), false},
	            {"CSE405", "MicroSoft", "", new Double(6.25), true},
	            {"CSE308", "Apple", "Morshed Hasan", new Double(7.35), true},
	            {"CSE407", "IBM", "", new Double(80.50), false},
	            {"CSE450", "MicroSoft", "Shah Alam", new Double(6.25), true},
	            {"CSE433", "Apple", "Nitesh Ahmed", new Double(7.35), true}      };
	        DefaultTableModel model = new DefaultTableModel(data, columnNames);
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
						Boolean checked = Boolean.valueOf(table.getValueAt(i, 4).toString());
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
