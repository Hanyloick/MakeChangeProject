import java.util.Scanner;

public class MakeChangeProject {

	public static void main(String[] args) {
		startUp();
	}
	
	public static void startUp() {
		 Scanner sc = new Scanner(System.in);
		 
		 double price, paid, toUser, owed;
		 int intPrice, intPaid, change;
		
		 //The user is prompted asking for the price of the item. //
		 System.out.println("what was your total?");
		 price = sc.nextDouble();
		 intPrice = (int) (price*100); //<-- "casting" a double into an int to round then multiplying to move the decimal
		 																	//then converting to cents 
		 
		 
		 System.out.println("how much are you paying?"); //The user is then prompted asking how much money was tendered
		 paid = sc.nextDouble();									 //by the customer.
		 intPaid = (int) (paid*100);
		 
		 
		 
		 change = intPaid - intPrice;	//<----total amount owed to the user as an int for math
		 toUser = paid - price; //<----- a double to print to the user.
		 owed = -toUser; //<----- total amount sill owed from the user as a double.
	 	
		 
		 
		 //Display an appropriate message if the customer provided too little money or the 
		 //exact amount.
		 
		 if (intPrice < intPaid) { //<-----user is owed
			 System.out.printf("you over paid by: " + "$%,.2f", toUser);
			 System.out.println(" ");
			 
			 //If the amount tendered is more than the cost of the item, display the number of bills 
			 // and coins that should be given to the customer.
			 //($20 ,$10 ,$5 ,$1, .25c, .10c, .05c, .01c)
			 findDenom(change);
				 
			 } else if (intPrice > intPaid) { //<----- user underpaid
				 System.out.printf("You Still Owe :$%,.2f",  owed);
			 } else if (intPrice == intPaid) { //<------- balanced transaction
				 System.out.println("Thankyou for your purchase!");
			 } // else { //<---- that's not money -_-
			  // System. out.println("you blew up a satelite..... shame on you"); //<-----attempting to figure out how to reprompt		 		
			//	 sc.next(); 													  //      after improper input :'(
				 																  //	  			
			 //}
			sc.close();	
	}
	
	public static void findDenom(int change) {
		 int twenty = change / 2000; //<---- twenty dollars = cents(in change) / $20 in cents
		 
		 if (twenty > 0) {		// if change(in cents)/$20.00(in cents) is greater than 0 
			 
			 change = change % 2000; //<----- get mod of change to move to next step.
		 	 System.out.println("you receive " + twenty + " twenties"); //<----change/2000 leaves the amount of 20s 
																			 	 //		 that will make change
		 
		 } else if ((change % 2000) <= 0) {
			 	//<------- if there weren't any 20s skips to the 
										//next step
		 }
		 int ten = change / 1000;
		 if (ten > 0)  {
			 change = change % 1000;
		 System.out.println("you receive " + ten + " tens");
		 } else if ((change % 1000) <= 0) {
				//<------- if there weren't any 10s skips to the 
										//next step
		 }
		 int five = change / 500;
		 if (five > 0) {
			 change = change % 500;
		 System.out.println("you receive " + five + " fives");
		 } else if ((change % 500) <= 0) {
				//<------- if there weren't any 5s skips to the 
										//next step
		 }
		 int one = change / 100;
		 if (one > 0) {
			 change = change % 100;
			 System.out.println("you receive " + one + " ones");
		 } else if ((change % 100) <= 0) {
				//<------- if there weren't any 1s skips to the 
										//next step
		 }	 
		int quarter = change / 25;
		if (quarter > 0) {
			change = change % 25;
		System.out.println("you receive " + quarter + " quarters");
		 } else if ((change % 25) <= 0) {
				//<------- if there weren't any quarters skips to the 
										//next step
		 }
		int dime = change / 10;
		if (dime > 0) {
			change = change % 10;
		System.out.println("you receive " + dime + " dimes");
		 } else if ((change % 10) <= 0) {
				//<------- if there weren't any dimes skips to the 
										//next step
		 }
		int nickel = change / 5;
		if (nickel > 0) {
			change = change % 5;
		System.out.println("you receive " + nickel + " nickels");
		} else if ((change % 5) <= 0) {
				//<------- if there weren't any nickels skips to the 
										//next step
		 }
		int penny = change;
		if (penny > 0) {
			change--;
		System.out.println("you receive: " + penny + " pennies");
		 } else if ((change * change) <= 0) {
				//<------- if there weren't any pennies skips to the 
										//next step
		 }	 
	
	}
	
}
	 //√1.Amount: .67, Tendered: .50, Result: Error message
	 //√2.Amount: .67, Tendered: 1.00, Result: 1 quarter, 1 nickel, 3 pennies.
	 //√3.Amount: .59, Tendered: 1.00, Result: 1 quarter, 1 dime, 1 nickel, 1 penny.
	 //√4.Amount: 3.96, Tendered: 20.00, Result: 1 ten dollar bill, 1 five dollar bill, 
	 //√1 one dollar bill, 4 pennies.
	 //√5.Amount: any amount less than 20.00, Tendered: anything greater than amount: 
	 //	correct denominations for correct change. 	





//	System.out.println(25.30 % 25);
// 0.9999999999999999999993434 pennies
// add 0.005
// Math.round();

//in the cash register we will calculate the amount of change returned to a 
//customer based on the purchase price and the amount tendered. 
//We will also notify the attendant how many of each piece of currency 
//($20 ,$10 ,$5 ,$1, .25c, .10c, .05c, .01c) is needed to make the change for the customer.
//Change should be provided using the largest bill and coin denominations as possible. 
//Denominations that are not used should not be displayed.
//
//Hint: Mod operato