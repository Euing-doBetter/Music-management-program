package Main;

import java.util.Scanner;

import Main.Main;

public class Main {

	public static void main(String[] args) {
		SongTool songt = new SongTool();
		
		while(true) {
			System.out.println("------------------------");
			System.out.println("1.정보 입력->");
			System.out.println("2.노래 추가->");
			System.out.println("3.노래 파일 저장->");
			System.out.println("4.노래 파일 열기->");
			System.out.println("5.나의 플레이리스트 보기->");
			System.out.println("6.나의 프로필 보기->");
			System.out.println("7.종료->");
			System.out.println("------------------------");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			if(choice==1) {
				songt.insert();
				
			}else if(choice==2) {
				songt.addsong();
				
			}else if(choice==3) {
				songt.fileSave();
				
			}else if(choice==4) {
				songt.fileRead();
				
			}else if(choice==5) {
				songt.Myplaylist();
				
			}else if(choice==6) {
				songt.Myprofile();
			}
			else {
				System.out.println("종료합니다");
				System.exit(choice);
			}
		}
	}
}
