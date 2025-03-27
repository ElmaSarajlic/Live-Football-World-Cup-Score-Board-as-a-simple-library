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
        Team uruguay = teamDatabase.getTeams().stream().filter(team -> team.getId().equals("6")).findFirst().orElse(null);
        Team italy = teamDatabase.getTeams().stream().filter(team -> team.getId().equals("7")).findFirst().orElse(null);
        Team argentina = teamDatabase.getTeams().stream().filter(team -> team.getId().equals("8")).findFirst().orElse(null);
        Team australia = teamDatabase.getTeams().stream().filter(team -> team.getId().equals("9")).findFirst().orElse(null);
        Team bosnia = teamDatabase.getTeams().stream().filter(team -> team.getId().equals("10")).findFirst().orElse(null);
        Team cyprus = teamDatabase.getTeams().stream().filter(team -> team.getId().equals("11")).findFirst().orElse(null);



        matchService.startMatch(mexico, canada);
        matchService.startMatch(spain, brazil);
        matchService.startMatch(germany, france);
        matchService.startMatch(uruguay, italy);
        matchService.startMatch(argentina, australia);
        matchService.startMatch(bosnia, cyprus);



        updateScores(matchService, "0", "1", 0, 5);
        updateScores(matchService, "2", "3", 10, 2);
        updateScores(matchService, "4", "5", 2, 2);
        updateScores(matchService, "6", "7", 6, 6);
        updateScores(matchService, "8", "9", 3, 1);
        updateScores(matchService, "10", "11", 2, 1);



        List<Match> sortedMatches = matchService.getSummary();
        sortedMatches.forEach(match ->
                System.out.println(match.getHomeTeam().getName() + " " + match.getHomeScore() + " - " +
                        match.getAwayTeam().getName() + " " + match.getAwayScore()));
    }

    private static void updateScores(MatchService service, String homeId, String awayId, int homeScore, int awayScore) {
        Match match = service.getSummary().stream()
                .filter(m -> m.getHomeTeam().getId().equals(homeId) && m.getAwayTeam().getId().equals(awayId))
                .findFirst()
                .orElse(null);

        if (match != null) {
            service.updateScore(match, homeScore, awayScore);
        } else {
            System.out.println("Match not found for team IDs " + homeId + " and " + awayId);
        }
    }
}
