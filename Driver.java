import java.io.*;
import java.util.*;
import java.nio.charset.*;

public class Driver {
    static ArrayList<Player> playerDB = new ArrayList<Player>();
    static ArrayList<Player> freeAgents = new ArrayList<Player>();

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
            System.out.println("7. Add Team");
            System.out.println("8. Display teams");
            System.out.println("9. Save");
            System.out.println("10. Quit");
            System.out.println("11. RESTORE");
            System.out.println("12. EVALFUN");
            System.out.println("13. PEVALFUN");
            System.out.println("14. Help");
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

    private void readInPlayerFile(File playerFile, String playerType) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(playerFile), StandardCharsets.UTF_8));
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
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

    private static void overall() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter position (e.g., C or 1B): ");
            String position = scanner.nextLine().toUpperCase();

            // Check if the client has already drafted a player for that position
            // Assuming drafted players are stored somewhere and can be checked
            // For now, let's assume no players have been drafted
            boolean isPositionDrafted = false; // Need to implement this check

            if (isPositionDrafted) {
                System.out.println("A player for this position has already been drafted.");
                return;
            }

            for (Player player : freeAgents) {
                if (player.getPosition().equalsIgnoreCase(position) && !player.getPlayerType().equals("Pitcher")) {
                    // Output player information
                    System.out.println(player.getName() + " " + player.getRealTeam() + " " + player.getPosition() + " " + player.getValuation());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void poverall() {
        try {
            boolean arePitchersDrafted = false; 
    
            if (arePitchersDrafted) {
                System.out.println("pitchers have already been drafted.");
                return;
            }
            for (Player player : freeAgents) {
                if (player.getPlayerType().equals("Pitcher")) {
                    System.out.println(player.getName() + " " + player.getTeam() + " " + player.getPosition() + " " + player.getStats());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    

    private static void idraft() {
        System.out.println("IDRAFT...");
    }

    private static void odraft() {
        System.out.println("ODRAFT...");
    }
}
