package scoreboard.core.service;
import scoreboard.core.model.Match;
import scoreboard.core.model.Team;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MatchService {
    private List<Match> matches = new ArrayList<>();

    public void startMatch(Team home, Team away) {
        matches.add(new Match(home, away));
    }

    public void updateScore(Match match, int homeScore, int awayScore) {
        match.setHomeScore(homeScore);
        match.setAwayScore(awayScore);
    }

    public void finishMatch(Match match) {
        matches.remove(match);
    }

    public List<Match> getSummary() {
        return matches.stream()
                .sorted(Comparator.comparingInt(Match::getTotalScore)
                        .reversed()
                        .thenComparing(Match::getStartTime))
                .collect(Collectors.toList());
    }

}

