package model;

import java.util.ArrayList;

public class FootballClub {
    private final int ORDER_OFFICES = 6;
    private final int ORDER_ROOM1 = 7;
    private final int COLUMNS_SIZE_ROOM2 = 6;
    private final int ROWS_SIZE_ROOM2 = 7;

    private String name;
    private int nit;
    private String fundationDate;
    private Team[] team = new Team[2];
    private ArrayList<Employee> employee = new ArrayList<>();
    private Coach[][] officeSector;
    private Player[][] dressingRoom1;
    private Player[][] dressingRoom2;

    /**
     * The constructor method of the Club Object<br>
     */
    public FootballClub(String name, int nit, String fundationDate) {
        this.name = name;
        this.nit = nit;
        this.fundationDate = fundationDate;
        team[0] = new Team("LIVERPOOL");
        team[1] = new Team("BARCELONA");
        officeSector = new Coach[ORDER_OFFICES][ORDER_OFFICES];
        dressingRoom1 = new Player[ORDER_ROOM1][ORDER_ROOM1];
        dressingRoom2 = new Player[ROWS_SIZE_ROOM2][COLUMNS_SIZE_ROOM2];
    }

    /**
     * Gets the club Name <br>
     * 
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the club Name <br>
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the club identification or nit <br>
     * 
     * @return nit
     */
    public int getNit() {
        return this.nit;
    }

    /**
     * Sets the club identification or nit <br>
     * 
     * @param nit != String
     */
    public void setNit(int nit) {
        this.nit = nit;
    }

    /**
     * Gets the fundation date of the club <br>
     * 
     * @return fundationDate
     */
    public String getFundationDate() {
        return this.fundationDate;
    }

    /**
     * Sets the fundation date of the club <br>
     * 
     * @param fundationDate
     */
    public void setFundationDate(String fundationDate) {
        this.fundationDate = fundationDate;
    }

