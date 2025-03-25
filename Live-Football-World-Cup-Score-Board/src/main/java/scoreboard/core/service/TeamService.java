package scoreboard.core.service;

import scoreboard.core.database.TeamDatabase;
import scoreboard.core.model.Team;

import java.util.List;

public class TeamService {

    private final TeamDatabase teamDatabase;

    public TeamService() {
        this.teamDatabase = new TeamDatabase();
    }


    public Team getTeamByName(String name) {
        return teamDatabase.getTeams().stream()
                .filter(team -> team.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    // ✅ Update a team's score
    public boolean updateTeamScore(String teamName, int newScore) {
        Team team = getTeamByName(teamName);
        if (team != null) {
            team.setScore(newScore);
            return true;
        }
        return false;
    }
}
