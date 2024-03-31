public class BatterStats {
    //Batter Stats
    int PA;
    int AB;
    int doubles;
    int triples;
    int RBI;
    int SB;
    int CS;
    double BA;
    double OBP;
    double SLG;
    double OPS;
    double OPSplus;
    int TB;
    int GDP;
    int SH;
    int SF;
    

    public BatterStats(){
    }

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

    //BATTER SPECIFIC

    public int getPA() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setPA(int newPA) throws Exception {
        System.out.println("Setter");
    }

    public int getAB() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setAB(int newAB) throws Exception {
        System.out.println("Setter");
    }

    public int getDoubles() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setDoubles(int newDoubles) throws Exception {
        System.out.println("Setter");
    }

    public int getTriples() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setTriples(int newTriples) throws Exception {
        System.out.println("Setter");
    }

    public int getRBI() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setRBI(int newRBI) throws Exception {
        System.out.println("Setter");
    }

    public int getSB() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setSB(int newSB) throws Exception {
        System.out.println("Setter");
    }

    public int getCS() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setCS(int newCS) throws Exception {
        System.out.println("Setter");
    }

    public double getBA() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setBA(double newBA) throws Exception {
        System.out.println("Setter");
    }

    public double getOBP() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setOBP(double newOBP) throws Exception {
        System.out.println("Setter");
    }

    public double getSLG() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setSLG(double newSLG) throws Exception {
        System.out.println("Setter");
    }

    public double getOPS() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setOPS(double newOPS) throws Exception {
        System.out.println("Setter");
    }

    public double getOPSplus() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setOPSplus(double newOPSplus) throws Exception {
        System.out.println("Setter");
    }

    public int getTB() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setTB(int newTB) throws Exception {
        System.out.println("Setter");
    }

    public int getGDP() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setGDP(int newGDP) throws Exception {
        System.out.println("Setter");
    }

    public int getSH() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setSH(int newSH) throws Exception {
        System.out.println("Setter");
    }

    public int getSF() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setSF(int newSF) throws Exception {
        System.out.println("Setter");
    }
}
