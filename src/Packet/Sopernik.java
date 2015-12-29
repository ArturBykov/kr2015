package Packet;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Sopernik implements Runnable{
	
	Thread sopt;
	
	public int sx; 
	public int sy;
	public int sv;
	
	public static Image simg = new ImageIcon("rival.jpg").getImage();
	
	public Sopernik(int sx, int sy, int sv){
		this.sx = sx;
		this.sy = sy;
		this.sv = sv;
	
	}
	
	public Rectangle getRect(){
		
		return new Rectangle(sx, sy, 150, 60);	
	
	}
		
	public void startSopernikThread(String name){
		sopt = new Thread(this, name);
		sopt.start();
	}

	@Override
	public void run() {
		while (true){
			Random rand = new Random();
			try {
				Thread.sleep(rand.nextInt(2500));
				
				Doroga.spisok.add(new Sopernik(700+rand.nextInt(50),
						rand.nextInt(500),
						10+rand.nextInt(20)));
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
			
		}
		
	}

	public Sopernik(){}
}
