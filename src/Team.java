/*
 * Programmer: Adam Schroeder
 * Project:    Final Project - Fantasy Baseball
 * Course:     COSC 381, Sp '24
 *  
 */


import java.util.*;

public class Team {
	
//**********************************DATA MEMBERS****************************************
		//private ArrayList<Player> freeAgents;  //These will be removed and added to the Driver class as new Team objects
		//private ArrayList<Player> allPlayers;  // ^      ^                            ^                        ^

		public ArrayList<Player> roster = new ArrayList<Player>();
		public String teamName;
		public Player catcher;
		public Player pitcher1;
		public Player pitcher2;
		public Player pitcher3;
		public Player pitcher4;
		public Player pitcher5;
		public Player firstbase;
		public Player secondbase;
		public Player thirdbase;
		public Player shortstop;
		public Player rightfield;
		public Player centerfield;
		public Player leftfield;
		
//**********************************CONSTRUCTORS****************************************
		
		public Team(String str) {

			catcher = null;
			pitcher1 = null;
			pitcher2 = null;
			pitcher3 = null;
			pitcher4 = null;
			pitcher5 = null;
			firstbase = null;
			secondbase = null;
			thirdbase = null;
			shortstop = null;
			rightfield = null;
			centerfield = null;
			leftfield = null;
			teamName = str;
			
			
		}

		public boolean hasFullPitchingStaff(){
			if(this.pitcher1 == null || this.pitcher2 == null || this.pitcher3 == null || this.pitcher4 == null || this.pitcher5 == null){
				return false;
			}else{
				return true;
			}
		}

		public boolean hasPosition(String pos){
			switch(pos){
				case "C":
					if(this.catcher == null){
						return false;
					}else{
						return true;
					}
				case "1B":
					if(this.firstbase == null){
						return false;
					}else{
						return true;
					}
				case "2B":
					if(this.secondbase == null){
						return false;
					}else{
						return true;
					}
				case "3B":
					if(this.thirdbase == null){
						return false;
					}else{
						return true;
					}
				case "SS":
					if(this.shortstop == null){
						return false;
					}else{
						return true;
					}
				case "LF":
					if(this.leftfield == null){
						return false;
					}else{
						return true;
					}
				case "CF":
					if(this.centerfield == null){
						return false;
					}else{
						return true;
					}	
				case "RF":
					if(this.rightfield == null){
						return false;
					}else{
						return true;
					}
				default:
					return false;	
			}
		}

		public void addPitcher(Player player, int draftCounter){
			if(this.pitcher1 == null){
				this.pitcher1 = player;
			} else if(this.pitcher2 == null){
				this.pitcher2 = player;
			} else if(this.pitcher3 == null){
				this.pitcher3 = player;
			} else if(this.pitcher4 == null){
				this.pitcher4 = player;
			} else if(this.pitcher5 == null){
				this.pitcher5 = player;
			}
			this.roster.add(player);
			player.setFantasyTeam(this.teamName);
			player.setDraftPosition(draftCounter);
		}

		public void addPlayer(Player player, int draftCounter){
			switch(player.getPosition()){
				case "C":
					this.catcher = player;
					this.roster.add(player);
					player.setFantasyTeam(this.teamName);
					player.setDraftPosition(draftCounter);
					break;
				case "1B":
					this.firstbase = player;
					this.roster.add(player);
					player.setFantasyTeam(this.teamName);
					player.setDraftPosition(draftCounter);
					break;
				case "2B":
					this.secondbase = player;
					this.roster.add(player);
					player.setFantasyTeam(this.teamName);
					player.setDraftPosition(draftCounter);
					break;
				case "3B":
					this.thirdbase = player;
					this.roster.add(player);
					player.setFantasyTeam(this.teamName);
					player.setDraftPosition(draftCounter);
					break;
				case "SS":
					this.shortstop = player;
					this.roster.add(player);
					player.setFantasyTeam(this.teamName);
					player.setDraftPosition(draftCounter);
					break;
				case "LF":
					this.leftfield = player;
					this.roster.add(player);
					player.setFantasyTeam(this.teamName);
					player.setDraftPosition(draftCounter);
					break;
				case "CF":
					this.centerfield = player;
					this.roster.add(player);
					player.setFantasyTeam(this.teamName);
					player.setDraftPosition(draftCounter);
					break;	
				case "RF":
					this.rightfield = player;
					this.roster.add(player);
					player.setFantasyTeam(this.teamName);
					player.setDraftPosition(draftCounter);
					break;
				default:
					break;
			}
		}

		public void displayTeam(){
			System.out.println("TEAM: "+this.teamName);
			System.out.println("C: " + (this.catcher != null ? this.catcher.getPlayerName() : "N/A"));
			System.out.println("1B: " + (this.firstbase != null ? this.firstbase.getPlayerName() : "N/A"));
			System.out.println("2B: " + (this.secondbase != null ? this.secondbase.getPlayerName() : "N/A"));
			System.out.println("3B: " + (this.thirdbase != null ? this.thirdbase.getPlayerName() : "N/A"));
			System.out.println("SS: " + (this.shortstop != null ? this.shortstop.getPlayerName() : "N/A"));
			System.out.println("LF: " + (this.leftfield != null ? this.leftfield.getPlayerName() : "N/A"));
			System.out.println("CF: " + (this.centerfield != null ? this.centerfield.getPlayerName() : "N/A"));
			System.out.println("RF: " + (this.rightfield != null ? this.rightfield.getPlayerName() : "N/A"));
			System.out.println("P1: " + (this.pitcher1 != null ? this.pitcher1.getPlayerName() : "N/A"));
			System.out.println("P2: " + (this.pitcher2 != null ? this.pitcher2.getPlayerName() : "N/A"));
			System.out.println("P3: " + (this.pitcher3 != null ? this.pitcher3.getPlayerName() : "N/A"));
			System.out.println("P4: " + (this.pitcher4 != null ? this.pitcher4.getPlayerName() : "N/A"));
			System.out.println("P5: " + (this.pitcher5 != null ? this.pitcher5.getPlayerName() : "N/A"));
			
		}

		public void stars(){
			this.reorderForStars();
			System.out.println("TEAM: "+this.teamName);
			for(Player player : this.roster){
				String name = player.getPlayerName();
				String position = player.getPosition();
				String draftPos = String.valueOf(player.getDraftPosition());

				System.out.println(position+": "+name+" DRAFTED: "+draftPos);
			}
		}

		public void reorderForStars(){
			Collections.sort(this.roster, (p1, p2) -> Integer.compare(p1.getDraftPosition(), p2.getDraftPosition()));
		}
}
