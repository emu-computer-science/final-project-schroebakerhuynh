import static org.junit.Assert.*;
import org.junit.Test;

public class testPitcherStats {

    @Test
    public void testPitcherStatsConstructor() {
        PitcherStats pitcherStats = new PitcherStats();
        assertNotNull(pitcherStats);
    }

    @Test
    public void testPitcherStatsGettersAndSetters() {
        String[] data = {"1", "Albert Abreu", "27", "NYY", "2", "2", ".500", "4.73", "45", "0", "19", "0", "0", "0", "59.0", "52", "39", "31", "9", "35", "1", "61", "6", "0", "5", "268", "92", "5.26", "1.475", "7.9", "1.4", "5.3", "9.3", "1.74", "abreual01"};
        PitcherStats pitcherStats = new PitcherStats(data);
        try {
            assertEquals(2, pitcherStats.getW());
            assertEquals(2, pitcherStats.getL());
            assertEquals(0.500, pitcherStats.getWLp(), 0.001);
            assertEquals(4.73, pitcherStats.getERA(), 0.001);
            assertEquals(0, pitcherStats.getGS());
            assertEquals(19, pitcherStats.getGF());
            assertEquals(0, pitcherStats.getCG());
            assertEquals(0, pitcherStats.getSHO());
            assertEquals(0, pitcherStats.getSV());
            assertEquals(59.0, pitcherStats.getIP(), 0.001);
            assertEquals(31, pitcherStats.getER());
            assertEquals(0, pitcherStats.getBK());
            assertEquals(5, pitcherStats.getWP());
            assertEquals(268, pitcherStats.getBF());
            assertEquals(31, pitcherStats.getER());
            assertEquals(0, pitcherStats.getBK());
            assertEquals(5, pitcherStats.getWP());
            assertEquals(268, pitcherStats.getBF());
            assertEquals(92.0, pitcherStats.getERAp(), 0.001);
            assertEquals(5.26, pitcherStats.getFIP(), 0.001);
            assertEquals(1.475, pitcherStats.getWHIP(), 0.001);
            assertEquals(7.9, pitcherStats.getH9(), 0.001);
            assertEquals(1.4, pitcherStats.getHR9(), 0.001);
            assertEquals(5.3, pitcherStats.getBB9(), 0.001);
            assertEquals(9.3, pitcherStats.getSO9(), 0.001);
            assertEquals(1.74, pitcherStats.getSOperW(), 0.001);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testPitcherStatsSetters() {
        PitcherStats pitcherStats = new PitcherStats();
        try {
            pitcherStats.setW(5);
            pitcherStats.setL(3);

            assertEquals(5, pitcherStats.getW());
            assertEquals(3, pitcherStats.getL());
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }
}
