import java.io.File;
import java.util.ArrayList;

public class Player{
    
    //Both type stats
    String playerType;
    String position;
    String playerName;
    int age;
    String mlbTeam;
    String fantasyTeam;
    int draftPosition;
    int G;
    int H;
    int HR;
    int BB;
    int IBB;
    int R;
    int SO;
    int HBP;
    PitcherStats pitcherStats = new PitcherStats();
    BatterStats batterStats = new BatterStats();
    
    //Constructor
    public Player(){}

    public Player(String[] line, String playerTypeStr){
        if(playerTypeStr.toLowerCase().equals("batter")){
            this.playerType = playerTypeStr;
            this.position = generatePosition(line[28]);
            this.playerName = line[1];
            this.age = line[2].isEmpty() ? -1 : Integer.valueOf(line[2]);
            this.mlbTeam = line[3];
            this.fantasyTeam = "FreeAgent";
            this.draftPosition = -1;
            this.G = line[4].isEmpty() ? 0 : Integer.valueOf(line[4]);
            this.H = line[8].isEmpty() ? 0 : Integer.valueOf(line[8]);
            this.HR = line[11].isEmpty() ? 0 : Integer.valueOf(line[11]);
            this.BB = line[15].isEmpty() ? 0 : Integer.valueOf(line[15]);
            this.IBB = line[27].isEmpty() ? 0 : Integer.valueOf(line[27]);
            this.R = line[7].isEmpty() ? 0 : Integer.valueOf(line[7]);
            this.SO = line[16].isEmpty() ? 0 : Integer.valueOf(line[16]);
            this.HBP = line[24].isEmpty() ? 0 : Integer.valueOf(line[24]);
            this.batterStats = new BatterStats(line);
        }else{
            this.playerType = playerTypeStr;
            this.position = "P";
            this.playerName = line[1];
            this.age = Integer.valueOf(line[2]);
            this.mlbTeam = line[3];
            this.fantasyTeam = "FreeAgent";
            this.draftPosition = -1;
            this.G = line[8].isEmpty() ? 0 : Integer.valueOf(line[8]);
            this.H = line[15].isEmpty() ? 0 : Integer.valueOf(line[15]);
            this.HR = line[18].isEmpty() ? 0 : Integer.valueOf(line[18]);
            this.BB = line[19].isEmpty() ? 0 : Integer.valueOf(line[19]);
            this.IBB = line[20].isEmpty() ? 0 : Integer.valueOf(line[20]);
            this.R = line[16].isEmpty() ? 0 : Integer.valueOf(line[16]);
            this.SO = line[21].isEmpty() ? 0 : Integer.valueOf(line[21]);
            this.HBP = line[22].isEmpty() ? 0 : Integer.valueOf(line[22]);
            this.pitcherStats = new PitcherStats(line);
        }
    }

    public String generatePosition(String positionSummary){
        for(int i = 0; i < positionSummary.length()-1; i++){
            if(isInteger(positionSummary.substring(i, i+1))){
                switch(positionSummary.substring(i, i+1)){
                    case "1":
                        return "P";
                    case "2":
                        return "C";
                    case "3":
                        return "1B";
                    case "4":
                        return "2B";
                    case "5":
                        return "3B";
                    case "6":
                        return "SS";
                    case "7":
                        return "LF";
                    case "8":
                        return "CF";
                    case "9":
                        return "RF";
                    default:
                        return "ERROR";
                }
            }
        }

        return "ERROR";
    }

    public boolean isInteger(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Getters and setters

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getAge() {
        return age;
    }

    public void setrAge(int playerAge) {
        this.age = playerAge;
    }

    public String getMlbTeam() {
        return mlbTeam;
    }

    public void setMlbTeam(String mlbTeam) {
        this.mlbTeam = mlbTeam;
    }

    public String getFantasyTeam() {
        return fantasyTeam;
    }

    public void setFantasyTeam(String fantasyTeam) {
        this.fantasyTeam = fantasyTeam;
    }

    public int getG(){
        return G;
    }

    public void setG(int newG){
        this.G = newG;
    }

    public int getH(){
        return H;
    }

    public void setH(int newH){
        this.H = newH;
    }

    public int getHR(){
        return HR;
    }

    public void setHR(int newHR){
        this.HR = newHR;
    }

    public int getBB(){
        return BB;
    }

    public void setBB(int newBB){
        this.BB = newBB;
    }

    public int getIBB(){
        return IBB;
    }

    public void setIBB(int newIBB){
        this.IBB = newIBB;
    }

    public int getR(){
        return R;
    }

    public void setR(int newR){
        this.R = newR;
    }

    public int getSO(){
        return SO;
    }

    public void setSO(int newSO){
        this.SO = newSO;
    }

    public int getHBP(){
        return HBP;
    }

    public void setHBP(int newHBP){
        this.HBP = newHBP;
    }
    
}
