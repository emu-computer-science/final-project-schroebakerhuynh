import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.nio.charset.*;
import net.objecthunter.exp4j.*;

public class Driver{
    //ArrayList to act as a database for all players
    public static ArrayList<Player> playerDB = new ArrayList<Player>();
    public static Team teamA = new Team("Team A");
    public static Team teamB = new Team("Team B");
    public static Team teamC = new Team("Team C");
    public static Team teamD = new Team("Team D");
    public static int draftCounter = 1;

    //ArrayList to act as a database for freeAgents, pick from for draft
    // public static ArrayList<Player> freeAgents = new ArrayList<Player>();
   
    public static void main(String[] args) throws Exception {
        //Read in the batter and pitchers
        readInPlayerFile(new File("player_stats/mlb_al_batter_stats_2023.txt"), "Batter");
        readInPlayerFile(new File("player_stats/mlb_al_pitching_stats_2023.txt"), "Pitcher");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            // Display main menu
            System.out.println("Main Menu:");
            System.out.println("ODRAFT");
            System.out.println("IDRAFT");
            System.out.println("DISPLAY");
            System.out.println("TEAM");
            System.out.println("STARS");
            System.out.println("OVERALL");
            System.out.println("POVERALL");
            System.out.println("EVALFUN");
            System.out.println("PEVALFUN");
            System.out.println("SAVE");
            System.out.println("RESTORE");
            System.out.println("HELP");
            System.out.println("QUIT");
            System.out.print("\nEnter your choice: ");
            
            String choice = scanner.nextLine();
            
            switch (choice.toUpperCase()) {
                case "ODRAFT":
                    oDraft();
                    break;
                case "IDRAFT":
                    iDraft();
                    break;
                case "DISPLAY":
                    displayPlayers();
                    break;
                case "TEAM":
                    displayTeam();
                    break;
                case "STARS":
                    displayTeamStars();
                    break;
                case "OVERALL":
                    overall();
                    break;
                case "POVERALL":
                    pOverall();
                    break;
                case "EVALFUN":
                    evalFun();
                    break;
                case "PEVALFUN":
                    pevalFun();
                    break;
                case "SAVE":
                    save();
                    break;
                case "RESTORE":
                    restore();
                    break;
                case "HELP":
                    help();
                    break;
                case "QUIT":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        
        scanner.close();
    }

    public static void save() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("saved_state.txt"))) {
            // Writing drafted player names for each team
            writer.println("TEAM_A_DRAFTED_PLAYERS");
            for (Player player : teamA.roster) {
                writer.println(player.getPlayerName());
            }

            writer.println("TEAM_B_DRAFTED_PLAYERS");
            for (Player player : teamB.roster) {
                writer.println(player.getPlayerName());
            }

            writer.println("TEAM_C_DRAFTED_PLAYERS");
            for (Player player : teamC.roster) {
                writer.println(player.getPlayerName());
            }

            writer.println("TEAM_D_DRAFTED_PLAYERS");
            for (Player player : teamD.roster) {
                writer.println(player.getPlayerName());
            }

            writer.println("DRAFT_COUNTER=" + draftCounter);
            System.out.println("Program state saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving program state: " + e.getMessage());
        }
    }

    public static void restore() {
    try (BufferedReader reader = new BufferedReader(new FileReader("saved_state.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Reading line: " + line);

            if (line.equals("TEAM_A_DRAFTED_PLAYERS")) {
                while ((line = reader.readLine()) != null && !line.startsWith("TEAM")) {
                    for (Player player : playerDB) {
                        if (player.getPlayerName().equals(line)) {
                            teamA.addPlayer(player, draftCounter);
                            break;
                        }
                    }
                }
            }

            if (line != null && line.equals("TEAM_B_DRAFTED_PLAYERS")) {
                while ((line = reader.readLine()) != null && !line.startsWith("TEAM")) {
                    for (Player player : playerDB) {
                        if (player.getPlayerName().equals(line)) {
                            teamB.addPlayer(player, draftCounter);
                            break;
                        }
                    }
                }
            }

            if (line != null && line.equals("TEAM_C_DRAFTED_PLAYERS")) {
                while ((line = reader.readLine()) != null && !line.startsWith("TEAM")) {
                    for (Player player : playerDB) {
                        if (player.getPlayerName().equals(line)) {
                            teamC.addPlayer(player, draftCounter);
                            break;
                        }
                    }
                }
            }

            if (line != null && line.equals("TEAM_D_DRAFTED_PLAYERS")) {
                while ((line = reader.readLine()) != null && !line.startsWith("TEAM")) {
                    for (Player player : playerDB) {
                        if (player.getPlayerName().equals(line)) {
                            teamD.addPlayer(player, draftCounter);
                            break;
                        }
                    }
                }
            }

            if (line != null && line.startsWith("DRAFT_COUNTER")) {
                draftCounter = Integer.parseInt(line.split("=")[1]);
            }
        }
        System.out.println("Program state restored successfully.");
    } catch (IOException e) {
        System.out.println("Error restoring program state: " + e.getMessage());
    }
}


    /* 
     * PROGRAMMER: BRANDON HUYHN + MACK BAKER
     * help()
     * Parses a comma-separated .txt file consisting of baseball players and turns it into an ArrayList based database
     * 
     * @param file to read in
     * @param the type of player ("Batter" or "Pitcher")
    */
    public static void help(){
        System.out.println();
        System.out.println("===============================HELP==============================");
        System.out.println("ODRAFT ---> Draft to a non-client team");
        System.out.println("IDRAFT ---> Draft to client team");
        System.out.println("DISPLAY ---> Display player list");
        System.out.println("TEAM ---> Display team roster by position");
        System.out.println("STARS ---> Display team roster by draft position");
        System.out.println("OVERALL ---> Display batters from playerDB by evaluation value");
        System.out.println("POVERALL ---> Display pitchers from playerDB by evalation value");
        System.out.println("EVALFUN ---> Mathematic evaluation of batters");
        System.out.println("PEVALFUN ---> Mathematic evaluation of pitchers");
        System.out.println("SAVE ---> Save current program state");
        System.out.println("RESTORE ---> Restore programs state from save file");
        System.out.println("HELP ---> Display command explanations");
        System.out.println("QUIT ---> Quit program");
        System.out.println("=================================================================");
        System.out.println();
    }
    

    /* 
     * PROGRAMMER: MACK BAKER
     * readInPlayerFile(File, String)
     * Parses a comma-separated .txt file consisting of baseball players and turns it into an ArrayList based database
     * 
     * @param file to read in
     * @param the type of player ("Batter" or "Pitcher")
    */
    public static void readInPlayerFile(File playerFile, String playerType){
		try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(playerFile), StandardCharsets.UTF_8));
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String[] thisPlayerStats = line.split(",");
                playerDB.add(new Player(thisPlayerStats, playerType));
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /* 
     * PROGRAMMER: BRANDON HUYHN
     * displayPlayers();
     * Displays all players in the playersDB
     * 
     *
    */
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

    /* 
     * PROGRAMMER: MACK BAKER
     * evalFun()
     * Retrieves a mathematical expression from the user based on certain player stats and then evalutes the expression
     * into a double that is then stored in the Player object's evaluationValue data member.
     * 
     *@throws Exception
    */
    private static void evalFun(){
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

            evaluationSort();
        } catch (ArithmeticException e){
            System.out.println("! INVALID MATHEMATICAL EXPRESSION ENTERED !");
        } catch (IllegalArgumentException e){
            System.out.println("! INVALID STAT ENTRY, ONE OR MORE OF THE STATS YOU ARE LOOKING TO EVAL IS CURRENTLY UNSUPPORTED");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    /* 
     * PROGRAMMER: MACK BAKER
     * evaluationSort()
     * Sorts both the playerDB and the freeAgents DB based on objects' evalVal
    */
    private static void evaluationSort(){
        Collections.sort(playerDB, (p1, p2) -> Double.compare(p2.getEvaluationValue(), p1.getEvaluationValue()));
    }

    /* 
     * PROGRAMMER: MACK BAKER
     * pevalFun()
     * Retrieves a mathematical expression from the user based on certain player stats and then evalutes the expression
     * into a double that is then stored in the Player object's evaluationValue data member.
     * 
     *@throws Exception
    */
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
    
            evaluationSort();

        } catch (ArithmeticException e){
            System.out.println("! INVALID MATHEMATICAL EXPRESSION ENTERED !");
        } catch (IllegalArgumentException e){
            System.out.println("! INVALID STAT ENTRY, ONE OR MORE OF THE STATS YOU ARE LOOKING TO EVAL IS CURRENTLY UNSUPPORTED");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /* 
     * PROGRAMMER: MACK BAKER
     * displayTeam()
     * Asks user for team to display and displays said team
     * 
    */
    public static void displayTeam(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the team you wish to display (A,B,C,D): ");
        String name = input.nextLine();
        switch(name.trim().toUpperCase()){
            case "A":
                teamA.displayTeam();
                break;
            case "B":
                teamB.displayTeam();
                break;
            case "C":
                teamC.displayTeam();
                break;
            case "D":
                teamD.displayTeam();
                break;
            default:
                break;
        }
    }

    public static void displayTeamStars(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the team you wish to display (A,B,C,D): ");
        String name = input.nextLine();
        switch(name.trim().toUpperCase()){
            case "A":
                teamA.stars();
                break;
            case "B":
                teamB.stars();
                break;
            case "C":
                teamC.stars();
                break;
            case "D":
                teamD.stars();
                break;
            default:
                break;
        }
    }

    /* 
     * PROGRAMMER: ANDREW SCHROEDER + MACK BAKER
     * iDraft()
     * 
     * 
    */
    public static void iDraft() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter player name you wish to draft: ");
        boolean playerFound = false;
        String nameInput = input.nextLine();
        searchDBLoop: for(Player player : playerDB){
            if(nameInput.toLowerCase().equals(player.getPlayerName().toLowerCase())){
                if(!(player.getFantasyTeam().equals("FreeAgent"))){
                    System.out.println("=========================ERROR=========================");
                    System.out.println("|| PLAYER IS NOT A FREE AGENT. YOU CANNOT DRAFT THEM ||");
                    System.out.println("=======================================================");
                    return;
                }
                switch(player.getPlayerType()){
                    case "Pitcher":
                        if(teamA.hasFullPitchingStaff()){
                            System.out.println("====================================ERROR=======================================");
                            System.out.println("|| Team A already has a full pitching staff. You cannot draft another pitcher. ||");
                            System.out.println("================================================================================");
                            return;
                        }else{
                            teamA.addPitcher(player, draftCounter);
                            nameInput = player.getPlayerName();
                            playerFound = true;
                            break searchDBLoop;
                        }
                    case "Batter":
                        if(teamA.hasPosition(player.getPosition())){
                            System.out.println("=========================================ERROR===========================================");
                            System.out.println("|| Team A already has a player at position "+player.getPosition()+". You cannot draft another");
                            System.out.println("=========================================================================================");
                            return;
                        }else{
                            teamA.addPlayer(player, draftCounter);
                            nameInput = player.getPlayerName();
                            playerFound = true;
                            break searchDBLoop;
                        }
                    default:
                        return;
                }
            }
        }
        if (playerFound) {
            System.out.println(nameInput + " has been drafted to Team A");
            draftCounter++;
        } else {
            System.out.println("ERROR --> PLAYER NOT FOUND");
        }
    }
    /* 
     * PROGRAMMER: ANDREW SCHROEDER + MACK BAKER
     * oDraft()
     * 
     * 
    */
    public static void oDraft() {
        Scanner input = new Scanner(System.in);
        boolean playerFound = false;
        System.out.print("\nEnter player name you wish to draft: ");
        String name = input.nextLine();
        System.out.print("\nEnter the name of the team the player should be drafted to: ");
        String teamToDraftTo = input.nextLine();
        Team teamPt = null;
        switch(teamToDraftTo.toUpperCase()){
            case "A":
                teamPt = Driver.teamA;
                break;
            case "B":
                teamPt = Driver.teamB;
                break;
            case "C":
                teamPt = Driver.teamC;
                break;
            case "D":
                teamPt = Driver.teamD;
                break;
            default:
                System.out.println("COULD NOT READ TEAM, PLEASE TRY AGAIN");
                return;
            
        }
        searchDBLoop: for(Player player : playerDB){
            if(name.toLowerCase().equals(player.getPlayerName().toLowerCase())){
                if(!(player.getFantasyTeam().equals("FreeAgent"))){
                    System.out.println("=========================ERROR=========================");
                    System.out.println("|| PLAYER IS NOT A FREE AGENT. YOU CANNOT DRAFT THEM ||");
                    System.out.println("=======================================================");
                    return;
                }
                switch(player.getPlayerType()){
                    case "Pitcher":
                        if(teamPt.hasFullPitchingStaff()){
                            System.out.println("====================================ERROR=======================================");
                            System.out.println("|| "+teamPt.teamName+" already has a full pitching staff. You cannot draft another pitcher. ||");
                            System.out.println("================================================================================");
                            return;
                        }else{
                            teamPt.addPitcher(player, draftCounter);
                            name = player.getPlayerName();
                            playerFound = true;
                            break searchDBLoop;
                        }
                    case "Batter":
                        if(teamPt.hasPosition(player.getPosition())){
                            System.out.println("=========================================ERROR===========================================");
                            System.out.println("|| "+teamPt.teamName+" already has a player at position "+player.getPosition()+". You cannot draft another");
                            System.out.println("=========================================================================================");
                            return;
                        }else{
                            teamPt.addPlayer(player, draftCounter);
                            name = player.getPlayerName();
                            playerFound = true;
                            break searchDBLoop;
                        }
                    default:
                        return;
                }
            }
        }
        if (playerFound) {
            System.out.println(name + " has been drafted to " + teamPt.teamName);
            draftCounter++;
        } else {
            System.out.println("ERROR ---> PLAYER NOT FOUND");
            draftCounter--;
        }
    }    

    /* 
     * PROGRAMMER: MACK BAKER
     * overall()
     * 
     * 
    */
    public static void overall(){
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter position or 'all' for all batters: ");
            String pos = input.nextLine().trim().toUpperCase();
            if(pos.equals("ALL")){
                for(Player player: playerDB){
                    if(teamA.hasPosition(player.getPosition()) || !(player.getFantasyTeam().equals("FreeAgent")) || player.getPlayerType().equals("Pitcher")){
                        continue;
                    } else{
                        String name = player.getPlayerName();
                        String mlbTeam = player.getMlbTeam();
                        String position = player.getPosition();
                        System.out.println("NAME: "+name+"| MLB TEAM: "+mlbTeam+"| Position: "+position);
                    }
                }
            } else{
                if(teamA.hasPosition(pos)){
                    System.out.println("=====================ERROR=====================");
                    System.out.println("Your team already has a player of this position");
                    System.out.println("===============================================");
                    return;
                }else{
                    for(Player player : playerDB){
                        if(!(player.getFantasyTeam().equals("FreeAgent")) || player.getPlayerType().equals("Pitcher") || !(player.getPosition().equals(pos))){
                            continue;
                        }else{
                            String name = player.getPlayerName();
                            String mlbTeam = player.getMlbTeam();
                            String position = player.getPosition();
                            System.out.println("NAME: "+name+"| MLB TEAM: "+mlbTeam+"| Position: "+position);
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    /* 
     * PROGRAMMER: MACK BAKER
     * pOverall()
     * 
     * 
    */
    public static void pOverall(){
        if(teamA.hasFullPitchingStaff()){
            System.out.println("============================ERROR===========================");
            System.out.println("Your team already has a full pitching staff of this position");
            System.out.println("============================================================");
            return;
        }else{
            for(Player player : playerDB){
                if(!(player.getPlayerType().equals("Pitcher")) || !(player.getFantasyTeam().equals("FreeAgent"))){
                    continue;
                }else{
                    String name = player.getPlayerName();
                    String mlbTeam = player.getMlbTeam();
                    String position = player.getPosition();
                    System.out.println("NAME: "+name+"| MLB TEAM: "+mlbTeam+"| Position: "+position);
                }
            }
        }
    }



}
