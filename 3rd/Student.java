package Prg3;

public class Student {
String name,address,category;
int usn,age;
double cgpa;
Student(String n,String a,String c,int u,int ag,double cg)
{
	name=n;
	address=a;
	category=c;
	usn=u;
	age=ag;
	cgpa=cg;
}
public String toString()
{
	return "Name:"+name+"\tUSN:"+usn+"\tAddress:"+address+"\tcategory:"+category+"\tage:"+age+"\tSGPA:"+cgpa;
}
}
