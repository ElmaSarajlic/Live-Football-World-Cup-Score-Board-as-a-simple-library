package scoreboard.core.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scoreboard.core.model.Match;
import scoreboard.core.model.Team;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestMatchService {
    private MatchService service;
    private Team homeTeam;
    private Team awayTeam;

    @BeforeEach
    void setUp() {
        service = new MatchService();
        homeTeam = new Team("1", "Home Team");
        awayTeam = new Team("2", "Away Team");
    }

    @Test
    public void testStartMatch() {
        service.startMatch(homeTeam, awayTeam);
        assertEquals(1, service.getSummary().size(), "There should be one match in the scoreboard after starting a match.");
    }

    @Test
    public void testUpdateScore() {
        service.startMatch(homeTeam, awayTeam);
        Match match = service.getSummary().get(0);
        service.updateScore(match, 3, 2);

        match = service.getSummary().get(0);
        assertEquals(3, match.getHomeScore(), "Home score updated to 3.");
        assertEquals(2, match.getAwayScore(), "Away score updated to 2.");
    }

    @Test
    public void testFinishMatch() {
        service.startMatch(homeTeam, awayTeam);
        Match match = service.getSummary().get(0);
        service.finishMatch(match);
        assertTrue(service.getSummary().isEmpty(), "Scoreboard is empty after finishing the match.");
    }

    @Test
    public void testGetSummaryOrder() {
        Team team1 = new Team("3", "Team1");
        Team team2 = new Team("4", "Team2");
        Team team3 = new Team("5", "Team3");
        Team team4 = new Team("6", "Team4");

        service.startMatch(team3, team4);
        try { Thread.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
        service.startMatch(team1, team2);

        service.updateScore(service.getSummary().get(0), 5, 3);
        service.updateScore(service.getSummary().get(1), 1, 1);

        List<Match> summary = service.getSummary();

        assertEquals("Team3", summary.get(0).getHomeTeam().getName(), "Team3 is first in the summary because of the higher score.");
        assertEquals("Team1", summary.get(1).getHomeTeam().getName(), "Team1 is second in the summary.");
    }
}
