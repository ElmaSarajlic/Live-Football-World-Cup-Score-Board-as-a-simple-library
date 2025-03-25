package scoreboard.core.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scoreboard.core.model.Match;
import scoreboard.core.model.Team;
import scoreboard.core.database.TeamDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestMatchService {

    private MatchService matchService;
    private TeamDatabase teamDatabase;

    @BeforeEach
    public void setup() {
        teamDatabase = new TeamDatabase(); // Initialize the TeamDatabase
        matchService = new MatchService(); // Initialize the MatchService
    }


    @Test
    public void testUpdateScore() {
        Team mexico = teamDatabase.getTeams().get(0);
        Team canada = teamDatabase.getTeams().get(1);

        matchService.startNewMatch(mexico, canada); // Start the match
        matchService.updateScore(mexico, 2, canada, 5); // Update score (Mexico 2 - Canada 5)

        List<Match> matches = matchService.getSummary(); // Get the current matches
        Match match = matches.get(0);

        // Verify score update
        assertEquals(2, match.getTeam1().getScore(), "Home score should be updated to 2");
        assertEquals(5, match.getTeam2().getScore(), "Away score should be updated to 5");
    }

    @Test
    public void testFinishMatch() {
        Team mexico = teamDatabase.getTeams().get(0);
        Team canada = teamDatabase.getTeams().get(1);

        matchService.startNewMatch(mexico, canada); // Start the match
        matchService.finishMatch(mexico, canada); // Finish the match

        // Verify match removal
        List<Match> matches = matchService.getSummary(); // Get the current matches
        assertTrue(matches.isEmpty(), "Match should be removed from the scoreboard after finishing");
    }
}
