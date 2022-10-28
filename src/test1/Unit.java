package test1;

import java.awt.*;

import javax.swing.ImageIcon;

public class Unit {
	
	int hp;
	int posX;
	int posY;
	int width;
	int height;
	Image img;
	Image resizeImg;
	
}

class Player extends Unit {

	public Player() {
		this.hp = 30;
		this.posX = 275;
		this.posY = 500;	
		this.width = 70;
		this.height = 70;
		this.img = new ImageIcon(Player.class.getResource("flight.png")).getImage();
		this.resizeImg = img.getScaledInstance(width, height, height);
	}
}

class Enemy extends Unit {
	int moveSpeed;

	public void move() {
	}
}

class Storm extends Enemy{
	public Storm(int posX, int posY) {
		this.hp = 15;
		this.posX = posX;
		this.posY = posY;
		this.width = 70;
		this.height = 70;
		this.img = new ImageIcon(Storm.class.getResource("storm.png")).getImage();
		this.resizeImg = img.getScaledInstance(width, height, height);
	}
	
	//폭풍
	@Override
	public void move() {
		this.posY -= 0.2;
		if(this.posY == 1) {
			this.posY = 540;
		}
	}
}

class Thunder extends Enemy{
	public Thunder(int posX, int posY) {
		this.hp = 30;
		this.posX = posX;
		this.posY = posY;
		this.width = 70;
		this.height = 70;
		this.img = new ImageIcon(Thunder.class.getResource("thunder.png")).getImage();
		this.resizeImg = img.getScaledInstance(width, height, height);
	}
	
	//번개
	@Override
	public void move() {
		this.posY += 0.2;
		if(this.posY == 540) {
			this.posY = 30;
		}
	}
	
	static boolean Crash(int x1, int y1, int x2, int y2, int w1, int h1, int w2, int h2){
		// x,y : 위치값 , w,h : 이미지의 높이와 길이.
		boolean result = false;
		if(Math.abs( ( x1 + w1 / 2 )  - ( x2 + w2 / 2 ))  <  ( w2 / 2 + w1 / 2 )  
				&& Math.abs( ( y1 + h1 / 2 )  - ( y2 + h2 / 2 ))  <  ( h2 / 2 + h1/ 2 ))
			result = true;
		else result = false;
		return result;
	}
}







