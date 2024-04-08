import java.io.*;
import java.util.*;
import java.nio.charset.*;

public class Driver {
    public static ArrayList<Player> playerDB = new ArrayList<Player>();
    public static ArrayList<Player> freeAgents = new ArrayList<Player>();
    
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.readInPlayerFile(new File("mlb_al_batter_stats_2023.txt"), "Batter");
        driver.readInPlayerFile(new File("mlb_al_pitching_stats_2023.txt"), "Pitcher");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            // Display main menu
            System.out.println("Main Menu:");
            System.out.println("1. Display players");
            System.out.println("2. Search for specific player");
            System.out.println("3. IDRAFT");
            System.out.println("4. ODRAFT");
            System.out.println("5. OVERALL");
            System.out.println("6. POVERALL");
            System.out.println("7. Add Team");
            System.out.println("8. Display Teams");
            System.out.println("9. Save");
            System.out.println("10. Load");
            System.out.println("11. Quit");
            System.out.println("Enter your choice:");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    displayPlayers();
                    break;
                case 2:
                    searchPlayer();
                    break;
                case 3:
                    Team.iDraft();
                    break;
                case 4:
                    Team.oDraft();
                    break;
                case 5:
                    Team thisTeam = new Team();
                    overall("C", thisTeam);
                    break;
                case 6:
                    poverall();
                    break;
                case 7:
                    addTeam();
                    break;
                case 8:
                    displayTeam();
                    break;
                case 9:
                    save();
                    break;
                case 10:
                    load();
                    break;
                case 11:
                    quit();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        
        scanner.close();
    }
    
    private static void displayPlayers() {
  
        int pageSize = 20;
        int currentPage = 0;
        int totalPages = (int) Math.ceil((double) playerDB.size() / pageSize);
    
        Scanner scanner = new Scanner(System.in);
    
        while (currentPage < totalPages) {
            int startIndex = currentPage * pageSize;
            int endIndex = Math.min((currentPage + 1) * pageSize, playerDB.size());
    
            for (int i = startIndex; i < endIndex; i++) {
                Player player = playerDB.get(i);
                System.out.println(player.playerType +" "+player.playerName+" "+player.position);
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
                    return; // Return to menu
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    
        scanner.close();
    }
    
    private static void searchPlayer() {
        Driver driver = new Driver();
        driver.readInPlayerFile(new File("mlb_al_batter_stats_2023.txt"), "Batter");
        driver.readInPlayerFile(new File("mlb_al_pitching_stats_2023.txt"), "Pitcher");
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the player you want to search for:");
        String playerNameToSearch = scanner.nextLine();
    
        boolean playerFound = false;
        for (Player player : driver.playerDB) {
            if (player.getPlayerName().equalsIgnoreCase(playerNameToSearch)) {
                System.out.println(player.playerType +" "+ player.playerName +" "+ player.position);
                playerFound = true;
                break;
            }
        }
    
        if (!playerFound) {
            System.out.println("Player not found.");
        }
    }

    private static void idraft() {
        System.out.println("IDRAFT...");
    }

    private static void odraft() {
        System.out.println("ODRAFT...");
    }

    private static void overall(String pos, Team thisTeam){
        try {
            pos = pos.trim().toUpperCase();
            if(thisTeam.hasPosition(pos)){
                throw new Exception("TEAM ALREADY CONTAINS A PLAYER OF THIS POSITION");
            }else{
                for(Player thisFreeAgent : freeAgents){
                    if(thisTeam.hasPosition(thisFreeAgent.position) || thisFreeAgent.playerType.equals("Pitcher")){
                        continue;
                    }else{
                        System.out.println(thisFreeAgent.playerName+" "+thisFreeAgent.mlbTeam+" "+thisFreeAgent.position);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void poverall() {
        System.out.println("POVERALL...");
    }

    private static void addTeam() {
        System.out.println("Adding a Team...");
    }

    private static void displayTeam() {
        System.out.println("Displaying Teams...");
    }
    
    private static void save() {
        System.out.println("Saving data...");
    }

    private static void load() {
        System.out.println("Loading data...");
    }

    private static void quit() {
        System.out.println("Quitting: Goodbye ...");
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