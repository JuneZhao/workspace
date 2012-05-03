/*
 * 功能：qq聊天
 */
package com.test1;
import java.awt.*;
import javax.swing.*;
public class test3 extends JFrame{

	JPanel jp;
	JTextArea jta;
	JScrollPane jsp;
	JComboBox jcb;
	JTextField jtf;
	JButton jb;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  test3 t=new test3();
	}
    public test3()
    {
    	jta=new JTextArea();
    	jsp=new JScrollPane(jta);
    	jp=new JPanel();
    	String arr[]={"布什","克林顿"};
    	jcb=new JComboBox(arr);
    	
    	jtf=new JTextField(10);
    	jb=new JButton("发送");
    	
    	//设置
    	jp.add(jcb);
    	jp.add(jtf);
    	jp.add(jb);
    	
    	//加入JFrame
    	this.add(jsp);
    	this.add(jp,BorderLayout.SOUTH);
    	
 	   this.setTitle("腾讯QQ");
 	   this.setIconImage(new ImageIcon("image/xx.jpg").getImage());
 	   this.setSize(300,200);
 	   this.setLocation(200,300);
 	   this.setVisible(true);
 	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
