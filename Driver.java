import java.io.*;
import java.util.*;
import java.nio.charset.*;

public class Driver {
    static ArrayList<Player> playerDB = new ArrayList<Player>();
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
            System.out.println("2. Search player");
            System.out.println("3. IDRAFT");
            System.out.println("4. ODRAFT");
            System.out.println("5. OVERALL");
            System.out.println("6. POVERALL");
            System.out.println("7. TEAM");
            System.out.println("8. STARS");
            System.out.println("9. Add Team");
            System.out.println("10. Display teams");
            System.out.println("11. Save");
            System.out.println("12. Quit");
            System.out.println("13. RESTORE");
            System.out.println("14. EVALFUN");
            System.out.println("15. PEVALFUN");
            System.out.println("16. Help");
            System.out.println("Enter your choice:");
            
            String choice = scanner.nextLine();
            
            switch (choice.toUpperCase()) {
                case "DISPLAY PLAYERS":
                    displayPlayers();
                    break;
                case "SEARCH PLAYER":
                    searchPlayer();
                    break;
                case "IDRAFT":
                    idraft();
                    break;
                case "ODRAFT":
                    odraft();
                    break;
                case "OVERALL":
                    overall();
                    break;
                case "POVERALL":
                    poverall();
                    break;
                case "ADD TEAM":
                    addTeam();
                    break;
                case "DISPLAY TEAMS":
                    displayTeam();
                    break;
                case "SAVE":
                    save();
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
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        
        scanner.close();
    }
    
    private static void displayPlayers() {
        System.out.println("Displaying players...");
    }
    
    private static void searchPlayer() {
        System.out.println("Searching for a specific player...");
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

    private static void quit() {
        System.out.println("Quitting: Goodbye...");
    }

    private static void restore() {
        System.out.println("Restoring...");   
    }

    private static void evalFun() {
        System.out.println("EVALFUN...");
    }

    private static void pevalFun() {
        System.out.println("PEVALFUN...");
    }

    private static void help() {
        System.out.println("HELP...");
    }

    public void readInPlayerFile(File playerFile, String playerType){
		try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(playerFile), StandardCharsets.UTF_8));
            String line = br.readLine();
            while((line = br.readLine()) != null){
                System.out.println(line);
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