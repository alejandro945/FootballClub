package model;

public abstract class Coach extends Employee {
    private int experienceYears;

    /**
     * The constructor method of a Coach Object, but in this case we wont use it,
     * due to this class is abstact <br>
     */
    public Coach(String employeeName, int employeeId, int salary, boolean state, int experienceYears) {
        super(employeeName, employeeId, salary, state);
        this.experienceYears = experienceYears;
    }

    /**
     * Gets the Experience years of a Coach <br>
     * 
     * @return experienceYears
     */
    public int getExperienceYears() {
        return this.experienceYears;
    }

    /**
     * Sets the Experience years of a Coach <br>
     * 
     * @param experienceYears != String
     */
    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    /**
     * ABSTRACT METHOD
     */
    public abstract String showInfo();

    // ---------------Method used to save a few lines of code--------------------
    /**
     * Shows the Generic information of each Coach registered in the app at the
     * moment <br>
     * 
     * @return contents
     */
    public String showContent() {
        String contents = super.showContents();
        contents += "**Experience Years: " + getExperienceYears() + "\n";
        return contents;
    }

}
