import java.util.ArrayList;

public class TempWorker extends Employee
{

	public TempWorker(String firstName, String secondName, double hourlyRate)//Constructor 
	{
		super(firstName, secondName, hourlyRate);
	}
	//Setters
	public void setFirstName(String FirstName)
	{
		this.firstName = FirstName;
	}
	
	public void setHourlyRate(double hourlyRate)
	{
		if (hourlyRate >= 0.0){//if invalid data is used it will return 0
		     this.hourlyRate = hourlyRate;
		}
	}
	
	public void setSecondName(String SecondName)
	{
		this.secondName = SecondName;
	}
	
	public double calculateSalary(double numHours) 
	{
		return super.calculateSalary(numHours);
	}
	public String toString(){
		return "firstname=" + firstName
				+"secondname="+ secondName
				+"hourly=" + hourlyRate;
		}
	}
