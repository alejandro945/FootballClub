package model;

public class AsistantCoach extends Coach {
    private boolean soccerProfessional;
    private Expertise expertise;

    /**
     * The constructor method of an Assistant Coach Object<br>
     */
    public AsistantCoach(String employeeName, int employeeId, int salary, boolean state, int experienceYears,
            boolean soccerProfessional, Expertise expertise) {
        super(employeeName, employeeId, salary, state, experienceYears);
        this.soccerProfessional = soccerProfessional;
        this.expertise = expertise;
    }

    /**
     * Gets the answer of the is a soccer professional? question. <br>
     * 
     * @return soccerProfessional
     */
    public boolean getSoccerProfessional() {
        return this.soccerProfessional;
    }

    /**
     * Sets the soccer professional answer <br>
     * 
     * @param soccerProfessional != String or an int
     */
    public void setSoccerProfessional(boolean soccerProfessional) {
        this.soccerProfessional = soccerProfessional;
    }

    /**
     * Gets the expertise of the assistantCoach <br>
     * 
     * @return Expertise
     */
    public Expertise getExpertise() {
        return this.expertise;
    }

    /**
     * Sets the expertise of the assistantCoach <br>
     * 
     * @param expertise != String or an int
     */
    public void setExpertise(Expertise expertise) {
        this.expertise = expertise;
    }

    /**
     * Shows the Particular information of each assistant Coach registered in the
     * app at the moment <br>
     * 
     * @return contents
     */
    @Override
    public String showInfo() {
        String contents = super.showContent();
        contents += "********** Assitant Coach ************\n";
        if (getSoccerProfessional()) {
            contents += "**Soccer Profesional: YES \n";
        } else {
            contents += "**Soccer Profesional: NO \n";
        }
        contents += "**Expertise: " + getExpertise() + "\n";
        contents += "**************************************\n";
        return contents;
    }

}
