package Packet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Doroga extends JPanel implements Runnable {
	
	private boolean isWork;
	
	static List <Sopernik> spisok = new ArrayList<Sopernik>();
	
	public Image imgm = new ImageIcon("carone.jpg").getImage();
	public Image imgl = new ImageIcon("caronel.jpg").getImage();
	public Image imgr = new ImageIcon("caroner.jpg").getImage();
	
	public Image img1 = new ImageIcon("Road.jpg").getImage();
	public Image img2 = new ImageIcon("Road.jpg").getImage();
	
	public Sopernik so = new Sopernik(); 
	
	Thread t;
	
	public static int ox = 15;
	public static int oy = 45;
	
	public static int odx = 0;
	public static int ody = 0;
	public static int nom = 1;
	
	Audio mp = new Audio();
	
	public static int x1 = 0;
	public static int x2 = 850;
	public static int y = 0;
	public static int dx = 0;	
	public int w = 0;
	
	
	public void startThreadDoroga(String name) {
		isWork = true;
		t = new Thread(this ,name);
		t.start();
		mp.audioThread("MP3");
	}
	
	public void paint(Graphics g) {
		g = (Graphics2D) g;
		
		if(oy <= 10){ox = 10;}
		if(oy >= 580){oy = 580;}
		if(ox <= 10){ox = 10;}
		if(ox >= 600){ox = 600;}
		
		if(x1<=(-850)){ x1=850;}
		if(x2<=(-850)){ x2=850;}
		g.drawImage(img1, x1, y , null);
		g.drawImage(img2, x2, y, null);
		
		if(nom == 1){
			g.drawImage(imgm, ox, oy, null);}
		if(nom == 2){
			g.drawImage(imgl, ox, oy, null);}
		if(nom == 3){
			g.drawImage(imgr, ox, oy, null);}

		Iterator <Sopernik> it = spisok.iterator();
		while(it.hasNext()){
			so = it.next();
			if (so.sx < 0){
				it.remove();
			}else{
				g.drawImage(Sopernik.simg, so.sx, so.sy, null);
			}
		}
		double v = (250/40)* dx;
		g.setColor(Color.white);
		Font font = new Font("Arial", Font.ITALIC, 18);
		g.setFont(font);
		g.drawString("Скорость: " + v + "км/ч", 100, 15);
		
	}
	
	public Rectangle getRect(){
		
		return new Rectangle(ox, oy, 150, 60);	
	
	}
	
	public void win (){
			if(w > 20000){
				isWork = false;
		JOptionPane.showConfirmDialog(null, "Вы выйграли");
		}else{
		w = w + dx;
		}
	}
	
	private void testDTP() {
		
		Iterator <Sopernik> i = spisok.iterator();
		while (i.hasNext()){
			Sopernik e = i.next();
			if (this.getRect().intersects(e.getRect())){
				System.out.println("lala1: "+this.getRect().x+" "+this.getRect().y);
				System.out.println("lala2: "+e.getRect().x+" "+e.getRect().y);
				isWork=false;
				JOptionPane.showConfirmDialog(null, "Вы проиграли");
				System.exit(1);
			}
		}
	
	}

	@Override
	public void run() {
		while (isWork) {
			try {
				t.sleep(20);
				x1 = x1 - dx;
				x2 = x2 - dx;
				so.sx = so.sx-so.sv;
				
			} catch (InterruptedException e) {}
			
			win();
			repaint();
			testDTP();
		}
	}
	

}