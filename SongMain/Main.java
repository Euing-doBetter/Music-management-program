package Main;

import java.util.Scanner;

import Main.Main;

public class Main {

	public static void main(String[] args) {
		SongTool songt = new SongTool();
		
		while(true) {
			System.out.println("------------------------");
			System.out.println("1.���� �Է�->");
			System.out.println("2.�뷡 �߰�->");
			System.out.println("3.�뷡 ���� ����->");
			System.out.println("4.�뷡 ���� ����->");
			System.out.println("5.���� �÷��̸���Ʈ ����->");
			System.out.println("6.���� ������ ����->");
			System.out.println("7.����->");
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
				System.out.println("�����մϴ�");
				System.exit(choice);
			}
		}
	}
}
