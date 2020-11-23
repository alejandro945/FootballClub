package model;

public class AsistantCoach extends Coach {
    private boolean soccerProfessional;
    private Expertise expertise;

    public AsistantCoach(String employeeName, int employeeId, int salary, int experienceYears,
            boolean soccerProfessional, Expertise expertise) {
        super(employeeName, employeeId, salary, experienceYears);
        this.soccerProfessional = soccerProfessional;
        this.expertise = expertise;
    }

    public boolean isSoccerProfessional() {
        return this.soccerProfessional;
    }

    public boolean getSoccerProfessional() {
        return this.soccerProfessional;
    }

    public Expertise getExpertise() {
        return this.expertise;
    }

    public void setExpertise(Expertise expertise) {
        this.expertise = expertise;
    }

    public void setSoccerProfessional(boolean soccerProfessional) {
        this.soccerProfessional = soccerProfessional;
    }

    @Override
    public String toString() {
        return "{" + " soccerProfessional='" + isSoccerProfessional() + "'" + "}";
    }

}
