package Test1;

import java.awt.event.ActionEvent;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class Songmpl implements Song{
	private List<SongDTO> list = new ArrayList<SongDTO>();
	
	public void insert(SongDTO dto) {
		
		list.add(dto); 
	}
	public void print(DefaultTableModel model) {
		
		model.setRowCount(0); 
		
		for(SongDTO dto : list) {
			
			Vector<String> v = new Vector<String>();
			
			v.add(dto.getNum());
			v.add(dto.getName());
			v.add(dto.getPname() + "");
			v.add(dto.getAname() + "");
			v.add(dto.getSname() + "");
			v.add(dto.getGen() + "");
			
			model.addRow(v);  
			
		}
	}
	public void prints(DefaultTableModel model2) {
		
		model2.setRowCount(0); 
		for(SongDTO dto : list) {
			
			Vector<String> v2 = new Vector<String>();
			
			v2.add(dto.getNum());
			v2.add(dto.getName());
			v2.add(dto.getPname() + "");
			
			
			model2.addRow(v2);
			
		}
	}

	public void save() {
		
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(null);
		File file = null;
		if(result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
		if(file == null) return;  
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void load() {
		
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);
		File file = null;
		if(result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
		
		if(file == null) return;
		
		list.clear(); 
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			while(true) {
				try {
					SongDTO dto = (SongDTO)ois.readObject();
					
					list.add(dto);
					
				}catch(EOFException e) {
					break;
				}
			}
			ois.close();
		}catch(IOException e) {
			
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
		
