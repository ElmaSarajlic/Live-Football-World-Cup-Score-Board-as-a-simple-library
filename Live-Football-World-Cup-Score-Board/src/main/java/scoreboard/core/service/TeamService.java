package scoreboard.core.service;

import scoreboard.core.database.TeamDatabase;
import scoreboard.core.model.Team;

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

}
