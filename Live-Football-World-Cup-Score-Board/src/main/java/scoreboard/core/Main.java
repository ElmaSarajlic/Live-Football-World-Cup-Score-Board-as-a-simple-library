package scoreboard.core;

import scoreboard.core.database.TeamDatabase;
import scoreboard.core.model.Team;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TeamDatabase teamDatabase = new TeamDatabase();

        // Run individual tests manually
        testGetTeams(teamDatabase);
        testUpdateScore(teamDatabase);
        testAddNewTeam(teamDatabase);
        testGetTeamById(teamDatabase);
    }

    public static void testGetTeams(TeamDatabase teamDatabase) {
        List<Team> teams = teamDatabase.getTeams();
        System.out.println("Testing getTeams...");
        if (teams != null && teams.size() == 10) {
            System.out.println("getTeams Test Passed!");
        } else {
            System.out.println("getTeams Test Failed!");
        }
    }

    public static void testUpdateScore(TeamDatabase teamDatabase) {
        List<Team> teams = teamDatabase.getTeams();
        Team mexico = teams.stream().filter(team -> team.getName().equals("Mexico")).findFirst().orElse(null);
        if (mexico != null) {
            mexico.setScore(5);
            if (mexico.getScore() == 5) {
                System.out.println("updateScore Test Passed!");
            } else {
                System.out.println("updateScore Test Failed!");
            }
        } else {
            System.out.println("updateScore Test Failed!");
        }
    }

    public static void testAddNewTeam(TeamDatabase teamDatabase) {
        List<Team> teams = teamDatabase.getTeams();
        Team newTeam = new Team(10, "Brazil", 0);
        teams.add(newTeam);

        if (teams.stream().anyMatch(team -> team.getName().equals("Brazil"))) {
            System.out.println("addNewTeam Test Passed!");
        } else {
            System.out.println("addNewTeam Test Failed!");
        }
    }

    public static void testGetTeamById(TeamDatabase teamDatabase) {
        List<Team> teams = teamDatabase.getTeams();
        Team brazil = teams.stream().filter(team -> team.getId() == 3).findFirst().orElse(null);

        if (brazil != null && brazil.getName().equals("Brazil")) {
            System.out.println("getTeamById Test Passed!");
        } else {
            System.out.println("getTeamById Test Failed!");
        }
    }
}
