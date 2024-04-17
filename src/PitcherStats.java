/*
 * Programmer: Team 1 (Adam Schroeder, Brandon Huyhn, Mack Baker)
 * Project:    Final Project - Fantasy Baseball
 * Course:     COSC 381, Sp '24
 *  
 */

public class PitcherStats {
    //Pitcher Stats
    private int W;
    private int L;
    private double WLp;
    private double ERA;
    private int GS;
    private int GF;
    private int CG;
    private int SHO;
    private int SV;
    private double IP;
    private int ER;
    private int BK;
    private int WP;
    private int BF;
    private double ERAp;
    private double FIP;
    private double WHIP;
    private double H9;
    private double HR9;
    private double BB9;
    private double SO9;
    private double SOperW;

    public PitcherStats(){}

    public PitcherStats(String line[]){
        this.W = line[4].isEmpty() ? 0 : Integer.valueOf(line[4]);
        this.L = line[5].isEmpty() ? 0 : Integer.valueOf(line[5]);
        this.WLp = line[6].isEmpty() ? 0 : Double.valueOf(line[6]);
        this.ERA = line[7].isEmpty() ? 0 : Double.valueOf(line[7]);
        this.GS = line[9].isEmpty() ? 0 : Integer.valueOf(line[9]);
        this.GF = line[10].isEmpty() ? 0 : Integer.valueOf(line[10]);
        this.CG = line[11].isEmpty() ? 0 : Integer.valueOf(line[11]);
        this.SHO = line[12].isEmpty() ? 0 : Integer.valueOf(line[12]);
        this.SV = line[13].isEmpty() ? 0 : Integer.valueOf(line[13]);
        this.IP = line[14].isEmpty() ? 0 : Double.valueOf(line[14]);
        this.ER = line[17].isEmpty() ? 0 : Integer.valueOf(line[17]);
        this.BK = line[23].isEmpty() ? 0 : Integer.valueOf(line[23]);
        this.WP = line[24].isEmpty() ? 0 : Integer.valueOf(line[24]);
        this.BF = line[25].isEmpty() ? 0 : Integer.valueOf(line[25]);
        this.ERAp = line[26].isEmpty() ? 0 : Double.valueOf(line[26]);
        this.FIP = line[27].isEmpty() ? 0 : Double.valueOf(line[27]); 
        this.WHIP = line[28].isEmpty() ? 0 : Double.valueOf(line[28]);
        this.H9 = line[29].isEmpty() ? 0 : Double.valueOf(line[29]);
        this.HR9 = line[30].isEmpty() ? 0 : Double.valueOf(line[30]);
        this.BB9 = line[31].isEmpty() ? 0 : Double.valueOf(line[31]);
        this.SO9 = line[32].isEmpty() ? 0 : Double.valueOf(line[32]);
        this.SOperW = line[33].isEmpty() ? 0 : Double.valueOf(line[33]);
    }

    //GETTERS + SETTERS

    public int getW() throws Exception{
        return this.W;
    }

    public void setW(int newW) throws Exception{
        this.W = newW;
    }
    
    public int getL() throws Exception{
        return this.L;
    }

    public void setL(int newL) throws Exception{
        this.L = newL;
    }

    public double getWLp() throws Exception{
        return this.WLp;
    }

    public void setWLp(double newWLp) throws Exception{
        this.WLp = newWLp;
    }

    public double getERA() throws Exception{
        return this.ERA;
    }

    public void setERA(double newERA) throws Exception{
        this.ERA = newERA;
    }

    public int getGS() throws Exception{
        return this.GS;
    }

    public void setGS(int newGS) throws Exception{
        this.GS = newGS;
    }

    public int getGF() throws Exception{
        return this.GF;
    }

    public void setGF(int newGF) throws Exception{
        this.GF = newGF;
    }

    public int getCG() throws Exception{
        return this.CG;
    }

    public void setCG(int newCG) throws Exception{
        this.CG = newCG;
    }

    public int getSHO() throws Exception{
       return this.SHO;
    }

    public void setSHO(int newSHO) throws Exception{
        this.SHO = newSHO;
    }

    public int getSV() throws Exception{
        return this.SV;
    }

    public void setSV(int newSV) throws Exception{
        this.SV = newSV;
    }

    public double getIP() throws Exception{
        return this.IP;
    }

    public void setIP(double newIP) throws Exception{
        this.IP = newIP;
    }

    public int getER() throws Exception {
       return this.ER;
    }

    public void setER(int newER) throws Exception {
        this.ER = newER;
    }

    public int getBK() throws Exception {
        return this.BK;
    }

    public void setBK(int newBK) throws Exception {
        this.BK = newBK;
    }

    public int getWP() throws Exception {
        return this.WP;
    }

    public void setWP(int newWP) throws Exception {
        this.WP = newWP;
    }

    public int getBF() throws Exception {
        return this.BF;
    }

    public void setBF(int newBF) throws Exception {
        this.BF = newBF;
    }

    public double getERAp() throws Exception {
        return this.ERAp;
    }

    public void setERAp(double newERAp) throws Exception {
        this.ERAp = newERAp;
    }

    public double getFIP() throws Exception {
        return this.FIP;
    }

    public void setFIP(double newFIP) throws Exception {
        this.FIP = newFIP;
    }

    public double getWHIP() throws Exception {
        return this.WHIP;
    }

    public void setWHIP(double newWHIP) throws Exception {
        this.WHIP = newWHIP;
    }

    public double getH9() throws Exception {
        return this.H9;
    }

    public void setH9(double newH9) throws Exception {
        this.H9 = newH9;
    }

    public double getHR9() throws Exception {
        return this.HR9;
    }

    public void setHR9(double newHR9) throws Exception {
        this.HR9 = newHR9;
    }

    public double getBB9() throws Exception {
        return this.BB9;
    }

    public void setBB9(double newBB9) throws Exception {
        this.BB9 = newBB9;
    }

    public double getSO9() throws Exception {
        return this.SO9;
    }

    public void setSO9(double newSO9) throws Exception {
        this.SO9 = newSO9;
    }

    public double getSOperW() throws Exception {
        return this.SOperW;
    }

    public void setSOperW(double newSOperW) throws Exception {
        this.SOperW = newSOperW;
    }



}
