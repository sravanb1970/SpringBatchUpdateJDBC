package com.Student.BO;

public class StudentBO {
private int sno;
private String sname;
private String saddress;
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSaddress() {
	return saddress;
}
public void setSaddress(String saddress) {
	this.saddress = saddress;
}
@Override
public String toString() {
	return "StudentBO [sid=" + sno + ", sname=" + sname + ", saddress=" + saddress + "]";
}

}
