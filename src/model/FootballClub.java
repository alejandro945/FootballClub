package model;

import java.util.ArrayList;

public class FootballClub {
    private final int ORDER_ROOM1 = 7;

    private String name;
    private int nit;
    private String fundationDate;
    private Coach[][] officeSector;
    private ArrayList<Employee> employee = new ArrayList<>();
    private Team[] team;
    private Player[][] dressingRoom1;
    private Player[][] dressingRoom2;

    public FootballClub() {
    }

    public FootballClub(String name, int nit, String fundationDate) {
        this.name = name;
        this.nit = nit;
        this.fundationDate = fundationDate;
        team[0] = new Team("A");
        team[1] = new Team("B");
        dressingRoom1 = new Player[ORDER_ROOM1][ORDER_ROOM1];
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

    public String hireEmployee(String employeeName, int employeeId, int salary, int ShirtNumber, int scoredGoals,
            double averageMark, Position position) {
        String msg = "Se ha contratado al nuevo jugador: " + employeeName + " exitosamente";
        Employee newEmployee = new Player(employeeName, employeeId, salary, ShirtNumber, scoredGoals, averageMark,
                position);
        employee.add(newEmployee);
        return msg;
    }

    public String hireEmployee(String employeeName, int employeeId, int salary, int achieveChampionships,
            int experienceYears, int teamsInCharge) {
        String msg = "Se ha contratado al nuevo entrenador principal: " + employeeName + " exitosamente";
        Employee newEmployee = new MainCoach(employeeName, employeeId, salary, achieveChampionships, experienceYears,
                teamsInCharge);
        employee.add(newEmployee);
        return msg;
    }

    public String hireEmployee(String employeeName, int employeeId, int salary, int experienceYears,
            boolean soccerProfessional, Expertise expertise) {
        String msg = "Se ha contratado al nuevo entrenador asistente: " + employeeName + " exitosamente";
        Employee newEmployee = new AsistantCoach(employeeName, employeeId, salary, experienceYears, soccerProfessional,
                expertise);
        employee.add(newEmployee);
        return msg;
    }

    public String fireEmployee(int employeeId) {
        String msg = "";
        for (int i = 0; i < employee.size(); i++) {
            Employee getEmployee = employee.get(i);
            if (getEmployee.getEmployeeId() == employeeId) {
                employee.remove(i);
                msg = " Se ha despedido al empleado " + getEmployee.getEmployeeName() + "\n" + " con identificacion "
                        + employeeId;
            }
        }
        return msg;
    }

    public String addEmployeeToTeam(Employee registeredEmployee, Team registeredTeam) {
        String msg = "";
        for (int i = 0; i < employee.size(); i++) {
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

    public String setGeneralEmployeeInfo(Employee registeredEmployee, String newName, int newSalary) {
        String msg = "La informacion suministrada del empleado " + registeredEmployee.getEmployeeName()
                + " ha sido actualizada";
        registeredEmployee.setEmployeeName(newName);
        registeredEmployee.setSalary(newSalary);
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

    public void calculatePlayerPrice() {

    }

    public String toString() {
        return "{" + " name='" + getName() + "'" + ", nit='" + getNit() + "'" + ", fundationDate='" + getFundationDate()
                + "'" + "}";
    }

}