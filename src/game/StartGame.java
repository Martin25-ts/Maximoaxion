package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


import method.Callable;
import player.AtrtibutInGame;
import timer.InputThread;
import timer.TimeGame;

public class StartGame implements Callable{
	static Random rand = new Random();
	public static AtrtibutInGame InGame = new AtrtibutInGame();
	public static boolean dead = true;
	static TimeGame tg = new TimeGame(InGame);
	static InputThread it = new InputThread();
	public static ArrayList<GameAtribut> listevent = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	
	
	
	
	public  synchronized static AtrtibutInGame buildShelter(int a) {
		
		
		return InGame;
	}
	public  synchronized static AtrtibutInGame improveShelter(int a) {
		
		
		
		
		return InGame;
	}
	public  synchronized static AtrtibutInGame consumeFood(int a) {
		int maxHunnger = 100;
		AtrtibutInGame nowInGame = getInGame();
		
		if(nowInGame.getHunger() + 10 <= 100) {
			if(nowInGame.getFood() - 10 >= 0) {
				nowInGame.setHunger(nowInGame.getHunger() + 10);
				nowInGame.setFood(nowInGame.getFood() - 10);
			}else if(nowInGame.getFood() - 10 <= -1){
				nowInGame.setHunger(nowInGame.getHunger() + nowInGame.getFood());
				nowInGame.setFood(0);
			}
		}else if(nowInGame.getHunger() + 10 >= 101) {
			if(nowInGame.getFood() - (100 - nowInGame.getHunger()) <= -1) {
				nowInGame.setHunger(nowInGame.getHunger() + nowInGame.getFood());
				nowInGame.setFood(0);
			}else if(nowInGame.getFood() - (100 - nowInGame.getHunger()) >= 1) {
				nowInGame.setHunger(nowInGame.getHunger() + (100 - nowInGame.getHunger()));
				nowInGame.setFood(nowInGame.getFood() - (100 - nowInGame.getHunger()));
			}
		}
		
		return nowInGame;
	}
	
	public  synchronized static AtrtibutInGame drinkWater(int a) {
			
			
			return InGame;
		}
	
	public  synchronized static AtrtibutInGame useHerbs(int a) {
		
		
		return InGame;
	}



	
	public  synchronized static AtrtibutInGame randomdecrease() {
		AtrtibutInGame nowInGame = getInGame();
		int newRandom = rand.nextInt(6);
		int newRandom2 = 5 - newRandom;
		
		nowInGame.setHunger(nowInGame.getHunger() - newRandom);
		nowInGame.setThirst(nowInGame.getThirst() - newRandom2);
		
		return nowInGame;
	}
	
	public  synchronized static AtrtibutInGame gatherWood() {
		AtrtibutInGame nowInGame = getInGame();
		
		nowInGame.setWood(nowInGame.getWood() + (rand.nextInt(10) + 1));
		
		return nowInGame;
	}
	
	
	
	public synchronized static AtrtibutInGame getInGame() {
		
		return InGame;
	}
	public synchronized static AtrtibutInGame nextDay(){
		AtrtibutInGame nowInGame = getInGame();
		nowInGame.setDay(nowInGame.getDay() + 1);
		return nowInGame;
	}
	public synchronized static AtrtibutInGame incrementHealt(int a) {
		
		
		
		if(InGame.getHealth() - a <= -1) {
			InGame.setHealth(InGame.getHealth() - a);
			dead = false;
			tg.over();
			System.out.println(dead);
		}else InGame.setHealth(InGame.getHealth() - a);
			
		return InGame;
	}
	
	public synchronized static void gameover() {
		dead = false;
	}
	public synchronized static boolean check() {
		
		if(InGame.getHealth() <= -1) {
			return false;
		}
		
		return true;
		
	}
	
	
	
	/*
	 * Method static untuk memanggil thread start dan stop untuk thread
	 * yang menjalankan waktu (20 detik)
	 */
	public synchronized static void stopthread() {
		TimeGame.stop();
	}
	public synchronized static void startthread() {
		tg.start();
	}
	
	
	public StartGame() {
		listevent = ListGameAtribut();
		tg.start();
		it.start();
		
		while (dead) {
			
		}
		
		logoDied();
		
	}
	
