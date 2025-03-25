package scoreboard.core.database;

import scoreboard.core.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamDatabase {
    private final List<Team> teams; // ✅ Declare the list

    public TeamDatabase() {
        this.teams = new ArrayList<>(); // ✅ Initialize the list before adding elements

        teams.add(new Team(0, "Mexico", 0));
        teams.add(new Team(1, "Canada", 5));
        teams.add(new Team(2, "Spain", 10));
        teams.add(new Team(3, "Brazil", 2));
        teams.add(new Team(4, "Germany", 2));
        teams.add(new Team(5, "France", 2));
        teams.add(new Team(6, "Uruguay", 6));
        teams.add(new Team(7, "Italy", 6));
        teams.add(new Team(8, "Argentina", 3));
        teams.add(new Team(9, "Australia", 1));
    }

    public List<Team> getTeams() {
        return teams;
    }
}