    /**
     * Assigns an office to a coach registered in the club, following all security
     * protocols (temperature taking and disinfection point) <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param registeredCoach != null
     * @return msg
     */
    public String addCoachToOffice(Coach registeredCoach) {
        String msg = "No hay oficinas disponibles";
        boolean asigned = false;
        for (int i = 0; i < ORDER_OFFICES && !asigned; i++) {
            for (int j = 0; j < ORDER_OFFICES && !asigned; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    if (officeSector[i][j] == null) {
                        officeSector[i][j] = registeredCoach;
                        asigned = true;
                        msg = "Se ha asignado una oficina exitosamente al entrenador "
                                + registeredCoach.getEmployeeName();
                    }
                } else if (i % 2 != 0 && j % 2 != 0) {
                    if (officeSector[i][j] == null) {
                        officeSector[i][j] = registeredCoach;
                        asigned = true;
                        msg = "Se ha asignado una oficina exitosamente al entrenador "
                                + registeredCoach.getEmployeeName();
                    }
                }
            }
        }
        return msg;
    }

    /**
     * Assigns a dressing room to a player registered at club, following all
     * security protocols (temperature check and disinfection point). In addition to
     * restricting access to players from different teams in the same dressing room
     * <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param registeredPlayer != null
     * @param registeredTeam   != null
     * @return msg
     */
    public String addPlayerToDressing(Player registeredPlayer, Team registeredTeam) {
        String msg = "No hay camerinos disponibles";
        int render1 = 0;
        int render2 = 0;
        boolean asigned1 = false;
        boolean asigned2 = false;
        if (dressingRoom1[0][0] != null) {
            render1 = dressingRoom1[0][0].getEmployeeId();
        }
        if (dressingRoom2[0][0] != null) {
            render2 = dressingRoom2[0][0].getEmployeeId();
        }
        for (int i = 0; i < ORDER_ROOM1 && !asigned1; i++) {
            for (int j = 0; j < ORDER_ROOM1 && !asigned1; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    if (dressingRoom1[0][0] == null) {
                        dressingRoom1[i][j] = registeredPlayer;
                        asigned1 = true;
                        msg = "Se ha asignado un vestidor en el camerino 1 exitosamente";
                    } else if (registeredTeam.getRegPlayer(render1) && dressingRoom1[i][j] == null) {
                        dressingRoom1[i][j] = registeredPlayer;
                        asigned1 = true;
                        msg = "Se ha asignado un vestidor en el camerino 1 exitosamente";
                    }
                }
                if (i % 2 != 0 && j % 2 != 0) {
                    if (registeredTeam.getRegPlayer(render1) && dressingRoom1[i][j] == null) {
                        dressingRoom1[i][j] = registeredPlayer;
                        asigned1 = true;
                        msg = "Se ha asignado un vestidor en el camerino 1 exitosamente";
                    }
                }
            }
        }
        for (int i = 0; i < ROWS_SIZE_ROOM2 && !asigned1 && !asigned2; i++) {
            for (int j = 0; j < COLUMNS_SIZE_ROOM2 && !asigned2; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    if (dressingRoom2[0][0] == null) {
                        dressingRoom2[i][j] = registeredPlayer;
                        asigned2 = true;
                        msg = "Se ha asignado un vestidor en el camerino 2 exitosamente";
                    } else if (registeredTeam.getRegPlayer(render2) && dressingRoom2[i][j] == null) {
                        dressingRoom2[i][j] = registeredPlayer;
                        asigned2 = true;
                        msg = "Se ha asignado un vestidor en el camerino 2 exitosamente";
                    }
                }
                if (i % 2 != 0 && j % 2 != 0) {
                    if (registeredTeam.getRegPlayer(render2) && dressingRoom2[i][j] == null) {
                        dressingRoom2[i][j] = registeredPlayer;
                        asigned2 = true;
                        msg = "Se ha asignado un vestidor en el camerino 2 exitosamente";
                    }
                }
            }
        }
        return msg;
    }

    /**
     * This method looks for a team in the club at the time of the iteration with
     * the same name that is passed by parameter <br>
     * 
     * @param teamName
     * @return existT
     */
    public boolean searchTeam(String teamName) {
        boolean existT = false;
        for (int i = 0; i < team.length && !existT; i++) {
            if (team[i].getTeamName().equalsIgnoreCase(teamName)) {
                existT = true;
            }
        }
        return existT;
    }

    /**
     * This method looks for an employee in the club at the time of the iteration
     * with the same identification that is passed by parameter <br>
     * 
     * @param employeeId != String
     * @return existE
     */
    public boolean searchEmployee(int employeeId) {
        boolean existE = false;
        for (int i = 0; i < employee.size() && !existE; i++) {
            Employee getEmployee = employee.get(i);
            if (getEmployee.getEmployeeId() == employeeId) {
                existE = true;
            }
        }
        return existE;
    }

    /**
     * Search a Player in a team depending of the id passed as a parameter <br>
     * <b> post: </b> this method will return a team object with the player in it
     * <br>
     * 
     * @param employeeId != String
     * @return Team
     */
    public Team searchPlayerInTeam(int employeeId) {
        boolean already = false;
        Team registeredTeam = null;
        for (int i = 0; i < team.length && !already; i++) {
            boolean existP = team[i].getRegPlayer(employeeId);
            if (existP) {
                registeredTeam = team[i];
                already = true;
            }
        }
        return registeredTeam;
    }

    /**
     * Gets an Employee object identified for its id <br>
     * 
     * @param employeeId != String
     * @return registeredEmployee
     */
    public Employee getEmployee(int employeeId) {
        Employee registeredEmployee = null;
        for (int i = 0; i < employee.size(); i++) {
            Employee getEmployee = employee.get(i);
            if (getEmployee.getEmployeeId() == employeeId) {
                registeredEmployee = getEmployee;
            }
        }
        return registeredEmployee;
    }

    /**
     * Gets a Player object identified for its id <br>
     * 
     * @param employeeId != String
     * @return registeredPlayer
     */
    public Player getPlayer(int employeeId) {
        Player registeredPlayer = null;
        for (int i = 0; i < employee.size(); i++) {
            Employee getPlayer = employee.get(i);
            if (getPlayer.getEmployeeId() == employeeId && getPlayer instanceof Player) {
                registeredPlayer = (Player) getPlayer;
            }
        }
        return registeredPlayer;
    }

    /**
     * Gets a Main coach object identified for its id <br>
     * 
     * @param employeeId != null
     * @return registeredMainCoach
     */
    public MainCoach getMainCoach(int employeeId) {
        MainCoach registeredMainCoach = null;
        for (int i = 0; i < employee.size(); i++) {
            Employee getMainCoach = employee.get(i);
            if (getMainCoach.getEmployeeId() == employeeId && getMainCoach instanceof MainCoach) {
                registeredMainCoach = (MainCoach) getMainCoach;
            }
        }
        return registeredMainCoach;
    }

    /**
     * Gets an assistant coach object identified for its id <br>
     * 
     * @param employeeId != String
     * @return registeredAsistantCoach
     */
    public AsistantCoach getAssitantCoach(int employeeId) {
        AsistantCoach registeredAsistantCoach = null;
        for (int i = 0; i < employee.size(); i++) {
            Employee getAsistantCoach = employee.get(i);
            if (getAsistantCoach.getEmployeeId() == employeeId && getAsistantCoach instanceof AsistantCoach) {
                registeredAsistantCoach = (AsistantCoach) getAsistantCoach;
            }
        }
        return registeredAsistantCoach;
    }

    /**
     * Gets a team object identified for its name <br>
     * 
     * @param teamName
     * @return registeredTeam
     */
    public Team getTeam(String teamName) {
        Team registeredTeam = null;
        boolean existT = false;
        for (int i = 0; i < team.length && !existT; i++) {
            if (team[i].getTeamName().equalsIgnoreCase(teamName)) {
                registeredTeam = team[i];
                existT = true;
            }
        }
        return registeredTeam;
    }

    /**
     * Hires a Player depending of the previously choosed option and if he meets the
     * basic data required for said process <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param employeeName For better display in console avoid symbols or characters
     *                     not recognized by the machine
     * @param employeeId   != String
     * @param salary       != String
     * @param state        != String or int, have to be a boolean
     * @param ShirtNumber  != String
     * @param position     != String or int, have to be a Position type
     * @return msg
     */
    public String hireEmployee(String employeeName, int employeeId, int salary, boolean state, int ShirtNumber,
            Position position) {
        String msg = "Se ha contratado al nuevo jugador: " + employeeName + " exitosamente";
        Employee newEmployee = new Player(employeeName, employeeId, salary, state, ShirtNumber, position);
        employee.add(newEmployee);
        return msg;
    }

    /**
     * Hires a Main coach depending of the previously choosed option and if he meets
     * the basic data required for said process <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param employeeName         for better display in console avoid symbols or
     *                             characters not recognized by the machine
     * @param employeeId           != String
     * @param salary               != String
     * @param state                != String or int, have to be a boolean
     * @param achieveChampionships != String
     * @param experienceYears      != String
     * @param teamsInCharge        != String
     * @return msg
     */
    public String hireEmployee(String employeeName, int employeeId, int salary, boolean state, int achieveChampionships,
            int experienceYears, int teamsInCharge) {
        String msg = "Se ha contratado al nuevo entrenador principal: " + employeeName + " exitosamente";
        Employee newEmployee = new MainCoach(employeeName, employeeId, salary, state, achieveChampionships,
                experienceYears, teamsInCharge);
        employee.add(newEmployee);
        return msg;
    }

    /**
     * Hires an Assistant coach depending of the previously choosed option and if he
     * meets the basic data required for said process <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param employeeName       for better display in console avoid symbols or
     *                           characters not recognized by the machine
     * @param employeeId         != String
     * @param salary             != String
     * @param state              != String or int, have to be a boolean
     * @param experienceYears    != String
     * @param soccerProfessional != String or int, have to be a boolean
     * @param expertise          != String or int, have to be a Expertise type
     * @return msg
     */
    public String hireEmployee(String employeeName, int employeeId, int salary, boolean state, int experienceYears,
            boolean soccerProfessional, Expertise expertise) {
        String msg = "Se ha contratado al nuevo entrenador asistente: " + employeeName + " exitosamente";
        Employee newEmployee = new AsistantCoach(employeeName, employeeId, salary, state, experienceYears,
                soccerProfessional, expertise);
        employee.add(newEmployee);
        return msg;
    }

    /**
     * Fires an employee just with its identification <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param employeeId != String
     * @return msg
     */
    public String fireEmployee(int employeeId) {
        String msg = "";
        for (int i = 0; i < employee.size(); i++) {
            Employee getEmployee = employee.get(i);
            if (getEmployee.getEmployeeId() == employeeId) {
                employee.remove(i);
                msg = " Se ha despedido al empleado " + getEmployee.getEmployeeName() + " con identificacion "
                        + employeeId;
            }
        }
        return msg;
    }

    /**
     * Adds an employee in an specific team following all the conjectures <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param registeredEmployee != null
     * @param registeredTeam     != null
     * @return msg
     */
    public String addEmployeeToTeam(Employee registeredEmployee, Team registeredTeam) {
        String msg = "ERROR 404";
        if (registeredEmployee instanceof Player) {
            Player registeredPlayer = (Player) registeredEmployee;
            msg = registeredTeam.addEmployee(registeredPlayer);
        } else if (registeredEmployee instanceof MainCoach) {
            MainCoach registeredMainCoach = (MainCoach) registeredEmployee;
            msg = registeredTeam.addEmployee(registeredMainCoach);
        } else if (registeredEmployee instanceof AsistantCoach) {
            AsistantCoach registeredAsistantCoach = (AsistantCoach) registeredEmployee;
            msg = registeredTeam.addEmployee(registeredAsistantCoach);
        }
        return msg;
    }

    /**
     * Removes an identified employee in an specific team <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param registeredEmployee != null
     * @param registeredTeam     != null
     * @return msg
     */
    public String removeEmployeeFromTeam(Employee registeredEmployee, Team registeredTeam) {
        String msg = "";
        if (registeredEmployee instanceof Player) {
            Player registeredPlayer = (Player) registeredEmployee;
            msg = registeredTeam.removeEmployee(registeredPlayer);
        } else if (registeredEmployee instanceof MainCoach) {
            MainCoach registeredMainCoach = (MainCoach) registeredEmployee;
            msg = registeredTeam.removeEmployee(registeredMainCoach);
        } else if (registeredEmployee instanceof AsistantCoach) {
            AsistantCoach registeredAsistantCoach = (AsistantCoach) registeredEmployee;
            msg = registeredTeam.removeEmployee(registeredAsistantCoach);
        }
        return msg;
    }

    /**
     * Sets the general information of a previously identified Employee <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param registeredEmployee != null
     * @param newName            for better display in console avoid symbols or
     *                           characters not recognized by the machine
     * @param newSalary          != String
     * @param newStatus          != String or int, have to be a boolean
     * @return msg
     */
    public String setGeneralEmployeeInfo(Employee registeredEmployee, String newName, int newSalary,
            boolean newStatus) {
        String msg = "La informacion suministrada del empleado " + registeredEmployee.getEmployeeName()
                + " ha sido actualizada";
        registeredEmployee.setEmployeeName(newName);
        registeredEmployee.setSalary(newSalary);
        registeredEmployee.setState(newStatus);
        return msg;
    }

    /**
     * Sets the particular information of a previously identified Player <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param regiteredPlayer != null
     * @param ShirtNumber     != String
     * @param scoredGoals     != String
     * @param averageMark     != String, worth noting is a double
     * @param position        != String and int have to be a Position type
     * @return msg
     */
    public String setParticularEmployeeInfo(Player regiteredPlayer, int ShirtNumber, int scoredGoals,
            double averageMark, Position position) {
        String msg = "La informacion suministrada del jugador " + regiteredPlayer.getEmployeeName()
                + " ha sido actualizada";
        regiteredPlayer.setShirtNumber(ShirtNumber);
        regiteredPlayer.setScoredGoals(scoredGoals);
        regiteredPlayer.setAverageMark(averageMark);
        regiteredPlayer.setPosition(position);
        return msg;
    }

    /**
     * Sets the particular information of a previously identified Main Coach <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param registeredMainCoach  != null
     * @param achieveChampionships != String
     * @param experienceYears      != String
     * @param teamsInCharge        != String
     * @return msg
     */
    public String setParticularEmployeeInfo(MainCoach registeredMainCoach, int achieveChampionships,
            int experienceYears, int teamsInCharge) {
        String msg = "La informacion suministrada del entrenador principal " + registeredMainCoach.getEmployeeName()
                + " ha sido actualizada";
        registeredMainCoach.setAchieveChampionships(achieveChampionships);
        registeredMainCoach.setExperienceYears(experienceYears);
        registeredMainCoach.setTeamsInCharge(teamsInCharge);
        return msg;
    }

    /**
     * Sets the particular information of a previously identified Assistant Coach
     * <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param registeredAsistantCoach != null
     * @param experienceYears         != String
     * @param soccerProfessional      != String or int have to be a boolean
     * @param expertise               != null
     * @return msg
     */
    public String setParticularEmployeeInfo(AsistantCoach registeredAsistantCoach, int experienceYears,
            boolean soccerProfessional, Expertise expertise) {
        String msg = "La informacion suministrada del entrenador asistente " + registeredAsistantCoach.getEmployeeName()
                + " ha sido actualizada";
        registeredAsistantCoach.setExperienceYears(experienceYears);
        registeredAsistantCoach.setSoccerProfessional(soccerProfessional);
        registeredAsistantCoach.setExpertise(expertise);
        return msg;
    }

    /**
     * Is use for Calculating the market price and the level of Main coaches and
     * Players <br>
     */
    public void employeeCalculates() {
        for (int i = 0; i < employee.size(); i++) {
            Employee getEmployee = employee.get(i);
            if (getEmployee instanceof Player) {
                Player registeredPlayer = (Player) getEmployee;
                registeredPlayer.calculateMarketPrice();
                registeredPlayer.calculateLevel();
            } else if (getEmployee instanceof MainCoach) {
                MainCoach registeredMainCoach = (MainCoach) getEmployee;
                registeredMainCoach.calculateMarketPrice();
                registeredMainCoach.calculateLevel();
            }
        }
    }

    /**
     * Pass by parameter or cath the pertinent information for adding a line up in
     * an specific team <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param registeredTeam != null
     * @param lineUpDate     != "empty"
     * @param tactic         != null
     * @param formationA     for each line in the field write a - indicating another
     *                       line in the same formation
     * @return msg
     */
    public String addLineUp(Team registeredTeam, String lineUpDate, Tactic tactic, String formationA) {
        int sumPlayers = 0;
        String msg = "Faltan o hay mas de 10 jugadores en la formacion ";
        String[] render = formationA.split("-");
        int[] binary = new int[render.length];
        for (int i = 0; i < render.length; i++) {
            binary[i] = Integer.parseInt(render[i]);
            sumPlayers += Integer.parseInt(render[i]);
        }
        if (sumPlayers == 10) {
            msg = registeredTeam.addLineup(lineUpDate, tactic, binary);
        }
        return msg;
    }

    /**
     * Show all the information of the teams registered in the club <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @return contents
     */
    public String showTeams() {
        String contents = "";
        for (int i = 0; i < team.length; i++) {
            contents += team[i].showContents();
        }
        return contents;
    }

    /**
     * Show the information of a team with the same name already passed as a
     * parameter <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param teamName an String
     * @return contents
     */
    public String showParticularTeam(String teamName) {
        String contents = "";
        for (int i = 0; i < team.length; i++) {
            if (team[i].getTeamName().equalsIgnoreCase(teamName)) {
                contents += team[i].showContents();
            }
        }
        return contents;
    }

    /**
     * Show all the information of the employees hired by the club in an instance of
     * our app <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @return contents
     */
    public String showEmployees() {
        String contents = "";
        if (employee.size() == 0) {
            contents = "No hay empleados registrados";
        } else {
            for (int i = 0; i < employee.size(); i++) {
                Employee getEmployee = employee.get(i);
                employeeCalculates();
                contents += getEmployee.showInfo();
            }
        }
        return contents;
    }

    /**
     * Show the information of a employee with the same identification already
     * passed as a parameter <br>
     * <b> post: </b> it will return a String message with the status of the user
     * request <br>
     * 
     * @param employeeId != String
     * @return contents
     */
    public String showParticularEmployee(int employeeId) {
        String contents = "";
        if (employee.size() == 0) {
            contents = "No hay empleados registrados";
        } else {
            for (int i = 0; i < employee.size(); i++) {
                Employee getEmployee = employee.get(i);
                if (getEmployee.getEmployeeId() == employeeId) {
                    employeeCalculates();
                    contents += getEmployee.showInfo();
                }
            }
        }
        return contents;
    }

    /**
     * Show the information of the line ups in an specific tema already passed as a
     * parameter <br>
     * 
     * @param registeredTeam != null
     * @return contents
     */
    public String showLineUps(Team registeredTeam) {
        String contents = registeredTeam.showLineUp();
        return contents;
    }

    /**
     * Shows all the information of the club including its employees, teams and
     * installations. It is important to highlight that it meets one of the
     * functional requirements <br>
     * 
     * @return contents
     */
    public String showClub() {
        String contents = "*************** Club ****************\n";
        contents += "**Name: " + getName() + "\n";
        contents += "**Nit: " + getNit() + "\n";
        contents += "**Fundation Date: " + getFundationDate() + "\n";
        for (int i = 0; i < employee.size(); i++) {
            Employee registeredEmployee = employee.get(i);
            contents += "**Employee " + (i + 1) + ":\n";
            contents += registeredEmployee.showContents();
        }
        for (int i = 0; i < team.length; i++) {
            if (team[i] != null) {
                contents += "**Team " + (i + 1) + ":\n";
                contents += team[i].showContents();
            }
        }
        contents += "**Office sector\n";
        for (int i = 0; i < ORDER_OFFICES; i++) {
            for (int j = 0; j < ORDER_OFFICES; j++) {
                if (officeSector[i][j] != null) {
                    contents += officeSector[i][j].getEmployeeName() + " ";
                } else {
                    contents += officeSector[i][j] + " ";
                }
            }
            contents += "\n";
        }
        contents += "**Dressing Room 1\n";
        for (int i = 0; i < ORDER_ROOM1; i++) {
            for (int j = 0; j < ORDER_ROOM1; j++) {
                if (dressingRoom1[i][j] != null) {
                    contents += dressingRoom1[i][j].getEmployeeName() + " ";
                } else {
                    contents += dressingRoom1[i][j] + " ";
                }
            }
            contents += "\n";
        }
        contents += "**Dressing Room 2\n";
        for (int i = 0; i < ROWS_SIZE_ROOM2; i++) {
            for (int j = 0; j < COLUMNS_SIZE_ROOM2; j++) {
                if (dressingRoom2[i][j] != null) {
                    contents += dressingRoom2[i][j].getEmployeeName() + " ";
                } else {
                    contents += dressingRoom2[i][j] + " ";
                }
            }
            contents += "\n";
        }
        return contents;
    }
}