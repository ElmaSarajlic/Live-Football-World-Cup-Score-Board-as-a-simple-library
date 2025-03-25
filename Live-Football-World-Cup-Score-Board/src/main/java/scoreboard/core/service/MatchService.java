package scoreboard.core.service;

import scoreboard.core.model.Match;
import scoreboard.core.model.Team;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MatchService {

    private List<Match> matches;

    public MatchService() {
        matches = new ArrayList<>();
    }

    // 1. Start a new match
    public void startNewMatch(Team team1, Team team2) {
        Match match = new Match(team1, team2);
        matches.add(match);
    }

    // 2. Update score
    public void updateScore(Team team1, int homeScore, Team team2, int awayScore) {
        // Find the match and update the scores
        for (Match match : matches) {
            if (match.getTeam1() == team1 && match.getTeam2() == team2) {
                team1.setScore(homeScore);
                team2.setScore(awayScore);
                return;
            }
        }
    }

    // 3. Finish a match
    public void finishMatch(Team team1, Team team2) {
        // Find and remove the match from the list
        matches.removeIf(match -> match.getTeam1() == team1 && match.getTeam2() == team2);
    }

    // 4. Get a summary of matches in progress
    public List<Match> getSummary() {
        // Sort by total score (desc) and by start time (desc)
        matches.sort(Comparator.comparingInt(Match::getTotalScore)
                .reversed()
                .thenComparing(Match::getStartTime).reversed());

        return matches;
    }
}
