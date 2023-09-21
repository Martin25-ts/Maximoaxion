package player;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	
	Scanner sc = new Scanner(System.in);
	private String userName,paswword;
	Integer score;
	
	
	
	public Player(String userName, String paswword, Integer score) {
		super();
		this.userName = userName;
		this.paswword = paswword;
		this.score = score;
	}
	
	public Player() {
		
	}



	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPaswword() {
		return paswword;
	}

	public void setPaswword(String paswword) {
		this.paswword = paswword;
	}
	
	
	//karena method register berhubungan dengan player makanya
	//mehodnya ditaro di class player biar gambang di debug atau di cari methodnya
	public ArrayList<Player> register(ArrayList<Player> user){
		
		String UserName,Password;
		Integer Score;
		
		do {
			System.out.print("Enter username [5..20]: ");
			UserName = sc.nextLine();
		} while(UserName.length() <= 4 || UserName.length() >= 21 || validatedoubleUser(user, UserName) == false);
		
		
		do {
			System.out.print("Enter password [5..20]: ");
			Password = sc.nextLine();
		} while (Password.length() <= 4 || Password.length() >= 21 );
		
		
		user.add(new Player(UserName, Password, 0));
		
		return user;
		
	}
	

	public int LogUser(ArrayList<Player> user, String us, String pass){
		int i = 0;
		
		for (Player player : user) {
			if(player.getUserName().equals(us) == true) {
				if(player.getPaswword().equals(pass) == true) return i;
				else break;
			}
			i++;
		}
		System.out.println("User not found...\r\n" + 
				"Press [Enter] to continue..");
		return -9999;
		
	}
	
	// Method untuk memastikan user tidak dapat mendaftarkan nama yang sudah terdaftar
	public boolean validatedoubleUser(ArrayList<Player> user,String us) {
		
		for (Player player : user) {
			if(player.getUserName().equals(us) == true) {
				return false;
			}
		}
		
		return true;
	}
	

}
