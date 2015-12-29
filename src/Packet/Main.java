package Packet;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		
		Doroga d = new Doroga();
		
		Audio mp = new Audio();		
		Sopernik s = new Sopernik();
		
		MyKeyDoroga kd = new MyKeyDoroga();
		
		JFrame frame = new JFrame("Priora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(850, 640);
		frame.add(d);
		d.startThreadDoroga("Doroga");
		mp.audioThread("MP3");
		s.startSopernikThread("Sopernik");
		frame.addKeyListener(kd);
		frame.setVisible(true);
		
	}

}
