import java.awt.GridLayout;
import java.awt.*;
import javax.swing.*;
public class CustomerMain 
{
public static void main(String args[])
{
	CustomerGui obj=new CustomerGui();
	obj.f1.setVisible(true);
	obj.f2.setVisible(false);
	obj.f1.setSize(600, 200);
	obj.f2.setSize(600, 200);
	obj.f1.setLayout(new GridLayout(1,2));
	obj.f2.setLayout(new GridLayout(1,2));
}
}
