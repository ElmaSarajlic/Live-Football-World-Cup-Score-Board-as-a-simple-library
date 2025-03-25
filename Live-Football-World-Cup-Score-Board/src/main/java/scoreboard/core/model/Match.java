package scoreboard.core.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Match {
    int id;
    private Team team1;
    private Team team2;
    private Date date;
    private LocalDateTime startTime;

    public Match(int id, Team team1, Team team2, int totalScore, Date date, LocalDateTime startTime) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.startTime = startTime;
    }

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getTotalScore() {
        return team1.getScore() + team2.getScore();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalDateTime getStartTime() {
        return startTime;  // Ensure this method is defined
    }
}
