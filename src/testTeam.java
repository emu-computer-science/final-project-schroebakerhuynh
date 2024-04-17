import static org.junit.Assert.*;
import java.io.File;
import org.junit.Before;
import org.junit.Test;


public class testTeam {
	
	Player testPlayer = new Player();
	Player releasePlayer = new Player();
	Player dudeGuy = new Player();
	
	@Test
	public void testHasFullPitchingStaff(){
		Team testTeam5of5 = new Team("Test Team 5/5");
		Team testTeam4of5 = new Team("Test Team 4/5");
		Team testTeam3of5 = new Team("Test Team 3/5");
		Team testTeam2of5 = new Team("Test Team 2/5");
		Team testTeam1of5 = new Team("Test Team 1/5");
		Team testTeam0of5 = new Team("Test Team 0/5");

		testTeam5of5.pitcher1 = new Player();

	}
	
	
}