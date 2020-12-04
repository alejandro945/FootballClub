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

    /**
     * The constructor method of a Team Object<br>
     */
    public Team(String teamName) {
        this.teamName = teamName;
        mainCoach = new MainCoach[MAX_SIZE_MAIN_COACH];
        asistantCoach = new AsistantCoach[MAX_SIZE_ASISTANT_COACH];
        player = new Player[MAX_SIZE_PLAYER];
    }

    /**
     * Gets the name of the Team <br>
     * 
     * @return teamName
     */
    public String getTeamName() {
        return this.teamName;
    }

    /**
     * Sets the name of the Team <br>
     * 
     * @param teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Gets the main Coach array or object main coaches registered in the Team <br>
     * 
     * @return maincoach
     */
    public MainCoach[] getMainCoach() {
        return this.mainCoach;
    }

    /**
     * Sets the main Coach array <br>
     * 
     * @param mainCoach
     */
    public void setMainCoach(MainCoach[] mainCoach) {
        this.mainCoach = mainCoach;
    }

    /**
     * Gets the Assitant Coach array or object assistant coaches registered in the
     * Team <br>
     * 
     * @return asistantCoach
     */
    public AsistantCoach[] getAsistantCoach() {
        return this.asistantCoach;
    }

    /**
     * Sets the assistant Coach array <br>
     * 
     * @param asistantCoach
     */
    public void setAsistantCoach(AsistantCoach[] asistantCoach) {
        this.asistantCoach = asistantCoach;
    }

    /**
     * Gets the Player array or object players registered in the Team <br>
     * 
     * @return Player[]
     */
    public Player[] getPlayer() {
        return this.player;
    }

    /**
     * Sets the Player array <br>
     * 
     * @param player
     */
    public void setPlayer(Player[] player) {
        this.player = player;
    }

    /**
     * 
     * This method looks for a player of the team at the time of the iteration with
     * the same id that is passed by parameter <br>
     * <b> post: </b> it will return a boolean depending on the search result <br>
     * 
     * @param employeeId != String
     * @return registeredPlayer
     */
    public boolean getRegPlayer(int employeeId) {
        boolean registeredPlayer = false;
        for (int i = 0; i < player.length; i++) {
            if (player[i] != null) {
                if (player[i].getEmployeeId() == employeeId) {
                    registeredPlayer = true;
                }
            }
        }
        return registeredPlayer;
    }

    /**
     * Adds a Player in the team based on the space criteria in it <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param registeredPlayer != null
     * @return msg
     */
    public String addEmployee(Player registeredPlayer) {
        String msg = "No se pudo agregar al jugador";
        boolean space = false;
        for (int i = 0; i < player.length && !space; i++) {
            if (player[i] == null) {
                player[i] = registeredPlayer;
                msg = "El jugador " + player[i].getEmployeeName() + " ha sido agregado exitosamente al equipo "
                        + getTeamName();
                space = true;
            }
        }
        return msg;
    }

    /**
     * Adds a Main Coach in the team based on the space criteria in it <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param registeredMainCoach != null
     * @return msg
     */
    public String addEmployee(MainCoach registeredMainCoach) {
        String msg = "No se pudo agregar al entrenador principal";
        boolean space = false;
        for (int i = 0; i < mainCoach.length && !space; i++) {
            if (mainCoach[i] == null) {
                mainCoach[i] = registeredMainCoach;
                msg = "El entrenador principal " + mainCoach[i].getEmployeeName()
                        + " ha sido agregado exitosamente al equipo " + getTeamName();
                space = true;
            }
        }
        return msg;
    }

    /**
     * Adds an Assistant coach in the team based on the space criteria in it <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param registeredAsistantCoach != null
     * @return msg
     */
    public String addEmployee(AsistantCoach registeredAsistantCoach) {
        String msg = "No se pudo agregar al entrenador asistente";
        boolean space = false;
        for (int i = 0; i < asistantCoach.length && !space; i++) {
            if (asistantCoach[i] == null) {
                asistantCoach[i] = registeredAsistantCoach;
                msg = "El entrenador asistente " + asistantCoach[i].getEmployeeName()
                        + " ha sido agregado exitosamente al equipo " + getTeamName();
                space = true;
            }
        }
        return msg;
    }

    /**
     * Removes a Player in the team wondering first if he is in the same <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param registeredPlayer != null
     * @return msg
     */
    public String removeEmployee(Player registeredPlayer) {
        String msg = "El jugador " + registeredPlayer.getEmployeeName() + " no se encuentra dentro del equipo";
        boolean space = false;
        for (int i = 0; i < MAX_SIZE_PLAYER && !space; i++) {
            if (player[i] != null && player[i] == registeredPlayer) {
                msg = "El jugador " + player[i].getEmployeeName() + " ha sido eliminado exitosamente del equipo "
                        + getTeamName();
                player[i] = null;
                space = true;
            }
        }
        return msg;
    }

    /**
     * Removes a Main Coach in the team wondering first if he is in the same <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param registeredMainCoach != null
     * @return msg
     */
    public String removeEmployee(MainCoach registeredMainCoach) {
        String msg = "El entrenador principal " + registeredMainCoach.getEmployeeName()
                + " no se encuentra dentro del equipo";
        boolean space = false;
        for (int i = 0; i < MAX_SIZE_MAIN_COACH && !space; i++) {
            if (mainCoach[i] != null) {
                if (mainCoach[i] == registeredMainCoach) {
                    msg = "El entrenador principal " + mainCoach[i].getEmployeeName()
                            + " ha sido eliminado exitosamente del equipo " + getTeamName();
                    mainCoach[i] = null;
                    space = true;
                }
            }
        }
        return msg;
    }

    /**
     * Removes an Assistant Coach in the team wondering first if he is in the same
     * <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param registeredAsistantCoach != null
     * @return msg
     */
    public String removeEmployee(AsistantCoach registeredAsistantCoach) {
        String msg = "El entrenador asistente " + registeredAsistantCoach.getEmployeeName()
                + " no se encuentra dentro del equipo";
        boolean space = false;
        for (int i = 0; i < MAX_SIZE_ASISTANT_COACH && !space; i++) {
            if (asistantCoach[i] != null) {
                if (asistantCoach[i] == registeredAsistantCoach) {
                    msg = "El entrenador asistente " + asistantCoach[i].getEmployeeName()
                            + " ha sido eliminado exitosamente del equipo " + getTeamName();
                    asistantCoach[i] = null;
                    space = true;
                }
            }
        }
        return msg;
    }

    /**
     * Add a team lineup <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param lineUpDate for better display in console avoid symbols or characters
     *                   not recognized by the machine
     * @param tactic     != String or an int have be Tactic type
     * @param formationA != String, have to be an int [] or array
     * @return msg
     */
    public String addLineup(String lineUpDate, Tactic tactic, int[] formationA) {
        String msg = "Se ha agregado exitosamente la nueva alineacion";
        LineUps newLineUp = new LineUps(lineUpDate, tactic);
        int[][] formation = newLineUp.addFormation(formationA);
        newLineUp.lineUpFormat(formation);
        lineUps.add(newLineUp);
        return msg;
    }

    /**
     * Shows the line ups registered in the team <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @return contents
     */
    public String showLineUp() {
        String contents = "";
        if (lineUps.size() == 0) {
            contents = "El equipo " + getTeamName() + " no tiene alineaciones registradas";
        } else {
            for (int i = 0; i < lineUps.size(); i++) {
                LineUps getLineUp = lineUps.get(i);
                contents += "**LineUp " + (i + 1) + "\n" + getLineUp.showLineUp();
            }
        }
        return contents;
    }

    /**
     * Shows the Generic information of each Team registered in the app at the
     * moment. It should be noted that there are only 2 teams for tax issues <br>
     * 
     * @return contents
     */
    public String showContents() {
        String contents = "*************** Team ****************\n";
        contents += "**Name: " + getTeamName() + "\n";
        if (player[0] != null || mainCoach[0] != null || asistantCoach[0] != null) {
            contents += "********** Team Employees *************\n";
        }
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
        contents += "**************************************\n";
        return contents;
    }

}
