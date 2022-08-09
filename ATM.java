package atmmgt;

import java.io.IOException;

public class ATM {
	
	public static void main(String args[]) throws IOException
	{
		OptionMenu optionmenu=new OptionMenu();
		introduction();
		optionmenu.mainMenu();
	}
	
	public static void introduction()
	{
		System.out.println();
	    System.out.println();
	    System.out.println("\t ***********************************");
	    System.out.println("\t \t WELCOME TO THE ATM PROJECT!");
	    System.out.println("\t ***********************************");
	}

}
