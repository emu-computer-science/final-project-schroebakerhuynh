import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

public class testDriver {


    @Test
    public void testReadInPlayerFileBatters(){
        Driver.readInPlayerFile(new File("final-project-schroebakerhuyhn/player_stats/mlb_al_batter_stats_2023.txt"), "Batter");
        assertEquals(false, Driver.playerDB.get(0) == null);
    }

    @Test
    public void testReadInPlayerFilePitchers(){
        Driver.readInPlayerFile(new File("final-project-schroebakerhuyhn/player_stats/mlb_al_pitching_stats_2023.txt"), "Pitcher");
        assertEquals(false, Driver.playerDB.get(0) == null);
    }

    @Test
    public void testIDraft(){
        Driver.teamA = new Team("Team A");
        Driver.readInPlayerFile(new File("final-project-schroebakerhuynh/player_stats/mlb_al_batter_stats_2023.txt"), "Batter");
        //Tyler Freeman
        Driver.iDraft();
        assertEquals("Tyler Freeman", Driver.teamA.thirdbase.getPlayerName());
        
        
    }

    @Test
    public void testODraft(){
        Driver.teamB = new Team("Team B");
        Driver.readInPlayerFile(new File("final-project-schroebakerhuynh/player_stats/mlb_al_batter_stats_2023.txt"), "Batter");
        //Tyler Freeman, B
        Driver.iDraft();
        assertEquals("Tyler Freeman", Driver.teamA.thirdbase.getPlayerName());
    }


}
