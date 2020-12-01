package model;

public class Player extends Employee implements SoccerWorld {
    private int ShirtNumber;
    private int scoredGoals;
    private double averageMark;
    private Position position;
    private double marketPrice;
    private double level;

    public Player(String employeeName, int employeeId, int salary, boolean state, int ShirtNumber, Position position) {
        super(employeeName, employeeId, salary, state);
        this.ShirtNumber = ShirtNumber;
        this.scoredGoals = 0;
        this.averageMark = 0;
        this.position = position;
        this.marketPrice = 0;
        this.level = 0;
    }

    public int getShirtNumber() {
        return this.ShirtNumber;
    }

    public void setShirtNumber(int ShirtNumber) {
        this.ShirtNumber = ShirtNumber;
    }

    public int getScoredGoals() {
        return this.scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    public double getAverageMark() {
        return this.averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getMarketPrice() {
        return this.marketPrice;
    }

    public double getLevel() {
        return this.level;
    }

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
