import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;

public class Employee {

    private String employeeld;
    private String employeeName;

    private String employeeAddress;
    private String contactNumber;

    private String employeeType;

    public void setEmployeeld(String employeeld) {
        this.employeeld = employeeld;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeld() {
        return employeeld;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void save() {

//Serialize object into a string representation
        String objectStr = MyUtils.serializeIntoAString(this);
        Connection connection = null;
        Statement stat = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDB", "root", "password");
            stat = connection.createStatement();
            stat.execute("INSERT INTO EMPLOYEE VALUES (" + objectStr + ")");
        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    public void calculateTax() {

        if (this.getEmployeeType().equals("fulltime")) { // Tax calc for full time employee
        }

        if (this.getEmployeeType().equals("contract")) { // Tax calc for contractors
        }
    }


}

/*
Reasons to change
->Changes in the Employee Attributes
->Changes in Database (directly connected to SQL)
->changes in tax calculation
*/