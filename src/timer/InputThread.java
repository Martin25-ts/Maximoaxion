package timer;

import java.util.Scanner;

import game.StartGame;
import method.Callable;


public class InputThread implements Runnable, Callable{
	Scanner sc = new Scanner(System.in);
	private Thread inputthread;
	private boolean runinput = false;
	private int input;
	public InputThread() {
		runinput = false;
	}
	

	@Override
	public void run() {
		
		while(runinput) {
			
			input = inputvalidate(0);
			if(input == 0) {
				if(TimeGame.isRunning()) {
					cls();
					StartGame.stopthread();
				
				}
				else StartGame.startthread();
				
			}
			else if(input == 1) {
				StartGame.InGame = StartGame.gatherWood();
				StartGame.InGame = StartGame.randomdecrease();
				cls();
				StartGame.Play(TimeGame.time);
			}
			else if(input == 2) {
				
			}
			else if(input == 3) {
				
			}
			else if(input == 4) {
				
			}
			else if(input == 5) {
				
			}
			else if(input == 6) {
				
			}
			else if(input == 7) {
				
			}
			else if(input == 8) {
				
			}
			else if(input == 9) {
				
			}else {
				cls();
				StartGame.Play(TimeGame.time);
			}
		}
	}
	
	public void start() {
		
		if(!runinput) {
			inputthread = new Thread(this);
			inputthread.start();
			runinput = true;
		}
		
	}
	
	public void stop() {
		runinput = false;
	}

}
