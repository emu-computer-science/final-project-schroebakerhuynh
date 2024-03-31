public class PitcherStats {
    //Pitcher Stats
    int W;
    int L;
    double WLp;
    double ERA;
    int GS;
    int GF;
    int CG;
    int SHO;
    int SV;
    double IP;
    int ER;
    int BK;
    int WP;
    int BF;
    double ERAp;
    double FIP;
    double WHIP;
    double H9;
    double HR9;
    double BB9;
    double SO9;
    double SOperW;

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

    public int getW() throws Exception{
        System.out.println("Getter");
        return 0;
    }

    public void setW(int newW) throws Exception{
        System.out.println("Setter");
    }
    
    public int getL() throws Exception{
        System.out.println("Getter");
        return 0;
    }

    public void setL(int newL) throws Exception{
        System.out.println("Setter");
    }

    public double getWLp() throws Exception{
        System.out.println("Getter");
        return 0.0;
    }

    public double getERA() throws Exception{
        System.out.println("Getter");
        return 0.0;
    }

    public void setERA(double newERA) throws Exception{
        System.out.println("Setter");
    }

    public int getGS() throws Exception{
        System.out.println("Returns GS");
        return 0;
    }

    public void setGS(int newGS) throws Exception{
        System.out.println("Sets GS");
    }

    public int getGF() throws Exception{
        System.out.println("Getter");
        return 0;
    }

    public void setGF(int newGF) throws Exception{
        System.out.println("Setter");
    }

    public int getCG() throws Exception{
        System.out.println("Getter");
        return 0;
    }

    public void setCG(int newCG) throws Exception{
        System.out.println("Setter");
    }

    public int getSHO() throws Exception{
        System.out.println("Getter");
        return 0;
    }

    public void setSHO(int newSHO) throws Exception{
        System.out.println("Setter");
    }

    public int getSV() throws Exception{
        System.out.println("Getter");
        return 0;
    }

    public void setSV(int newSV) throws Exception{
        System.out.println("Setter");
    }

    public double getIP() throws Exception{
        System.out.println("Getter");
        return 0;
    }

    public void setIP(double newIP) throws Exception{
        System.out.println("Setter");
    }

    public int getER() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setER(int newER) throws Exception {
        System.out.println("Setter");
    }

    public int getBK() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setBK(int newBK) throws Exception {
        System.out.println("Setter");
    }

    public int getWP() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setWP(int newWP) throws Exception {
        System.out.println("Setter");
    }

    public int getBF() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setBF(int newBF) throws Exception {
        System.out.println("Setter");
    }

    public double getERAp() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setERAp(double newERAp) throws Exception {
        System.out.println("Setter");
    }

    public double getFIP() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setFIP(double newFIP) throws Exception {
        System.out.println("Setter");
    }

    public double getWHIP() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setWHIP(double newWHIP) throws Exception {
        System.out.println("Setter");
    }

    public double getH9() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setH9(double newH9) throws Exception {
        System.out.println("Setter");
    }

    public double getHR9() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setHR9(double newHR9) throws Exception {
        System.out.println("Setter");
    }

    public double getBB9() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setBB9(double newBB9) throws Exception {
        System.out.println("Setter");
    }

    public double getSO9() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setSO9(double newSO9) throws Exception {
        System.out.println("Setter");
    }

    public double getSOperW() throws Exception {
        System.out.println("Getter");
        return 0;
    }

    public void setSOperW(double newSOperW) throws Exception {
        System.out.println("Setter");
    }



}
