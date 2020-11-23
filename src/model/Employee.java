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

    public String toString() {
        return "{" + " employeeName='" + getEmployeeName() + "'" + ", employeeId='" + getEmployeeId() + "'"
                + ", salary='" + getSalary() + "'" + "}";
    }

}
