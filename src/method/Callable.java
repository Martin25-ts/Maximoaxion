package method;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import game.Event;
import game.GameAtribut;
import game.StartGame;
import player.AtrtibutInGame;
import timer.TimeGame;

;

public interface Callable {
	Scanner sc = new Scanner(System.in);
	default void logoMaximoaxion() {
		System.out.println("███╗░░░███╗░█████╗░██╗░░██╗██╗███╗░░░███╗░█████╗░░█████╗░██╗░░██╗██╗░█████╗░███╗░░██╗");
        System.out.println("████╗░████║██╔══██╗╚██╗██╔╝██║████╗░████║██╔══██╗██╔══██╗╚██╗██╔╝██║██╔══██╗████╗░██║");
        System.out.println("██╔████╔██║███████║░╚███╔╝░██║██╔████╔██║██║░░██║███████║░╚███╔╝░██║██║░░██║██╔██╗██║");
        System.out.println("██║╚██╔╝██║██╔══██║░██╔██╗░██║██║╚██╔╝██║██║░░██║██╔══██║░██╔██╗░██║██║░░██║██║╚████║");
        System.out.println("██║░╚═╝░██║██║░░██║██╔╝╚██╗██║██║░╚═╝░██║╚█████╔╝██║░░██║██╔╝╚██╗██║╚█████╔╝██║░╚███║");
        System.out.println("╚═╝░░░░░╚═╝╚═╝░░╚═╝╚═╝░░╚═╝╚═╝╚═╝░░░░░╚═╝░╚════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░╚════╝░╚═╝░░╚══╝");
	}
	
	default void logoDied() {
		System.out.println("██╗░░░██╗░█████╗░██╗░░░██╗??██████╗░██╗███████╗██████╗░");
        System.out.println("╚██╗░██╔╝██╔══██╗██║░░░██║??██╔══██╗██║██╔════╝██╔══██╗");
        System.out.println("░╚████╔╝░██║░░██║██║░░░██║??██║░░██║██║█████╗░░██║░░██║");
        System.out.println("░░╚██╔╝░░██║░░██║██║░░░██║??██║░░██║██║██╔══╝░░██║░░██║");
        System.out.println("░░░██║░░░╚█████╔╝╚██████╔╝??██████╔╝██║███████╗██████╔╝");
        System.out.println("░░░╚═╝░░░░╚════╝░░╚═════╝░??╚═════╝░╚═╝╚══════╝╚═════╝░");
        
        System.out.println("\nPress enter to Conitnue...");
	}
	
	
	default void cls() {
		for (int i = 0; i < 35; i++) {
			System.out.println();
		}
	}
	
	
	
	default void threadSleep(int a) {
		Thread n = new Thread();
		try {
			n.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	default ArrayList<GameAtribut> ListGameAtribut (){
		
		ArrayList<GameAtribut> newlist = new ArrayList<>();
		
		newlist.add(new Event("Morning", "The birds are out and the sky is blue - it's morning" , "Volcanic Eruption", "The ground is shaking and the sky is darkened by ash - a volcano has erupted!", "Damage Random 1 - 5."));
		newlist.add(new Event("Night", "The light is dim and the shadows are long - it's night. " , "Volcanic Eruption", "The ground is shaking and the sky is darkened by ash - a volcano has erupted!", "Damage Random 1 - 5."));
		newlist.add(new Event("Night", "The light is dim and the shadows are long - it's night. " , "Mssive Thunderstorm", "The Sky is dark and lightning is striking everywhere - a massive thunderstorm is raging!", "Damage Random 3 - 7."));
		newlist.add(new Event("Morning", "The birds are out and the sky is blue - it's morning" , "Mssive Thunderstorm", "The Sky is dark and lightning is striking everywhere - a massive thunderstorm is raging!", "Damage Random 3 - 7."));
		newlist.add(new Event("Night", "The light is dim and the shadows are long - it's night. " , "Massive bird migration", "The sky is filled with birds of all kinds, moving in a massive migration.", "Damage Random 1 - 3."));
		
		newlist.add(new Event("Morning", "The birds are out and the sky is blue" , "Massive earthquake", "The ground is shaking violently and buildings are collapsing - a massive earthquake is underway!", "Damage Random 1 - 4."));
		newlist.add(new Event("Morning", "The birds are out and the sky is blue" , "Solar eclipse", "The sun is obscured by the moon, casting an eerie shadow on the world - it's a solar eclipse!", "Prevent player from performing gathering actions. Damage Random 4 – 8."));
		newlist.add(new Event("Morning", "The birds are out and the sky is blue" , "Scorching sun", "The sun is burning hot and the air is stifling - it's a scorching day!", "Prevent player from gathering water."));
		
		newlist.add(new Event("Night", "The light is dim and the shadows are long - it's night. " , "Blood moon", "The sky is filled with birds of all kinds, moving in a massive migration.The moon is red and the sky is eerie - it's a blood moon!", "Damage Random 1 - 3."));
		newlist.add(new Event("Night", "The light is dim and the shadows are long - it's night. " , "Massive bats invasion", "The sky is filled with swarms of bats, covering the world in darkness.", "Damage Random 1 - 3."));
		newlist.add(new Event("Night", "The light is dim and the shadows are long - it's night. " , "Alien invasion", "Strange objects are falling from the sky and people are running in fear - it's an alien invasion!", "Damage Random 1 - 3."));
		newlist.add(new Event("Night", "The light is dim and the shadows are long - it's night. " , "Blackout", "The world is dark and silent, as a massive blackout has plunged everything into darkness.", "Damage Random 1 - 3."));
		
		newlist.add(new GameAtribut("Dawn", "The darkness is fading and the sky is getting brighter - it's dawn"));
		newlist.add(new GameAtribut("Dusk", "The world is getting quiter and the air is getting cooler - it's down"));
		newlist.add(new GameAtribut("Noon", "The day is half over and the light is bright - it's noon."));
		newlist.add(new GameAtribut("Midnight", "The darkness is fading and the sky is getting brighter - it's dawn"));

		
		return newlist;
		
		
	}
	default int inputvalidate(int a) {
		
		
		try {
			a = sc.nextInt();
		} catch (InputMismatchException e) {
			sc.nextLine();
			return -9999;
		}
		
		return a;
	}

}
