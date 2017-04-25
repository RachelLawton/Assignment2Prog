import java.util.ArrayList;

	public class SalesWorker extends Employee
		{
		private double salesPerformanceBonus;

	public SalesWorker(String firstName,String lastName,double hourlyRate,double salesPerformanceBonus)//Constructor 
	{
		super(firstName ,lastName,hourlyRate);
		if(salesPerformanceBonus >= 0 && salesPerformanceBonus <= 20)
		     this.salesPerformanceBonus = salesPerformanceBonus;

	}//getter
	public double  getSalesPerformanceBonus()
	{
		return salesPerformanceBonus;
	}
	//setter
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
	
	public void setsalesPerformanceBonus(double salesPerformanceBonus)
	{
		if (salesPerformanceBonus >= 0 && salesPerformanceBonus <= 20)
	{
		this.salesPerformanceBonus = salesPerformanceBonus; 
	}
		
	}
	
	public double calculateSalary(double numHours) 
	{
		return super.calculateSalary(numHours) *(1 + salesPerformanceBonus/100);
	}
	
	public String toString(){
		return super.toString() +
				"Performance Bonus=" + " " + salesPerformanceBonus;
	}
}