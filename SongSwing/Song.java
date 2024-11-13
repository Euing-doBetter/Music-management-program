package Test1;

import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

interface Song {
	public void insert(SongDTO dto);
	public void print(DefaultTableModel model);
	public void prints(DefaultTableModel model2);
	public void save();
	public void load();

	
}
