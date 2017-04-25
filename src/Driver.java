import java.util.ArrayList;
import java.util.Scanner;

	public class Driver
	{
		private Scanner input;
		private ArrayList<Employee> employees;
	
	
	public static void main(String[] args) 
	{
		Driver app = new Driver();
	}

	public Driver()
	{
		input = new Scanner(System.in);
		employees = new  ArrayList<Employee>();
		runMenu();
	}
	 private int mainMenu()//main menu
	 { 
		       System.out.println("Employees");
		       System.out.println("---------");   
		       System.out.println("  1) Add a new Employee");   
		       System.out.println("  2) Add a Employee to manager");
		       System.out.println("  3) Calculate Salaries for an Employee");   
		       System.out.println("  4) Calculate All Salaries");   
	           System.out.println("  5) Employee details");            
		       System.out.println("  0) Exit");
		       System.out.print("==>> ");
		       int option = input.nextInt();
		       return option;
	 }
	 
	 private void runMenu()//displays menu
	   {
		 int option = 0;
	       do //prevents it from duplicating itself many times
	       {
	    	    option = mainMenu();
	    	   switch (option)
	           {
	    	   
	              case 1:    System.out.println("What Employee do you want to add?");
	            	  		 addDeptEmployee();
	           	             break;	           	             
	              case 2:    System.out.println("What Employee do you want to add to Manager?");
	            	  		 addExistingDeptEmployee();
	                         break;
	              case 3:    System.out.println("What Salaries Do You Want to Calculate?");
	            	  		 calculateDeptEmployeeSalaries();	              	
	                         break;
	              case 4:    System.out.println("Calculate All Salaries");
	                         calculateAllWages();
	                         break;
	              case 5:    System.out.println("For Employees Details");
	              			 printDeptEmployeeDetails();	            	  		 
                  break;           
	             default:    System.out.println("Invalid number Inserted: " + option);
	                         break;
	           }
	       }while
	       (option != 0);
	   }
	       
	 private void addDeptEmployee(){//add employee
		 System.out.println("Insert Employees First Name Please");
		 String firstName = input.nextLine();
	     firstName = input.nextLine();
	     
	     System.out.println("Insert Employees Second Name Please");
	     String secondName = input.nextLine();
	     
	     System.out.println("Insert Employees Hourly Rate Please");
	     double hourlyRate = input.nextDouble();
	     
	     System.out.println("Please Pick What Employee: ");
	        System.out.println("---------");
	        System.out.println(" 1) Manager");
	        System.out.println(" 2) Sales Worker");
	        System.out.println(" 3) Temporary Worker");
	        int employeeType = input.nextInt();
	        
	        if (employeeType == 1)
	        {
	            System.out.print("The Manager's Bonus:");
	            double managerBonus = input.nextDouble();
	            Employee manage = new Manager(firstName,secondName,hourlyRate, managerBonus);
	            employees.add(manage);
	        }
	        else if (employeeType == 2)
	        {
	            System.out.print("The Sales Performance Bonus:");
	            double salesPerformanceBonus = input.nextDouble();
	            employees.add(new SalesWorker(firstName, secondName, hourlyRate, salesPerformanceBonus));
	        }
	        else if (employeeType == 3)
	        	System.out.print("The Temporary Worker Does Not Get A Bonus:");
	            employees.add(new TempWorker(firstName, secondName, hourlyRate));
	    }
	 
	 private void  addExistingDeptEmployee(){// add existing employee
		System.out.println("Please Choose An Existing Department Employee To Add:");
		System.out.println(listWorkers());
     	System.out.println("Insert Employees Number Please");
     	int whichEmployee = input.nextInt();
     	
     	System.out.println("Please Choose A Manager To Postion The Employee With:");{
        System.out.println(listManagers());
         
        System.out.print("Please Insert The Manager You Want: ");
        int whichManager = input.nextInt();
        
        Manager man = (Manager)employees.get(whichManager);
        man.addDeptEmployee(employees.get(whichEmployee));
        
        System.out.println("The Employee Has Been Added To Department Succesfully.");
     }
	 }
     private void calculateDeptEmployeeSalaries()//calculate salaries
        {
            if (employees.size() > 0)
            {
                System.out.println("Please Insert The Employee You Want:");
                System.out.println(listEmployees());
                int anEmployee = input.nextInt();
                
                if ((anEmployee > 0) && ((anEmployee) <= employees.size()))
                {
                    System.out.print("Please Insert How Many Hours  " + employees.get(anEmployee).getFirstName() + " Worked:");
                    double numHours = input.nextDouble();
                    employees.get(anEmployee).calculateSalary(numHours);
                    System.out.println(employees.get(anEmployee).getFirstName() + "Earned: " + employees.get(anEmployee).calculateSalary(numHours));
                }
                else
                {
                    System.out.println("Incorrect option.");
                 
                }
                
            }
            
          }
     private void calculateAllWages(){//caluclate all salaries
  	   if (employees.size() == 0)
  	   {
  		   System.out.println("no employees");
  	   }
  	   double salaries = 0;
  	   for (int i = 0; i < employees.size(); i++){
  		   salaries += employees.get(i).calculateSalary(37.5);
  	   }
  	 System.out.println("All Salaries Without Overtime equals"+ salaries);
     }
     
      private void printDeptEmployeeDetails()
        {
           for (int i = 0; i < employees.size(); i++)
            {               
        	   System.out.println((i) + employees.get(i).getFirstName() + "" + employees.get(i).getSecondName());
                System.out.println("Their Hourly Rate Is: " + employees.get(i).getHourlyRate());
                 System.out.println("Their Salary Is: " + employees.get(i).getcalculateOvertime());
             }
        }
      private String listEmployees(){
    	  String listWorkers = "";
    	  for (int i = 0; i < employees.size(); i++){
    		 listWorkers = listWorkers+(i + "|"+employees.get(i))+ "\n";
    	  }
    	  return listWorkers;
      } 
      private String listManagers(){
    	  String listWorkers = "";
    	  for (int i = 0; i < employees.size(); i++){
    		  if (employees.get(i) instanceof Manager)
    		 listWorkers = listWorkers+(i + "|"+employees.get(i))+ "\n";
    	  }
    	  return listWorkers;
      } 
      private String listWorkers(){
    	  String listWorkers = "";
    	  for (int i = 0; i < employees.size(); i++){
    		  if (employees.get(i) instanceof SalesWorker || employees.get(i) instanceof TempWorker)
    		 listWorkers = listWorkers+(i + "|"+employees.get(i))+ "\n";
    	  }
    	  return listWorkers;
      } 
     }
	
        

	 
	
	
	

	   
	 