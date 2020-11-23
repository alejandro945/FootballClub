package model;

import java.util.ArrayList;

public class Team {
    private final int MAX_SIZE_MAIN_COACH = 1;
    private final int MAX_SIZE_ASISTANT_COACH = 3;
    private final int MAX_SIZE_PLAYER = 25;

    private String teamName;
    private MainCoach[] mainCoach;
    private AsistantCoach[] asistantCoach;
    private Player[] player;
    private ArrayList<LineUps> lineUps = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
        mainCoach = new MainCoach[MAX_SIZE_MAIN_COACH];
        asistantCoach = new AsistantCoach[MAX_SIZE_ASISTANT_COACH];
        player = new Player[MAX_SIZE_PLAYER];
    }

    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public MainCoach[] getMainCoach() {
        return this.mainCoach;
    }

    public void setMainCoach(MainCoach[] mainCoach) {
        this.mainCoach = mainCoach;
    }

    public AsistantCoach[] getAsistantCoach() {
        return this.asistantCoach;
    }

    public void setAsistantCoach(AsistantCoach[] asistantCoach) {
        this.asistantCoach = asistantCoach;
    }

    public Player[] getPlayer() {
        return this.player;
    }

    public void setPlayer(Player[] player) {
        this.player = player;
    }

    public String toString() {
        return "{" + " teamName='" + getTeamName() + "'" + "}";
    }

}
