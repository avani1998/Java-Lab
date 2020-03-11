import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class sgpaGui implements ActionListener
{
	JFrame f1,f2;
	JLabel lname,lage,lusn,laddr,ls1,ls2,ls3,ls4,ls5,ls6,ls7,ls8,lcate;
	JTextField tname,tage,tusn,taddr,ts1,ts2,ts3,ts4,ts5,ts6,ts7,ts8,tcate;
	JTextArea txtar;
	ArrayList<sgpaStudent> arr;
	double sgpa[]=new double[8];
	double cgpa=0;
	JButton compute=new JButton("Compute");
	JButton display=new JButton("Display");
	JButton add=new JButton("Add");
	String categ;
	sgpaGui()
	{
		f1=new JFrame("Enter student details");
		f2=new JFrame("Show Student details");
		txtar=new JTextArea(20,30);
		lname=new JLabel("Enter your name");
		lage=new JLabel("Enter your age");
		lusn=new JLabel("Enter your usn");
		laddr=new JLabel("Enter your address");
		lcate=new JLabel("Enter category");
		ls1=new JLabel("Sem 1");
		ls2=new JLabel("Sem 2");
		ls3=new JLabel("Sem 3");
		ls4=new JLabel("Sem 4");
		ls5=new JLabel("Sem 5");
		ls6=new JLabel("Sem 6");
		ls7=new JLabel("Sem 7");
		ls8=new JLabel("Sem 8");
		tname=new JTextField(20);
		tage=new JTextField(3);
		tusn=new JTextField(10);
		taddr=new JTextField(50);
		ts1=new JTextField(5);
		ts2=new JTextField(5);
		ts3=new JTextField(5);
		ts4=new JTextField(5);
		ts5=new JTextField(5);
		ts6=new JTextField(5);
		ts7=new JTextField(5);
		ts8=new JTextField(5);
		tcate=new JTextField(20);
		f1.add(lname);f1.add(tname);
		f1.add(lusn);f1.add(tusn);f1.add(lage);f1.add(tage);f1.add(laddr);f1.add(taddr);	
		f1.add(compute);
		f1.add(display);
		compute.addActionListener(this);
		display.addActionListener(this);
		f1.add(ls1);f1.add(ts1);
		f1.add(ls2);f1.add(ts2);
		f1.add(ls3);f1.add(ts3);
		f1.add(ls4);f1.add(ts4);
		f1.add(ls5);f1.add(ts5);
		f1.add(ls6);f1.add(ts6);
		f1.add(ls7);f1.add(ts7);
		f1.add(ls8);f1.add(ts8);
		f2.add(txtar);
		f2.setVisible(false);
		arr=new ArrayList<sgpaStudent>();
	}
	public void actionPerformed(ActionEvent evt)
	{
			if(evt.getSource()==compute)
			{
			sgpa[0]=Double.parseDouble(ts1.getText());
			sgpa[1]=Double.parseDouble(ts2.getText());
			sgpa[2]=Double.parseDouble(ts3.getText());
			sgpa[3]=Double.parseDouble(ts4.getText());
			sgpa[4]=Double.parseDouble(ts5.getText());
			sgpa[5]=Double.parseDouble(ts6.getText());
			sgpa[6]=Double.parseDouble(ts7.getText());
			sgpa[7]=Double.parseDouble(ts8.getText());
			for(int i=0;i<8;i++)
			{
				if(sgpa[i]<0 || sgpa[i]>10)
				{
					JOptionPane.showMessageDialog(f1, "Invalid Input");
					break;
				}
				cgpa+=sgpa[i];
			}
			cgpa=cgpa/8.0;
			categ=tcate.getText();
			if (!categ.equalsIgnoreCase("UG")|| !categ.equalsIgnoreCase("PG"))
			{
				JOptionPane.showMessageDialog(f1, "Invalid Category");
				tcate.requestFocus(true);
			}
			int age=Integer.parseInt(tage.getText());
			if(age<18)
			{
				JOptionPane.showConfirmDialog(f1, "Enter valid age");
				tage.requestFocus(true);
			}
			JOptionPane.showMessageDialog(f1,"CGPA is:"+cgpa);
		}
		if(evt.getSource()==add)
		{
			String name=tname.getText();
			int age=Integer.parseInt(tage.getText());
			String addr=taddr.getText();
			String usn=tusn.getText();
			sgpaStudent s=new sgpaStudent(name,usn,addr,age,cgpa,categ);
			arr.add(s);
		}
		if(evt.getSource()==display)
		{
			f1.setVisible(false);
			f2.setVisible(true);
			txtar.setText(" ");
			for(sgpaStudent a:arr)
			{
				txtar.append(" "+a);   //Write others
			}
		}
	}
}
