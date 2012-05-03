package com.tank;

//坦克类
class Tank
{  	
	//坦克的横纵坐标
	int haxis;
	int vaxis;
	int step=3;
	int direction;
	int type;
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
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


	public Tank(int haxis,int vaxis,int type)
	{
		this.haxis=haxis;
		this.vaxis=vaxis;
		this.type=type;
	}
}

class Hero extends Tank
{   
	public Hero(int haxis,int vaxis)
	{
		super(haxis, vaxis,0);
	}
}

class Enemy extends Tank
{
	public Enemy(int haxis,int vaxis)
	{
		super(haxis, vaxis,1);
	}
}