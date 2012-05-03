package com.test;

import java.util.Vector;

class Bullet implements Runnable
{
	int x;
	int y;
	int direction;
	int step;
	boolean isLive;
    public Bullet(int x,int y,int direction)
    {
    	this.x=x;
    	this.y=y;
    	this.direction=direction;
    	this.step=1;
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
	public static final int MYTANK=4;
	public static final int ENEMY=5;
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
		{	
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
			
			Thread t=new Thread(b);
			t.start();
		}
	}
}

class MyTank extends Tank implements Runnable
{   
    int countmyTank;
	public int getType() {
		return type;
	}
	public MyTank(int x,int y)
	{
		super(x,y);
		type=MYTANK;
//		countmyTank=3;
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
		}
	}
}

class Enemy extends Tank implements Runnable
{   
	static int countEnemy;
	public int getType() {
		return type;
	}
	public Enemy(int x,int y)
	{
		super(x,y);
		type=ENEMY;
//		countEnemy=20;
	}
	public void run() {
		// TODO Auto-generated method stub
	    while(true)
	    {
	    	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	if(numofbullet <= 4)
                shot();	
	    }
	}
}
