package model;

public abstract class Employee {
    private String employeeName;
    private int employeeId;
    private int salary;

    public Employee(String employeeName, int employeeId, int salary) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * ABSTRACT METHOD
     */
    public abstract String showInfo();

    // ---------------Method used to save a few lines of code--------------------
    /**
     * Shows the Generic information of each Playlist registered in the app at the
     * moment <br>
     * 
     * @return contents
     */
    public String showContents() {
        String contents = "************* Employee **************\n";
        contents += "**Name: " + getEmployeeName() + "\n";
        contents += "**ID: " + getEmployeeId() + "\n";
        contents += "**Salary: " + getSalary() + "\n";
        contents += "**************************************\n";
        return contents;
    }

}
