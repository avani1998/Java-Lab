import java.util.*;
public class BookDetails 
{
static ArrayList<Book> b;
static HashMap<Integer,Book> hm;
static Scanner sc;
BookDetails()
{
	b=new ArrayList<Book>();
	sc=new Scanner(System.in);
	hm=new HashMap<Integer,Book>();
}
public static void main(String args[])
{
	int ch;int i=0;
	while(true)
	{
		System.out.println("1:Enter 2:Print 3:Stop");
		ch=sc.nextInt();
		if(ch==1)
		{
			String title=sc.nextLine();
			String author=sc.nextLine();
			String pub=sc.nextLine();
			int price=sc.nextInt();
			Book b1=new Book(title,pub,author,price);
			b.add(b1);
			hm.put(++i,b1);
		}
		else if(ch==2) 
		{
			for(Book b1:b)
			{
				System.out.println(b1);
			}
		}
		else 
			break;
	}
	BookDetails obj=new BookDetails();
	obj.sortBooks();
	//obj.operations();
}
public void sortBooks()
{
	ArrayList<Book> newb=(ArrayList<Book>)b.clone();
	Collections.sort(newb,new CompareBookPrice());
	System.out.println("The sorted books are:");
	for(Book r:newb)
	{
		System.out.println(r);
	}
}
}
