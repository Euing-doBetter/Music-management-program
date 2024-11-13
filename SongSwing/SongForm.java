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
		
		super("음악관리시스템");
		
		// 왼쪽 - 입력
		
		JPanel numP = new JPanel();
		JLabel numL = new JLabel("학번");
		numT = new JTextField(20);
		numP.add(numL);
		numP.add(numT);
		JPanel nameP = new JPanel();
		JLabel nameL = new JLabel("이름");
		nameT = new JTextField(20);
		nameP.add(nameL);
		nameP.add(nameT);
		JPanel PnameP = new JPanel();
		JLabel PnameL = new JLabel("플레이리스트이름");
		PnameT = new JTextField(20);
		PnameP.add(PnameL);
		PnameP.add(PnameT);
		JPanel SnameP = new JPanel();
		JLabel SnameL = new JLabel("노래제목");
		SnameT = new JTextField(20);
		SnameP.add(SnameL);
		SnameP.add(SnameT);
		JPanel AnameP = new JPanel();
		JLabel AnameL = new JLabel("아티스트이름");
		AnameT = new JTextField(20);
		AnameP.add(AnameL);
		AnameP.add(AnameT);
		JPanel GenP = new JPanel();
		JLabel GenL = new JLabel("장르");
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
		
		
		// 오른쪽 테이블 
		Vector<String> v = new Vector<String>();
		v.add("학번");
		v.add("이름");
		v.add("플레이리스트");
		v.add("아티스트");
		v.add("노래제목");
		v.add("장르");
		model = new DefaultTableModel(v, 0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		JPanel rightP = new JPanel();
		rightP.setLayout(new GridLayout(1, 1));
		rightP.add(scroll);
		
		Vector<String> v2 = new Vector<String>();
		v2.add("학번");
		v2.add("이름");
		v2.add("플레이리스트");
		model2 = new DefaultTableModel(v2, 0);
		table2 = new JTable(model2);
		JScrollPane scroll2 = new JScrollPane(table2);
		
		JPanel rightP2 = new JPanel();
		rightP2.setLayout(new GridLayout(2, 1));
		rightP2.add(scroll2);
		
		// 왼쪽 + 오른쪽 
		JPanel centerP = new JPanel();
		centerP.setLayout(new GridLayout(1, 3));
		centerP.add(leftP);
		centerP.add(rightP);
		centerP.add(rightP2);
		
		song = new Songmpl();

		
		
		// 버튼
		insertBtn = new JButton("정보 입력");
		insertBtn2 = new JButton("노래 추가");
		saveBtn = new JButton("노래 파일 저장");
		loadBtn = new JButton("노래 파일 열기");
		printBtn = new JButton("나의 플레이리스트 보기");
		printBtn2 = new JButton("나의	 프로필 보기");
		ExitBtn = new JButton("종료");
		
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
			
			JOptionPane.showMessageDialog(this, "등록 완료");
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
			
			JOptionPane.showMessageDialog(this, "등록 완료");
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
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}
	}
}
