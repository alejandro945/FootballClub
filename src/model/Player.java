package model;

public class Player extends Employee implements SoccerWorld {
    private int ShirtNumber;
    private int scoredGoals;
    private double averageMark;
    private Position position;
    private double marketPrice;
    private double level;

    public Player(String employeeName, int employeeId, int salary, int ShirtNumber, int scoredGoals, double averageMark,
            Position position) {
        super(employeeName, employeeId, salary);
        this.ShirtNumber = ShirtNumber;
        this.scoredGoals = scoredGoals;
        this.averageMark = averageMark;
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

    }

    public void calculateLevel() {

    }

    @Override
    public String showInfo() {
        String contents = super.showContents();
        contents += "************* Player **************\n";
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
