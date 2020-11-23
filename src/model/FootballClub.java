package model;

import java.util.ArrayList;

public class FootballClub {
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

    public String toString() {
        return "{" + " name='" + getName() + "'" + ", nit='" + getNit() + "'" + ", fundationDate='" + getFundationDate()
                + "'" + "}";
    }

}