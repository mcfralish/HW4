import java.util.*;

public class NBA {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println();

		// Construct Team Heat
		System.out.println("Creating the NBA Team \"Heat\".");
		NBATeam heat = new NBATeam("Heat");
		addPlayers(heat);
		
		
		// Construct Team Spurs
		System.out.println("Creating the NBA Team \"Spurs\".");
		NBATeam spurs = new NBATeam("Spurs");
		addPlayers(spurs);
		
		// Simulates Games
		System.out.println("Game on Now...");
		System.out.println();
		while(heat.getWins()<7&&heat.getLosses()<7) {
			double win = Math.random();
			if (win>.5) heat.winGame(spurs);
			else spurs.winGame(heat);
		}
		
		// Prints Results
		if (heat.getWins()==7) System.out.println("Heat win the series!\n");
		else System.out.println("Spurs win the series!\n");
		System.out.println(heat);
		System.out.println();
		System.out.println(spurs);
		
	}
	
	public static void addPlayers(NBATeam name) {
		String ifAddPlayer;
		String playerName;
		System.out.println("Add a player to the"+ name.getTeamName()+ "? (yes/no)");
		ifAddPlayer = sc.next();
		while(!ifAddPlayer.equalsIgnoreCase("yes")&&!ifAddPlayer.equalsIgnoreCase("no")) {
			System.out.println("Invalid Entry.");
			System.out.println("Add a player to the \"Heat\"? (yes/no");
			ifAddPlayer = sc.next();
		}
		
		while (ifAddPlayer.equalsIgnoreCase("yes")) {
			System.out.println("What is the name to be added?");
			playerName = sc.next();
			name.addAPlayer(playerName);
			
			System.out.println("Add another player to the"+ name.getTeamName()+"? (yes/no)");
			ifAddPlayer = sc.next();
			while(!ifAddPlayer.equalsIgnoreCase("yes")&&!ifAddPlayer.equalsIgnoreCase("no")) {
				System.out.println("Invalid Entry.");
				System.out.println("Add a player to the \"Heat\"? (yes/no");
				ifAddPlayer = sc.next();
			}
		}
	}

}
