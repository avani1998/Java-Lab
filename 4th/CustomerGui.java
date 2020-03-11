import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CustomerGui implements ActionListener 
{
	JFrame f2;
	JFrame f1=new JFrame("Checkout");
	HashMap<Long,String> hm=new HashMap<Long,String>();
	ArrayList<Item> itemlist=new ArrayList<Item>();
	String user="user123";
	String password="Password";
	JLabel lphno,lname,litemid,lquant,litemn,lprice;
	JTextField tphno,tname,tquant,titemid,titemn,tprice;
	JButton check1,check2,pay;
	Integer[] discount= {0,10,20,50};
	Item i;
	double amt;
	CustomerGui()
	{
		while(true)
		{
			String u=JOptionPane.showInputDialog(f1,"Enter the username","Login Details",JOptionPane.INFORMATION_MESSAGE);
			if(u.equals(user))
			{
				String p= JOptionPane.showInputDialog(f1,"Enter the password","Login Details",JOptionPane.INFORMATION_MESSAGE);
				if (p.equals(password))
				{
					break;
				}
				else 
					JOptionPane.showMessageDialog(f1,"Invalid Login","Please enter correct password",JOptionPane.OK_OPTION);
			}
			else 
				JOptionPane.showMessageDialog(f1,"Invalid Login","Please enter correct username",JOptionPane.OK_OPTION);
		}
		//f2.setVisible(false);
		f1.setVisible(true);
		lphno=new JLabel("Enter your phone number");
		tphno=new JTextField(10);
		f1.add(lphno);
		f1.add(tphno);
		check1=new JButton("Check");
		f1.add(check1);
		check1.addActionListener(this);
		f2=new JFrame("Cart");
		lname=new JLabel("Customer Name");
		litemid=new JLabel("Enter Id");
		lquant=new JLabel("Enter quantity");
		litemn=new JLabel("Enetr Item name");
		lprice=new JLabel("Item Price");
		tname=new JTextField(20);
		tquant=new JTextField(20);
		titemid=new JTextField(20);
		titemn=new JTextField(20);
		tprice=new JTextField(20);
		f2.add(lname);f2.add(tname);f2.add(lphno);f2.add(tphno);
		f2.add(litemid);f2.add(titemid);f2.add(litemn);f2.add(titemn);
		f2.add(lquant);f2.add(tquant);f2.add(lprice);f2.add(tprice);
		check2=new JButton("Check");
		pay=new JButton("Pay");
		check2.addActionListener(this);
		pay.addActionListener(this);
		itemlist.add(new Item("10","Potato",2.99));
		itemlist.add(new Item("12","Brinjal",3.99));
		itemlist.add(new Item("14","Tomato",6.99));
		itemlist.add(new Item("16","Lettuce",8.99));
		
	}
	public void actionPerformed(ActionEvent evt)
	{
		Long Phno;String name;
		if(evt.getSource()==check1)
		{
			Phno=Long.parseLong(tphno.getText());
			if(!hm.containsKey(Phno))
			{
				name=JOptionPane.showInputDialog(f1,"Hello New customer.","Please enter your name",JOptionPane.INFORMATION_MESSAGE);
				hm.put(Phno,name);
			}
			else 
			{
				name=hm.get(Phno);
				String strLong = Long.toString(Phno);
				f1.setVisible(false);
				f2.setVisible(true); 
				tname.setText(name);
				tphno.setText(strLong);
			}
		}
		if (evt.getSource()==check2)
		{
			boolean flag=false;
			String iid=titemid.getText();
			int q=Integer.parseInt(tquant.getText());
			for(Item x: itemlist)
			{
				if(x.id.equals(iid))
				{
					i=x;
					flag=true;
					break;
				}
			}
			if(flag==true)
			{
				titemn.setText(i.name);
				amt=i.price*q;
				tprice.setText(Double.toString(amt));
			}
			else 
				JOptionPane.showMessageDialog(f2, "Enter a valid item");
			
		}
		if(evt.getSource()==pay)
		{
			int d1=JOptionPane.showOptionDialog(f2, "Choose discount(%):", "Offer", 0,
					JOptionPane.INFORMATION_MESSAGE, null, discount, discount[0]);
			JOptionPane.showMessageDialog(f2, "Amount to be paid: Rs. "+(amt-(amt*discount[d1]/100)), 
					"Bill", JOptionPane.INFORMATION_MESSAGE);
			f2.setVisible(false);
			f1.setVisible(true);
		}
	}
}
