package model;

public abstract class Coach extends Employee {
    private int experienceYears;

    public Coach(String employeeName, int employeeId, int salary, int experienceYears) {
        super(employeeName, employeeId, salary);
        this.experienceYears = experienceYears;
    }

    public int getExperienceYears() {
        return this.experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public String toString() {
        return "{" + " experienceYears='" + getExperienceYears() + "'" + "}";
    }

}
