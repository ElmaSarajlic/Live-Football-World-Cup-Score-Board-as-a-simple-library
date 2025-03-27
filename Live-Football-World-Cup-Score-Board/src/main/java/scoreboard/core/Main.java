package scoreboard.core;

import scoreboard.core.database.TeamDatabase;
import scoreboard.core.model.Match;
import scoreboard.core.model.Team;
import scoreboard.core.service.MatchService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MatchService matchService = new MatchService();
        TeamDatabase teamDatabase = new TeamDatabase();

        Team mexico = teamDatabase.getTeams().stream().filter(team -> team.getId().equals("0")).findFirst().orElse(null);
        Team canada = teamDatabase.getTeams().stream().filter(team -> team.getId().equals("1")).findFirst().orElse(null);
        Team spain = teamDatabase.getTeams().stream().filter(team -> team.getId().equals("2")).findFirst().orElse(null);
        Team brazil = teamDatabase.getTeams().stream().filter(team -> team.getId().equals("3")).findFirst().orElse(null);
        Team germany = teamDatabase.getTeams().stream().filter(team -> team.getId().equals("4")).findFirst().orElse(null);
        Team france = teamDatabase.getTeams().stream().filter(team -> team.getId().equals("5")).findFirst().orElse(null);
        Team Uruguay = teamDatabase.getTeams().stream().filter(team -> team.getId().equals("6")).findFirst().orElse(null);
        Team Italy = teamDatabase.getTeams().stream().filter(team -> team.getId().equals("7")).findFirst().orElse(null);
        Team Argentina = teamDatabase.getTeams().stream().filter(team -> team.getId().equals("8")).findFirst().orElse(null);
        Team Australia = teamDatabase.getTeams().stream().filter(team -> team.getId().equals("9")).findFirst().orElse(null);


        matchService.startMatch(mexico, canada);
        matchService.startMatch(spain, brazil);
        matchService.startMatch(germany, france);
        matchService.startMatch(Uruguay, Italy);
        matchService.startMatch(Argentina, Australia);


        updateScores(matchService, "Mexico", "Canada", 0, 5);
        updateScores(matchService, "Spain", "Brazil", 10, 2);
        updateScores(matchService, "Germany", "France", 2, 2);
        updateScores(matchService, "Uruguay", "Italy", 6, 6);
        updateScores(matchService, "Argentina", "Australia", 3, 1);


        List<Match> sortedMatches = matchService.getSummary();
        sortedMatches.forEach(match ->
                System.out.println(match.getHomeTeam().getName() + " " + match.getHomeScore() + " - " +
                        match.getAwayTeam().getName() + " " + match.getAwayScore()));
    }

    private static void updateScores(MatchService service, String home, String away, int homeScore, int awayScore) {
        Match match = service.getSummary().stream()
                .filter(m -> m.getHomeTeam().getName().equals(home) && m.getAwayTeam().getName().equals(away))
                .findFirst()
                .orElse(null);
        if (match != null) {
            service.updateScore(match, homeScore, awayScore);
        }
    }
}
