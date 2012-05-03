package com.test;

import java.util.Vector;

class Record
{	
	private static int numofmy1=3;
	private static int numofmy2=5;
	private static int numofenm=17;
	private static int clearemy1=0;
	private static int clearemy2=0;
	public static int getNumofmy1() {
		return numofmy1;
	}
	public static int getNumofmy2() {
		return numofmy2;
	}
	public static int getNumofenm() {
		return numofenm;
	}
	public static int getClearemy1() {
		return clearemy1;
	}
	public static int getClearemy2() {
		return clearemy2;
	}
    public static void reduceNumofemy()
    {
    	numofenm--;
    }
    public static void reduceNumofmy1()
    {
    	numofmy1--;
    }
    public static void reduceNumofmy2()
    {
    	numofmy2--;
    }
    public static void addClearemy1()
    {
    	clearemy1++;
    }
    public static void addClearemy2()
    {
    	clearemy2++;
    }
}
class Bullet implements Runnable
{   
	public static final int ENEMY=0;
	public static final int MYTANK1=1;
	public static final int MYTANK2=2;
	public static final int UNDEFINED=-1;
	int x;
	int y;
	int direction;
	int step;
	boolean isLive;
	int owner=UNDEFINED;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public boolean isLive() {
		return isLive;
	}
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
    public Bullet(int x,int y,int direction)
    {
    	this.x=x;
    	this.y=y;
    	this.direction=direction;
    	this.step=8;
    	isLive=true;
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
			switch(direction)
			{
			case Tank.UP:
				y -= step;
				break;
			case Tank.LEFT:
				x -= step;
				break;
			case Tank.DOWN:
				y += step;
				break;
			case Tank.RIGHT:
				x += step;
				break;
			}
			
			if(x<0 || x>400 ||y<0 ||y>300)
			{   
				isLive=false;
				break;
			}
		}
	}
	
}
abstract class Tank
{
	public static final int UP=0;
	public static final int LEFT=1;
	public static final int DOWN=2;
	public static final int RIGHT=3;
	public static final int MYTANK1=4;
	public static final int MYTANK2=5;
	public static final int ENEMY=6;
	public static final int UNDEFINED=-1;
	int x;
	int y;
	int step;
	int direction;
	int type;
    boolean isLive;
	Vector<Bullet> vts=null;
	Bullet b=null;
	int numofbullet=0;
	public int getType() {
		return type;
	}
	public void setType() {
		this.type = UNDEFINED;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
		step=1;
	    direction=UP;
	    type=UNDEFINED;
	    isLive=true;
	    vts=new Vector<Bullet>();
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getStep() {
		return step;
	}

	public void shot()
	{
		// TODO Auto-generated method stub	
			switch(direction)
			{
			case Tank.UP:
				b=new Bullet(x,y-15,Tank.UP);
				numofbullet++;
				vts.add(b);
			break;
			case Tank.LEFT:
				b=new Bullet(x-15,y,Tank.LEFT);
				numofbullet++;
				vts.add(b);
			break;
			case Tank.DOWN:
				b=new Bullet(x,y+15,Tank.DOWN);
				numofbullet++;
				vts.add(b);
			break;
			case Tank.RIGHT:
				b=new Bullet(x+15,y,Tank.RIGHT);
				numofbullet++;
				vts.add(b);
			break;	
			}
			if(this.getType()== Tank.MYTANK1)
			{
				b.owner = Bullet.MYTANK1;
			}
			else if(this.getType()== Tank.MYTANK2)
			{
				b.owner = Bullet.MYTANK2;
			}
			else if(this.getType()== Tank.ENEMY)
			{
				b.owner = Bullet.ENEMY;
			}
			Thread t=new Thread(b);
			t.start();
      }
}

class MyTank extends Tank implements Runnable
{
    Vector<MyTank> vtsm=new Vector<MyTank>();
    public void setVtsm(Vector<MyTank> vtsm)
    {
    	this.vtsm=vtsm;
    }
	public int getType() {
		return type;
	}
	public MyTank(int x,int y,int type)
	{
		super(x,y);
		this.type=type;
	}
	public boolean istouchEach()
	{
		boolean b=false;
		switch(this.direction)
		{
		case Tank.UP:
			for(int i=0;i<vtsm.size();++i)
			{
			  MyTank t=vtsm.get(i);
			  if(this != t)
			  {
			  if(t.direction == Tank.LEFT || t.direction == Tank.RIGHT)
			  {
				  if(this.x-10>=t.x-15 && this.x-10<= t.x+15 && this.y-15 >=t.y-10 && this.y-15 <=t.y+10)
					  return true;
				  if(this.x+10>=t.x-15 && this.x+10<= t.x+15 && this.y-15 >=t.y-10 && this.y-15 <=t.y+10)
			          return true;
//				  if(t.x+15>=this.x-10 && t.x-15<= this.x+10 && t.y+10 >=this.y-15 && t.y-10 <=this.y+15)
//					  b=true;
			  }
			  if(t.direction == Tank.UP || t.direction == Tank.DOWN)
			  {
				  if(this.x-10>=t.x-10 && this.x-10<= t.x+10 && this.y-15 >=t.y-15 && this.y-15 <=t.y+15)
					  return true;
			      if(this.x+10>=t.x-10 && this.x+10<= t.x+10 && this.y-15 >=t.y-15 && this.y-15 <=t.y+15)
			          return true;

//				  if(t.x+10>=this.x-10 && t.x-10<= this.x+10 && t.y+15 >=this.y-15 && t.y-15 <=this.y+15)
//					  b=true;
			  }	
			  }
			}
			break;
		case Tank.LEFT:
			for(int i=0;i<vtsm.size();++i)
			{
			  MyTank t=vtsm.get(i);
			  if(this != t)
			  {
			  if(t.direction == Tank.LEFT || t.direction == Tank.RIGHT)
			  {
				  if(this.x-15>=t.x-15 && this.x-15<= t.x+15 && this.y-10 >=t.y-10 && this.y-10 <=t.y+10)
					  return true;
				  if(this.x-15>=t.x-15 && this.x-15<= t.x+15 && this.y+10 >=t.y-10 && this.y+10 <=t.y+10)
			          return true;

//				  if(t.x+15>=this.x-15 && t.x-15<= this.x+15 && t.y+10 >=this.y-10 && t.y-10 <=this.y+10)
//			          b=true;
			  }
			  if(t.direction == Tank.UP || t.direction == Tank.DOWN)
			  {
				  if(this.x-15>=t.x-10 && this.x-15<= t.x+10 && this.y-10 >=t.y-15 && this.y-10 <=t.y+15)
					  return true;
			      if(this.x-15>=t.x-10 && this.x-15<= t.x+10 && this.y+10 >=t.y-15 && this.y+10 <=t.y+15)
			          return true;

//				  if(t.x+10>=this.x-15 && t.x-10<= this.x+15 && t.y+15 >=this.y-10 && t.y-15 <=this.y+10)
//			          b=true;
			  }	
			  }
			}
			break;
		case Tank.DOWN:
			for(int i=0;i<vtsm.size();++i)
			{
			  MyTank t=vtsm.get(i);
			  if(this != t)
			  {
			  if(t.direction == Tank.LEFT || t.direction == Tank.RIGHT)
			  {
				  if(this.x-10>=t.x-15 && this.x-10<= t.x+15 && this.y+15 >=t.y-10 && this.y+15 <=t.y+10)
					  return true;
				  if(this.x+10>=t.x-15 && this.x+10<= t.x+15 && this.y+15 >=t.y-10 && this.y+15 <=t.y+10)
			          return true;
			        
//			  if(t.x+15>=this.x-10 && t.x-15<= this.x+10 && t.y+10 >=this.y-15 && t.y-10 <=this.y+15)
//					  b=true;
			  }
			  if(t.direction == Tank.UP || t.direction == Tank.DOWN)
			  {
				  if(this.x-10>=t.x-10 && this.x-10<= t.x+10 && this.y+15 >=t.y-15 && this.y+15 <=t.y+15)
					  return true;
			      if(this.x+10>=t.x-10 && this.x+10<= t.x+10 && this.y+15 >=t.y-15 && this.y+15 <=t.y+15)
			          return true;

//				  if(t.x+10>=this.x-10 && t.x-10<= this.x+10 && t.y+15 >=this.y-15 && t.y-15 <=this.y+15)
//					  b=true;
			  }	
			  }
			}
			break;
		case Tank.RIGHT:
			for(int i=0;i<vtsm.size();++i)
			{
			  MyTank t=vtsm.get(i);
			  if(this != t)
			  {
			  if(t.direction == Tank.LEFT || t.direction == Tank.RIGHT)
			  {
				  if(this.x+15>=t.x-15 && this.x+15<= t.x+15 && this.y-10 >=t.y-10 && this.y-10 <=t.y+10)
					  return true;
				  if(this.x+15>=t.x-15 && this.x+15<= t.x+15 && this.y+10 >=t.y-10 && this.y+10 <=t.y+10)
			          return true;
		  
//				  if(t.x+15>=this.x-15 && t.x-15<= this.x+15 && t.y+10 >=this.y-10 && t.y-10 <=this.y+10)
//			          b=true;
			  }
			  if(t.direction == Tank.UP || t.direction == Tank.DOWN)
			  {
				  if(this.x+15>=t.x-10 && this.x+15<= t.x+10 && this.y-10 >=t.y-15 && this.y-10 <=t.y+15)
					  return true;
			      if(this.x+15>=t.x-10 && this.x+15<= t.x+10 && this.y+10 >=t.y-15 && this.y+10 <=t.y+15)
			          return true;

//			      if(t.x+10>=this.x-15 && t.x-10<= this.x+15 && t.y+15 >=this.y-10 && t.y-15 <=this.y+10)
//			          b=true;
			  }	
			  }
			}
			break;
		}
		return b;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(this.isLive)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Enemy extends Tank implements Runnable
{   
//	static int countEnemy=20;
	Vector<Enemy> ets=new Vector<Enemy>();
	public int getType() {
		return type;
	}
	public void setEts(Vector<Enemy> ets)
	{
		this.ets=ets;
	}	

	public boolean istouchEach()
	{
		boolean b=false;
		switch(this.direction)
		{
		case Tank.UP:
			for(int i=0;i<ets.size();++i)
			{
			  Enemy t=ets.get(i);
			  if(this != t)
			  {
			  if(t.direction == Tank.LEFT || t.direction == Tank.RIGHT)
			  {
				  if(this.x-10>=t.x-15 && this.x-10<= t.x+15 && this.y-15 >=t.y-10 && this.y-15 <=t.y+10)
					  return true;
				  if(this.x+10>=t.x-15 && this.x+10<= t.x+15 && this.y-15 >=t.y-10 && this.y-15 <=t.y+10)
			          return true;

//				  if(t.x+15>=this.x-10 && t.x-15<= this.x+10 && t.y+10 >=this.y-15 && t.y-10 <=this.y+15)
//					  b=true;
			  }
			  if(t.direction == Tank.UP || t.direction == Tank.DOWN)
			  {
				  if(this.x-10>=t.x-10 && this.x-10<= t.x+10 && this.y-15 >=t.y-15 && this.y-15 <=t.y+15)
					  return true;
			      if(this.x+10>=t.x-10 && this.x+10<= t.x+10 && this.y-15 >=t.y-15 && this.y-15 <=t.y+15)
			          return true;

//				  if(t.x+10>=this.x-10 && t.x-10<= this.x+10 && t.y+15 >=this.y-15 && t.y-15 <=this.y+15)
//					  b=true;
			  }	
			  }
			}
			break;
		case Tank.LEFT:
			for(int i=0;i<ets.size();++i)
			{
			  Enemy t=ets.get(i);
			  if(this != t)
			  {
			  if(t.direction == Tank.LEFT || t.direction == Tank.RIGHT)
			  {
				  if(this.x-15>=t.x-15 && this.x-15<= t.x+15 && this.y-10 >=t.y-10 && this.y-10 <=t.y+10)
					  return true;
				  if(this.x-15>=t.x-15 && this.x-15<= t.x+15 && this.y+10 >=t.y-10 && this.y+10 <=t.y+10)
			          return true;

//				  if(t.x+15>=this.x-15 && t.x-15<= this.x+15 && t.y+10 >=this.y-10 && t.y-10 <=this.y+10)
//			          b=true;
			  }
			  if(t.direction == Tank.UP || t.direction == Tank.DOWN)
			  {
				  if(this.x-15>=t.x-10 && this.x-15<= t.x+10 && this.y-10 >=t.y-15 && this.y-10 <=t.y+15)
					  return true;
			      if(this.x-15>=t.x-10 && this.x-15<= t.x+10 && this.y+10 >=t.y-15 && this.y+10 <=t.y+15)
			          return true;

//				  if(t.x+10>=this.x-15 && t.x-10<= this.x+15 && t.y+15 >=this.y-10 && t.y-15 <=this.y+10)
//			          b=true;
			  }	
			  }
			}
			break;
		case Tank.DOWN:
			for(int i=0;i<ets.size();++i)
			{
			  Enemy t=ets.get(i);
			  if(this != t)
			  {
			  if(t.direction == Tank.LEFT || t.direction == Tank.RIGHT)
			  {
				  if(this.x-10>=t.x-15 && this.x-10<= t.x+15 && this.y+15 >=t.y-10 && this.y+15 <=t.y+10)
					  return true;
				  if(this.x+10>=t.x-15 && this.x+10<= t.x+15 && this.y+15 >=t.y-10 && this.y+15 <=t.y+10)
			          return true;
			        
//			  if(t.x+15>=this.x-10 && t.x-15<= this.x+10 && t.y+10 >=this.y-15 && t.y-10 <=this.y+15)
//					  b=true;
			  }
			  if(t.direction == Tank.UP || t.direction == Tank.DOWN)
			  {
				  if(this.x-10>=t.x-10 && this.x-10<= t.x+10 && this.y+15 >=t.y-15 && this.y+15 <=t.y+15)
					  return true;
			      if(this.x+10>=t.x-10 && this.x+10<= t.x+10 && this.y+15 >=t.y-15 && this.y+15 <=t.y+15)
			          return true;

//				  if(t.x+10>=this.x-10 && t.x-10<= this.x+10 && t.y+15 >=this.y-15 && t.y-15 <=this.y+15)
//					  b=true;
			  }	
			  }
			}
			break;
		case Tank.RIGHT:
			for(int i=0;i<ets.size();++i)
			{
			  Enemy t=ets.get(i);
			  if(this != t)
			  {
			  if(t.direction == Tank.LEFT || t.direction == Tank.RIGHT)
			  {
				  if(this.x+15>=t.x-15 && this.x+15<= t.x+15 && this.y-10 >=t.y-10 && this.y-10 <=t.y+10)
					  return true;
				  if(this.x+15>=t.x-15 && this.x+15<= t.x+15 && this.y+10 >=t.y-10 && this.y+10 <=t.y+10)
			          return true;
		  
//				  if(t.x+15>=this.x-15 && t.x-15<= this.x+15 && t.y+10 >=this.y-10 && t.y-10 <=this.y+10)
//			          b=true;
			  }
			  if(t.direction == Tank.UP || t.direction == Tank.DOWN)
			  {
				  if(this.x+15>=t.x-10 && this.x+15<= t.x+10 && this.y-10 >=t.y-15 && this.y-10 <=t.y+15)
					  return true;
			      if(this.x+15>=t.x-10 && this.x+15<= t.x+10 && this.y+10 >=t.y-15 && this.y+10 <=t.y+15)
			          return true;

//			      if(t.x+10>=this.x-15 && t.x-10<= this.x+15 && t.y+15 >=this.y-10 && t.y-15 <=this.y+10)
//			          b=true;
			  }	
			  }
			}
			break;
		}
		return b;
	}
	public Enemy(int x,int y)
	{
		super(x,y);
		type=ENEMY;
	}
	public void run() {
		// TODO Auto-generated method stub
	    while(this.isLive)
	    {
	    	if(numofbullet <= 1)
                shot();
	    	switch(this.direction)
	    	{
	    	case Tank.UP:
	    		for(int i=0;i<30;i++)
	    		{   
	    			if(y>15 && !istouchEach())
	    			{	  y-=step;
		    	try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	}
		    	}
	    	break;
	    	case Tank.LEFT:
	    		for(int i=0;i<30;i++)
	    		{
	    			if(x>15 && !istouchEach())
	    			{
	    			x-=step;
		    	    try 
		    	{
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			}
	    		}
	    	break;
	    	case Tank.DOWN:
	    		for(int i=0;i<30;i++)
	    		{
	    			if(y<285 && !istouchEach())
	    			{
	    				y +=step;
	    				try {
						Thread.sleep(50);
	    					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		    }
	    		}
	    	break;
	    	case Tank.RIGHT:
	    		for(int i=0;i<30;i++)
	    		{
	    			if(x<385 && !istouchEach())
	    			{  
	    				x +=step;
		    	     try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			}
	    		}
	    	break;
	    	}
	    	this.direction = (int)(Math.random()*4);
	    }
	}
}
