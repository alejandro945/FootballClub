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

    /**
     * ABSTRACT METHOD
     */
    public abstract String showInfo();

    // ---------------Method used to save a few lines of code--------------------
    /**
     * Shows the Generic information of each Playlist registered in the app at the
     * moment <br>
     * 
     * @return contents
     */
    public String showContents() {
        String contents = super.showContents();
        contents += "**Experience Years: " + getExperienceYears() + "\n";
        return contents;
    }

}
