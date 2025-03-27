package scoreboard.core.database;

import scoreboard.core.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamDatabase {
    private final List<Team> teams;

    public TeamDatabase() {
        this.teams = new ArrayList<>();

        teams.add(new Team("0", "Mexico"));
        teams.add(new Team("1", "Canada"));
        teams.add(new Team("2", "Spain"));
        teams.add(new Team("3", "Brazil"));
        teams.add(new Team("4", "Germany"));
        teams.add(new Team("5", "France"));
        teams.add(new Team("6", "Uruguay"));
        teams.add(new Team("7", "Italy"));
        teams.add(new Team("8", "Argentina"));
        teams.add(new Team("9", "Australia"));
    }

    public List<Team> getTeams() {
        return teams;
    }
}
