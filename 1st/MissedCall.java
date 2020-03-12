import java.util.*;
public class MissedCall 
{
	public static void main(String args[])
	{
		HashMap<Long,String> hm;
		ArrayList<MissedDetails> arr;
		hm=new HashMap<Long,String>();
		arr=new ArrayList<MissedDetails>(10);
		hm.put((long)900820934,"ABC");
		hm.put((long)900820934,"CDF");
		hm.put((long)900820934,"FGH");
		hm.put((long)900820871,"IJK");
		Scanner sc=new Scanner(System.in); 
		int ch;
		String name,time;long num;
		while(true)
		{
			System.out.println("Choose 1:Add 2:Display 2:Exit");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1: 
				System.out.println("Enter the number");
				num=sc.nextLong();
				if(hm.containsKey(num))    //error
				{
					name=hm.get(num);
					System.out.println("Enter time");
					time=sc.next();
				}
				else
				{
					name ="Private Caller";
					System.out.println("Enter time");
					time=sc.next();
				}
				MissedDetails md=new MissedDetails(name,time,num);
				if(arr.size()>=10)
				{
					arr.remove(0);
					arr.add(md);
				}
				else 
					arr.add(md);
				break;
			case 2:
				Iterator<MissedDetails> itr=arr.iterator();
				//for(MissedDetails a:arr)
				if(itr.hasNext())
				{
					MissedDetails a=(MissedDetails) itr.next();
					int p;
					while(true)
					{
						System.out.println(a);
						System.out.println("1:Delete call 2: Move to next Call 3:display details");
						p=sc.nextInt();
						if(p==1)
						{
							itr.remove();
						}
						else if(p==2)
							continue;
						else
							System.out.println(a);
					}
				}
				break;
			case 3: break;	
			}
		}
	}
}
