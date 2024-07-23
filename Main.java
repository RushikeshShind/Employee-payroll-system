import javax.naming.Name;
import java.util.ArrayList;

abstract class Employee{
    
    private String name;
    
    private int id;

//Constructor   Class 1 = Employee
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    // Create getName Method
    public String getName(){
      return name;
    }
    // Create getId Method
    public int getId(){
        return id;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    @Override
    //using polymorphism
    public String toString(){
        return "Employee[name="+name+", id="+id+", salary="+calculateSalary()+"]";

    }


}
// Class 2 FullTimeEmployee
class FullTimeEmployee extends Employee{
    private double montlySalary;

    public FullTimeEmployee(String name, int id, double montlySalary){
      // using super keyword
        super(name, id);
        this.montlySalary = montlySalary;

    }
    @Override
    public double calculateSalary(){
        return montlySalary;
    }

}
// Class 3 PartTimeEmployee
class PartTimeEmployee extends Employee{

   private int hoursWorked;
   private double hourlyRate;

   public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
       super(name, id);
       this.hoursWorked = hoursWorked;
       this.hourlyRate =hourlyRate;
   }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}
// Creating a class of Payroll System
class PayrollSystem{
    private ArrayList<Employee> employeeList;
// Create Constructor
    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if (employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove !=null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployee(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}





public class Main {
    public static void main(String[] args){
      PayrollSystem payrollSystem = new PayrollSystem();
      FullTimeEmployee emp1 = new FullTimeEmployee("Rushi", 1,45000 );
      PartTimeEmployee emp2 = new PartTimeEmployee("Shivam", 2,40,150);

      payrollSystem.addEmployee(emp1);
      payrollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployee();
        System.out.println("Removing employees");
        payrollSystem.removeEmployee(1);
        System.out.println("Remaining Employees Details: ");
        payrollSystem.displayEmployee();
     }
}