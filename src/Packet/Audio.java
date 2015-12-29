package Packet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Audio implements Runnable {

	Thread au;
	
	public void audioThread(String name){
	
		au = new Thread(this, name);
		au.start();
	
	}
	@Override
	public void run() {
		while (true){
		try {
			Player p = new Player(new FileInputStream("NFS.mp3"));
			p.play();
		} catch (FileNotFoundException | JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	}
}
