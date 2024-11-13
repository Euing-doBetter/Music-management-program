package Main;

import java.io.Serializable;

public class Songdo implements Serializable{
	
	private int num;
	private String name;
	private String Pname;
	private int age;
	private String songn;
	private String Art;
	private String Gen;
	
	public Songdo(int num, String name, int age, String pname,String songn,String art, String Gen) {
		this.age= age;
		this.name=name;
		this.num=num;
		this.Pname=pname;
		this.Art = art;
		this.Gen = Gen;
		this.songn = songn;
	}
	public Songdo(String songn2, String art2, String gen2) {
		this.songn = songn2;
		this.Art = art2;
		this.Gen =gen2;
	}
	public String getSongn() {
		return songn;
	}
	public void setSongn(String songn) {
		this.songn = songn;
	}
	public String getArt() {
		return Art;
	}
	public void setArt(String art) {
		Art = art;
	}
	public String getGen() {
		return Gen;
	}
	public void setGen(String gen) {
		Gen = gen;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		this.Pname = pname;
	}
	
	public String toString() {
		return num+"\t"+name+"\t"+age+"\t"+Pname+"\t";
		
	}
	public String Mpys() {
		
		return songn+"\t"+Art+"\t"+Gen+"\t";
	}

	public String playlist() {
		// TODO Auto-generated method stub
		return Pname;
	}
	

}

