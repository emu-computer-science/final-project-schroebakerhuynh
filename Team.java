/*
 * Programmer: Adam Schroeder
 * Project:    Final Project - Fantasy Baseball
 * Course:     COSC 381, Sp '24
 *  
 */

package main;

import java.util.*;
import java.io.*;

public class Team {
	//included data members
	private ArrayList<Player> roster;
	private ArrayList<Player> freeAgents;
	private ArrayList<Player> allPlayers;
	private int teamOwner;
	private String teamName;
	

	
//*********************************INITIALIZATION***************************************
	public void initialize() {
		
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
	public void oDraft() {
		System.out.println("oDraft completed");
	}//end oDraft
	
	//method to draft a player onto current team
	public void iDraft() {
		System.out.println("iDraft completed");
	}
	
	//method to release a player as a Free Agent
	public void release() {
		System.out.println("Player released");
	}
	
	
	
	
	
}
