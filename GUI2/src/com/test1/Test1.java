/*
 * ����:�ʰ�
 */
package com.test1;
import java.awt.*;
import javax.swing.*;
public class Test1 extends JFrame{
    
	//�������
	JSplitPane jsp;
	JList jlist;
	JLabel jl;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 t=new Test1();
	}
   public Test1()
   {
	   String []arr={"boy","girl","teacher"};
	   jlist=new JList(arr);
	   
	   //JLabel���Է�ͼƬ
	   jl=new JLabel();
	   
	   //��ִ���
	   jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jlist,jl);
	   
	   //���Ա仯
	   jsp.setOneTouchExpandable(true);
	   
	   this.add(jsp);
	   
	   this.setSize(400,300);
	   
	   this.setLocation(200,200);
	   
	   this.setVisible(true);
   }
}
