import java.io.*;
import java.util.*;
import java.nio.charset.*;

public class Driver {
    ArrayList<Player> playerDB = new ArrayList<Player>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            // Display main menu
            System.out.println("Main Menu:");
            System.out.println("1. Display players");
            System.out.println("2. Search for specific player");
            System.out.println("3. IDRAFT");
            System.out.println("4. ODRAFT");
            System.out.println("5. Add Team");
            System.out.println("6. Display Teams");
            System.out.println("7. Save");
            System.out.println("8. Load");
            System.out.println("9. Quit");
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
                    idraft();
                    break;
                case 4:
                    odraft();
                    break;
                case 5:
                    addTeam();
                    break;
                case 6:
                    displayTeam();
                    break;
                case 7:
                    save();
                    break;
                case 8:
                    load();
                    break;
                case 9:
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
        Driver driver = new Driver();
        driver.readInPlayerFile(new File("mlb_al_batter_stats_2023.txt"), "Batter");
        driver.readInPlayerFile(new File("mlb_al_pitching_stats_2023.txt"), "Pitcher");
    }
    
    private static void searchPlayer() {
        System.out.println("Searching for a specific player...");
    }

    private static void idraft() {
        System.out.println("idraft...");
    }

    private static void odraft() {
        System.out.println("odraft...");
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
                System.out.println(line);
                String[] thisPlayerStats = line.split(",");
                playerDB.add(new Player(thisPlayerStats, playerType));
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
}
