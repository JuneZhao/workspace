/*
 * 功能：事件监听机制
 */
package com.test;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
//import java.util.EventListener;
//import java.util.Vector;
public class test extends JFrame{
    
	MyPanel mp=null;
	public static void main(String[] args) {
	// TODO Auto-generated method stub
    test t=new test();
	}
    
	public test()
	{   
		mp=new MyPanel();
		
		this.add(mp);
		
		this.setSize(400,300);
		this.addKeyListener(mp);
		Thread t=new Thread(mp);
		t.start();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}
}

class MyPanel extends JPanel implements KeyListener,Runnable
{
	int numofEmy=3;
	int numofMtank=2;
    Vector<Enemy> vts=null;
    Vector<MyTank>  vtsm=null;
	public void paint(Graphics g)
	{
		super.paint(g);
	    	
		g.setColor(Color.red);
		g.fillRect(0, 0, 400, 300);
		
		for(int i=0;i<vtsm.size();++i)
		{   
			if(vtsm.get(i).isLive)
			{
				draw(g,vtsm.get(i));
			}
			for(int m=0;m<vtsm.get(i).vts.size();++m)
			{
				if(vtsm.get(i).vts.get(m) != null && vtsm.get(i).vts.get(m).isLive)
			       g.drawLine(vtsm.get(i).vts.get(m).x, vtsm.get(i).vts.get(m).y, vtsm.get(i).vts.get(m).x, vtsm.get(i).vts.get(m).y);
			    if(!vtsm.get(i).vts.get(m).isLive)				
			      {
				   vtsm.get(i).vts.remove(vtsm.get(i).vts.get(m));
				   vtsm.get(i).numofbullet--;			
			      }
			}
			if(!vtsm.get(i).isLive)
			{   
//				if(vtsm.get(i).countmyTank <= 0)
				  vtsm.remove(vtsm.get(i));
//				else
//				  vtsm.get(i).countmyTank--;
			}
			
		}
		for(int j=0;j<vts.size();++j)
		{   
			if(vts.get(j).isLive)
			{
				draw(g,vts.get(j));
			}
			for(int k=0;k<vts.get(j).vts.size();++k)
			{	
				if(vts.get(j).vts.get(k) != null && vts.get(j).vts.get(k).isLive)
			      g.drawLine(vts.get(j).vts.get(k).x, vts.get(j).vts.get(k).y, vts.get(j).vts.get(k).x, vts.get(j).vts.get(k).y);		
		        if(!vts.get(j).vts.get(k).isLive)				
		        {
			      vts.get(j).vts.remove(vts.get(j).vts.get(k));
			      vts.get(j).numofbullet--;			
		        }
			}
			if(!vts.get(j).isLive)
			{
//				if(vts.get(j).countEnemy <= 0)
				   vts.remove(vts.get(j));
//				else
//				   vts.get(j).countEnemy--;
			}
		}
	}
   
