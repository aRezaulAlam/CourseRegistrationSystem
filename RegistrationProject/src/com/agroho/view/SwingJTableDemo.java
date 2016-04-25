package com.agroho.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * The Class SwingJTableDemo to show our running example.
 *
 * @author ashraf_sarhan
 */
public class SwingJTableDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					// Set Nimbus as L&F
					setLookAndFeel(Constants.NIMBUS_LF);
					createAndShowGUI(args);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void createAndShowGUI(String[] args) throws Exception {
		// Figure out what directory to display
		File dir;
		if (args.length > 0)
			dir = new File(args[0]);
		else
			dir = new File(System.getProperty("user.home"));

		// Create a TableModel object to represent the contents of the directory
		CustomTableModel tableModel = new CustomTableModel(dir);

		// Create a JTable and tell it to display our model
		JTable table = new JTable(tableModel);

		// Put the JTable in a JScrollPane to handle scrolling
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension(873, 709));

		JTextField dirPathTextField = new JTextField(26);

		// Create an action listener to display the given directory
		JButton displayDirButton = new JButton("Display Directory");
		displayDirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dirPath = dirPathTextField.getText();
				if (dirPath != null && !"".equals(dirPath)) {
					File newDir = new File(dirPath);
					;
					CustomTableModel newTableModel = new CustomTableModel(
							newDir);
					table.setModel(newTableModel);
				} else {
					JOptionPane.showMessageDialog(null,
							"Directory path is empty", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JPanel ctrlPane = new JPanel();
		ctrlPane.add(dirPathTextField);
		ctrlPane.add(displayDirButton);

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				ctrlPane, tableScrollPane);
		splitPane.setDividerLocation(35);
		splitPane.setEnabled(false);

		// Display it all in a scrolling window and make the window appear
		JFrame frame = new JFrame("Swing JTable Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(splitPane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
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
