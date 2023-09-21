package method;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import player.Player;

public interface Writeable {
	
	default void writefileUser(ArrayList<Player> user) {
		
		try {
			BufferedWriter writer = new  BufferedWriter(new FileWriter("res/save.txt",true));
				writer.write(user.get(user.size()-1).getUserName() + "#" + user.get(user.size()-1).getPaswword() + "#" + user.get(user.size()-1).getScore() + "\n");
				
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
