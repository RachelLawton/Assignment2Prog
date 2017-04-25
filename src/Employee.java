import java.util.ArrayList;
import java.util.Scanner;

public abstract class Employee
{
	protected String firstName;
	protected String secondName;
	protected double  hourlyRate;
	private double salary;
	private double numHours;
	protected double calculateOvertime;
	private final static double NORMAL_WEEK = 37.5;
	
	
	public Employee (String FirstName,String SecondName,double hourlyRate){//Constructor 
		this.firstName = FirstName;
		this.secondName = SecondName;
		if (hourlyRate >= 0.0)//if invalid data is used it will return 0
		{
		     this.hourlyRate = hourlyRate;
	    }

		//Getters//
	}
	public String getFirstName(){
		return firstName;
	}
	
	public double getcalculateOvertime(){
		return calculateOvertime;
	}

	public String getSecondName(){
		return secondName;
	}

	public double getHourlyRate(){
		return hourlyRate;
	}
	
	public double getnumHours(){
		return numHours;
	}
	
	//Setters//
	public void setHourlyRate(double hourlyRate){
		if (hourlyRate >= 0.0){ //if invalid data is used it will return 0
		     this.hourlyRate = hourlyRate;
		}
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setSecondName(String secondName){
		this.secondName = secondName;
	}
	
	private double calculateOvertime(double numHours){
		double overtime = numHours - NORMAL_WEEK;
		double overPay = overtime*(hourlyRate*2);
		return overPay;
	}
	
	public double calculateSalary(double numHours){
		if (numHours > 37.5) //if working hours are above 37.5(overtime)
		{
			 salary = ((NORMAL_WEEK * hourlyRate)+ calculateOvertime(numHours));//overtime is calculated
		}
		else 
		{
			 salary = numHours*hourlyRate;//otherwise a normal salary is calculated
		}
		return salary;
	}
	
	public String toString(){
		return "Firstname=" + " " + firstName + "	"
				+"Secondname=" + " " + secondName + "	"
				+"Hourly=" + " " + hourlyRate + "	";
	}
}




