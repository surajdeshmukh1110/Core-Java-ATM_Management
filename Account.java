package atmmgt;

import java.text.DecimalFormat;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
	
	private int customerNumber;
	private int pinNumber;
	private double chackingBalence=0;
	private double savingBalence=0;
	
	Scanner input=new Scanner(System.in);
	DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");
	
	public Account()
	{
		
	}

	public Account(int customerNumber,int pinNumber)
	{
		this.customerNumber=customerNumber;
		this.pinNumber=pinNumber;
		
	}
	public Account(int customerNumber, int pinNumber, double chackingBalence, double savingBalence) {
		super();
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
		this.chackingBalence = chackingBalence;
		this.savingBalence = savingBalence;
		//this.input = input;
		//this.moneyFormat = moneyFormat;
	}

	// Getter Setter For getCustomerNumber
	public int getCustomerNumber() {
		return customerNumber;
	}
      
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	// Getter Setter For get pinNumber
	public int getPinNumber() {
		return pinNumber;
		
	}

	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
		
	}

	// Getter Setter For getCustomerNumber
	public double getChackingBalence() {
		return chackingBalence;
	}

	public void setChackingBalence(double chackingBalence) {
		this.chackingBalence = chackingBalence;
	}

	public double getSavingBalence() {
		return savingBalence;
	}

	public void setSavingBalence(double savingBalence) {
		this.savingBalence = savingBalence;
	}
	
	public double calcChackingWithdraw(double amount)
	{
		chackingBalence=(chackingBalence-amount);
		return chackingBalence;
	}
	
	public double calcChackingDeposit(double amount)
	{
		chackingBalence=(chackingBalence+amount);
		return chackingBalence;
	}
	public double calcSavingDeposite(double amount)
	{
		savingBalence=(savingBalence+amount);
		return savingBalence;
	}
	
	public double calcSavingBalence(double amount )
	{
		return amount;
	}

	public void calcSavingTransfer(double amount)
	{
		savingBalence=savingBalence-amount;
		chackingBalence=chackingBalence+amount;
		
	}
	
	
	public void getChackingWithdrawInput()
	{
		boolean end =false;
		while(!end)
		{
			try
			{
				System.out.println("\n Current Chacking Account Balence ; "+moneyFormat.format(chackingBalence));
				System.out.println("\n Amount You Want To Withdraw from Chacking Amount :  ");
				double amount=input.nextDouble();
				if((chackingBalence-amount)>=0 && amount >=0)
				{
					calcChackingWithdraw(amount);
					System.out.println("\n Current Chacking Accounty Balence : "+moneyFormat.format(chackingBalence));
					end=true;
					
				}
				else
				{
					System.out.println("\n Balernce CanNot Be Negative ");
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("\n Invalid Choice.");
				input.next();
			}
		}
	}

	
	
	
	public void getsavingWithdrawInput()
	{
		boolean end =false;
		while(!end)
		{
			try
			{
				System.out.println("\n Current Saving Account Balence ; "+moneyFormat.format(savingBalence));
				System.out.println("\n Amount You Want To Withdraw from Saving Amount :  ");
				double amount=input.nextDouble();
				if((savingBalence-amount)>=0 && amount >=0)
				{
					calcChackingDeposit(amount);
					System.out.println("\n Current Chacking Accounty Balence : "+moneyFormat.format(savingBalence));
					end=true;
					
				}
				else
				{
					System.out.println("\n Balernce CanNot Be Negative ");
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("\n Invalid Choice.");
				input.next();
			}
		}
	}
	
	
	
	
	public void getChackingDepositeInput()
	{
		boolean end =false;
		while(!end)
		{
			try
			{
				System.out.println("\n Current Chacking Account Balence ; "+moneyFormat.format(chackingBalence));
				System.out.println("\n Amount You Want To Withdraw from Chacking Account :  ");
				double amount=input.nextDouble();
				if((chackingBalence+amount)>=0 && amount >=0)
				{
					calcChackingDeposit(amount);
					System.out.println("\n Current Chacking Accounty Balence : "+moneyFormat.format(chackingBalence));
					end=true;
					
				}
				else
				{
					System.out.println("\n Balernce CanNot Be Negative ");
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("\n Invalid Choice.");
				input.next();
			}
		}
	}
	
	
	
	public void getSavingDepositeInput()
	{
		boolean end =false;
		while(!end)
		{
			try
			{
				System.out.println("\n Current Chacking Account Balence ; "+moneyFormat.format(chackingBalence));
				System.out.println("\n Amount You Want To Withdraw from Chacking Amount :  ");
				double amount=input.nextDouble();
				if((chackingBalence+amount)>=0 && amount >=0)
				{
					calcSavingDeposite(amount);
					System.out.println("\n Current Chacking Accounty Balence : "+moneyFormat.format(chackingBalence));
					end=true;
					
				}
				else
				{
					System.out.println("\n Balernce CanNot Be Negative ");
				}
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("\n Invalid Choice.");
				input.next();
			}
		}
	}
	
	
	
	public void getTransferInput(String accType)
	{
		boolean end =false;
		while(!end)
		{
			try
			{
				if(accType.equals("Chackings"))
				{
					System.out.println("\n Select an Account you wish To Transfer funds to:");
					System.out.println("1.Savings");
					System.out.println("2.Exit");
					System.out.println("3.\n choice");
					int choice=input.nextInt();
					switch(choice)
					{
					case 1: System.out.println("\n current Chacking Account Balence : "+moneyFormat.format(chackingBalence));
					        System.out.println("\n Amount You Want To Deposite into Your Savings Account : ");
					        double amount=input.nextDouble();
					        if((chackingBalence+amount)>=0 && amount >=0)
							{
								calcChackingDeposit(amount);
								System.out.println("\n Current Chacking Accounty Balence : "+moneyFormat.format(chackingBalence));
								System.out.println("\n Current Saving Accounty Balence : "+moneyFormat.format(savingBalence));
								
								end=true;
								
							}
							else
							{
								System.out.println("\n Balence CanNot Be Negative ");
							}
					        break;
					case 2: return;
					
					default : 
						     System.out.println("\n Invalid Choice.");
						     break;
					    
					}
				
				}
				
			}
			
			catch(InputMismatchException e)
			{
				System.out.println("\n Invalid Choice.");
				input.next();
			}
		}
	}
}
	

