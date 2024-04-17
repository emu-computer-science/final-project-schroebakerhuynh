import static org.junit.Assert.*;
import org.junit.Test;

public class testPlayer {

    @Test
    public void testPlayerConstructor() {
        Player playerStatus = new Player();
		assertNotNull(playerStatus);
    }

    @Test
public void testPlayerGetters() {
    String[] batterData = {"1", "José Abreu", "36", "HOU", "141", "594", "540", "62", "128", "23", "1", "18", "90", "0", "1", "42", "130", "237", "296", "383", "680", "87", "207", "16", "6", "0", "6", "1", "*3/D", "abreujo02"};
    Player batterPlayer = new Player(batterData, "batter");

    assertEquals("batter", batterPlayer.getPlayerType());
    assertEquals("1B", batterPlayer.getPosition());
    assertEquals("José Abreu", batterPlayer.getPlayerName());
    assertEquals(36, batterPlayer.getAge()); // Age represented as an integer
    assertEquals("HOU", batterPlayer.getMlbTeam());
    assertEquals("FreeAgent", batterPlayer.getFantasyTeam());
    assertEquals(-1, batterPlayer.getDraftPosition());
    assertEquals(141, batterPlayer.getG());
    assertEquals(128, batterPlayer.getH());
    assertEquals(18, batterPlayer.getHR());
    assertEquals(42, batterPlayer.getBB());
    assertEquals(1, batterPlayer.getIBB());
    assertEquals(62, batterPlayer.getR());
    assertEquals(130, batterPlayer.getSO());
    assertEquals(6, batterPlayer.getHBP());
}



    @Test
    public void testPlayerSetters() {
		String[] batterData = {"1", "José Abreu", "36", "HOU", "141", "594", "540", "62", "128", "23", "1", "18", "90", "0", "1", "42", "130", "237", "296", "383", "680", "87", "207", "16", "6", "0", "6", "1", "*3/D", "abreujo02"};
        Player batterPlayer = new Player(batterData, "batter");

        batterPlayer.setPlayerType("newType");
        assertEquals("newType", batterPlayer.getPlayerType());

        batterPlayer.setPosition("newPosition");
        assertEquals("newPosition", batterPlayer.getPosition());

        batterPlayer.setPlayerName("newName");
        assertEquals("newName", batterPlayer.getPlayerName());

        batterPlayer.setrAge(30);
        assertEquals(30, batterPlayer.getAge());

        batterPlayer.setMlbTeam("newTeam");
        assertEquals("newTeam", batterPlayer.getMlbTeam());

        batterPlayer.setFantasyTeam("newFantasyTeam");
        assertEquals("newFantasyTeam", batterPlayer.getFantasyTeam());

        batterPlayer.setG(10);
        assertEquals(10, batterPlayer.getG());

        batterPlayer.setH(20);
        assertEquals(20, batterPlayer.getH());

        batterPlayer.setHR(5);
        assertEquals(5, batterPlayer.getHR());

        batterPlayer.setBB(15);
        assertEquals(15, batterPlayer.getBB());

        batterPlayer.setIBB(3);
        assertEquals(3, batterPlayer.getIBB());

        batterPlayer.setR(25);
        assertEquals(25, batterPlayer.getR());

        batterPlayer.setSO(30);
        assertEquals(30, batterPlayer.getSO());

        batterPlayer.setHBP(2);
        assertEquals(2, batterPlayer.getHBP());

        batterPlayer.setDraftPosition(5);
        assertEquals(5, batterPlayer.getDraftPosition());
    }
}
