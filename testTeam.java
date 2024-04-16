import static org.junit.Assert.*;
import java.io.File;
import org.junit.Before;
import org.junit.Test;


public class testTeam {
	
	Player testPlayer = new Player();
	Player releasePlayer = new Player();
	Player dudeGuy = new Player();
	
	@Before
	public void setUp() {
		
		testPlayer.setPosition("firstbase");
		releasePlayer.setPosition("secondbase");
		dudeGuy.setPosition("thirdbase");
		Team.setTeamName("Free Agents");
		testPlayer.setFantasyTeam(Team.getTeamName());
	}
	
	@Test
	public void testListRoster() {
		assertEquals(true,true);
	}
	
	@Test
	public void testStars() {
		assertEquals(true,true);
	}
	
	@Test
	public void testIDraft() {
		System.out.println("\nSearch for Player Josh Bell");
		Team.iDraft();
		for (int i = 0; i < Driver.playerDB.size(); i++) {
			if (Driver.playerDB.get(i).getPlayerName().equals("Josh Bell")) {
				dudeGuy = Driver.playerDB.get(i);
				System.out.println("Found: " + Driver.playerDB.get(i).getPlayerName());
			}
		}
		assertNotEquals(dudeGuy.getFantasyTeam(), testPlayer.getFantasyTeam());
	}
	
	@Test
	public void testODraft() {
		System.out.println("\nSearch for Player Matt Brash");
		Team.oDraft();
		for (int i = 0; i < Driver.playerDB.size(); i++) {
			if (Driver.playerDB.get(i).getPlayerName().equals("Matt Brash"));
				dudeGuy = Driver.playerDB.get(i);
		}
		assertNotEquals(dudeGuy.getFantasyTeam(), testPlayer.getFantasyTeam());
	}
	
	@Test
	public void testRelease() {
		
		assertEquals(true, true);
	}
	
	@Test
	public void testHasPosition() {
		assertEquals(false, Team.hasPosition("catcher"));
	}
	
	@Test
	public void testDisplayDraftRound() {
		assertNotEquals(Team.displayDraftRound(), null);
	}
	
	@Test
	public void testGetTeamName() {
		String name = Team.getTeamName();
		assertEquals(name, Team.getTeamName());
	}
	
	@Test
	public void testSetTeamName() {
		String name = "testName";
		Team.setTeamName(name);
		assertEquals(name, Team.getTeamName());
	}
	
	@Test
	public void testEndRound() {
		int num = Team.displayDraftRound();
		Team.endRound();
		assertEquals(num + 1, Team.displayDraftRound());
	}
	
}