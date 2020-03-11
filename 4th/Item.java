public class Item {
	String name,id;
	double price;
	Item(String i,String n,double c){
		id=i;
		name=n;
		price=c;
	}
	public String toString() {
		return id+" "+name+" "+price;
	}
}
