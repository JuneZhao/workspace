/*
 * ���ܣ�̹����Ϸ1.0
 */
package com.tank;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;

import javax.swing.*;
public class MyTank2 extends JFrame{
    
	MyPanel mp=null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTank2 mk=new MyTank2();
//		mp.addKeyListener(this);
	}
    public MyTank2()
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
		{
			hero.haxis-=hero.step;
			hero.setDirection(1);
		}
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			hero.haxis+=hero.step;
		    hero.setDirection(3);	
		}
		if(arg0.getKeyCode() == KeyEvent.VK_UP)
		{
			hero.vaxis-=hero.step;
		    hero.setDirection(0);	
		}
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
		{	
			hero.vaxis+=hero.step;
		    hero.setDirection(2);
		}
		repaint();
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	//�����̹��
	Hero hero=null;
	Vector<Enemy> vts=null;
	int size=3;
	//��дpaint
	public void paint(Graphics g)
	{	       
	    super.paint(g);	 
	    g.setColor(Color.red);
	    g.fillRect(0, 0, 400, 300);
	    //�����Լ���tank
	    this.drawTank(hero,g);
	    
		for(int i=0;i<vts.size();i++)
		{
		this.drawTank(vts.get(i),g);
		}
	}
	
	public MyPanel()
	{
		hero=new Hero(20,20);
		vts=new Vector<Enemy>(size);
		
		for(int i=0;i<size;i++)
		{
			Enemy enemy=new Enemy((i+1)*50,0);
			vts.add(enemy);
		}
	}
	
	//����̹�˵ĺ���
	public void drawTank(Tank tk,Graphics g)
	{
		//�ж���ʲô����tank
		switch(tk.getType())
		{
		case 0:
		    g.setColor(Color.CYAN);
		    break;
		case 1:
			g.setColor(Color.gray);
			break;
		}
		//�жϷ���
		switch(tk.getDirection())
		{
		case 0:
	    //��������ľ���
	    g.fill3DRect(tk.getHaxis(),tk.getVaxis(),5,30,false);
	    //��������ľ���
	    g.fill3DRect(tk.getHaxis()+15,tk.getVaxis(),5,30,false);
	    //�����м�ľ���
	    g.fill3DRect(tk.getHaxis()+5,tk.getVaxis()+5,10,20,false);
	    //�����м��Բ��
	    g.drawOval(tk.getHaxis()+5, tk.getVaxis()+10, 8, 8);
	    //�����м����
	    g.drawLine(tk.getHaxis()+9, tk.getVaxis()+15, tk.getHaxis()+9, tk.getVaxis());
	    break;
		case 1:
		    //��������ľ���
		    g.fill3DRect(tk.getHaxis(),tk.getVaxis(),30,5,false);
		    //��������ľ���
		    g.fill3DRect(tk.getHaxis(),tk.getVaxis()+15,30,5,false);
		    //�����м�ľ���
		    g.fill3DRect(tk.getHaxis()+5,tk.getVaxis()+5,20,10,false);
		    //�����м��Բ��
		    g.drawOval(tk.getHaxis()+10, tk.getVaxis()+5, 8, 8);
		    //�����м����
		    g.drawLine(tk.getHaxis()+15, tk.getVaxis()+9, tk.getHaxis(), tk.getVaxis()+9);
	     break;
		case 2:
		    //��������ľ���
		    g.fill3DRect(tk.getHaxis(),tk.getVaxis(),5,30,false);
		    //��������ľ���
		    g.fill3DRect(tk.getHaxis()+15,tk.getVaxis(),5,30,false);
		    //�����м�ľ���
		    g.fill3DRect(tk.getHaxis()+5,tk.getVaxis()+5,10,20,false);
		    //�����м��Բ��
		    g.drawOval(tk.getHaxis()+5, tk.getVaxis()+10, 8, 8);
		    //�����м����
		    g.drawLine(tk.getHaxis()+9, tk.getVaxis()+15, tk.getHaxis()+9, tk.getVaxis()+30);
	     break;
		case 3:
		    //��������ľ���
		    g.fill3DRect(tk.getHaxis(),tk.getVaxis(),30,5,false);
		    //��������ľ���
		    g.fill3DRect(tk.getHaxis(),tk.getVaxis()+15,30,5,false);
		    //�����м�ľ���
		    g.fill3DRect(tk.getHaxis()+5,tk.getVaxis()+5,20,10,false);
		    //�����м��Բ��
		    g.drawOval(tk.getHaxis()+10, tk.getVaxis()+5, 8, 8);
		    //�����м����
		    g.drawLine(tk.getHaxis()+15, tk.getVaxis()+9, tk.getHaxis()+30, tk.getVaxis()+9);
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