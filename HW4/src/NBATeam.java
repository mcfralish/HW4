/* Michael C Fralish
 * 03/06/2020
 * PID: 001-17-6489
 * Title: NBATeam
 * This is a class file for the object NBATeam. It holds states and performs functions for the teams.
 */
import java.util.*;
public class NBATeam {
	
	private String sTeamName;
	private int nWin;
	private int nLoss;
	private int numPlayers = 0;
	
	private String[] playerArray;
	
	public NBATeam(String name) {
		sTeamName = name;
		nWin = 0;
		nLoss = 0;
		playerArray = new String[0];
	}
	
	public String toString() {
		return sTeamName+"\n"+Arrays.toString(playerArray)+"\nWins: "+nWin+"\nLosses: "+nLoss;
	}
	
	public void addAPlayer(String name) {
		numPlayers++;
		String[] tempPlayers = new String[numPlayers];
		for (int i=0;i<playerArray.length;i++) {
			tempPlayers[i]=playerArray[i];
		}
		tempPlayers[numPlayers-1]=name;
		playerArray=tempPlayers;
	}
	
	public void winGame(NBATeam opponent) {
		nWin++;
		opponent.loseGame();
	}
	
	public void loseGame() {
		nLoss++;
	}
	
	public String getTeamName() {
		return sTeamName;
	}
	
	public int getWins() {
		return nWin;
	}
	
	public int getLosses() {
		return nLoss;
	}

}
