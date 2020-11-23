package model;

public class Player extends Employee implements SoccerWorld {
    private int ShirtNumber;
    private int scoredGoals;
    private double averageMark;
    private Position position;

    public Player(String employeeName, int employeeId, int salary, int ShirtNumber, int scoredGoals, double averageMark,
            Position position) {
        super(employeeName, employeeId, salary);
        this.ShirtNumber = ShirtNumber;
        this.scoredGoals = scoredGoals;
        this.averageMark = averageMark;
        this.position = position;
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

    public void calculateMarketPrice() {

    }

    public void calculateLevel() {

    }

    public String toString() {
        return "{" + " ShirtNumber='" + getShirtNumber() + "'" + ", scoredGoals='" + getScoredGoals() + "'"
                + ", averageMark='" + getAverageMark() + "'" + "}";
    }
}
