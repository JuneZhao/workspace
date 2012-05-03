/*
 * 功能：图形用户界面（gui）,布局管理器(边界布局管理(BorderLaylout),流式布局(FlowLayout),网格布局(GridLayout)(可以做计算器))
 * 利用JPanel来实现多重布局
 */
package com.test;
import java.awt.*;
import javax.swing.*;
public class test extends JFrame{
 
	//把需要的swing组件放到这里
//	int size=9;
//  JButton[] jb=new JButton[size];
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
    JPanel jp1,jp2;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  //JFrame顶层容器类(可以添加其它swing组建的类)
      test t1=new test();
	}
	//构造函数

	public test()
	{
//		  jb=new JButton[]{new JButton("关羽"),new JButton("张飞"),new JButton("赵云"),new JButton("马超"),new JButton("黄忠")};
//        jb=new JButton[]{new JButton("1"),new JButton("2"),new JButton("3"),new JButton("4"),new JButton("5"),new JButton("6"),new JButton("7"),new JButton("8"),new JButton("9")};
//	     for(int i=0;i<9;++i)
//	    	  jb[i]=new JButton(String.valueOf(i));
		//创建组件
		//JPanel布局默认是FlowLayout
		jp1=new JPanel();
		jp2=new JPanel();
		
		jb1=new JButton("西瓜");
		jb2=new JButton("苹果");
		jb3=new JButton("荔枝");
		jb4=new JButton("葡萄");
		jb5=new JButton("橘子");
		jb6=new JButton("香蕉");
		
		//设置布局
		jp1.add(jb1);
		jp1.add(jb2);
		
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
        
		//把Panel加入到JFrame
		this.add(jp1,BorderLayout.NORTH);
		this.add(jb6,BorderLayout.CENTER);
		this.add(jp2,BorderLayout.SOUTH);
		
	      //设置网格布局
	      this.setLayout(new GridLayout(3,3,10,10));
	      
		//添加组件
/*       this.add(jb[0],BorderLayout.WEST);
         this.add(jb[1],BorderLayout.EAST);
         this.add(jb[2],BorderLayout.CENTER);
         this.add(jb[3],BorderLayout.SOUTH);
         this.add(jb[4],BorderLayout.NORTH);
*/
//		  for(int i=0;i<jb.length;++i)
//			  this.add(jb[i]);
	      
	      //流式布局默认是居中对齐
//	      FlowLayout fl=new FlowLayout(FlowLayout.RIGHT);
	      
	      //设置新布局
//	      this.setLayout(fl);
	      
	      //设置初始位置
	      this.setLocation(200,200);
	      
	      //给窗口设置标题
	      this.setTitle("网格布局演示");
	      
	      //设置大小,按像素
	      this.setSize(200, 200);
	      
	      //显示
	      this.setVisible(true);
	      
	      //禁止用户改变窗体大小
//	      this.setResizable(false);
	      
	      //设置当关闭串口的时候，保证jvm也退出.
	      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
