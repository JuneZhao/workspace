/*
 * ���ܣ�ͼ���û����棨gui��,���ֹ�����(�߽粼�ֹ���(BorderLaylout),��ʽ����(FlowLayout),���񲼾�(GridLayout)(������������))
 * ����JPanel��ʵ�ֶ��ز���
 */
package com.test;
import java.awt.*;
import javax.swing.*;
public class test extends JFrame{
 
	//����Ҫ��swing����ŵ�����
//	int size=9;
//  JButton[] jb=new JButton[size];
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
    JPanel jp1,jp2;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  //JFrame����������(�����������swing�齨����)
      test t1=new test();
	}
	//���캯��

	public test()
	{
//		  jb=new JButton[]{new JButton("����"),new JButton("�ŷ�"),new JButton("����"),new JButton("��"),new JButton("����")};
//        jb=new JButton[]{new JButton("1"),new JButton("2"),new JButton("3"),new JButton("4"),new JButton("5"),new JButton("6"),new JButton("7"),new JButton("8"),new JButton("9")};
//	     for(int i=0;i<9;++i)
//	    	  jb[i]=new JButton(String.valueOf(i));
		//�������
		//JPanel����Ĭ����FlowLayout
		jp1=new JPanel();
		jp2=new JPanel();
		
		jb1=new JButton("����");
		jb2=new JButton("ƻ��");
		jb3=new JButton("��֦");
		jb4=new JButton("����");
		jb5=new JButton("����");
		jb6=new JButton("�㽶");
		
		//���ò���
		jp1.add(jb1);
		jp1.add(jb2);
		
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
        
		//��Panel���뵽JFrame
		this.add(jp1,BorderLayout.NORTH);
		this.add(jb6,BorderLayout.CENTER);
		this.add(jp2,BorderLayout.SOUTH);
		
	      //�������񲼾�
	      this.setLayout(new GridLayout(3,3,10,10));
	      
		//������
/*       this.add(jb[0],BorderLayout.WEST);
         this.add(jb[1],BorderLayout.EAST);
         this.add(jb[2],BorderLayout.CENTER);
         this.add(jb[3],BorderLayout.SOUTH);
         this.add(jb[4],BorderLayout.NORTH);
*/
//		  for(int i=0;i<jb.length;++i)
//			  this.add(jb[i]);
	      
	      //��ʽ����Ĭ���Ǿ��ж���
//	      FlowLayout fl=new FlowLayout(FlowLayout.RIGHT);
	      
	      //�����²���
//	      this.setLayout(fl);
	      
	      //���ó�ʼλ��
	      this.setLocation(200,200);
	      
	      //���������ñ���
	      this.setTitle("���񲼾���ʾ");
	      
	      //���ô�С,������
	      this.setSize(200, 200);
	      
	      //��ʾ
	      this.setVisible(true);
	      
	      //��ֹ�û��ı䴰���С
//	      this.setResizable(false);
	      
	      //���õ��رմ��ڵ�ʱ�򣬱�֤jvmҲ�˳�.
	      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
