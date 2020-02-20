package Prg3;
import javax.swing.*;
import javax.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
public class gui implements ActionListener
{
	ArrayList<Student> ar;
	JFrame f1,f2;
	JLabel na,ag,us,cat,add,cgp;
	JTextField name,age,category,address,cgpa,usn;
	JTextArea disp;
	JButton compute,done;
	gui()
	{
		f1.setVisible(true);
		f2.setVisible(false);
		f1=new JFrame("Enter the details");
		na=new JLabel("Enter the name");
		name=new JTextField(30);
		ag=new JLabel("Enter the age");
		age=new JTextField(30);
		us=new JLabel("Enter the  USN");
		usn=new JTextField(30);
		cat=new JLabel("Enter the category");
		category=new JTextField(30);
		add=new JLabel("Enter the address");
		address=new JTextField(30);
		cgp=new JLabel("Enter the CGPA of 8 semesters");
		cgpa=new JTextField(30);
		f2=new  JFrame("Display student details");
		disp=new JTextArea(10,30);
		compute =new JButton("Compute");
		done=new JButton("Done");
		ar=new ArrayList<Student>();
		f1.add(na);f1.add(name);
		f1.add(ag);f1.add(age);
		f1.add(us);f1.add(usn);
		f1.add(cat);f1.add(category);
		f1.add(add);f1.add(address);
		f1.add(cgp);f1.add(cgpa);
		compute.addActionListener(this);
		done.addActionListener(this);
		

	}
	public void actionPerformed(ActionEvent evt)
	{
		int checkage,checkusn;
		if (evt.getSource()==compute)
		{
			try
			{
				checkage=Integer.parseInt(age.getText());
				checkusn=Integer.parseInt(usn.getText());
				if(checkage<18 || checkusn<300)
				{
					age.requestFocus();
				}
				else
				{
					Student s1=new Student(name.getText(),address.getText(),category.getText(),Integer.parseInt(usn.getText()),Integer.parseInt(age.getText()),Integer.parseInt(cgpa.getText()));
					ar.add(s1);
				}
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showConfirmDialog(f1, "Enter valid age and USN");
			}
		}
		else
		{
			f1.setVisible(false);
			disp.setText(" ");
			for(Student s:ar)
			{
				disp.append(s+"\n");
				disp.append("\n");
			}
			f2.add(disp);
		}
		
	}

}
