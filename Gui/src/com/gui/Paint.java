package com.gui;
import java.awt.*;

import javax.swing.*;
public class Paint extends JFrame{

	/**
	 * @param args
	 */
	JButton jb1,jb2,jb3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Paint()
	{
		jb1=new JButton();
		jb2=new JButton();
		jb3=new JButton();
	    
//		this.setLayout(new GridBagLayout());
	}
}
class MyPanel extends JPanel
{
	public void paint(Graphics g)
	{
		super.paint(g);;
		g.drawLine(0, 0, 10, 10);
	}
}