package model;

import java.util.ArrayList;

public class Team {
    private final int MAX_SIZE_MAIN_COACH = 1;
    private final int MAX_SIZE_ASISTANT_COACH = 3;
    private final int MAX_SIZE_PLAYER = 25;

    private String teamName;
    private MainCoach[] mainCoach;
    private AsistantCoach[] asistantCoach;
    private Player[] player;
    private ArrayList<LineUps> lineUps = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
        mainCoach = new MainCoach[MAX_SIZE_MAIN_COACH];
        asistantCoach = new AsistantCoach[MAX_SIZE_ASISTANT_COACH];
        player = new Player[MAX_SIZE_PLAYER];
    }

    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public MainCoach[] getMainCoach() {
        return this.mainCoach;
    }

    public void setMainCoach(MainCoach[] mainCoach) {
        this.mainCoach = mainCoach;
    }

    public AsistantCoach[] getAsistantCoach() {
        return this.asistantCoach;
    }

    public void setAsistantCoach(AsistantCoach[] asistantCoach) {
        this.asistantCoach = asistantCoach;
    }

    public Player[] getPlayer() {
        return this.player;
    }

    public void setPlayer(Player[] player) {
        this.player = player;
    }

    public boolean getRegPlayer(int employeeId) {
        boolean registeredPlayer = false;
        for (int i = 0; i < player.length; i++) {
            if (player[i].getEmployeeId() == employeeId) {
                registeredPlayer = true;
            }
        }
        return registeredPlayer;
    }

    public String addEmployee(Player registeredPlayer) {
        String msg = "No se pudo agregar al jugador";
        boolean space = false;
        for (int i = 0; i < player.length && !space; i++) {
            if (player[i] == null) {
                player[i] = registeredPlayer;
                msg = "El jugador " + player[i].getEmployeeName() + " ha sido agregado exitosamente al equipo"
                        + getTeamName();
                space = true;
            }
        }
        return msg;
    }

    public String addEmployee(MainCoach registeredMainCoach) {
        String msg = "No se pudo agregar al entrenador principal";
        boolean space = false;
        for (int i = 0; i < mainCoach.length && !space; i++) {
            if (mainCoach[i] == null) {
                mainCoach[i] = registeredMainCoach;
                msg = "El entrenador principal " + mainCoach[i].getEmployeeName()
                        + " ha sido agregado exitosamente al equipo" + getTeamName();
                space = true;
            }
        }
        return msg;
    }

    public String addEmployee(AsistantCoach registeredAsistantCoach) {
        String msg = "No se pudo agregar al entrenador asistente";
        boolean space = false;
        for (int i = 0; i < asistantCoach.length && !space; i++) {
            if (asistantCoach[i] == null) {
                asistantCoach[i] = registeredAsistantCoach;
                msg = "El entrenador asistente " + asistantCoach[i].getEmployeeName()
                        + " ha sido agregado exitosamente al equipo" + getTeamName();
                space = true;
            }
        }
        return msg;
    }

    public String removeEmployee(Player registeredPlayer) {
        String msg = "No se pudo eliminar al jugador";
        boolean space = false;
        for (int i = 0; i < player.length && !space; i++) {
            if (player[i] == registeredPlayer) {
                player[i] = null;
                msg = "El jugador " + player[i].getEmployeeName() + " ha sido eliminado exitosamente del equipo"
                        + getTeamName();
                space = true;
            }
        }
        return msg;
    }

    public String removeEmployee(MainCoach registeredMainCoach) {
        String msg = "No se pudo eliminar al entrenador principal";
        boolean space = false;
        for (int i = 0; i < mainCoach.length && !space; i++) {
            if (mainCoach[i] == registeredMainCoach) {
                mainCoach[i] = null;
                msg = "El entrenador principal " + mainCoach[i].getEmployeeName()
                        + " ha sido eliminado exitosamente del equipo" + getTeamName();
                space = true;
            }
        }
        return msg;
    }

    public String removeEmployee(AsistantCoach registeredAsistantCoach) {
        String msg = "No se pudo eliminar al entrenador asistente";
        boolean space = false;
        for (int i = 0; i < asistantCoach.length && !space; i++) {
            if (asistantCoach[i] == registeredAsistantCoach) {
                asistantCoach[i] = null;
                msg = "El entrenador asistente " + asistantCoach[i].getEmployeeName()
                        + " ha sido eliminado exitosamente del equipo" + getTeamName();
                space = true;
            }
        }
        return msg;
    }

    public String addLineup(String lineUpDate, Tactic tactic, String formationA) {
        String msg = "Se ha agregado exitosamente la nueva alineacion";
        String[] render = new String[3];
        render = formationA.split("-");
        int defenders = Integer.parseInt(render[0]);
        int midfielders = Integer.parseInt(render[1]);
        int fowards = Integer.parseInt(render[2]);
        LineUps newLineUp = new LineUps(lineUpDate, tactic);
        int[][] formation = newLineUp.addFormation(defenders, midfielders, fowards);
        newLineUp.lineUpFormat(formation);
        lineUps.add(newLineUp);
        return msg;
    }

    public String showContents() {
        String contents = "************* Team **************\n";
        contents += "**Name: " + getTeamName() + "\n";
        for (int i = 0; i < MAX_SIZE_PLAYER; i++) {
            if (player[i] != null) {
                contents += "**Player " + (i + 1) + "\n" + player[i].showInfo();
            }
        }
        for (int i = 0; i < MAX_SIZE_MAIN_COACH; i++) {
            if (mainCoach[i] != null) {
                contents += "**Main Coach: " + "\n" + mainCoach[i].showInfo();
            }
        }
        for (int i = 0; i < MAX_SIZE_ASISTANT_COACH; i++) {
            if (asistantCoach[i] != null) {
                contents += "**Assintant Coach " + (i + 1) + "\n" + asistantCoach[i].showInfo();
            }
        }
        for (int i = 0; i < lineUps.size(); i++) {
            LineUps getLineUp = lineUps.get(i);
            contents += "**LineUp " + (i + 1) + "\n" + getLineUp.showLineUp();
        }
        contents += "**************************************\n";
        return contents;
    }

}