	public static String timeNow(int a) {
		
		
			for (GameAtribut gameAtribut : listevent) {
				if(a == 0 && gameAtribut.getTimeDay().equals("Dawn")) {
					System.out.println(gameAtribut.getDescription());
					break;
				}
				else if(a == 1 && gameAtribut.getTimeDay().equals("Morning")){
					System.out.println(gameAtribut.getDescription());
					break;
				}
				else if(a == 2 && gameAtribut.getTimeDay().equals("Noon")){
					System.out.println(gameAtribut.getDescription());
					break;
				}
				else if(a == 3 && gameAtribut.getTimeDay().equals("Dusk")){
					System.out.println(gameAtribut.getDescription());
					break;
				}
				else if(a == 4 && gameAtribut.getTimeDay().equals("Night")){
					System.out.println(gameAtribut.getDescription());
					break;
				}
				else if(a == 5 && gameAtribut.getTimeDay().equals("Midnight")){
					System.out.println(gameAtribut.getDescription());
					InGame = nextDay();
					break;
				}
				
				
			}
		
		
		return "";
	}
	
	public synchronized static void viewheaderGame(int time) {
		int sum = 0;
		System.out.println("Day " + InGame.getDay());
		System.out.println("------\n");
		
		
		timeNow(time);
		System.out.println("Disini Taro Keterangan event\n\n");
		
		
		System.out.print("Health : [");
		for (int i = 0; i < 20; i++) { 
			
			if(sum < (int) Math.ceil(InGame.getHealth()/5)) {
				System.out.print("|");
				sum++;
			}else {
				System.out.print(" ");
				sum++;
			}
			
			
		}
		System.out.println("] (" + InGame.getHealth() + "%)");
		
		sum = 0;
		System.out.print("Hunger : [");
		for (int i = 0; i < 20; i++) { 
			
			if(sum < (int) Math.ceil(InGame.getHunger()/5) ) {
				System.out.print("|");
				sum++;
			}else {
				System.out.print(" ");
				sum++;
			}
			
			
		}
		System.out.println("] (" + InGame.getHunger()  + "%)");
		
		
		sum = 0;
		System.out.print("Thirst : [");
		for (int i = 0; i < 20; i++) { 
			
			if(sum < (int) Math.ceil(InGame.getThirst()/5)) {
				System.out.print("|");
				sum++;
			}else {
				System.out.print(" ");
				sum++;
			}
			
			
		}
		System.out.println("] (" + InGame.getThirst() + "%)");
		
		sum = 0;
		System.out.print("Shelter : [");
		for (int i = 0; i < 20; i++) { 
			
			if(sum < (int) Math.ceil(InGame.getShelter()/5)) {
				System.out.print("|");
				sum++;
			}else {
				System.out.print(" ");
				sum++;
			}
			
			
		}
		System.out.println("] (" + InGame.getShelter() * 5 + "%)\n");
		
		System.out.println("Resources : ");
		System.out.println("- Wood : " + InGame.getWood());
		System.out.println("- Food : " + InGame.getFood());
		System.out.println("- Water : " + InGame.getWater());
		System.out.println("- Herb : " + InGame.getHerb());
		
	}
	public synchronized static void Play(int time) {
		
		viewheaderGame(time);
		System.out.println("Actions:\r\n" + 
				"1. Gather wood\r\n" + 
				"2. Build shelter\r\n" + 
				"3. Hunt for food\r\n" + 
				"4. Consume food\r\n" + 
				"5. Collect water\r\n" + 
				"6. Drink water\r\n" + 
				"7. Gather herbs\r\n" + 
				"8. Use herbs\n");
		
		System.out.print("Enter 0 to ");
		if(TimeGame.isRunning()) {
			System.out.println("pause");
		}else {
			System.out.println("unpause");
		}
		System.out.print("What do you want to do? [1..8]: ");
		
	}

}
