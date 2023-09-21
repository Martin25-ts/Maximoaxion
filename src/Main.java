
import java.util.ArrayList;
import java.util.Scanner;

import game.StartGame;
import method.*;
import method.Readable;
import player.*;
import timer.*;

public class Main implements Callable , Writeable , Readable{

	ArrayList<Player> user = new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);
	Integer log;
	
	public void menuUtama() {
		
		/*
		 * Saat masuk ke menu utama pastikan arraylist user di kosongkan terlebih dahulu,
		 * agar tidak terjadu double data saat nanti akan dimasukan data dari save.txt
		 * 
		 * namun sebelum dikosongkan pastikan semua perubahan sudah ditulis dalam save.txt
		 */
		cls();
		user.removeAll(user);
		user = readfileUser(user);
		
		logoMaximoaxion(); // Method untuk menampilkan logo MAXIMOAXION
		
		
		int choise = 0;
		System.out.println("1. Play");
		System.out.println("2. Register");
		System.out.println("3. Highscore");
		System.out.println("4. How to play");
		System.out.println("5. Exit");
		do {
			System.out.print(">> ");
			choise = inputvalidate(choise);
		} while (choise <= 0 || choise  >= 6);
		
		if(choise == 1) {
			Player log = new Player();
			String us,pass;
			do {
				System.out.print("Enter username [5..20]: ");
				us = sc.nextLine();
			} while(us.length() <= 4 || us.length() >= 21 );
			
			
			do {
				System.out.print("Enter password [5..20]: ");
				pass = sc.nextLine();
			} while (pass.length() <= 4 || pass.length() >= 21 );
			
			
			this.log = log.LogUser(user, us, pass);
			
			if(this.log == -9999) {
				sc.nextLine();
				menuUtama();
			}else {
				StartGame newGame = new StartGame();
				
				menuUtama();
			}
			
			
		}else if(choise == 2) {
			
			Player baru = new Player();
			
			user.addAll(baru.register(user));
			writefileUser(user);

			menuUtama();
		}else if(choise == 3) {
			ArrayList<Player> sort = user;
			sort.sort((o2, o1) -> o1.getScore().compareTo(o2.getScore()));
			System.out.println("========Highscore========");
			for (Player player : sort) {
				System.out.printf("%-30s : %2d%n", player.getUserName(), player.getScore());
			}
			System.out.println("\n\n\nPress [Enter] to continue..");
			sc.nextLine();
			sc.nextLine();
			
			menuUtama();
		}else if(choise == 4) {
			
			System.out.println("\nThis game goal is to survive as long as possible.\r\n" + 
					"However there will be disaster and event that will deal you damage.\r\n" + 
					"In order to survive you must gather resources, build shelter, and never go out at night.\r\n" + 
					"Goodluck! you gon need that\r\n" + 
					"\r\n" + 
					"Press [Enter] to continue..");
			sc.nextLine();
			sc.nextLine();
			menuUtama();
			
		}
		
	}
	
		
	public Main() {
		
		menuUtama();
		
		
	}

	public static void main(String[] args) {

		new Main();
	}

}
