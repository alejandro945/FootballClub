package model;

public class LineUps {
    private final int COLUMNS_SIZE = 7;
    private final int ROWS_SIZE = 10;

    private String lineUpDate;
    private int[][] formation;
    private String formationString;
    private Tactic tactic;

    public LineUps(String lineUpDate, Tactic tactic) {
        this.lineUpDate = lineUpDate;
        formation = new int[ROWS_SIZE][COLUMNS_SIZE];
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

    public int getCOLUMNS_SIZE() {
        return this.COLUMNS_SIZE;
    }

    public int getROWS_SIZE() {
        return this.ROWS_SIZE;
    }

    public String getFormationString() {
        return this.formationString;
    }

    public void setFormationString(String formationString) {
        this.formationString = formationString;
    }

    public int[][] addFormation(int[] render) {
        for (int i = 0; i < ROWS_SIZE; i++) {
            for (int j = 0; j < COLUMNS_SIZE; j++) {
                formation[i][j] = 0;
            }
        }
        for (int i = 0; i < ROWS_SIZE && i < render.length; i++) {
            for (int j = 0; j < COLUMNS_SIZE && render[i] > 0; j++) {
                formation[i][j] = 1;
                render[i]--;
            }
        }
        setFormation(formation);
        return formation;
    }

    public void lineUpFormat(int[][] formation, int size) {
        int[] render = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < COLUMNS_SIZE; j++) {
                render[i] += formation[i][j];
            }
        }
        for (int i = 0; i < render.length; i++) {
            formationString += render[i] + "-";
        }
        setFormationString(formationString);
    }

    public String showLineUp() {
        String contents = "********* Line Up *********\n";
        contents += "**Date: " + getLineUpDate() + "\n";
        contents += "**Tactic: " + getTactic() + "\n";
        contents += "*****Formation*****\n";
        contents += "**" + getFormationString() + "**" + "\n";
        if (formation.length != 0) {
            for (int i = 0; i < ROWS_SIZE; i++) {
                for (int j = 0; j < COLUMNS_SIZE; j++) {
                    contents += formation[i][j] + " ";
                }
                contents += "\n";
            }
        }
        contents += "**************************";
        return contents;
    }
}
