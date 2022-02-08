import java.util.ArrayList;
import java.util.List;

class Scratch {
    public static void main(String[] args) {
        Facade facade=new Facade();
        facade.createDevelopers();
        facade.createManager();
        facade.printDetails();
    }
}

interface Employee{
  String companyName="ABC.COM";
  void getEmployeeDetails();
    int getId();
    String getName();
}
class Developer implements Employee{
    private String name;
    private int id;

    public Developer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void getEmployeeDetails() {
        System.out.println("Name : "+this.getName()+" , ID : "+this.getId());
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
class Manager implements Employee{
    private String name;
    private int id;
    private List<Employee> teamMembers;

    public Manager(String name, int id, List<Employee> teamMembers) {
        this.name = name;
        this.id = id;
        this.teamMembers = teamMembers;
    }

    @Override
    public void getEmployeeDetails() {
        System.out.println("Manager Name : "+this.getName()+" , ID : "+this.getId());
        for (Employee employee: teamMembers
             ) {
            System.out.println("Developer Name : "+employee.getName()+" , ID: "+employee.getId());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Employee> teamMembers) {
        this.teamMembers = teamMembers;
    }
}

class Facade{
    List<Employee> developers;
    Employee manager;
    void createDevelopers(){
        this.developers=new ArrayList<>();
        Employee devOne=new Developer("DJ",1);
        Employee devTwo=new Developer("VJ",2);
        Employee devThree=new Developer("PJ",3);
        this.developers.add(devOne);
        this.developers.add(devTwo);
        this.developers.add(devThree);
    }
    void createManager(){
        this.manager=new Manager("RJ",4,developers);
    }
    void printDetails(){
        this.manager.getEmployeeDetails();
    }
}