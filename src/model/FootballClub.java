package model;

import java.util.ArrayList;

public class FootballClub {
    private final int ORDER_OFFICES = 6;
    private final int ORDER_ROOM1 = 7;
    private final int COLUMNS_SIZE_ROOM2 = 7;
    private final int ROWS_SIZE_ROOM2 = 6;

    private String name;
    private int nit;
    private String fundationDate;
    private Team[] team = new Team[2];
    private ArrayList<Employee> employee = new ArrayList<>();
    private Coach[][] officeSector;
    private Player[][] dressingRoom1;
    private Player[][] dressingRoom2;

    public FootballClub(String name, int nit, String fundationDate) {
        this.name = name;
        this.nit = nit;
        this.fundationDate = fundationDate;
        team[0] = new Team("LIVERPOOL");
        team[1] = new Team("BARCELONA");
        officeSector = new Coach[ORDER_OFFICES][ORDER_OFFICES];
        dressingRoom1 = new Player[ORDER_ROOM1][ORDER_ROOM1];
        dressingRoom2 = new Player[COLUMNS_SIZE_ROOM2][ROWS_SIZE_ROOM2];
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNit() {
        return this.nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getFundationDate() {
        return this.fundationDate;
    }

    public void setFundationDate(String fundationDate) {
        this.fundationDate = fundationDate;
    }

    public String addCoachToOffice(Coach registeredCoach) {
        String msg = "No hay oficinas disponibles";
        boolean asigned = false;
        for (int i = 0; i < ORDER_OFFICES && !asigned; i++) {
            for (int j = 0; j < ORDER_OFFICES; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    officeSector[i][j] = registeredCoach;
                    asigned = true;
                    msg = "Se ha asignado una oficina exitosamente al entrenador " + registeredCoach.getEmployeeName();
                } else if (i % 2 != 0 && j % 2 != 0) {
                    officeSector[i][j] = registeredCoach;
                    asigned = true;
                    msg = "Se ha asignado una oficina exitosamente al entrenador " + registeredCoach.getEmployeeName();
                }
            }
        }
        return msg;
    }

    public String addPlayerToDressing(Player registeredPlayer, Team registeredTeam) {
        String msg = "No hay camerinos disponibles";
        boolean asigned1 = false;
        boolean asigned2 = false;
        int render1 = dressingRoom1[0][0].getEmployeeId();
        int render2 = dressingRoom2[0][0].getEmployeeId();
        for (int i = 0; i < ORDER_ROOM1 && !asigned1; i++) {
            for (int j = 0; j < ORDER_ROOM1; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    if (dressingRoom1.length == 0) {
                        dressingRoom1[i][j] = registeredPlayer;
                        render1 = dressingRoom1[0][0].getEmployeeId();
                        asigned1 = true;
                        msg = "Se ha asignado un vestidor en el camerino 1 exitosamente";
                    } else if (registeredTeam.getRegPlayer(render1)) {
                        dressingRoom1[i][j] = registeredPlayer;
                    }
                }
                if (i % 2 != 0 && j % 2 != 0) {
                    if (registeredTeam.getRegPlayer(render1)) {
                        dressingRoom1[i][j] = registeredPlayer;
                        asigned1 = true;
                        msg = "Se ha asignado un vestidor en el camerino 1 exitosamente";
                    }
                }
            }
        }
        for (int i = 0; i < COLUMNS_SIZE_ROOM2 && !asigned2; i++) {
            for (int j = 0; j < ROWS_SIZE_ROOM2; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    if (dressingRoom2.length == 0) {
                        dressingRoom2[i][j] = registeredPlayer;
                        render2 = dressingRoom2[0][0].getEmployeeId();
                        asigned2 = true;
                        msg = "Se ha asignado un vestidor en el camerino 2 exitosamente";
                    } else if (registeredTeam.getRegPlayer(render2)) {
                        dressingRoom2[i][j] = registeredPlayer;
                    }
                }
                if (i % 2 != 0 && j % 2 != 0) {
                    if (registeredTeam.getRegPlayer(render2)) {
                        dressingRoom2[i][j] = registeredPlayer;
                        asigned2 = true;
                        msg = "Se ha asignado un vestidor en el camerino 2 exitosamente";
                    }
                }
            }
        }
        return msg;
    }

    public boolean searchTeam(String teamName) {
        boolean existT = false;
        for (int i = 0; i < team.length && !existT; i++) {
            if (team[i].getTeamName().equalsIgnoreCase(teamName)) {
                existT = true;
            }
        }
        return existT;
    }

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

    public String hireEmployee(String employeeName, int employeeId, int salary, boolean state, int ShirtNumber,
            Position position) {
        String msg = "Se ha contratado al nuevo jugador: " + employeeName + " exitosamente";
        Employee newEmployee = new Player(employeeName, employeeId, salary, state, ShirtNumber, position);
        employee.add(newEmployee);
        return msg;
    }

    public String hireEmployee(String employeeName, int employeeId, int salary, boolean state, int achieveChampionships,
            int experienceYears, int teamsInCharge) {
        String msg = "Se ha contratado al nuevo entrenador principal: " + employeeName + " exitosamente";
        Employee newEmployee = new MainCoach(employeeName, employeeId, salary, state, achieveChampionships,
                experienceYears, teamsInCharge);
        employee.add(newEmployee);
        return msg;
    }

    public String hireEmployee(String employeeName, int employeeId, int salary, boolean state, int experienceYears,
            boolean soccerProfessional, Expertise expertise) {
        String msg = "Se ha contratado al nuevo entrenador asistente: " + employeeName + " exitosamente";
        Employee newEmployee = new AsistantCoach(employeeName, employeeId, salary, state, experienceYears,
                soccerProfessional, expertise);
        employee.add(newEmployee);
        return msg;
    }

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

    public String setGeneralEmployeeInfo(Employee registeredEmployee, String newName, int newSalary,
            boolean newStatus) {
        String msg = "La informacion suministrada del empleado " + registeredEmployee.getEmployeeName()
                + " ha sido actualizada";
        registeredEmployee.setEmployeeName(newName);
        registeredEmployee.setSalary(newSalary);
        registeredEmployee.setState(newStatus);
        return msg;
    }

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

    public String setParticularEmployeeInfo(MainCoach registeredMainCoach, int achieveChampionships,
            int experienceYears, int teamsInCharge) {
        String msg = "La informacion suministrada del entrenador principal " + registeredMainCoach.getEmployeeName()
                + " ha sido actualizada";
        registeredMainCoach.setAchieveChampionships(achieveChampionships);
        registeredMainCoach.setExperienceYears(experienceYears);
        registeredMainCoach.setTeamsInCharge(teamsInCharge);
        return msg;
    }

    public String setParticularEmployeeInfo(AsistantCoach registeredAsistantCoach, int experienceYears,
            boolean soccerProfessional, Expertise expertise) {
        String msg = "La informacion suministrada del entrenador asistente " + registeredAsistantCoach.getEmployeeName()
                + " ha sido actualizada";
        registeredAsistantCoach.setExperienceYears(experienceYears);
        registeredAsistantCoach.setSoccerProfessional(soccerProfessional);
        registeredAsistantCoach.setExpertise(expertise);
        return msg;
    }

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

    public String addLineUp(Team registeredTeam, String lineUpDate, Tactic tactic, String formationA) {
        int sumPlayers = 0;
        String msg = "Faltan o hay mas de 10 jugadores en la formacion ";
        String[] render = formationA.split("-");
        int[] binary = new int[render.length];
        int size = 0;
        for (int i = 0; i < render.length; i++) {
            binary[i] = Integer.parseInt(render[i]);
            sumPlayers += Integer.parseInt(render[i]);
            size++;
        }
        if (sumPlayers == 10) {
            msg = registeredTeam.addLineup(lineUpDate, tactic, binary, size);
        }
        return msg;
    }

    public String showTeams() {
        String contents = "";
        if (team.length == 0) {
            contents = "No hay equipos en la app";
        } else {
            for (int i = 0; i < team.length; i++) {
                contents += team[i].showContents();
            }
        }

        return contents;
    }

    public String showGenericEmployee() {
        String contents = "";
        if (employee.size() == 0) {
            contents = "No hay empleados registrados";
        } else {
            for (int i = 0; i < employee.size(); i++) {
                Employee getEmployee = employee.get(i);
                contents += getEmployee.showContents();
            }
        }
        return contents;
    }

    public String showParticularEmployee() {
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
}