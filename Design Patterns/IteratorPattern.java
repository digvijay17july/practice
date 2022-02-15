
/*
Main class to iterate over a data structure
 */
class Scratch {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        Employee employeeOne = new Employee(1, "DJ", "India");
        Employee employeeTwo = new Employee(2, "PJ", "India");
        Employee employeeThree = new Employee(3, "RJ", "India");
        employees[0]=employeeOne;
        employees[1]=employeeTwo;
        employees[2]=employeeThree;
        EmployeeRepository  employeeRepository = new EmployeeRepository();
        employeeRepository.setEmployees(employees);
        EmployeeIterator employeeIterator= (EmployeeIterator) employeeRepository.getIterator();
        while (employeeIterator.hasNext()){
            Employee employee= (Employee) employeeIterator.next();
            System.out.println("Employee ID: "+employee.id +" Name: "+employee.name+" Address: "+employee.Address);
        }
    }
}

/*
Class holding information of the employees
 */
class Employee {
    int id;
    String name;
    String Address;

    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        Address = address;
    }
}

/*
Iterator Interface
 */
interface Iterator {
    boolean hasNext();

    Object next();
}

/*
Interface to get iterator instance
 */
interface Container {
    public Iterator getIterator();
}

/*
EmployeeRepository class holding the collection of employees
 */
class EmployeeRepository implements Container {
    EmployeeIterator employeeIterator;
    @Override
    public Iterator getIterator() {
        return this.employeeIterator;
    }
    public void setEmployees(Employee[] employees) {
        this.employeeIterator=new EmployeeIterator();
        this.employeeIterator.employees = employees;
    }

}
/*
Iterator to iterate over a collection of employees
 */
class EmployeeIterator implements Iterator {
    Employee[] employees;
    int pos = 0;

    @Override
    public boolean hasNext() {
        if (this.pos >= this.employees.length || this.employees[this.pos] == null)
            return false;
        else
            return true;
    }

    @Override
    public Object next() {
        if (this.employees[pos] != null) {
            Employee employee = this.employees[pos];
            this.pos++;
            return employee;
        }
        return null;
    }
}