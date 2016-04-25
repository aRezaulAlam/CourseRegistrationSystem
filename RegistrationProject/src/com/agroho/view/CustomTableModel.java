package com.agroho.view;

import java.io.File;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

/**
 * The Class CustomTableModel contains methods to allow the JTable component to
 * get and display data about the files in a specified directory. It represents
 * a table with six columns: filename, size, modification date, plus three
 * columns for flags: directory, readable, writable.
 * 
 * @author ashraf_sarhan
 */
@SuppressWarnings("serial")
public class CustomTableModel extends AbstractTableModel {

	private File dir;
	private String[] filenames;
	private String[] columnNames = TableColumn.getNames();
	private Class<?>[] columnClasses = Constants.COLUMN_CLASSES;

	// This table model works for any one given directory
	public CustomTableModel(File dir) {
		this.dir = dir;
		// Store a list of files in the directory
		this.filenames = dir.list();
	}

	// Returns a constant columns number for this model
	public int getColumnCount() {
		return Constants.COLUMN_CLASSES.length;
	}

	// Returns the number of files in directory
	public int getRowCount() {
		return filenames.length;
	}

	// Returns the name of the given column index
	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Class<?> getColumnClass(int col) {
		return columnClasses[col];
	}

	// Returns the value of each cell
	public Object getValueAt(int row, int col) {
		File f = new File(dir, filenames[row]);
		TableColumn tableColumn = TableColumn.fromIndex(col);
		switch (tableColumn) {
		case NAME:
			return filenames[row];
		case SIZE:
			return new Long(f.length());
		case LAST_MODIFIED:
			return new Date(f.lastModified());
		case DIRECTORY:
			return f.isDirectory() ? Boolean.TRUE : Boolean.FALSE;
		case READABLE:
			return f.canRead() ? Boolean.TRUE : Boolean.FALSE;
		case WRITABLE:
			return f.canWrite() ? Boolean.TRUE : Boolean.FALSE;
		default:
			return null;
		}
	}

}
