package model;

public class MainCoach extends Coach implements SoccerWorld {
    private int achieveChampionships;
    private int teamsInCharge;
    private double marketCoachPrice;
    private double coachLevel;

    public MainCoach(String employeeName, int employeeId, int salary, boolean state, int achieveChampionships,
            int experienceYears, int teamsInCharge) {
        super(employeeName, employeeId, salary, state, experienceYears);
        this.achieveChampionships = achieveChampionships;
        this.teamsInCharge = teamsInCharge;
        this.marketCoachPrice = 0;
        this.coachLevel = 0;
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

    public double getMarketCoachPrice() {
        return this.marketCoachPrice;
    }

    public double getCoachLevel() {
        return this.coachLevel;
    }

    public void calculateMarketPrice() {
        this.marketCoachPrice = (getSalary() * 10) + (getExperienceYears() * 100) + (getAchieveChampionships() * 50);
    }

    public void calculateLevel() {
        this.coachLevel = 5 + (getAchieveChampionships() / 10);
    }

    @Override
    public String showInfo() {
        String contents = super.showContents();
        contents += "************* Main Coach **************\n";
        contents += "**Achieve Championships: " + getAchieveChampionships() + "\n";
        contents += "**Teams in charge: " + getTeamsInCharge() + "\n";
        contents += "**Market Price: " + (int) getMarketCoachPrice() + "\n";
        contents += "**Level: " + (int) getCoachLevel() + "\n";
        contents += "**************************************\n";
        return contents;
    }

}
