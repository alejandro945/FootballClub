package model;

public class LineUps {
    private String lineUpDate;
    private int[][] formation;
    private Tactic tactic;

    public LineUps(String lineUpDate, int[][] formation, Tactic tactic) {
        this.lineUpDate = lineUpDate;
        this.formation = formation;
        this.tactic = tactic;
    }

    public String getLineUpDate() {
        return this.lineUpDate;
    }

    public void setLineUpDate(String lineUpDate) {
        this.lineUpDate = lineUpDate;
    }

    public int[][] getFormation() {
        return this.formation;
    }

    public void setFormation(int[][] formation) {
        this.formation = formation;
    }

    public Tactic getTactic() {
        return this.tactic;
    }

    public void setTactic(Tactic tactic) {
        this.tactic = tactic;
    }

    public String toString() {
        return "{" + " lineUpDate='" + getLineUpDate() + "'" + ", formation='" + getFormation() + "'" + ", tactic='"
                + getTactic() + "'" + "}";
    }
}
