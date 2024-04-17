public class BatterStats {
    //Batter Stats
    private int PA;
    private int AB;
    private int doubles;
    private int triples;
    private int RBI;
    private int SB;
    private int CS;
    private double BA;
    private double OBP;
    private double SLG;
    private double OPS;
    private double OPSplus;
    private int TB;
    private int GDP;
    private int SH;
    private int SF;
    
    //Blank constructor
    public BatterStats(){
    }

    //Constructor with line of stats
    public BatterStats(String[] line){
        this.PA = line[5].isEmpty() ? 0 : Integer.valueOf(line[5]);
        this.AB = line[6].isEmpty() ? 0 : Integer.valueOf(line[6]);
        this.doubles = line[9].isEmpty() ? 0 : Integer.valueOf(line[9]);
        this.triples = line[10].isEmpty() ? 0 : Integer.valueOf(line[10]);
        this.RBI = line[12].isEmpty() ? 0 : Integer.valueOf(line[12]);
        this.SB = line[13].isEmpty() ? 0 : Integer.valueOf(line[13]);
        this.CS = line[14].isEmpty() ? 0 : Integer.valueOf(line[14]);
        this.BA = line[17].isEmpty() ? 0 : Double.valueOf(line[17]);
        this.OBP = line[18].isEmpty() ? 0 : Double.valueOf(line[18]);
        this.SLG = line[19].isEmpty() ? 0 : Double.valueOf(line[19]);
        this.OPS = line[20].isEmpty() ? 0 : Double.valueOf(line[20]);
        this.OPSplus = line[21].isEmpty() ? 0 : Double.valueOf(line[21]);
        this.TB = line[22].isEmpty() ? 0 : Integer.valueOf(line[22]);
        this.GDP = line[23].isEmpty() ? 0 : Integer.valueOf(line[23]);
        this.SH = line[25].isEmpty() ? 0 : Integer.valueOf(line[25]);
        this.SF = line[26].isEmpty() ? 0 : Integer.valueOf(line[26]);
    }

    //GETTERS + SETTERS
    public int getPA() throws Exception {
        return this.PA;
    }

    public void setPA(int newPA) throws Exception {
        this.PA = newPA;
    }

    public int getAB() throws Exception {
        return this.AB;
    }

    public void setAB(int newAB) throws Exception {
        this.AB = newAB;
    }

    public int getDoubles() throws Exception {
        return this.doubles;
    }

    public void setDoubles(int newDoubles) throws Exception {
        this.doubles = newDoubles;
    }

    public int getTriples() throws Exception {
        return this.triples;
    }

    public void setTriples(int newTriples) throws Exception {
        this.triples = newTriples;
    }

    public int getRBI() throws Exception {
        return this.RBI;
    }

    public void setRBI(int newRBI) throws Exception {
        this.RBI = newRBI;
    }

    public int getSB() throws Exception {
        return this.SB;
    }

    public void setSB(int newSB) throws Exception {
        this.SB = newSB;
    }

    public int getCS() throws Exception {
        return this.CS;
    }

    public void setCS(int newCS) throws Exception {
        this.CS = newCS;
    }

    public double getBA() throws Exception {
        return this.BA;
    }

    public void setBA(double newBA) throws Exception {
        this.BA = newBA;
    }

    public double getOBP() throws Exception {
        return this.OBP;
    }

    public void setOBP(double newOBP) throws Exception {
        this.OBP = newOBP;
    }

    public double getSLG() throws Exception {
        return this.SLG;
    }

    public void setSLG(double newSLG) throws Exception {
        this.SLG = newSLG;
    }

    public double getOPS() throws Exception {
        return this.OPS;
    }

    public void setOPS(double newOPS) throws Exception {
        this.OPS = newOPS;
    }

    public double getOPSplus() throws Exception {
        return this.OPSplus;
    }

    public void setOPSplus(double newOPSplus) throws Exception {
        this.OPSplus = newOPSplus;
    }

    public int getTB() throws Exception {
        return this.TB;
    }

    public void setTB(int newTB) throws Exception {
        this.TB = newTB;
    }

    public int getGDP() throws Exception {
        return this.GDP;
    }

    public void setGDP(int newGDP) throws Exception {
        this.GDP = newGDP;
    }

    public int getSH() throws Exception {
        return this.SH;
    }

    public void setSH(int newSH) throws Exception {
        this.SH = newSH;
    }

    public int getSF() throws Exception {
        return this.SF;
    }

    public void setSF(int newSF) throws Exception {
        this.SF = newSF;
    }
}
