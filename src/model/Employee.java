package model;

public abstract class Employee {
    private String employeeName;
    private int employeeId;
    private int salary;
    private boolean state;

    /**
     * The constructor method of an Employee Object, but in this case we wont use
     * it, due to this class is abstact <br>
     */
    public Employee(String employeeName, int employeeId, int salary, boolean state) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.salary = salary;
        this.state = state;
    }

    /**
     * Gets the employee name <br>
     * 
     * @return employeeName
     */
    public String getEmployeeName() {
        return this.employeeName;
    }

    /**
     * Sets the employee name <br>
     * 
     * @param employeeName
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Gets the employee identification <br>
     * 
     * @return employeeId
     */
    public int getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Sets the employee identification <br>
     * 
     * @param employeeId != String or a decimal
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets the employee salary <br>
     * 
     * @return salary
     */
    public int getSalary() {
        return this.salary;
    }

    /**
     * Sets the employee salary <br>
     * 
     * @param salary != String
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Gets the employee status <br>
     * 
     * @return state
     */
    public boolean getState() {
        return this.state;
    }

    /**
     * Sets the employee Status <br>
     * 
     * @param state != String or an int
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * ABSTRACT METHOD
     */
    public abstract String showInfo();

    // ---------------Method used to save a few lines of code--------------------
    /**
     * Shows the Generic information of each Employee registered in the app at the
     * moment <br>
     * 
     * @return contents
     */
    public String showContents() {
        String contents = "************* Employee **************\n";
        contents += "**Name: " + getEmployeeName() + "\n";
        contents += "**ID: " + getEmployeeId() + "\n";
        contents += "**Salary: " + getSalary() + "\n";
        if (getState()) {
            contents += "**Status: ACTIVE\n";
        } else {
            contents += "**Status: INACTIVE\n";
        }
        contents += "**************************************\n";
        return contents;
    }

}
