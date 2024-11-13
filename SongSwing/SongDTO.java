package Test1;

import java.io.Serializable;
import java.text.DecimalFormat;

public class SongDTO implements Serializable{
	private String num; 
	private String name; 
	private String Pname; 
	private String Aname; 
	private String Sname;
	private String Gen;
	public String getGen() {
		return Gen;
	}
	public void setGen(String gen) {
		Gen = gen;
	}

	private int tot; 

	

	// getter & setter
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
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
	public String getAname() {
		return Aname;
	}
	public void setAname(String aname) {
		this.Aname = aname;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		this.Sname = sname;
	}


	
}
