import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            // Display main menu
            System.out.println("Main Menu:");
            System.out.println("1. Display players");
            System.out.println("2. Search for specific player");
            System.out.println("3. Add Team");
            System.out.println("4. Display Teams");
            System.out.println("5. Save");
            System.out.println("6. Load");
            System.out.println("7. Quit");
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
                    addTeam();
                    break;
                case 4:
                    displayTeam();
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    load();
                    break;
                case 7:
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

    private static void load() {
        System.out.println("Loading data...");
    }

    private static void quit() {
        System.out.println("Quitting: Goodbye ...");
    }
}
