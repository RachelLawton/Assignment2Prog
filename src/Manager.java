import java.util.ArrayList;

public class Manager extends Employee
{
	private double bonus;
	private ArrayList<Employee> employees;



	public Manager(String firstName, String secondName, double hourlyRate, double bonus) //Constructor 
	{
		super(firstName, secondName, hourlyRate);
		if(bonus >=0.0)
		{
			this.bonus = bonus;
		}	
		this.employees = new ArrayList<Employee>();

	}

	public void addDeptEmployee(Employee Emp){
		employees.add (Emp);
	}

	public int numberInDept(){
		return employees.size();

	}

	//Getters

	public  ArrayList<Employee> getDept(){
		return employees;
	}

	public double getBonus(){
		return bonus;
	}

	public ArrayList<Employee> getEmployees(){
		return employees;
	}

	//Setters

	public void setBonus(double bonus){
		if (bonus >= 0.0) //if invalid data is used it will return 0
		{
			this.bonus = bonus;
		}

	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}


	public void setSecondName(String secondName){
		this.secondName = secondName;
	}

	public void setDept(ArrayList<Employee> employees){
		this.employees = employees ;
	}

	public double calculateSalary(double numHours) {
		return super.calculateSalary(numHours) + bonus;
	}

	public String toString(){
		return super.toString() +
				"Manager Bonus=" + " " + bonus;
	}
}
