package com.test1;
import java.awt.*;
import javax.swing.*;
public class Test extends JFrame{
    
	/**
	 * @param args
	 */
	JPanel jp1,jp2,jp3;
	JTextField jtf;
	JPasswordField jpf;
	JLabel jl1,jl2;
	JButton jb1,jb2;
	public static void main(String[] args){
		// TODO Auto-generated method stub
     Test t1=new Test();
	}
   public Test()
   {
	   jp1=new JPanel();
	   jp2=new JPanel();
	   jp3=new JPanel();
	   
	   jl1=new JLabel("�û���");
	   jl2=new JLabel("��    ��");
	   
	   jtf=new JTextField(10);
	   jpf=new JPasswordField(10);
	   
	   jb1=new JButton("��½");
	   jb2=new JButton("ȡ��");
	   
	   jp1.add(jl1);
	   jp1.add(jtf);
	   
	   jp2.add(jl2);
	   jp2.add(jpf);
	   
	   jp3.add(jb1);
	   jp3.add(jb2);
	   
	   //���ò��ֹ�����
	   this.setLayout(new GridLayout(3,1));
	   
	   this.add(jp1);
	   this.add(jp2);
	   this.add(jp3);
	   
	   this.setTitle("��½��");
	   this.setSize(300,200);
	   this.setLocation(200,300);
	   this.setVisible(true);
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
