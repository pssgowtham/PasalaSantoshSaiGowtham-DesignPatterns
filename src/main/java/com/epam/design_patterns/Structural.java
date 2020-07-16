package com.epam.design_patterns;
import java.io.BufferedReader;  
import java.io.InputStreamReader;
import java.io.IOException;  

interface CreditCard {  
    public void giveBankDetails();  
    public String getCreditCard();  
}

interface Food {  
    public String prepareFood();  
    public double foodPrice();  
}

class BankDetails{  
    private String bankName;  
    private String accHolderName;  
    private long accNumber;  
      
    public String getBankName() {  
        return bankName;  
    }  
    public void setBankName(String bankName) {  
        this.bankName = bankName;  
    }  
    public String getAccHolderName() {  
        return accHolderName;  
    }  
    public void setAccHolderName(String accHolderName) {  
        this.accHolderName = accHolderName;  
    }  
    public long getAccNumber() {  
        return accNumber;  
    }  
    public void setAccNumber(long accNumber) {  
        this.accNumber = accNumber;  
    }  
}

class BankCustomer extends BankDetails implements CreditCard {  
	 public void giveBankDetails(){  
	  try{  
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
	      
	   System.out.print("Enter the account holder name :");  
	   String customername=br.readLine();  
	   System.out.print("\n");  
	      
	   System.out.print("Enter the account number:");  
	   long accno=Long.parseLong(br.readLine());  
	   System.out.print("\n");  
	      
	   System.out.print("Enter the bank name :");  
	   String bankname=br.readLine();  
	      
	   setAccHolderName(customername);  
	   setAccNumber(accno);  
	   setBankName(bankname);  
	   }catch(Exception e){  
	        e.printStackTrace();  
	   }  
	  }  
	  @Override  
	  public String getCreditCard() {  
	   long accno=getAccNumber();  
	   String accholdername=getAccHolderName();  
	   String bname=getBankName();  
	          
	   return ("The Account number "+accno+" of "+accholdername+" in "+bname+ "bank is valid and authenticated for issuing the credit card. ");  
	  }  
	}

class VegFood implements Food {  
    public String prepareFood(){  
         return "Veg Food";  
    }  
  
        public double foodPrice(){  
        return 50.0;  
    }  
}  

abstract class FoodDecorator implements Food{  
    private Food newFood;  
    public FoodDecorator(Food newFood)  {  
        this.newFood=newFood;  
    }  
    @Override  
    public String prepareFood(){  
        return newFood.prepareFood();   
    }  
    public double foodPrice(){  
        return newFood.foodPrice();  
    }  
} 

class NonVegFood extends FoodDecorator{    
    public NonVegFood(Food newFood) {  
        super(newFood);  
    }  
    public String prepareFood(){  
        return super.prepareFood() +" With Roasted Chiken and Chiken Curry  ";   
    }  
    public double foodPrice()   {  
        return super.foodPrice()+150.0;  
    }  
}  

class ChineeseFood extends FoodDecorator{  
	  public ChineeseFood(Food newFood)    {  
	        super(newFood);  
	  }  
	    public String prepareFood(){  
	        return super.prepareFood() +" With Fried Rice and Manchurian  ";   
	    }  
	    public double foodPrice()   {  
	        return super.foodPrice()+65.0;  
	        }  
	}  

public class Structural {
    private static int  choice;  
	public void ittop() throws NumberFormatException, IOException{
	   //adapter pattern
		System.out.println("Adaptor pattern:");
		CreditCard targetInterface=new BankCustomer();  
		targetInterface.giveBankDetails();  
		System.out.print(targetInterface.getCreditCard()); 
	  
	  //decarator pattern
		System.out.println("\n\nDecarator pattern:");
		do{        
	        System.out.print("========= Food Menu ============ \n");  
	        System.out.print("            1. Vegetarian Food.   \n");  
	        System.out.print("            2. Non-Vegetarian Food.\n");  
	        System.out.print("            3. Chineese Food.         \n");  
	        System.out.print("            4. Exit                        \n");  
	        System.out.print("Enter your choice: ");  
	        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));   
	        choice=Integer.parseInt(br.readLine());  
	        switch (choice) {  
	        case 1:{   
	                 VegFood vf=new VegFood();  
	              System.out.println(vf.prepareFood());  
	              System.out.println( vf.foodPrice());  
	            }  
	            break;  
	              
	                case 2:{  
	                Food f1=new NonVegFood((Food) new VegFood());  
	                    System.out.println(f1.prepareFood());  
	                System.out.println( f1.foodPrice());  
	        }  
	            break;    
	     case 3:{  
	             Food f2=new ChineeseFood((Food) new VegFood());  
	                     System.out.println(f2.prepareFood());  
	                    System.out.println( f2.foodPrice());  
	              }  
	            break;    
	              
	         default:{    
	            System.out.println("Other than these no food available");  
	        }         
	    return;  
	     }//end of switch  
	          
	}while(choice!=4);  
	    }  
	}