	public MyPanel()
	{	
		Thread th[]=new Thread[numofMtank];
		vtsm=new Vector<MyTank>(numofMtank);
		for(int j=0;j<numofMtank;++j)
		{
			MyTank mt=new MyTank((j+1)*50,50);
			vtsm.add(j, mt);
		    vtsm.get(j).setDirection(Tank.UP);
		    th[j]=new Thread(mt);
		    th[j].start();
		}
		
		
		Thread t[]=new Thread[numofEmy];
		vts=new Vector<Enemy>(numofEmy);
		for(int i=0;i<numofEmy;++i)
		{
			Enemy emy=new Enemy((i+1)*50,15);
			vts.add(emy);
			vts.get(i).setDirection(Tank.DOWN);
	        t[i]=new Thread(vts.get(i));
		    t[i].start();
		}		
	}
	public void hitTank(Bullet b,Tank tk)
	{    
		 if(b != null)
	     {
			 if(tk.getType() == Tank.MYTANK)
	     {
	    	 switch(tk.getDirection())
	    	 {
	    	  case Tank.UP:
	    	  case Tank.DOWN:
	    		  if(b.x >= tk.x-10 && b.x <= tk.x+10 && b.y >= tk.y-15 && b.y <= tk.y+15)
	    		  {
	    			  tk.isLive =false;
	    			  b.isLive = false;
	    			  break;
	    		  }
	    		
	    	  case Tank.LEFT:
	    	  case Tank.RIGHT:
	    		  if(b.x >= tk.x-15 && b.x <= tk.x+15 && b.y >= tk.y-10 && b.y <= tk.y+10)
	    		  {
	    			  tk.isLive =false;
	    			  b.isLive = false;
	    			  break;
	    		  }
	          default:
	    			  break;
	    		  
	    	 }
	     }
	     else if(tk.getType() == Tank.ENEMY)
	     {
	    	 switch(tk.getDirection())
	    	 {
	    	  case Tank.UP:
	    	  case Tank.DOWN:
	    		  if(b.x >= tk.x-10 && b.x <= tk.x+10 && b.y >= tk.y-15 && b.y <= tk.y+15)
	    		  {
	    			  tk.isLive =false;
	    			  b.isLive = false;	
	    			  break;
	    		  }
	    	  case Tank.LEFT:
	    	  case Tank.RIGHT:
	    		  if(b.x >= tk.x-15 && b.x <= tk.x+15 && b.y >= tk.y-10 && b.y <= tk.y+10)
	    		  {
	    			  tk.isLive =false;
	    			  b.isLive = false;
	    			  break;
	    		  }
	    	default:
	    		break;
	    	 }
	     }
	     }
	}
	public void hit(Bullet b1,Bullet b2)
	{
		if(b1 != null && b2 != null)
		{
           if(b1.x == b2.x && b1.y == b2.y)
        	   b1.isLive=false;
               b2.isLive=false;
		}
	}
	public void draw(Graphics g,Tank tk)
	{
		if(tk.getType() == Tank.MYTANK)
		{
			g.setColor(Color.CYAN);
		}
		if(tk.getType() == Tank.ENEMY) 
		{
			g.setColor(Color.green);
		}	
		switch(tk.getDirection())
		{
			 case Tank.UP:
				 g.drawOval(tk.getX()-4, tk.getY()-4, 8, 8);
				 g.drawLine(tk.getX(), tk.getY(), tk.getX(), tk.getY()-15);
				 g.draw3DRect(tk.getX()-5, tk.getY()-10, 10, 20, false);
				 g.draw3DRect(tk.getX()-10, tk.getY()-15, 5, 30, false);
				 g.draw3DRect(tk.getX()+5, tk.getY()-15, 5, 30, false);
				 break;
			 case Tank.LEFT:
				 g.drawOval(tk.getX()-4, tk.getY()-4, 8, 8);
				 g.drawLine(tk.getX(), tk.getY(), tk.getX()-15, tk.getY());
				 g.draw3DRect(tk.getX()-10, tk.getY()-5, 20, 10, false);
				 g.draw3DRect(tk.getX()-15, tk.getY()-10, 30, 5, false);
				 g.draw3DRect(tk.getX()-15, tk.getY()+5, 30, 5, false);
				 break;
			 case Tank.DOWN:
				 g.drawOval(tk.getX()-4, tk.getY()-4, 8, 8);
				 g.drawLine(tk.getX(), tk.getY(), tk.getX(), tk.getY()+15);
				 g.draw3DRect(tk.getX()-5, tk.getY()-10, 10, 20, false);
				 g.draw3DRect(tk.getX()-10, tk.getY()-15, 5, 30, false);
				 g.draw3DRect(tk.getX()+5, tk.getY()-15, 5, 30, false);
				 break;
			 case Tank.RIGHT:
				 g.drawOval(tk.getX()-4, tk.getY()-4, 8, 8);
				 g.drawLine(tk.getX(), tk.getY(), tk.getX()+15, tk.getY());
				 g.draw3DRect(tk.getX()-10, tk.getY()-5, 20, 10, false);
				 g.draw3DRect(tk.getX()-15, tk.getY()-10, 30, 5, false);
				 g.draw3DRect(tk.getX()-15, tk.getY()+5, 30, 5, false);
				 break;
		}

	}
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		{
			if(arg0.getKeyCode() == KeyEvent.VK_UP)
			{   
				if(vtsm.get(0) != null)
				{
				vtsm.get(0).y -= vtsm.get(0).getStep();
				vtsm.get(0).setDirection(Tank.UP);
				}
			}
			if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
			{   
				if(vtsm.get(0) != null)
				{
				vtsm.get(0).x -= vtsm.get(0).getStep();
				vtsm.get(0).setDirection(Tank.LEFT);
				}
			}
			if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
			{   
				if(vtsm.get(0) != null)
				{
				vtsm.get(0).y += vtsm.get(0).getStep();
				vtsm.get(0).setDirection(Tank.DOWN);
				}
			}
			if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
			{   
				if(vtsm.get(0) != null)
				{
				vtsm.get(0).x += vtsm.get(0).getStep();
				vtsm.get(0).setDirection(Tank.RIGHT);
				}
			}
			if(arg0.getKeyCode() == KeyEvent.VK_W)
			{  
				if(vtsm.get(1) != null)
				{
				vtsm.get(1).y -= vtsm.get(1).getStep();
				vtsm.get(1).setDirection(Tank.UP);
				}
			}
			if(arg0.getKeyCode() == KeyEvent.VK_A)
			{   
				if(vtsm.get(1) != null)
				{
				vtsm.get(1).x -= vtsm.get(1).getStep();
				vtsm.get(1).setDirection(Tank.LEFT);
				}
			}
			if(arg0.getKeyCode() == KeyEvent.VK_S)
			{   
				if(vtsm.get(1) != null)
				{
				vtsm.get(1).y += vtsm.get(1).getStep();
				vtsm.get(1).setDirection(Tank.DOWN);
				}
			}
			if(arg0.getKeyCode() == KeyEvent.VK_D)
			{   
				if(vtsm.get(1) != null)
				{
				vtsm.get(1).x += vtsm.get(1).getStep();
				vtsm.get(1).setDirection(Tank.RIGHT);
				}
			}
			if(arg0.getKeyCode() == KeyEvent.VK_J)
			{   
				if(vtsm.get(0) != null)
				{
				  if(vtsm.get(0).numofbullet <=4)
					  vtsm.get(0).shot();
				}
			}
			if(arg0.getKeyCode() == KeyEvent.VK_K)
			{   
				if(vtsm.get(1) != null)
				{
				if(vtsm.get(1).numofbullet <=4)
					vtsm.get(1).shot();
				}
			}
			repaint();
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(this)
			{
			 for(int i=0;i<vts.size();++i)
			  {	
				for(int j=0;j<vtsm.size();++j)
				if(vts.get(i) != null && vtsm.get(j) != null)
				  {    
					    for(int k=0;k<vtsm.get(j).vts.size();++k)
						   hitTank(vtsm.get(j).vts.get(k),vts.get(i));
					    for(int m=0;m<vts.get(j).vts.size();++m)
					       hitTank(vts.get(i).vts.get(m),vtsm.get(j));
//					    hitTank(vtsm.get(j).b,vtsm.get(j));
//					    hit(vtsm.get(j).b,vts.get(i).b);
//					    hit(vtsm.get(j).b,vtsm.get(j).b);
//					    hit(vts.get(i).b,vts.get(i).b);
				   }
			   }
			  repaint();
			}
		}
	}
	
}
