import java.io.*;
import java.util.*;
import java.nio.charset.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Driver {
    public static ArrayList<Player> playerDB = new ArrayList<Player>();
    public static ArrayList<Player> freeAgents = new ArrayList<Player>();
    public static Team myTeam;
    
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.readInPlayerFile(new File("mlb_al_batter_stats_2023.txt"), "Batter");
        driver.readInPlayerFile(new File("mlb_al_pitching_stats_2023.txt"), "Pitcher");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            // Display main menu
            System.out.println("Main Menu:");
            System.out.println("Display players");
            System.out.println("Search for specific player");
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
            System.out.println("EVALFUN");
            System.out.println("PEVALFUN");
            System.out.println("Help");
            System.out.print("\nEnter your choice: ");
            
            String choice = scanner.nextLine();
            
            switch (choice.toUpperCase()) {
                case "DISPLAY PLAYERS":
                    displayPlayers();
                    break;
                case "SEARCH PLAYERS":
                    searchPlayer();
                    break;
                case "IDRAFT":
                    Team.iDraft();
                    break;
                case "ODRAFT":
                    Team.oDraft();
                    break;
                case "OVERALL":
                    overall();
                    break;
                case "POVERALL":
                    poverall();
                    break;
                case "ADD TEAM":
                    myTeam = new Team();;
                    break;
                case "DISPLAY TEAMS":
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
                    try {
                        evalFun();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    break;
                case "PEVALFUN":
                    try {
                        pevalFun();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
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
  
        int pageSize = 20;
        int currentPage = 0;
        int totalPages = (int) Math.ceil((double) playerDB.size() / pageSize);
    
        Scanner scanner = new Scanner(System.in);
    
        while (currentPage < totalPages) {
            int startIndex = currentPage * pageSize;
            int endIndex = Math.min((currentPage + 1) * pageSize, playerDB.size());
    
            for (int i = startIndex; i < endIndex; i++) {
                Player player = playerDB.get(i);
                System.out.println(player.getPlayerType() +" "+player.getPlayerName()+" "+player.getPosition());
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
        for (Player player : playerDB) {
            if (player.getPlayerName().equalsIgnoreCase(playerNameToSearch)) {
                System.out.println(player.getPlayerType() +" "+ player.getPlayerName() +" "+ player.getPosition());
                playerFound = true;
                break;
            }
        }
    
        if (!playerFound) {
            System.out.println("Player not found.");
        }
    }

    private static void overall(){
        try {
            if(myTeam == null){
                System.out.println("NEED TO CREATE YOUR TEAM FIRST");
                return;
            }

            Scanner input = new Scanner(System.in);
            System.out.print("\nENTER POSITION (ALL FOR ALL PLAYERS): ");
            String pos = input.nextLine();
            pos = pos.trim().toUpperCase();
            if(myTeam.hasPosition(pos)){
                System.out.println("TEAM ALREADY HAS THIS POSITION");
                return; 
            }
            if(pos.equals("ALL")){
                for(Player thisFreeAgent : freeAgents){
                    if(myTeam.hasPosition(thisFreeAgent.getPosition()) || thisFreeAgent.getPlayerType().equals("Pitcher")){
                        continue;
                    }else{
                        System.out.println(thisFreeAgent.getPlayerName()+" "+thisFreeAgent.getMlbTeam()+" "+thisFreeAgent.getPosition()+" "+thisFreeAgent.getEvaluationValue());
                    }
                }
            }else{
                for(Player thisFreeAgent : freeAgents){
                    if(thisFreeAgent.getPosition().equals(pos)){
                        System.out.println(thisFreeAgent.getPlayerName()+" "+thisFreeAgent.getMlbTeam()+" "+thisFreeAgent.getPosition()+thisFreeAgent.getEvaluationValue());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void poverall() {
        try {
            if(myTeam == null){
                System.out.println("NEED TO CREATE YOUR TEAM FIRST");
                return;
            }

            if(myTeam.hasFullPitchingStaff()){
                System.out.println("TEAM'S PITCHING STAFF IS ALREADY FULL");
                return;
            }
            for(Player thisFreeAgent : freeAgents){
                if(thisFreeAgent.getPlayerType().equals("Pitcher")){
                    System.out.println(thisFreeAgent.getPlayerName()+" "+thisFreeAgent.getMlbTeam()+" "+thisFreeAgent.getPosition()+" "+thisFreeAgent.getEvaluationValue());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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

    private static void restore() {
        System.out.println("Restoring...");
    }

    private static void evalFun() throws Exception {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("\nPLEASE ENTER YOUR EVALUATION EXPRESSION: ");
            String evaluationString = input.nextLine();
            ExpressionBuilder eb = new ExpressionBuilder(evaluationString);

            eb.variables("BA", "OBP", "AB", "SLG", "SB");
    
            Expression expression = eb.build();
    
            for(Player player : playerDB){
                if(player.getPlayerType().equals("Batter")){
                    expression.setVariable("BA", player.batterStats.getBA());
                    expression.setVariable("OBP", player.batterStats.getOBP());
                    expression.setVariable("AB", (double) player.batterStats.getAB());
                    expression.setVariable("SLG", player.batterStats.getSLG());
                    expression.setVariable("SB", (double) player.batterStats.getSB());
        
                    player.setEvaluationValue(expression.evaluate());
                }
        
            }
            for(Player player : freeAgents){
                if(player.getPlayerType().equals("Batter")){
                    expression.setVariable("BA", player.batterStats.getBA());
                    expression.setVariable("OBP", player.batterStats.getOBP());
                    expression.setVariable("AB", (double) player.batterStats.getAB());
                    expression.setVariable("SLG", player.batterStats.getSLG());
                    expression.setVariable("SB", (double) player.batterStats.getSB());
        
                    player.setEvaluationValue(expression.evaluate());
                }
        
            }

            evaluationSort();
        } catch (ArithmeticException e){
            System.out.println("! INVALID MATHEMATICAL EXPRESSION ENTERED !");
        } catch (IllegalArgumentException e){
            System.out.println("! INVALID STAT ENTRY, ONE OR MORE OF THE STATS YOU ARE LOOKING TO EVAL IS CURRENTLY UNSUPPORTED");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void evaluationSort(){
        Collections.sort(playerDB, (p1, p2) -> Double.compare(p2.getEvaluationValue(), p1.getEvaluationValue()));
        Collections.sort(freeAgents, (p1, p2) -> Double.compare(p2.getEvaluationValue(), p1.getEvaluationValue()));
    }

    private static void pevalFun() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("\nPLEASE ENTER YOUR EVALUATION EXPRESSION: ");
            String evaluationString = input.nextLine();
            ExpressionBuilder eb = new ExpressionBuilder(evaluationString);
    
            eb.variables("G", "GS", "ERA", "IP", "BB");
    
            Expression expression = eb.build();
    
            for(Player player : playerDB){
                if(player.getPlayerType().equals("Pitcher")){
                    expression.setVariable("G", (double) player.getG());
                    expression.setVariable("GS", (double) player.pitcherStats.getGS());
                    expression.setVariable("ERA", (double) player.pitcherStats.getERA());
                    expression.setVariable("IP", player.pitcherStats.getIP());
                    expression.setVariable("BB", (double) player.getBB());
        
                    player.setEvaluationValue(expression.evaluate());   
                }
        
            }

            for(Player player : freeAgents){
                if(player.getPlayerType().equals("Pitcher")){
                    expression.setVariable("G", (double) player.getG());
                    expression.setVariable("GS", (double) player.pitcherStats.getGS());
                    expression.setVariable("ERA", (double) player.pitcherStats.getERA());
                    expression.setVariable("IP", player.pitcherStats.getIP());
                    expression.setVariable("BB", (double) player.getBB());
        
                    player.setEvaluationValue(expression.evaluate());
                }
        
            }
    
            evaluationSort();

        } catch (ArithmeticException e){
            System.out.println("! INVALID MATHEMATICAL EXPRESSION ENTERED !");
        } catch (IllegalArgumentException e){
            System.out.println("! INVALID STAT ENTRY, ONE OR MORE OF THE STATS YOU ARE LOOKING TO EVAL IS CURRENTLY UNSUPPORTED");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
}

    private static void help() {
        System.out.println("HELP...");
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