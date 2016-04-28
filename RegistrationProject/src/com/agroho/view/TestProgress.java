package com.agroho.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ProgressMonitor;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestProgress {
	
	String userId;
	String userType;

    public static void main(String[] args) {
        new TestProgress("","");
    }

    public TestProgress(String userId, String userType) {
    	this.userId = userId;
    	this.userType = userType;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                new BackgroundWorker().execute();

            }

        });
    }

    public class BackgroundWorker extends SwingWorker<Void, Void> {

        private ProgressMonitor monitor;

        public BackgroundWorker() {
            addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
                        if (monitor == null) {
                            monitor = new ProgressMonitor(null, "Success... Getting "+userType+" Data... ID: "+userId, null, 0, 50);
                        }
                        monitor.setProgress(getProgress());
                    }
                }

            });
        }

        @Override
        protected void done() {
            if (monitor != null) {
                monitor.close();
                if (userType.equals("Student")) {
                	new StudentHome(userId).setVisible(true);
					} 
					 else if (userType.equals("Faculty")) {

					new FacultyHome(userId).setVisible(true);
						 
					} else if(userType.equals("Admin")){
						System.out.println("Admin");
					}
                
            }
        }

        @Override
        protected Void doInBackground() throws Exception {
            for (int index = 0; index < 50; index++) {
                setProgress(index);
                Thread.sleep(75);
            }
            return null;
        }
    }
}