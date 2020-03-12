import java.util.*;
public class CompareBookPrice implements Comparator<Book> 
{
public int compare(Book b1,Book b2)
{
	return(b1.price-b2.price);
}
}
