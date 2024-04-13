import static org.junit.Assert.*;
import org.junit.Test;

public class testBatterStats {

    @Test
    public void testBatterStatsConstructor() {
        BatterStats batterStats = new BatterStats();
        assertNotNull(batterStats);
    }

    @Test
    public void testBatterStatsGettersAndSetters() {
        String[] data = {"1", "José Abreu", "36", "HOU", "141", "594", "540", "62", "128", "23", "1", "18", "90", "0", "1", "42", "130", ".237", ".296", ".383", ".680", "87", "207", "16", "6", "0", "6", "1", "*3/D", "abreujo02"};
        BatterStats batterStats = new BatterStats(data);
        try {
            assertEquals(594, batterStats.getPA());
            assertEquals(540, batterStats.getAB());
            assertEquals(23, batterStats.getDoubles());
            assertEquals(1, batterStats.getTriples());
            assertEquals(90, batterStats.getRBI());
            assertEquals(0, batterStats.getSB());
            assertEquals(1, batterStats.getCS());
            assertEquals(0.237, batterStats.getBA(), 0.001);
            assertEquals(0.296, batterStats.getOBP(), 0.001);
            assertEquals(0.383, batterStats.getSLG(), 0.001);
            assertEquals(0.680, batterStats.getOPS(), 0.001);
			assertEquals(87, batterStats.getOPSplus(), 0.001);
            assertEquals(207, batterStats.getTB());
            assertEquals(16, batterStats.getGDP());
            assertEquals(0, batterStats.getSH());
            assertEquals(6, batterStats.getSF());
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
}

    @Test
    public void testBatterStatsSetters() {
        BatterStats batterStats = new BatterStats();
        try {
            batterStats.setPA(100);
            batterStats.setAB(50);

            assertEquals(100, batterStats.getPA());
            assertEquals(50, batterStats.getAB());
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }
}
