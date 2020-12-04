package model;

public class Player extends Employee implements SoccerWorld {
    private int ShirtNumber;
    private int scoredGoals;
    private double averageMark;
    private Position position;
    private double marketPrice;
    private double level;

    /**
     * The constructor method of a Player Object<br>
     */
    public Player(String employeeName, int employeeId, int salary, boolean state, int ShirtNumber, Position position) {
        super(employeeName, employeeId, salary, state);
        this.ShirtNumber = ShirtNumber;
        this.scoredGoals = 0;
        this.averageMark = 0;
        this.position = position;
        this.marketPrice = 0;
        this.level = 0;
    }

    /**
     * Gets the shirt number of the player <br>
     * 
     * @return ShirtNumber
     */
    public int getShirtNumber() {
        return this.ShirtNumber;
    }

    /**
     * Sets the shirt number of the player <br>
     * 
     * @param ShirtNumber != String
     */
    public void setShirtNumber(int ShirtNumber) {
        this.ShirtNumber = ShirtNumber;
    }

    /**
     * Gets the Scored Goals of the player <br>
     * 
     * @return scoredGoals
     */
    public int getScoredGoals() {
        return this.scoredGoals;
    }

    /**
     * Sets the Scored Goals of the player <br>
     * 
     * @param scoredGoals != String
     */
    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    /**
     * Gets the average mark of the player <br>
     * 
     * @return averageMark
     */
    public double getAverageMark() {
        return this.averageMark;
    }

    /**
     * Sets the average mark of the player <br>
     * 
     * @param averageMark != String
     */
    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    /**
     * @return Position
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     * @param position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Gets the market price of the player <br>
     * 
     * @return marketPrice
     */
    public double getMarketPrice() {
        return this.marketPrice;
    }

    /**
     * Gets the level of the player <br>
     * 
     * @return level
     */
    public double getLevel() {
        return this.level;
    }

    /**
     * Calculates the market price of the player with criteria-based
     * counterproductive <br>
     */
    public void calculateMarketPrice() {
        if (getPosition() == Position.GOAL_KEEPER) {
            this.marketPrice = (getSalary() * 12) + (getAverageMark() * 150);
        } else if (getPosition() == Position.DEFENDER) {
            this.marketPrice = (getSalary() * 13) + (getAverageMark() * 125) + (getScoredGoals() * 100);
        } else if (getPosition() == Position.MIDFIELDER) {
            this.marketPrice = (getSalary() * 14) + (getAverageMark() * 135) + (getScoredGoals() * 120);
        } else if (getPosition() == Position.FOWARD) {
            this.marketPrice = (getSalary() * 15) + (getAverageMark() * 145) + (getScoredGoals() * 150);
        }
    }

    /**
     * Calculates the level of the player with criteria-based counterproductive <br>
     */
    public void calculateLevel() {
        if (getPosition() == Position.GOAL_KEEPER) {
            this.level = (getAverageMark() * 0.9);
        } else if (getPosition() == Position.DEFENDER) {
            this.level = (getAverageMark() * 0.9) + (getScoredGoals() / 100);
        } else if (getPosition() == Position.MIDFIELDER) {
            this.level = (getAverageMark() * 0.9) + (getScoredGoals() / 90);
        } else if (getPosition() == Position.FOWARD) {
            this.level = (getAverageMark() * 0.9) + (getScoredGoals() / 80);
        }
    }

    /**
     * Shows the Particular information of each Player registered in the app at the
     * moment <br>
     * 
     * @return contents
     */
    @Override
    public String showInfo() {
        String contents = super.showContents();
        contents += "************* Player ****************\n";
        contents += "**Shirt Number: " + getShirtNumber() + "\n";
        contents += "**Goals: " + getScoredGoals() + "\n";
        contents += "**Average Mark: " + getAverageMark() + "\n";
        contents += "**Position: " + getPosition() + "\n";
        contents += "**Market Price: " + (int) getMarketPrice() + "\n";
        contents += "**Level: " + (int) getLevel() + "\n";
        contents += "**************************************\n";
        return contents;
    }
}
