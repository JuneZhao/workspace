/*
 * 功能:java绘图原理
 */
package com.paint;
import java.awt.*;
import javax.swing.*;
public class Paint extends JFrame{

	/**
	 * @param args
	 */
//	MyPanel mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paint p=new Paint();
	}
   public Paint()
   {
/*	   mp=new MyPanel();
	   
	   this.add(mp);
	   
	   this.setSize(300,300);
	   
	   this.setLocation(100,100);
	   
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   this.setVisible(true);
	   */
   }
}

/*class MyPanel extends JPanel
{
//覆盖JPanel的paint的方法
//Graphics是绘图的重要类,你可以把它理解成一直画笔
	public void paint(Graphics g)
	{
		//调用父类进行初始化，必不可少
//		super.paint(g);
//		g.drawOval(10,10, 20, 20);	
		
//		Image imk=Tookit.GetDefault()
      
	  g.setColor(Color.green);
	  g.setFont(new Font("微软雅黑",Font.BOLD,30));
	  g.drawString("祖国万岁",100, 100);
	}

}*/
