package com.test1;
import java.awt.*;

import javax.swing.*;
public class Test2 extends JFrame{

	JPanel jp1,jp2,jp3,jp4;
	JSplitPane jsp;
	JPasswordField jpf;
	JLabel jl1,jl2,jl3,jl4;
	JButton jb1,jb2,jb3;
	JComboBox jcb1;
	JCheckBox jchb1,jchb2;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 t2=new Test2();
	}
   public Test2()
   {
	   jp1=new JPanel();
	   jp2=new JPanel();
	   jp3=new JPanel();
	   jp4=new JPanel();
//	   jp5=new JPanel();
	   
	   jl1=new JLabel(new ImageIcon("image/xx.gif"));
	   jl2=new JLabel(new ImageIcon("image/11.gif"));
	   
	   String num[]={"460175801","1751642737"};
	   jcb1=new JComboBox(num);
	   
	   jpf=new JPasswordField();
	      
	   jl3=new JLabel("◊¢≤·’À∫≈");
	   jl4=new JLabel("’“ªÿ√‹¬Î");
	   
	   jchb1=new JCheckBox("º«◊°√‹¬Î");
	   jchb2=new JCheckBox("◊‘∂Øµ«¬º");
	   
	   jp1.add(jchb1);
	   jp1.add(jchb2);
	   
	   jp2.setLayout(new GridLayout(3,2,10,5));
	   
	   jp2.add(jcb1);
	   jp2.add(jl3);
	   jp2.add(jpf);
	   jp2.add(jl4);
	   jp2.add(jp1);
	   
	   jp3.add(jl2,BorderLayout.WEST);
	   jp3.add(jp2,BorderLayout.EAST);
//	   jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jl2,jp2);
	   jb1=new JButton("∂‡’À∫≈");
	   jb2=new JButton("…Ë÷√");
	   jb3=new JButton("µ«¬Ω");
	   
	   jp4.add(jb1);
	   jp4.add(jb2);
	   jp4.add(jb3);   
	   
	   this.add(jp3);
	   this.add(jl1,BorderLayout.NORTH);
	   this.add(jp4,BorderLayout.SOUTH);
	   
 	   this.setTitle("QQ2012");
//	   this.setIconImage(new ImageIcon("image/xx.jpg").getImage());
// 	   this.setBackground(RGB(12,124,123));
 	   this.setSize(800,500);
 	   this.setLocation(200,300);
 	   this.setResizable(false);
 	   this.setVisible(true);
 	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			   
   }
}
