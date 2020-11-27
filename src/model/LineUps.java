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
        formation = new int[COLUMNS_SIZE][ROWS_SIZE];
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

    public int[][] addFormation(int defenders, int midfielders, int fowards) {
        for (int i = 0; i < COLUMNS_SIZE; i++) {
            for (int j = 0; j < ROWS_SIZE; j++) {
                formation[i][j] = 0;
            }
        }
        for (int i = 0; i < COLUMNS_SIZE; i++) {
            for (int j = 0; j < ROWS_SIZE; j++) {
                if (i == 2 && fowards != 0) {
                    formation[i][j] = 1;
                    fowards--;
                }
                if (i == 5 && midfielders != 0) {
                    formation[i][j] = 1;
                    midfielders--;
                }
                if (i == 8 && defenders != 0) {
                    formation[i][j] = 1;
                    defenders--;
                }
            }
        }
        setFormation(formation);
        return formation;
    }

    public void lineUpFormat(int[][] formation) {
        int defender = 0;
        int midfielders = 0;
        int fowards = 0;
        for (int i = 0; i < COLUMNS_SIZE; i++) {
            for (int j = 0; j < ROWS_SIZE; j++) {
                if (i == 2) {
                    fowards += formation[i][j];
                }
                if (i == 5) {
                    midfielders += formation[i][j];
                }
                if (i == 8) {
                    defender += formation[i][j];
                }
            }
        }
        String formationString = defender + "-" + midfielders + "-" + fowards;
        setFormationString(formationString);
    }

    public String showLineUp() {
        String contents = "********* Line Up *********\n";
        contents += "**Date: " + getLineUpDate() + "\n";
        contents += "**Tactic: " + getTactic() + "\n";
        contents += "*****Formation*****\n";
        contents += "**" + getFormationString() + "**" + "\n";
        if (formation.length != 0) {
            for (int i = 0; i < COLUMNS_SIZE; i++) {
                for (int j = 0; j < ROWS_SIZE; j++) {
                    contents += formation[i][j] + " ";
                }
                contents += "\n";
            }
        }
        contents += "**************************";
        return contents;
    }
}
