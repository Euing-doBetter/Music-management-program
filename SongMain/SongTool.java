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
	
	public void insert() {	//정보 입력
		
		System.out.println("정보 입력을 시작합니다.");
		System.out.println("--------------------------");
		System.out.println("학번을 입력하세요");
		int num =sc.nextInt();
		
		int findIndex = findIndex(num);
		if (findIndex != -1) {
			System.out.println("동일한 학번이 존재합니다.");
			return ;
		}
		System.out.println("이름을 입력하세요");
		String name =sc.next();
		
		System.out.println("나이를 입력하세요");
		int age = sc.nextInt();
		
		System.out.println("플레이리스트의 이름을 정해주세요");
		String Pname = sc.next();
		
		System.out.println("개인정보입력완료.");
		

		System.out.println("플레이리스트에 추가할 노래를 작성하겠습니다.");
		System.out.println("노래제목을 입력해주세요");
		String songn = sc.next();
		
		System.out.println("아티스트를 입력해주세요");
		String Art = sc.next();
		
		System.out.println("장르를 입력해주세요");
		System.out.println("ex)발라드,팝송,힙합,케이팝,재즈 등");
		String Gen = sc.next();
		
		Songdo gdo  = new Songdo(num,name,age,Pname,songn,Art,Gen);
		list.add(gdo);
	}
	public void fileSave() {	// 파일저장
		try {
		String fileName2 = "D:\\Test\\java_test.txt";	
	      File myFiles = new File(fileName2);
	      FileOutputStream fo = new FileOutputStream(myFiles);
	      ObjectOutputStream oo = new ObjectOutputStream(fo); 
	      oo.writeObject(list); 
	      oo.close(); 
	      fo.close();
	      System.out.println("파일을 저장하였습니다.");
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
	}
	public int findIndex(int num) {	// 정수 학번 검색
		int findIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			if (num == list.get(i).getNum()) {
				findIndex = i;
				break;
			}
		}
		return findIndex;
	}
	public ArrayList<Songdo> fileRead() {	// 파일열기
		ArrayList<Songdo> list_ts = null;
		try {
			String fileName2 = "D:\\Test\\java_test.txt";;	
			ObjectInputStream oi = new ObjectInputStream(new FileInputStream(fileName2));
			list_ts = (ArrayList<Songdo>)oi.readObject();//파일에서 ArrayList읽기
			oi.close();
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		list = list_ts;
		System.out.println("파일을 열기하였습니다.");
		return list;
	}
	public void addsong() {
		System.out.println("노래제목을 입력해주세요");
		String songn = sc.next();
		
		System.out.println("아티스트를 입력해주세요");
		String Art = sc.next();
		
		System.out.println("장르를 입력해주세요");
		System.out.println("ex)발라드,팝송,힙합,케이팝,재즈 등");
		String Gen = sc.next();
		
		Songdo gdo  = new Songdo(songn,Art,Gen);
		list.add(gdo);
		
		
	}
	public void Myplaylist() {
		
		
		System.out.println("나의 플레이리스트");
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i).playlist());
		}
		System.out.println("---------------------------------------------");
		System.out.println("노래제목"+"\t"+"아티스트"+"\t"+"장르");
		System.out.println("---------------------------------------------");
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i).Mpys());
		}
		
	}
	public void Myprofile() {
		System.out.println("학번"+"\t"+"\t"+"이름"+"\t"+"나이"+"\t"+"플레이리스트 이름");
		System.out.println("-----------------------------------------------------");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
	}
}
