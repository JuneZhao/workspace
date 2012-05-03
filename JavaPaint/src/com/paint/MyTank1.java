/*
 * ���ܣ�̹����Ϸ1.0
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
    	//ע�����
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
	//����һ���ҵ�̹��
	//��дpaint
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
	
	//����̹�˵ĺ���
	public void drawTank(int haxis,int vaxis,Graphics g,int direction,int type)
	{
		//�ж���ʲô����tank
		switch(type)
		{
		case 0:
		    g.setColor(Color.CYAN);
		    break;
		case 1:
			g.setColor(Color.gray);
			break;
		}
		//�жϷ���
		switch(direction)
		{
		case 0:
	    //��������ľ���
	    g.fill3DRect(haxis,vaxis,5,30,false);
	    //��������ľ���
	    g.fill3DRect(haxis+15,vaxis,5,30,false);
	    //�����м�ľ���
	    g.fill3DRect(haxis+5,vaxis+5,10,20,false);
	    //�����м��Բ��
	    g.drawOval(haxis+5, vaxis+10, 8, 8);
	    //�����м����
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
//̹����
class Tank
{  	
	//̹�˵ĺ�������
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