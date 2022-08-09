package atmmgt;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.plaf.MenuItemUI;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
//import java.InputMismatchException;
import java.util.Map;


public class OptionMenu {
	
	Scanner menuInput=new Scanner(System.in);

	DecimalFormat moneyFormat=new DecimalFormat("''###,##0.00");
	
	HashMap<Integer, Account>data=new HashMap<Integer,Account>();
	
	public void getLogin() throws IOException
	{
		boolean end =false;
		int customerNumber=0;
		int pinNumber=0;
		
		while(!end)
		{
			try
			{
				System.out.println("\n Enter Your Customer Number : ");
				customerNumber=menuInput.nextInt();
				System.out.println("\n Enter Your PIN Number : ");
				pinNumber=menuInput.nextInt();
				//Iterator it=dataentrySet().iterator();
				Iterator it=data.entrySet().iterator();
				while(it.hasNext())
				{
					Map.Entry pair=(Map.Entry)it.next();
					Account acc=(Account)pair.getValue();
					if(data.containsKey(customerNumber)&&pinNumber==acc.getPinNumber())
					{
						getAccountType(acc);
						end=true;
						break;
					}
				}
					if(!end)
					{
						System.out.println("\n Wrong Customer Number or PIN ");
						
					}
				
				}
					catch(InputMismatchException e)
					{
						System.out.println("\n Invalid Character(s) ,Only Numbers.");
					
			        }
			}
		}
			public void getAccountType(Account acc)
			{
				boolean end=false;
				while(!end)
				{
					try
					{
						System.out.println("\n enter The Account You Want To Access : ");
						System.out.println("Type 1 - Checkings Account");
						System.out.println("Type 2 - Savings Account ");
						System.out.println("Type 3 - Exit");
						System.out.println("\n Choice : ");
						int selection=menuInput.nextInt();
						
						switch(selection)
						{
						case 1: 
							   getChecking(acc);
							   break;
						case 2: 
							   getSaving(acc);
							   break;
						case 3: 
							  end=true;
							   break;
					    default:
					    	    System.out.println("\n Invalid Choice.");
						}
			   		}
						catch(InputMismatchException e)
						{
							System.out.println("\n Invalid Choice.");
							menuInput.next();
						}
					}	
			}
			public void getChecking(Account acc)
			{
				boolean end=false;
				while(!end)
				{
					try
					{
						
						System.out.println("\n Chacking Account : ");
						System.out.println("Type 1 - View Balence ");
						System.out.println("Type 2 - Withraw Fund");
						System.out.println("Type 3 - Deposit Fund");
						System.out.println("Type 4 - Transfer Fund");
						System.out.println("\n Choice : ");
						
						int selection  =menuInput.nextInt();
						
						switch (selection) {
						case 1:
							   System.out.println("\n Chacking AccountBalence : " +moneyFormat.format(acc.getChackingBalence()));
							   break;
						case 2:
							    acc.getChackingWithdrawInput();
							    break;
						case 3:
							   acc.getChackingDepositeInput();
						       break;
						case 4:
							    acc.getTransferInput("Chackings");
						        break;
						        
						case 5: 
							      end=true;
						          break;
						default:
							     System.out.println("\n Invalid Choice");
							     
					}
					}
						catch(InputMismatchException e)
						{
							System.out.println("\n Invalid Choice.");
							menuInput.next();
						}
				}
				}
		
				
				public void getSaving(Account acc)
				{
					boolean end=false;
					while(!end)
					{
						try
						{
							
							System.out.println("\n Saving Account : ");
							System.out.println("Type 1 - View Balence ");
							System.out.println("Type 2 - Withraw Fund");
							System.out.println("Type 3 - Deposit Fund");
							System.out.println("Type 4 - Transfer Fund");
							System.out.println("Type 5 - Exit : ");
							System.out.println("Choice : ");
							
							int selection =menuInput.nextInt();
							
							switch(selection)
							{
							case 1 : 
								     System.out.println("\n Saving Account Balence : "+moneyFormat.format( acc.getSavingBalence()));
								    
								     break;
							case 2 : 
							        acc.getsavingWithdrawInput();
							        break;
							case 3 : 
						        acc.getSavingDepositeInput();
						        break;
						        
							case 4 : 
						        acc.getTransferInput("Savings");
						        break;
							case 5 : 
						        end=true;
						        break;
						        
						    default: 
						    	    System.out.println("\n Invalid Choice.");
						    	    
								     
							}
							
							
						}
						catch(InputMismatchException e)
						{
							System.out.println("\n Invalid Choice");
							menuInput.next();
						}
						
					}
					
				}
			
	public void createAccount() throws IOException
	{
		int cst_no=0;
		boolean end=false;
		while(!end)
		{
			try
			{
				System.out.println("\n Enter Your Customer Number ");
				cst_no=menuInput.nextInt();
				Iterator it=data.entrySet().iterator();
				
				while(it.hasNext())
				{
					Map.Entry pair=(Map.Entry)it.next();
					if(!data.containsKey(cst_no))
					{
						end=true;
					}
				}
				if(!end)
				{
					System.out.println("\n This Customer Number Is Alrady Resistered ");
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("\n Invalid Choice.");
				menuInput.next();
			}
		}
		System.out.println("\n Enter PIN To be Registered");
		int pin =menuInput.nextInt();
		//data.put(sct_no,new Account(cst_no,pin));
		data.put(cst_no, new Account(cst_no,pin));
		System.out.println("\n Your New Account Has been Successfully Registered");
		System.out.println("\n Rederected To Login.......");
		getLogin();
		
	}
	
	
	public void mainMenu() throws IOException
	{
		data.put(952141,new Account(952141,191904,1000,5000));
		data.put(123,new Account(123,123,20000,50000));
		
		boolean end=false;
		while(!end)
		{
			
             try
			   {
				   System.out.println("\t Type 1 : Login");
					System.out.println("\t Type 2 : Create Account");
					System.out.println();
					System.out.println("\t Choice : ");
					int choice=menuInput.nextInt();
					
					switch(choice)
					{
					case 1 :  
						   getLogin();
						   end=true;
						   break;
						   
					case 2 : 
						    createAccount();
						    end=true;
						    break;
					default : 
						     System.out.println("\t Invalid Choice.");
						     
					}
			   }
					catch(InputMismatchException e)
					{
						System.out.println("\t Invalid Choice.");
						menuInput.next();
					}
			   }
             System.out.println("\t Thank You for Using This ATM.\n");
             menuInput.close();
             System.exit(0);
			

        }
		
		
}
	
				
		    
		
			
	

