package model;

public class LineUps {
    private final int COLUMNS_SIZE = 7;
    private final int ROWS_SIZE = 10;

    private String lineUpDate;
    private int[][] formation;
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

    public int[][] addFormation(int[] render) {
        for (int i = 0; i < ROWS_SIZE; i++) {
            for (int j = 0; j < COLUMNS_SIZE; j++) {
                formation[i][j] = 0;
            }
        }
        int z = 0;
        if (render.length == 1 || render.length == 2) {
            z = 5;
        } else if (render.length == 3 || render.length == 4) {
            z = 6;
        } else if (render.length == 5 || render.length == 6) {
            z = 7;
        } else if (render.length == 7 || render.length == 8) {
            z = 8;
        } else if (render.length == 9 || render.length == 10) {
            z = 9;
        }
        int i = 0;
        while (i < render.length) {
            int count = 0;
            if (render[i] % 2 == 0) {
                count = 1;
                int j = 4;
                while (j < COLUMNS_SIZE && render[i] > 0) {
                    formation[z][j] = 1;
                    count++;
                    if (count % 2 == 0) {
                        j = j - count;
                    } else if (count % 2 != 0) {
                        j = j + count;
                    }
                    render[i]--;
                }
            } else if (render[i] % 2 != 0) {
                int j = 3;
                while (j < COLUMNS_SIZE && render[i] > 0) {
                    formation[z][j] = 1;
                    count++;
                    if (count % 2 == 0) {
                        j = j - count;
                    } else if (count % 2 != 0) {
                        j = j + count;
                    }
                    render[i]--;
                }
            }
            i++;
            z--;
        }
        setFormation(formation);
        return formation;
    }

    public String lineUpFormat(int[][] formation) {
        String formationString = "";
        int[] nativ = new int[10];
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < COLUMNS_SIZE; j++) {
                nativ[i] += formation[i][j];
            }
        }
        for (int i = 9; i >= 0; i--) {
            if (nativ[i] != 0) {
                formationString += nativ[i] + "-";
            }

        }
        formationString = formationString.substring(0, formationString.length() - 1);
        return formationString;
    }

    public String showLineUp() {
        String contents = "********* Line Up *********\n";
        contents += "**Date: " + getLineUpDate() + "\n";
        contents += "**Tactic: " + getTactic() + "\n";
        contents += "*****Formation*****\n";
        contents += "**" + lineUpFormat(formation) + "**" + "\n";
        if (formation.length != 0) {
            for (int i = 0; i < ROWS_SIZE; i++) {
                for (int j = 0; j < COLUMNS_SIZE; j++) {
                    contents += formation[i][j] + " ";
                }
                contents += "\n";
            }
        }
        contents += "**************************\n";
        return contents;
    }
}
