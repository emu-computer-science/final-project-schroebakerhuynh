/*
 * Programmer: Adam Schroeder
 * Project:    Final Project - Fantasy Baseball
 * Course:     COSC 381, Sp '24
 *  
 */


import java.util.*;
import java.io.*;

public class Team {
	
//**********************************DATA MEMBERS****************************************
		//private ArrayList<Player> freeAgents;  //These will be removed and added to the Driver class as new Team objects
		//private ArrayList<Player> allPlayers;  // ^      ^                            ^                        ^

		private ArrayList<Player> roster;
		private int teamOwner;
		private String teamName;
		private Player catcher;
		private Player pitcher;
		private Player firstbase;
		private Player secondbase;
		private Player thirdbase;
		private Player shortstop;
		private Player rightfield;
		private Player centerfield;
		private Player leftfield;
		
//**********************************CONSTRUCTORS****************************************
		
		public Team() {
			
			System.out.println("Running Team");
			Scanner input = new Scanner(System.in);
			int num = 0;
			boolean repeat = true;
			while (repeat) {
			repeat = false;
			System.out.print("\nEnter a number for the Team: " );
				try {
					num = input.nextInt();
				}
				catch (InputMismatchException ex) {
					System.out.println("Input Mismatch. Try Again");
					input.next();
					repeat = true;
				}
				
				System.out.print("\nEnter a team name: " );
				teamName = input.nextLine();
			}
			input.close();
			
			teamOwner = num;
			catcher = null;
			pitcher = null;
			firstbase = null;
			secondbase = null;
			thirdbase = null;
			shortstop = null;
			rightfield = null;
			centerfield = null;
			leftfield = null;
			
			System.out.println("\nTeam " + teamOwner + " successfully created");
		}

//***********************************METHODS********************************************
	//method to list the entire roster of the current team
	public void listRoster() {
	
		System.out.println("It's a-me! Roster List!");
		//for (int i = 0; i < roster.size(); i++) {
			//System.out.println(i + ": " + roster[i].name);      //check Player class for either data member or toString to pull the name
		//} //end for loop
}//end listRoster
	
	//method to identify a player as being drafted by another team
	public void oDraft(String name) {
		boolean found = false;                        //marker to identify if the player was found int he database
		for (int i = 0; i < Driver.playerDB.size(); i++) {         //For each player in the database, try to match the name
			if (name.equals(Driver.playerDB.get(i).getPlayerName()));{       //Found the player with the desired name
				found = true;
				Driver.playerDB.get(i).setFantasyTeam("Drafted");            //indicates that a player has been drafted by someone
			} //end if statement
		} //end for loop
	}//end oDraft
	
	//method to draft a player onto current team
	public void iDraft(String name) {
		Player draftee = new Player();  			//Empty player object
		String position = "";
		boolean found = false;                        //marker to identify if the player was found int he database
		for (int i = 0; i < Driver.playerDB.size(); i++) {         //For each player in the database, try to match the name
			if (name.equals(Driver.playerDB.get(i).getPlayerName()));{       //Found the player with the desired name
				found = true;
				draftee = Driver.playerDB.get(i);
				position = draftee.getPosition();
				position.toLowerCase();
				
				
				if (position.equals("catcher")) {
					catcher = draftee;
					Driver.playerDB.get(i).setFantasyTeam(teamName);
				}
				else if(position.equals("pitcher")) {
					pitcher = draftee;
					Driver.playerDB.get(i).setFantasyTeam(teamName);
				}
				else if(position.equals("firstbase")) {
					firstbase = draftee;
					Driver.playerDB.get(i).setFantasyTeam(teamName);
				}
				else if(position.equals("secondbase")) {
					secondbase = draftee;
					Driver.playerDB.get(i).setFantasyTeam(teamName);
				}
				else if(position.equals("thirdbase")) {
					thirdbase = draftee;
					Driver.playerDB.get(i).setFantasyTeam(teamName);
				}
				else if(position.equals("shortstop")) {
					shortstop = draftee;
					Driver.playerDB.get(i).setFantasyTeam(teamName);
				}
				else if(position.equals("leftfield")) {
					leftfield = draftee;
					Driver.playerDB.get(i).setFantasyTeam(teamName);
				}
				else if(position.equals("centerfield")) {
					centerfield = draftee;
					Driver.playerDB.get(i).setFantasyTeam(teamName);
				}
				else if(position.equals("rightfield")) {
					rightfield = draftee;
					Driver.playerDB.get(i).setFantasyTeam(teamName);
				}
				else
					System.out.println("\nERROR STATEMENT: You gotta fix your position matching. Player output isn't matching Team input\n");
				
				
			}//end if statement
		}//end for loop
		if (!found)
			System.out.println("\nCould not find that player in the database\n");
	}
	
	//method to release a player as a Free Agent
	public void release() {
		System.out.println("Player released");
	}
	
	
	
	
	
}
