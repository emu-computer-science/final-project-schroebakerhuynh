import static org.junit.Assert.*;
import java.io.File;
import org.junit.Before;
import org.junit.Test;


public class testTeam {
	
	@Test
	public void testHasFullPitchingStaff(){
		Team testTeam5of5 = new Team("Test Team 5/5");
		Team testTeam4of5 = new Team("Test Team 4/5");
		Team testTeam3of5 = new Team("Test Team 3/5");
		Team testTeam2of5 = new Team("Test Team 2/5");
		Team testTeam1of5 = new Team("Test Team 1/5");
		Team testTeam0of5 = new Team("Test Team 0/5");


		testTeam5of5.pitcher1 = new Player();
		testTeam5of5.pitcher2 = new Player();
		testTeam5of5.pitcher3 = new Player();
		testTeam5of5.pitcher4 = new Player();
		testTeam5of5.pitcher5 = new Player();

		assertEquals(true, testTeam5of5.hasFullPitchingStaff());

		testTeam4of5.pitcher1 = new Player();
		testTeam4of5.pitcher2 = new Player();
		testTeam4of5.pitcher3 = new Player();
		testTeam4of5.pitcher4 = new Player();
		
		assertEquals(false, testTeam4of5.hasFullPitchingStaff());

		testTeam3of5.pitcher1 = new Player();
		testTeam3of5.pitcher2 = new Player();
		testTeam3of5.pitcher3 = new Player();
		
		assertEquals(false, testTeam3of5.hasFullPitchingStaff());

		testTeam2of5.pitcher1 = new Player();
		testTeam2of5.pitcher2 = new Player();

		assertEquals(false, testTeam2of5.hasFullPitchingStaff());

		testTeam1of5.pitcher1 = new Player();

		assertEquals(false, testTeam1of5.hasFullPitchingStaff());
		assertEquals(false, testTeam0of5.hasFullPitchingStaff());
	}
	
	@Test
	public void testHasPosition(){
		String catcher = "C";
		Player testee = new Player();
		testee.setPosition("C");
		Team testTeam = new Team("Test Team");
		testTeam.addPlayer(testee, 1);

		assertEquals(true, testTeam.hasPosition("C"));

		Player testee2 = new Player();
		testee2.setPosition("1B");
		Team testTeam2 = new Team("Test Team");
		testTeam2.addPlayer(testee2,1);
		
		assertEquals(false, testTeam2.hasPosition("C"));
	}

	@Test
	public void testAddPitcher(){
		Player testee = new Player();
		Team testTeam = new Team("Test Team");
		testTeam.addPitcher(testee,1);

		assertEquals(false, (testTeam.pitcher1 == null));
	}

	@Test
	public void testAddPlayer(){
		Player testee = new Player();
		testee.setPosition("1B");
		Team testTeam = new Team("Test Team");

		testTeam.addPlayer(testee, 1);
		assertEquals(false, (testTeam.firstbase == null));

	}

}