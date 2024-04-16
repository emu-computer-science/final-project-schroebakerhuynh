import java.io.*;
import java.util.*;
import java.nio.charset.*;

public class Driver {
    public static ArrayList<Player> playerDB = new ArrayList<Player>();
    public static ArrayList<Player> freeAgents = new ArrayList<Player>();
    public static Scanner scanner = new Scanner(System.in); // Declare scanner as a class-level variable
    
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.readInPlayerFile(new File("mlb_al_batter_stats_2023.txt"), "Batter");
        driver.readInPlayerFile(new File("mlb_al_pitching_stats_2023.txt"), "Pitcher");
        
        help();
        
        boolean running = true;
        
        while (running) {
            System.out.print("\nEnter a command: ");
            String input = scanner.nextLine(); // Read the command and its arguments
            String[] parts = input.split(" ", 2); // Split the input into command and arguments
            
            String command = parts[0].toUpperCase(); // Get the command
            
            switch (command) {
                case "DISPLAY PLAYERS":
                    displayPlayers();
                    break;
                case "SEARCH PLAYER":
                    searchPlayer();
                    break;
                case "IDRAFT":
                    if (parts.length == 2) {
                        idraft(parts[1]);
                    } else {
                        System.out.println("Invalid command. Please specify a player name.");
                    }
                    break;
                case "ODRAFT":
                    if (parts.length == 2) {
                        odraft(parts[1]);
                    } else {
                        System.out.println("Invalid command. Please specify a player name and team.");
                    }
                    break;
                case "OVERALL":
                    if (parts.length == 2) {
                        Team thisTeam = new Team();
                        overall(parts[1], thisTeam);
                    } else {
                        System.out.println("Invalid command. Please specify a position.");
                    }
                    break;
                case "POVERALL":
                    if (parts.length == 2) {
                        Team thisTeamPoverall = new Team();
                        poverall(parts[1], thisTeamPoverall);
                    } else {
                        System.out.println("Invalid command. Please specify a position.");
                    }
                    break;
                case "ADD TEAM":
                    addTeam();
                    break;
                case "DISPLAY":
                    displayTeam();
                    break;
                case "SAVE":
                    save();
                    break;
                case "LOAD":
                    load();
                    break;
                case "QUIT":
                    quit();
                    running = false;
                    break;
                case "RESTORE":
                    restore();
                    break;
                case "EVALFUN":
                    evalFun();
                    break;
                case "PEVALFUN":
                    pevalFun();
                    break;
                case "HELP":
                    help();
                    break;
                default:
                    System.out.println("Invalid command. Please try again or type 'HELP' for available commands.");
                    break;
            }
        }
        
        scanner.close();
    }
    
    public static void displayPlayers() {
  
        int pageSize = 20;
        int currentPage = 0;
        int totalPages = (int) Math.ceil((double) playerDB.size() / pageSize);
    
        Scanner scanner = new Scanner(System.in);
    
        while (currentPage < totalPages) {
            int startIndex = currentPage * pageSize;
            int endIndex = Math.min((currentPage + 1) * pageSize, playerDB.size());
    
            for (int i = startIndex; i < endIndex; i++) {
                Player player = playerDB.get(i);
                System.out.println(player.getPlayerType() + " " + player.getPlayerName() + " " + player.getPosition());
            }
    
            System.out.println("\nPage " + (currentPage + 1) + " of " + totalPages);
            System.out.println("1. Next Page");
            if (currentPage > 0) {
                System.out.println("2. Previous Page");
            }
            System.out.println("3. Return to Menu");
            System.out.println("Enter your choice:");
    
            int choice = scanner.nextInt();
            scanner.nextLine();
    
            switch (choice) {
                case 1:
                    if (currentPage < totalPages - 1) {
                        currentPage++;
                    } else {
                        System.out.println("You are already on the last page.");
                    }
                    break;
                case 2:
                    if (currentPage > 0) {
                        currentPage--;
                    } else {
                        System.out.println("You are already on the first page.");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    
        scanner.close();
    }
    
    public static void searchPlayer() {
        Driver driver = new Driver();
        driver.readInPlayerFile(new File("mlb_al_batter_stats_2023.txt"), "Batter");
        driver.readInPlayerFile(new File("mlb_al_pitching_stats_2023.txt"), "Pitcher");
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the player you want to search for:");
        String playerNameToSearch = scanner.nextLine();
    
        boolean playerFound = false;
        for (Player player : driver.playerDB) {
            if (player.getPlayerName().equalsIgnoreCase(playerNameToSearch)) {
                System.out.println(player.getPlayerType() + " " + player.getPlayerName() + " " + player.getPosition());
                playerFound = true;
                break;
            }
        }
    
        if (!playerFound) {
            System.out.println("Player not found.");
        }
    }

    public static void idraft() {
        System.out.println("IDRAFT...");
    }

    public static void odraft() {
        System.out.println("ODRAFT...");
    }

    public static void overall(String pos, Team thisTeam){
        try {
            pos = pos.trim().toUpperCase();
            if(thisTeam.hasPosition(pos)){
                throw new Exception("TEAM ALREADY CONTAINS A PLAYER OF THIS POSITION");
            }else{
                for(Player thisFreeAgent : freeAgents){
                    if (thisTeam.hasPosition(thisFreeAgent.getPosition()) || thisFreeAgent.getPlayerType().equals("Pitcher")) {
                        continue;
                    }else{
                        System.out.println(thisFreeAgent.getPlayerName() + " " + thisFreeAgent.getMlbTeam() + " " + thisFreeAgent.getPosition());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void poverall(String pos, Team thisTeam){
        try {
            pos = pos.trim().toUpperCase();
            if(thisTeam.hasPosition(pos)){
                throw new Exception("TEAM ALREADY CONTAINS A PLAYER OF THIS POSITION");
            }else{
                for(Player thisFreeAgent : freeAgents){
                    if(thisFreeAgent.getPlayerType().equalsIgnoreCase("Pitcher")){
                        continue;
                    }else{
                        System.out.println(thisFreeAgent.getPlayerName() + " " + thisFreeAgent.getMlbTeam() + " " + thisFreeAgent.getPosition());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addTeam() {
        System.out.println("Adding a Team...");
    }

    public static void displayTeam() {
        System.out.println("Displaying Teams...");
    }
    
    public static void save() {
        System.out.println("Saving data...");
    }

    public static void load() {
        System.out.println("Loading data...");
    }

    public static void quit() {
        System.out.println("Quitting: Goodbye ...");
    }

    public static void restore() {
        System.out.println("Restoring...");
    }

    public static void evalFun() {
        System.out.println("EVALFUN...");
    }

    public static void pevalFun() {
        System.out.println("PEVALFUN...");
    }

    public static void help() {
        System.out.println("Main Menu:");
        System.out.println("Display Players");
        System.out.println("Search Player");
        System.out.println("IDRAFT");
        System.out.println("ODRAFT");
        System.out.println("OVERALL");
        System.out.println("POVERALL");
        System.out.println("Add Team");
        System.out.println("Display Teams");
        System.out.println("Save");
        System.out.println("Load");
        System.out.println("Quit");
        System.out.println("Restore");
        System.out.println("Evalfun");
        System.out.println("Pevealfun");
        System.out.println("Help");
    }

    public void readInPlayerFile(File playerFile, String playerType){
		try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(playerFile), StandardCharsets.UTF_8));
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String[] thisPlayerStats = line.split(",");
                playerDB.add(new Player(thisPlayerStats, playerType));
                freeAgents.add(new Player(thisPlayerStats, playerType));
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
}


