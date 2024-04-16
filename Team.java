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

		private static ArrayList<Player> roster = new ArrayList<Player>();
		private static int teamOwner;
		private static String teamName;
		private static Player catcher;
		private static Player pitcher1;
		private static Player pitcher2;
		private static Player pitcher3;
		private static Player pitcher4;
		private static Player pitcher5;
		private static Player firstbase;
		private static Player secondbase;
		private static Player thirdbase;
		private static Player shortstop;
		private static Player rightfield;
		private static Player centerfield;
		private static Player leftfield;
		private static int draftRound = 1;
		
//**********************************CONSTRUCTORS****************************************
		
		public Team() {
			
			Scanner input = new Scanner(System.in);
			int num = 0;
			boolean repeat = true;
			while (repeat) {
			repeat = false;
			System.out.print("\nEnter a number for the Team: " );
				try {
					num = input.nextInt();
					input.nextLine();
				}
				catch (InputMismatchException ex) {
					System.out.println("Input Mismatch. Try Again");
					input.next();
					repeat = true;
				}
				
				System.out.print("Enter a team name: " );
				teamName = input.nextLine();
			}
			
			teamOwner = num;
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
			
			roster.add(catcher);
			roster.add(pitcher1);
			roster.add(pitcher2);
			roster.add(pitcher3);
			roster.add(pitcher4);
			roster.add(pitcher5);
			roster.add(firstbase);
			roster.add(secondbase);
			roster.add(thirdbase);
			roster.add(shortstop);
			roster.add(rightfield);
			roster.add(centerfield);
			roster.add(leftfield);
			
			
			
			System.out.println("\nTeam " + teamOwner + " successfully created\n");
		}

//***********************************METHODS********************************************
	//method to list the entire roster of the current team
	public static void listRoster() {
	
		for (int i = 0; i < roster.size(); i++) {
			System.out.println(roster.get(i).getPosition() + ": " + roster.get(i).getPlayerName());      //check Player class for either data member or toString to pull the name
		} 
}//end listRoster
	
	//method for listing roster by draft order
	
	public static void stars() {
		System.out.println("Player Name     \tPosition\tDrafted");
		for (int i = 0; i < 13; i++) {
			for(int j = 0; j < roster.size(); j++) {
				if (roster.get(j).getDraftPosition() == i)
					System.out.println(roster.get(j).getPlayerName() + "\t" + roster.get(j).getPosition() + roster.get(j).getDraftPosition());
			}
		}//end for loop
	}//end stars method
	
	//method to identify a player as being drafted by another team
	public static void oDraft() {
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter player name that was drafted: ");
		String name = input.nextLine();
		
		boolean found = false;                        //marker to identify if the player was found int he database
		for (int i = 0; i < Driver.playerDB.size(); i++) {         //For each player in the database, try to match the name
			if (name.equals(Driver.playerDB.get(i).getPlayerName()));{       //Found the player with the desired name
				found = true;
				Driver.playerDB.get(i).setFantasyTeam("Drafted");           //indicates that a player has been drafted by someone
				Driver.playerDB.get(i).setDraftPosition(draftRound);
			} //end if statement
		} //end for loop
		input.close();
	}//end oDraft
	
	//method to draft a player onto current team
	public static void iDraft() {
		Scanner input = new Scanner(System.in);
		System.out.print("\nEnter player name you wish to draft: ");
		String name = input.nextLine();
		Player draftee = new Player();  			//Empty player object
		String position = "";
		boolean found = false;                        //marker to identify if the player was found int he database
		for (int i = 0; i < Driver.playerDB.size(); i++) {         //For each player in the database, try to match the name
			if (name.equals(Driver.playerDB.get(i).getPlayerName()));{       //Found the player with the desired name
				found = true;
				draftee = Driver.playerDB.get(i);
				position = draftee.getPosition();
				position.toLowerCase();
				draftee.setDraftPosition(draftRound);
				
				
				if (position.equals("catcher")) {
					catcher = draftee;
					Driver.playerDB.get(i).setFantasyTeam(teamName);
				}
				else if(position.equals("pitcher")) {
					if(pitcher1 == null)
						pitcher1 = draftee;
					else if (pitcher2 == null)
						pitcher2 = draftee;
					else if (pitcher3 == null)
						pitcher3 = draftee;
					else if (pitcher4 == null)
						pitcher4 = draftee;
					else if (pitcher5 == null)
						pitcher5 = draftee;
					else {
						System.out.println("All pitcher positions are filled");
						return;
					}
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
		
	}//end of iDraft
	
	//method to release a player as a Free Agent
	public static void release() {
		System.out.println("Player released");
	}
	
	public static void endRound() {
		draftRound++;
	}

	public static boolean hasPosition(String pos){
		switch(pos){
			case "C":
				if(catcher == null){
					return false;
				}else{
					return true;
				}
			case "1B":
				if(firstbase == null){
					return false;
				}else{
					return true;
				}
			case "2B":
				if(secondbase == null){
					return false;
				}else{
					return true;
				}
			case "3B":
				if(thirdbase == null){
					return false;
				}else{
					return true;
				}
			case "SS":
				if(shortstop == null){
					return false;
				}else{
					return true;
				}
			case "LF":
				if(leftfield == null){
					return false;
				}else{
					return true;
				}
			case "CF":
				if(centerfield == null){
					return false;
				}else{
					return true;
				}	
			case "RF":
				if(rightfield == null){
					return false;
				}else{
					return true;
				}
			default:
				return false;	
		}
	}
	
	public static int displayDraftRound() {
		return draftRound;
	}
	
	public static String getTeamName() {
		return teamName;
	}
	
	public static void setTeamName(String string) {
		teamName = string;
	}
	
	
	
	
	
}
