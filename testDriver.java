import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;

public class testDriver {

    @Test
    public void testDisplayPlayers() {
        Driver driver = new Driver();
        driver.readInPlayerFile(new File("mlb_al_batter_stats_2023.txt"), "Batter");
        driver.readInPlayerFile(new File("mlb_al_pitching_stats_2023.txt"), "Pitcher");
        assertTrue(Driver.playerDB.size() > 0);
    }

    @Test
    public void testSearchPlayer() {
        Driver driver = new Driver();
        driver.readInPlayerFile(new File("mlb_al_batter_stats_2023.txt"), "Batter");
        driver.readInPlayerFile(new File("mlb_al_pitching_stats_2023.txt"), "Pitcher");
        assertTrue(Driver.playerDB.stream().anyMatch(player -> player.getPlayerName().equalsIgnoreCase("José Abreu")));
    }


    @Test
	public void addTeam() {
		equals(true);
	}

    @Test
	public void displayTeam() {
		equals(true);
	}

    @Test
	public void save() {
		equals(true);
	}

    @Test
	public void load() {
		equals(true);
	}

    @Test
	public void quit() {
		equals(true);
	}
    
}
