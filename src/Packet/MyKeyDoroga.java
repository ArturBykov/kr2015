package Packet;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyDoroga extends KeyAdapter{

	Doroga dor;
	Thread th;
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT){
			if (Doroga.dx >= 0 & Doroga.dx < 10){
				Doroga.dx = Doroga.dx + 2;
			}
			if (Doroga.dx >= 10 & Doroga.dx < 20){
				Doroga.dx = Doroga.dx + 2;
			}
			if (Doroga.dx >= 20 & Doroga.dx < 30){
				Doroga.dx = Doroga.dx + 1;
			}
			if (Doroga.dx >= 30 & Doroga.dx < 40){
				Doroga.dx = Doroga.dx + 1;
			}
			if (Doroga.dx > 40){
				Doroga.dx = 40;
			}
		}
		//========================================
		if (key == KeyEvent.VK_LEFT){
			if (Doroga.dx >= 0 && Doroga.dx < 10){
				Doroga.dx = Doroga.dx - 1;
			}
			if (Doroga.dx >= 10 && Doroga.dx < 20){
				Doroga.dx = Doroga.dx - 1;
			}
			if (Doroga.dx >= 20 && Doroga.dx < 30){
				Doroga.dx = Doroga.dx - 2;
			}
			if (Doroga.dx >= 30 && Doroga.dx < 40){
				Doroga.dx = Doroga.dx - 3;
			}
			if (Doroga.dx >= 40){
				Doroga.dx=Doroga.dx - 4;
			}
			if(Doroga.dx <= 0){
				Doroga.dx = 0;
			}
		}
		//==========================================
		if (key == KeyEvent.VK_UP){
			if (Doroga.oy >= 30 && Doroga.dx > 0){
				Doroga.oy = Doroga.oy - 7;
				Doroga.nom = 2;
			}
		}
		//==========================================
		if (key == KeyEvent.VK_DOWN){
			if (Doroga.oy <= 500 && Doroga.dx > 0){
				Doroga.oy =Doroga.oy + 7;
				Doroga.nom = 3;
			}
		}
		//===========================================
		if (key == KeyEvent.VK_SHIFT){
			if (Doroga.ox >= 10 && Doroga.dx > 0 && Doroga.ox <= 700){
				Doroga.ox = Doroga.ox + 5;
			}
		}
		//===========================================
		if (key == KeyEvent.VK_SPACE){
			if (Doroga.ox >= 10 && Doroga.dx > 0 && Doroga.ox <= 700){
				Doroga.ox = Doroga.ox - 5;
			}
		}
	}
	
	//=================================================================
	//=================================================================
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN){
			Doroga.nom = 1;
		}
	}

}
