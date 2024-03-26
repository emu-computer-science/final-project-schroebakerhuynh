import java.io.File;
import java.util.ArrayList;

public class Player{
    
    //Both type stats
    String playerType;
    String position;
    String playerName;
    int playerAge;
    String mlbTeam;
    String fantasyTeam;
    int teamsDraftOrder;
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

    public int getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(int playerAge) {
        this.playerAge = playerAge;
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
