package ui;

import java.util.Scanner;

import model.*;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    private FootballClub footballClub;

    /**
     * The constructor method of the menu Object<br>
     */
    public Menu() {
        this.footballClub = new FootballClub("Swift Club", 900735894, "11 de abril de 1950");
    }

    /**
     * Shows the principal menu and general funtional requirements of our App <br>
     */
    public void showMenu() {
        System.out.println("MENU PRINCIPAL: Elija una opcion segun su requerimiento");
        System.out.println("-------------------------------MANEJO DE EMPLEADOS-------------------------------");
        System.out.println("(1) Para contratar un nuevo empleado al club");
        System.out.println("(2) Para despedir un empleado del club");
        System.out.println("--------------------------------MANEJO DE EQUIPOS---------------------------------");
        System.out.println("(3) Para agregar un empleado a un equipo");
        System.out.println("(4) Para remover un empleado de un equipo");
        System.out.println("(5) Para agregar alineaciones del equipo");
        System.out.println("-------------------------------ACTUALIZAR INFORMACION----------------------------");
        System.out.println("(6) Para actualizar informacion general de empleados");
        System.out.println("(7) Para actualizar informacion particular de empleados");
        System.out.println("---------------------------------MOSTRAR GENERAL---------------------------------");
        System.out.println("(8) Para mostrar informacion de todo el club");
        System.out.println("(9) Para mostrar los equipos del club");
        System.out.println("(10) Para mostrar los empleados del club");
        System.out.println("-------------------------------MOSTRAR PARTICULAR--------------------------------");
        System.out.println("(11) Para mostrar un equipo en especifico");
        System.out.println("(12) Para mostrar un empleado en especifico");
        System.out.println("----------------------------------INSTALACIONES----------------------------------");
        System.out.println("(13) Para asignar oficinas");
        System.out.println("(14) Para asignar vestuarios");
        System.out.println("-----------------------------------SALIR-----------------------------------------");
        System.out.println("(15) Salir de App");
    }

    /**
     * Reads the option entered by console <br>
     * <b> pre: </b> Positive integer number which is diferent to String and 1 less
     * than or equal to choice less than or equal to 8 <br>
     * <b> post: </b> It will return an int for its corresponding use <br>
     * 
     * @return choice
     */
    public int readOption() {
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    /**
     * Reads or captures the pertinent information for setting a employee up <br>
     * <b> pre: </b> 1<= state <=2 <br>
     * <b> post: </b> It will hire an employee and will return a String message
     * indicating the status of the request <br>
     * 
     * @return String
     */
    public String readEmployee() {
        String msg = "El identificador del empleado ya ha sido registrado";
        System.out.println("Ingrese el identificador del empleado");
        int employeeId = sc.nextInt();
        boolean exist = footballClub.searchEmployee(employeeId);
        if (!exist) {
            System.out.println("Ingrese el nombre del empleado");
            sc.nextLine();
            String employeeName = sc.nextLine();
            System.out.println("Ingrese el salario del empleado");
            int salary = sc.nextInt();
            System.out.println("Ingrese el estado del empleado\n" + "1-ACTIVO\n" + "2-INACTIVO");
            int choice = sc.nextInt();
            boolean state = false;
            if (choice == 1) {
                state = true;
            }
            System.out.println("Indique el tipo del empleado\n" + "1-JUGADOR\n" + "2-ENTRENADOR PRINCIPAL\n"
                    + "3-ENTRENADOR ASISTENTE");
            int type = sc.nextInt();
            if (type == 1) {
                System.out.println("Ingrese el numero de la camisa del jugador");
                int ShirtNumber = sc.nextInt();
                System.out.println("Elige la posicion del jugador\n" + "1-Arquero\n" + "2-Defensor\n" + "3-Volante\n"
                        + "4-Delantero");
                int pos = sc.nextInt();
                Position position = null;
                switch (pos) {
                    case 1:
                        position = Position.GOAL_KEEPER;
                        break;
                    case 2:
                        position = Position.DEFENDER;
                        break;
                    case 3:
                        position = Position.MIDFIELDER;
                        break;
                    case 4:
                        position = Position.FOWARD;
                        break;
                }
                msg = footballClub.hireEmployee(employeeName, employeeId, salary, state, ShirtNumber, position);
            } else if (type == 2) {
                System.out.println("Ingrese los anios de experiencia del entrenador principal");
                int experienceYears = sc.nextInt();
                System.out.println("Ingrese los campeonatos conseguidos del entrenador principal");
                int achieveChampionships = sc.nextInt();
                System.out.println("Ingrese la cantidad de equipos a cargo del entrenador principal");
                int teamsInCharge = sc.nextInt();
                msg = footballClub.hireEmployee(employeeName, employeeId, salary, state, achieveChampionships,
                        experienceYears, teamsInCharge);
            } else if (type == 3) {
                System.out.println("Ingrese los anios de experiencia del asistente tecnico");
                int experienceYears = sc.nextInt();
                System.out.println("¿Ha sido jugador profesional?\n" + "1-YES\n" + "2-NO");
                int pfs = sc.nextInt();
                boolean soccerProfessional = false;
                if (pfs == 1) {
                    soccerProfessional = true;
                }
                System.out.println("Elige la experticia del asistente tecnico\n" + "1-OFENSIVO\n" + "2-DEFENSIVO\n"
                        + "3-POSESION\n" + "4-JUGADAS DE LABORATORIO");
                int exp = sc.nextInt();
                Expertise expertise = null;
                switch (exp) {
                    case 1:
                        expertise = Expertise.OFFENSIVE;
                        break;
                    case 2:
                        expertise = Expertise.DEFENSIVE;
                        break;
                    case 3:
                        expertise = Expertise.POSSESSION;
                        break;
                    case 4:
                        expertise = Expertise.LABORATORY_PLAYS;
                        break;
                }
                msg = footballClub.hireEmployee(employeeName, employeeId, salary, state, experienceYears,
                        soccerProfessional, expertise);
            }
        }
        return msg;
    }

    public String fireEmployee() {
        String msg = "No se ha encontrado un empleado con la identificacion suministrada";
        System.out.println("Ingrese el identificador del empleado");
        int employeeId = sc.nextInt();
        boolean exist = footballClub.searchEmployee(employeeId);
        if (exist) {
            msg = footballClub.fireEmployee(employeeId);
        }
        return msg;
    }

    public String addEmployeeToTeam() {
        String msg = "No se ha encontrado un empleado con la identificacion suministrada o un equipo con ese nombre";
        System.out.println("Ingrese el identificador del empleado");
        int employeeId = sc.nextInt();
        System.out.println("Ingrese el nombre del equipo que lo agregara");
        sc.nextLine();
        String teamName = sc.nextLine();
        boolean existE = footballClub.searchEmployee(employeeId);
        boolean existT = footballClub.searchTeam(teamName);
        if (existE && existT) {
            Employee registeredEmployee = footballClub.getEmployee(employeeId);
            Team registeredTeam = footballClub.getTeam(teamName);
            msg = footballClub.addEmployeeToTeam(registeredEmployee, registeredTeam);
        }
        return msg;
    }

    public String removeEmployeeFromTeam() {
        String msg = "No se ha encontrado un empleado con la identificacion suministrada o un equipo con ese nombre";
        System.out.println("Ingrese el identificador del empleado");
        int employeeId = sc.nextInt();
        System.out.println("Ingrese el nombre del equipo al que pertenece");
        sc.nextLine();
        String teamName = sc.nextLine();
        boolean existE = footballClub.searchEmployee(employeeId);
        boolean existT = footballClub.searchTeam(teamName);
        if (existE && existT) {
            Employee registeredEmployee = footballClub.getEmployee(employeeId);
            Team registeredTeam = footballClub.getTeam(teamName);
            msg = footballClub.removeEmployeeFromTeam(registeredEmployee, registeredTeam);
        }
        return msg;
    }

    public String addLineUpToTeam() {
        String msg = "No se ha encontrado un equipo con ese nombre en el club";
        System.out.println("Ingrese el nombre del equipo que lo agregara");
        String teamName = sc.nextLine();
        boolean existT = footballClub.searchTeam(teamName);
        if (existT) {
            Team registeredTeam = footballClub.getTeam(teamName);
            System.out.println("Ingrese la fecha de la alineacion");
            String lineUpDate = sc.nextLine();
            System.out.println("Ingrese la formacion(eg.4-4-2)");
            String formationA = sc.nextLine();
            System.out.println("Elige la tactica de la alineacion\n" + "1-Posesion\n" + "2-Contra Ataque\n"
                    + "3-Presion Alta\n" + "4-Defecto");
            int tac = sc.nextInt();
            Tactic tactic = null;
            switch (tac) {
                case 1:
                    tactic = Tactic.POSSESSION;
                    break;
                case 2:
                    tactic = Tactic.COUNTER_ATTACK;
                    break;
                case 3:
                    tactic = Tactic.HIGH_PRESSURE;
                    break;
                case 4:
                    tactic = Tactic.DEFAULT;
                    break;
            }
            msg = footballClub.addLineUp(registeredTeam, lineUpDate, tactic, formationA);
        }
        return msg;
    }

    public String setGeneralInfo() {
        String msg = "No se ha encontrado un empleado con la identificacion suministrada";
        System.out.println("Ingrese el identificador del empleado");
        int employeeId = sc.nextInt();
        boolean existE = footballClub.searchEmployee(employeeId);
        if (existE) {
            Employee registeredEmployee = footballClub.getEmployee(employeeId);
            System.out.println("Ingrese el nuevo nombre del empleado");
            sc.nextLine();
            String newName = sc.nextLine();
            System.out.println("Ingrese el nuevo salario del empleado");
            int newSalary = sc.nextInt();
            System.out.println("Actualice el estado del empleado\n" + "1-ACTIVO\n" + "2-INACTIVO");
            int choice = sc.nextInt();
            boolean newStatus = false;
            if (choice == 1) {
                newStatus = true;
            }
            msg = footballClub.setGeneralEmployeeInfo(registeredEmployee, newName, newSalary, newStatus);
        }
        return msg;
    }

    public String setParticularInfo() {
        String msg = "No se ha encontrado un empleado con la identificacion suministrada";
        System.out.println("Ingrese el identificador del empleado");
        int employeeId = sc.nextInt();
        boolean existE = footballClub.searchEmployee(employeeId);
        Player regiteredPlayer = footballClub.getPlayer(employeeId);
        MainCoach registeredMainCoach = footballClub.getMainCoach(employeeId);
        AsistantCoach registeredAsistantCoach = footballClub.getAssitantCoach(employeeId);
        if (existE && regiteredPlayer != null) {
            System.out.println("Ingrese el nuevo numero de la camisa del jugador");
            int ShirtNumber = sc.nextInt();
            System.out.println("Ingrese la cantidad de goles en la temporada del jugador");
            int scoredGoals = sc.nextInt();
            System.out.println("Ingrese la calificacion promedio del jugador");
            double averageMark = sc.nextDouble();
            System.out.println("Elige la nueva posicion del jugador\n" + "1-Arquero\n" + "2-Defensor\n" + "3-Volante\n"
                    + "4-Delantero");
            int pos = sc.nextInt();
            Position position = null;
            switch (pos) {
                case 1:
                    position = Position.GOAL_KEEPER;
                    break;
                case 2:
                    position = Position.DEFENDER;
                    break;
                case 3:
                    position = Position.MIDFIELDER;
                    break;
                case 4:
                    position = Position.FOWARD;
                    break;
            }
            msg = footballClub.setParticularEmployeeInfo(regiteredPlayer, ShirtNumber, scoredGoals, averageMark,
                    position);
        } else if (existE && registeredMainCoach != null) {
            System.out.println("Ingrese los anios de experiencia del entrenador principal");
            int experienceYears = sc.nextInt();
            System.out.println("Ingrese los campeonatos conseguidos del entrenador principal");
            int achieveChampionships = sc.nextInt();
            System.out.println("Ingrese la cantidad de equipos a cargo del entrenador principal");
            int teamsInCharge = sc.nextInt();
            msg = footballClub.setParticularEmployeeInfo(registeredMainCoach, achieveChampionships, experienceYears,
                    teamsInCharge);
        } else if (existE && registeredAsistantCoach != null) {
            System.out.println("Ingrese los anios de experiencia del asistente tecnico");
            int experienceYears = sc.nextInt();
            System.out.println("¿Ha sido jugador profesional?\n" + "1-YES\n" + "2-NO");
            int pfs = sc.nextInt();
            boolean soccerProfessional = false;
            if (pfs == 1) {
                soccerProfessional = true;
            }
            System.out.println("Elige la experticia del asistente tecnico\n" + "1-OFENSIVO\n" + "2-DEFENSIVO\n"
                    + "3-POSESION\n" + "4-JUGADAS DE LABORATORIO");
            int exp = sc.nextInt();
            Expertise expertise = null;
            switch (exp) {
                case 1:
                    expertise = Expertise.OFFENSIVE;
                    break;
                case 2:
                    expertise = Expertise.DEFENSIVE;
                    break;
                case 3:
                    expertise = Expertise.POSSESSION;
                    break;
                case 4:
                    expertise = Expertise.LABORATORY_PLAYS;
                    break;
            }
            msg = footballClub.setParticularEmployeeInfo(registeredAsistantCoach, experienceYears, soccerProfessional,
                    expertise);
        }
        return msg;
    }

    public String showParticularTeam() {
        String msg = "No se ha encontrado un equipo con ese nombre en el club";
        System.out.println("Ingrese el nombre del equipo a mostrar");
        String teamName = sc.nextLine();
        boolean existT = footballClub.searchTeam(teamName);
        if (existT) {
            msg = footballClub.showParticularTeam(teamName);
        }
        return msg;
    }

    public String showParticularEmployee() {
        String msg = "No se ha encontrado un empleado con la identificacion suministrada";
        System.out.println("Ingrese el identificador del empleado");
        int employeeId = sc.nextInt();
        boolean existE = footballClub.searchEmployee(employeeId);
        if (existE) {
            msg = footballClub.showParticularEmployee(employeeId);
        }
        return msg;
    }

    public String assingOffice() {
        String msg = "No se ha encontrado un entrenador con la identificacion suministrada";
        System.out.println("Ingrese el identificador del entrenador");
        int employeeId = sc.nextInt();
        boolean existE = footballClub.searchEmployee(employeeId);
        Coach registeredCoachM = footballClub.getMainCoach(employeeId);
        Coach registeredCoachA = footballClub.getAssitantCoach(employeeId);
        if (existE && registeredCoachM != null) {
            msg = footballClub.addCoachToOffice(registeredCoachM);
        } else if (existE && registeredCoachA != null) {
            msg = footballClub.addCoachToOffice(registeredCoachA);
        }
        return msg;
    }

    public String assignLocker() {
        String msg = "No se ha encontrado un jugador con la identificacion suministrada o aun no ha sido registrado en un equipo";
        System.out.println("Ingrese el identificador del jugador");
        int employeeId = sc.nextInt();
        boolean existE = footballClub.searchEmployee(employeeId);
        Player registeredPlayer = footballClub.getPlayer(employeeId);
        Team registeredTeam = footballClub.searchPlayerInTeam(employeeId);
        if (existE & registeredPlayer != null & registeredTeam != null) {
            msg = footballClub.addPlayerToDressing(registeredPlayer, registeredTeam);
        }
        return msg;
    }

    /**
     * Will execute the pertinent request of the user in the main menu <br>
     * 
     * @param choice Positive integer number which is diferent to String and 1 less
     *               than or equal to choice less than or equal to 15 <br>
     */
    public void doOperation(int choice) {
        switch (choice) {
            case 1:
                System.out.println(readEmployee());
                break;
            case 2:
                System.out.println(fireEmployee());
                break;
            case 3:
                System.out.println(addEmployeeToTeam());
                break;
            case 4:
                System.out.println(removeEmployeeFromTeam());
                break;
            case 5:
                System.out.println(addLineUpToTeam());
                break;
            case 6:
                System.out.println(setGeneralInfo());
                break;
            case 7:
                System.out.println(setParticularInfo());
                break;
            case 8:
                System.out.println(footballClub.showClub());
                break;
            case 9:
                System.out.println(footballClub.showTeams());
                break;
            case 10:
                System.out.println(footballClub.showEmployees());
                break;
            case 11:
                System.out.println(showParticularTeam());
                break;
            case 12:
                System.out.println(showParticularEmployee());
                break;
            case 13:
                System.out.println(assingOffice());
                break;
            case 14:
                System.out.println(assignLocker());
                break;
            case 15:
                System.out.println("Gracias por utilizar nuestros servicios");
                break;
            default:
                System.out.println("Error, opción no válida");
        }
    }

    /**
     * This method will display our main menu while option diferent of 15 at the
     * same time of run our App <br>
     */
    public void startProgram() {
        int option;
        do {
            showMenu();
            option = readOption();
            doOperation(option);
        } while (option != 15);
    }

}
