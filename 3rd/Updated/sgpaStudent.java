public class sgpaStudent 
{
	String name,usn,address,category;
	int age;
	double cgpa;
	sgpaStudent(String n,String u,String a,int ag,double c,String cat)
	{
		name=n;
		usn=u;
		address=a;
		age=ag;
		cgpa=c;
		category=cat;
	}
	public String toString()
	{
		return usn+" "+name+" "+age+" "+address+" "+cgpa+" "+category;
	}
}
