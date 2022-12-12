public class Employee {

    private int idNumber;
    private String firstName;
    private String lastName;
    private static int mostRecentIDNumber = 100;
    private static int totalEmployees = 0;

    public Employee (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        mostRecentIDNumber++;
        idNumber = mostRecentIDNumber;
        totalEmployees++;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getIdNumber() {
        return idNumber;
    }
    public static int getMostRecentIDNumber() {
        return mostRecentIDNumber;
    }
    public static int getTotalEmployees() {
        return totalEmployees;
    }

    public String toString() {
        return "Employee full name: " + firstName + " " + lastName + "\nEmployee ID number: " + idNumber + "\nMost Recent Employee ID: " + mostRecentIDNumber + "\nTotal Employees: " + totalEmployees;
    }
}
