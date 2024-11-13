package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import Main.SongTool;

public class SongTool implements Serializable{
	
	ArrayList<Songdo> list = new ArrayList<Songdo>();
	Scanner sc = new Scanner(System.in);
	
	public void insert() {	//���� �Է�
		
		System.out.println("���� �Է��� �����մϴ�.");
		System.out.println("--------------------------");
		System.out.println("�й��� �Է��ϼ���");
		int num =sc.nextInt();
		
		int findIndex = findIndex(num);
		if (findIndex != -1) {
			System.out.println("������ �й��� �����մϴ�.");
			return ;
		}
		System.out.println("�̸��� �Է��ϼ���");
		String name =sc.next();
		
		System.out.println("���̸� �Է��ϼ���");
		int age = sc.nextInt();
		
		System.out.println("�÷��̸���Ʈ�� �̸��� �����ּ���");
		String Pname = sc.next();
		
		System.out.println("���������Է¿Ϸ�.");
		

		System.out.println("�÷��̸���Ʈ�� �߰��� �뷡�� �ۼ��ϰڽ��ϴ�.");
		System.out.println("�뷡������ �Է����ּ���");
		String songn = sc.next();
		
		System.out.println("��Ƽ��Ʈ�� �Է����ּ���");
		String Art = sc.next();
		
		System.out.println("�帣�� �Է����ּ���");
		System.out.println("ex)�߶��,�˼�,����,������,���� ��");
		String Gen = sc.next();
		
		Songdo gdo  = new Songdo(num,name,age,Pname,songn,Art,Gen);
		list.add(gdo);
	}
	public void fileSave() {	// ��������
		try {
		String fileName2 = "D:\\Test\\java_test.txt";	
	      File myFiles = new File(fileName2);
	      FileOutputStream fo = new FileOutputStream(myFiles);
	      ObjectOutputStream oo = new ObjectOutputStream(fo); 
	      oo.writeObject(list); 
	      oo.close(); 
	      fo.close();
	      System.out.println("������ �����Ͽ����ϴ�.");
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
	}
	public int findIndex(int num) {	// ���� �й� �˻�
		int findIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			if (num == list.get(i).getNum()) {
				findIndex = i;
				break;
			}
		}
		return findIndex;
	}
	public ArrayList<Songdo> fileRead() {	// ���Ͽ���
		ArrayList<Songdo> list_ts = null;
		try {
			String fileName2 = "D:\\Test\\java_test.txt";;	
			ObjectInputStream oi = new ObjectInputStream(new FileInputStream(fileName2));
			list_ts = (ArrayList<Songdo>)oi.readObject();//���Ͽ��� ArrayList�б�
			oi.close();
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		list = list_ts;
		System.out.println("������ �����Ͽ����ϴ�.");
		return list;
	}
	public void addsong() {
		System.out.println("�뷡������ �Է����ּ���");
		String songn = sc.next();
		
		System.out.println("��Ƽ��Ʈ�� �Է����ּ���");
		String Art = sc.next();
		
		System.out.println("�帣�� �Է����ּ���");
		System.out.println("ex)�߶��,�˼�,����,������,���� ��");
		String Gen = sc.next();
		
		Songdo gdo  = new Songdo(songn,Art,Gen);
		list.add(gdo);
		
		
	}
	public void Myplaylist() {
		
		
		System.out.println("���� �÷��̸���Ʈ");
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i).playlist());
		}
		System.out.println("---------------------------------------------");
		System.out.println("�뷡����"+"\t"+"��Ƽ��Ʈ"+"\t"+"�帣");
		System.out.println("---------------------------------------------");
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i).Mpys());
		}
		
	}
	public void Myprofile() {
		System.out.println("�й�"+"\t"+"\t"+"�̸�"+"\t"+"����"+"\t"+"�÷��̸���Ʈ �̸�");
		System.out.println("-----------------------------------------------------");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
	}
}
