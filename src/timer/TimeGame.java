package timer;



import game.StartGame;
import method.Callable;
import player.AtrtibutInGame;

public class TimeGame implements Runnable, Callable {
	private Thread game;
	
	AtrtibutInGame InGame = null;
	private static boolean gameRunning = false;
	static public Integer time;
	public TimeGame(AtrtibutInGame InGame) {
		this.InGame = InGame;
		gameRunning = false;
		time = 1;
	}

	@Override
	public void run() {

		cls();
		StartGame.Play(time);
		while (gameRunning) {
			
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(time + 1 >= 6) {
				time = 0;
			}else {
				time++;
			}
			
			System.out.println("sudah 20 pengurangan heatlh");
			cls();
			StartGame.Play(time);
		}
		
	}
	public static synchronized boolean isRunning() {
		return gameRunning;
	}
	
	
	
	public void start() {
		
		if(!gameRunning) {
			game = new Thread(this);
			game.start();
			gameRunning = true;
		}
		

	}
	
	
	
	public synchronized static void stop() {
		
		gameRunning = false;
		time = 1;
		
		StartGame.Play(time);
	}

	public void over( ) {
		gameRunning = false;
		
		
	}

}
