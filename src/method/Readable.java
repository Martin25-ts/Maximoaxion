package method;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import player.Player;

public interface Readable {

	default ArrayList<Player> readfileUser(ArrayList<Player> user) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("res/save.txt"));
			
			String Line;
			while((Line = reader.readLine()) != null) {
				String[] splitter = Line.split("#");
				user.add(new Player(splitter[0], splitter[1], Integer.parseInt(splitter[2])));
			}
			reader.close();

		} catch (Exception e) {
		}
		
		return user;
		
	}
}
