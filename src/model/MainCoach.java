package model;

public class MainCoach extends Coach implements SoccerWorld {
    private int achieveChampionships;
    private int teamsInCharge;

    public MainCoach(String employeeName, int employeeId, int salary, int achieveChampionships, int experienceYears,
            int teamsInCharge) {
        super(employeeName, employeeId, salary, experienceYears);
        this.achieveChampionships = achieveChampionships;
        this.teamsInCharge = teamsInCharge;
    }

    public int getAchieveChampionships() {
        return this.achieveChampionships;
    }

    public void setAchieveChampionships(int achieveChampionships) {
        this.achieveChampionships = achieveChampionships;
    }

    public int getTeamsInCharge() {
        return this.teamsInCharge;
    }

    public void setTeamsInCharge(int teamsInCharge) {
        this.teamsInCharge = teamsInCharge;
    }

    public void calculateMarketPrice() {

    }

    public void calculateLevel() {

    }

    @Override
    public String toString() {
        return "{" + " achieveChampionships='" + getAchieveChampionships() + "'" + ", teamsInCharge='"
                + getTeamsInCharge() + "'" + "}";
    }

}
