package model;

public class MainCoach extends Coach implements SoccerWorld {
    private int achieveChampionships;
    private int teamsInCharge;
    private double marketCoachPrice;
    private double coachLevel;

    /**
     * The constructor method of a Main Coach Object<br>
     */
    public MainCoach(String employeeName, int employeeId, int salary, boolean state, int achieveChampionships,
            int experienceYears, int teamsInCharge) {
        super(employeeName, employeeId, salary, state, experienceYears);
        this.achieveChampionships = achieveChampionships;
        this.teamsInCharge = teamsInCharge;
        this.marketCoachPrice = 0;
        this.coachLevel = 0;
    }

    /**
     * Gets the achieve championships of the coach <br>
     * 
     * @return achieveChampionships
     */
    public int getAchieveChampionships() {
        return this.achieveChampionships;
    }

    /**
     * Sets the achieve championships of the coach <br>
     * 
     * @param achieveChampionships != String
     */
    public void setAchieveChampionships(int achieveChampionships) {
        this.achieveChampionships = achieveChampionships;
    }

    /**
     * Gets the teams in charge of the coach <br>
     * 
     * @return teamsInCharge
     */
    public int getTeamsInCharge() {
        return this.teamsInCharge;
    }

    /**
     * Sets the achieve championships of the coach <br>
     * 
     * @param teamsInCharge != String
     */
    public void setTeamsInCharge(int teamsInCharge) {
        this.teamsInCharge = teamsInCharge;
    }

    /**
     * Gets the market Price of the coach <br>
     * 
     * @return marketCoachPrice
     */
    public double getMarketCoachPrice() {
        return this.marketCoachPrice;
    }

    /**
     * Gets the level of the coach <br>
     * 
     * @return coachLevel
     */
    public double getCoachLevel() {
        return this.coachLevel;
    }

    /**
     * Calculates the market price of the main coach with criteria-based
     * counterproductive <br>
     */
    public void calculateMarketPrice() {
        this.marketCoachPrice = (getSalary() * 10) + (getExperienceYears() * 100) + (getAchieveChampionships() * 50);
    }

    /**
     * Calculates the level of the main coach with criteria-based counterproductive
     * <br>
     */
    public void calculateLevel() {
        this.coachLevel = 5 + (getAchieveChampionships() / 10);
    }

    /**
     * Shows the Particular information of each Main Coach registered in the app at
     * the moment <br>
     * 
     * @return contents
     */
    @Override
    public String showInfo() {
        String contents = super.showContent();
        contents += "************* Main Coach **************\n";
        contents += "**Achieve Championships: " + getAchieveChampionships() + "\n";
        contents += "**Teams in charge: " + getTeamsInCharge() + "\n";
        contents += "**Market Price: " + (int) getMarketCoachPrice() + "\n";
        contents += "**Level: " + (int) getCoachLevel() + "\n";
        contents += "**************************************\n";
        return contents;
    }

}
