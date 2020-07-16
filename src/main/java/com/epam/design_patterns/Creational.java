package com.epam.design_patterns;
import java.io.BufferedReader;  
import java.io.InputStreamReader;  

interface Prototype {  
	  
    public Prototype getClone();  
     
}

class EmployeeRecord implements Prototype
{  
    
	   private int id;  
	   private String name, designation;  
	   private double salary;  
	   private String address;  
	      
	   public EmployeeRecord(){  
	            System.out.println("   Employee Records of Oracle Corporation ");  
	            System.out.println("---------------------------------------------");  
	            System.out.println("Eid"+"\t"+"Ename"+"\t"+"Edesignation"+"\t"+"Esalary"+"\t\t"+"Eaddress");  
	      
	}  
	  
	 public  EmployeeRecord(int id, String name, String designation, double salary, String address) {  
	          
	        this();  
	        this.id = id;  
	        this.name = name;  
	        this.designation = designation;  
	        this.salary = salary;  
	        this.address = address;  
	    }  
	      
	  public void showRecord(){  
	          
	        System.out.println(id+"\t"+name+"\t"+designation+"\t"+salary+"\t"+address);  
	   }  
	  
	    @Override  
	    public Prototype getClone() {  
	          
	        return new EmployeeRecord(id,name,designation,salary,address);  
	    }  
}

abstract class Plan{  
    protected double rate;  
    abstract void getRate();  

    public void calculateBill(int units){ 
    	
         System.out.println(units*rate);  
     }  
}

class  DomesticPlan extends Plan{  
    //@override  
     public void getRate(){  
         rate=3.50;              
    }  
}

class  CommercialPlan extends Plan{  
	   //@override   
	    public void getRate(){   
	        rate=7.50;  
	   } 
}

class  InstitutionalPlan extends Plan{  
	   //@override  
	    public void getRate(){   
	        rate=5.50;  
	   } 
}

class GetPlanFactory{  
    
	   //use getPlan method to get object of type Plan   
	       public Plan getPlan(int planType){  
	            
	          if(planType==1) {  
	                 return new DomesticPlan();  
	               }   
	           else if(planType==2){  
	                return new CommercialPlan();  
	            }   
	          else if(planType==3) {  
	                return new InstitutionalPlan();  
	          } 
	      return null;  
	   }  
}

public class Creational  {

    public void baka() throws Exception  {  
    	//Prototype design
    	System.out.println("Prototype Design:");
    	 BufferedReader br =new BufferedReader(new InputStreamReader(System.in));  
         System.out.print("Enter Employee Id: ");  
         int eid=Integer.parseInt(br.readLine());  
           
         System.out.print("Enter Employee Name: ");  
         String ename=br.readLine();
         System.out.print("Enter Employee Designation: ");  
         String edesignation=br.readLine(); 
         System.out.print("Enter Employee Address: ");  
         String eaddress=br.readLine();  
         System.out.print("Enter Employee Salary: ");  
         double esalary= Double.parseDouble(br.readLine());
         EmployeeRecord e1=new EmployeeRecord(eid,ename,edesignation,esalary,eaddress);  
         e1.showRecord();
         System.out.println("\n");  
         EmployeeRecord e2=(EmployeeRecord) e1.getClone();  
         e2.showRecord();    
         
        //factory method
     	System.out.println("\nFactory Method Design:");
         GetPlanFactory planFactory = new GetPlanFactory();  
         
         System.out.print("Enter the name of plan for which the bill will be generated: ");  
         br=new BufferedReader(new InputStreamReader(System.in));  
         System.out.println("Choose any plan:");
         System.out.println("1)Domestic Plan\n2)Commercial Plan\n3)Institutional Plan");
         int planName=Integer.parseInt(br.readLine());  
         if(planName<=3) {
             System.out.print("Enter the number of units for bill will be calculated: ");  
             int units=Integer.parseInt(br.readLine());  
        	 Plan p = planFactory.getPlan(planName);
	          System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");  
	          p.getRate();  
	          p.calculateBill(units);  
         }
         else {
        	 System.out.println("Invalid Choice");
         }
    }
}
