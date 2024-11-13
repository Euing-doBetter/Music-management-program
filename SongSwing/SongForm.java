package Test1;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SongForm extends JFrame implements ActionListener{
	private ArrayList<SongDTO> list;
	private Song song;
	private JButton insertBtn,insertBtn2, printBtn,printBtn2,ExitBtn, saveBtn, loadBtn;
	private JTextField numT, nameT, PnameT, AnameT, SnameT,Gen;
	private JTable table,table2;
	private DefaultTableModel model,model2;
	
	public SongForm() {
		
		super("���ǰ����ý���");
		
		// ���� - �Է�
		
		JPanel numP = new JPanel();
		JLabel numL = new JLabel("�й�");
		numT = new JTextField(20);
		numP.add(numL);
		numP.add(numT);
		JPanel nameP = new JPanel();
		JLabel nameL = new JLabel("�̸�");
		nameT = new JTextField(20);
		nameP.add(nameL);
		nameP.add(nameT);
		JPanel PnameP = new JPanel();
		JLabel PnameL = new JLabel("�÷��̸���Ʈ�̸�");
		PnameT = new JTextField(20);
		PnameP.add(PnameL);
		PnameP.add(PnameT);
		JPanel SnameP = new JPanel();
		JLabel SnameL = new JLabel("�뷡����");
		SnameT = new JTextField(20);
		SnameP.add(SnameL);
		SnameP.add(SnameT);
		JPanel AnameP = new JPanel();
		JLabel AnameL = new JLabel("��Ƽ��Ʈ�̸�");
		AnameT = new JTextField(20);
		AnameP.add(AnameL);
		AnameP.add(AnameT);
		JPanel GenP = new JPanel();
		JLabel GenL = new JLabel("�帣");
		Gen = new JTextField(20);
		GenP.add(GenL);
		GenP.add(Gen);
		
		JPanel leftP = new JPanel();
		
		leftP.setLayout(new GridLayout(6, 1,5,5));
		leftP.add(numP);
		leftP.add(nameP);
		leftP.add(PnameP);
		leftP.add(AnameP);
		leftP.add(SnameP);
		leftP.add(GenP);
		
		
		// ������ ���̺� 
		Vector<String> v = new Vector<String>();
		v.add("�й�");
		v.add("�̸�");
		v.add("�÷��̸���Ʈ");
		v.add("��Ƽ��Ʈ");
		v.add("�뷡����");
		v.add("�帣");
		model = new DefaultTableModel(v, 0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		JPanel rightP = new JPanel();
		rightP.setLayout(new GridLayout(1, 1));
		rightP.add(scroll);
		
		Vector<String> v2 = new Vector<String>();
		v2.add("�й�");
		v2.add("�̸�");
		v2.add("�÷��̸���Ʈ");
		model2 = new DefaultTableModel(v2, 0);
		table2 = new JTable(model2);
		JScrollPane scroll2 = new JScrollPane(table2);
		
		JPanel rightP2 = new JPanel();
		rightP2.setLayout(new GridLayout(2, 1));
		rightP2.add(scroll2);
		
		// ���� + ������ 
		JPanel centerP = new JPanel();
		centerP.setLayout(new GridLayout(1, 3));
		centerP.add(leftP);
		centerP.add(rightP);
		centerP.add(rightP2);
		
		song = new Songmpl();

		
		
		// ��ư
		insertBtn = new JButton("���� �Է�");
		insertBtn2 = new JButton("�뷡 �߰�");
		saveBtn = new JButton("�뷡 ���� ����");
		loadBtn = new JButton("�뷡 ���� ����");
		printBtn = new JButton("���� �÷��̸���Ʈ ����");
		printBtn2 = new JButton("����	 ������ ����");
		ExitBtn = new JButton("����");
		
		JPanel btnP = new JPanel();
		btnP.add(insertBtn);
		btnP.add(insertBtn2);
		btnP.add(saveBtn);
		btnP.add(loadBtn);
		btnP.add(printBtn);
		btnP.add(printBtn2);
		btnP.add(ExitBtn);
		
		
		Container c = getContentPane();
		c.add("Center", centerP);
		c.add("South", btnP);
		

		setBounds(200, 500, 1500, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	public void event() {
		insertBtn.addActionListener(this);
		insertBtn2.addActionListener(this);
		printBtn.addActionListener(this);
		printBtn2.addActionListener(this);
		saveBtn.addActionListener(this);
		loadBtn.addActionListener(this);
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == insertBtn) {
			
			SongDTO dto = new SongDTO();
			
			dto.setNum(numT.getText());
			dto.setName(nameT.getText());
			dto.setPname(PnameT.getText());
			dto.setAname(SnameT.getText()); 
			dto.setSname(AnameT.getText());
			dto.setGen(Gen.getText());
			
			song.insert(dto);
			
			JOptionPane.showMessageDialog(this, "��� �Ϸ�");
			numT.setText("");
			nameT.setText("");
			PnameT.setText("");
			SnameT.setText("");
			AnameT.setText("");
			Gen.setText("");

		}else if(e.getSource() == insertBtn2) {
			SongDTO dto = new SongDTO();
			
			dto.setPname(PnameT.getText());
			dto.setAname(SnameT.getText()); 
			dto.setSname(AnameT.getText());
			dto.setGen(Gen.getText());

			song.insert(dto);
			
			JOptionPane.showMessageDialog(this, "��� �Ϸ�");
			PnameT.setText("");
			SnameT.setText("");
			AnameT.setText("");
			Gen.setText("");
			
		}
		else if(e.getSource() == printBtn) {
			
			song.print(model);
			
		}else if(e.getSource()==printBtn2) {
			song.prints(model2);
		}

		else if(e.getSource() == saveBtn) {
			song.save();
		}
		else if(e.getSource() == loadBtn) {
			song.load();
			song.print(model);
			
			
		}
		else if(e.getSource()==ExitBtn) {
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
		}
	}
}
