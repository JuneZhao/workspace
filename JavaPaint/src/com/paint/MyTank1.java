/*
 * 功能：坦克游戏1.0
 */
package com.paint;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;

import javax.swing.*;
public class MyTank1 extends JFrame{
    
	MyPanel mp=null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTank1 mk=new MyTank1();
//		mp.addKeyListener(this);
	}
    public MyTank1()
    {
    	mp=new MyPanel();
    	
    	this.add(mp);
    	this.setSize(400,300);
    	this.setVisible(true);
    	//注册监听
    	this.addKeyListener(mp);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MyPanel extends JPanel implements KeyListener,MouseListener,MouseMotionListener
{
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
			hero.haxis--;
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
			hero.haxis++;
		if(arg0.getKeyCode() == KeyEvent.VK_UP)
			hero.vaxis--;
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
			hero.vaxis++;
		repaint();
	}

	
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	Hero hero=null;
	//定义一个我的坦克
	//重写paint
	public void paint(Graphics g)
	{
	    super.paint(g);
	    
	    g.setColor(Color.red);
	    g.fillRect(0, 0, 400, 300);
	    
	    this.drawTank(hero.haxis, hero.vaxis, g, 0, 1);
	}
	
	public MyPanel()
	{
		hero=new Hero(20,20);	
	}
	
	//画出坦克的函数
	public void drawTank(int haxis,int vaxis,Graphics g,int direction,int type)
	{
		//判断是什么类型tank
		switch(type)
		{
		case 0:
		    g.setColor(Color.CYAN);
		    break;
		case 1:
			g.setColor(Color.gray);
			break;
		}
		//判断方向
		switch(direction)
		{
		case 0:
	    //画出左面的矩形
	    g.fill3DRect(haxis,vaxis,5,30,false);
	    //画出右面的矩形
	    g.fill3DRect(haxis+15,vaxis,5,30,false);
	    //画出中间的矩形
	    g.fill3DRect(haxis+5,vaxis+5,10,20,false);
	    //画出中间的圆形
	    g.drawOval(haxis+5, vaxis+10, 8, 8);
	    //画出中间的线
	    g.drawLine(haxis+9, vaxis+15, haxis+9, vaxis);
	    break;
		}
	}

	
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
//坦克类
class Tank
{  	
	//坦克的横纵坐标
	int haxis=0;
	int vaxis=0;
	
	public int getHaxis() {
		return haxis;
	}

	public void setHaxis(int haxis) {
		this.haxis = haxis;
	}

	public int getVaxis() {
		return vaxis;
	}

	public void setVaxis(int vaxis) {
		this.vaxis = vaxis;
	}


	public Tank(int haxis,int vaxis)
	{
		this.haxis=haxis;
		this.vaxis=vaxis;
	}
}

class Hero extends Tank
{
	public Hero(int haxis,int vaxis)
	{
		super(haxis, vaxis);
	}
}