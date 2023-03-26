import java.util.Scanner;

public class MakeChangeProject {
	private int[] denominations = { 2000, 1000, 500, 100, 25, 10, 5, 1 };
	private String[] denominationBills = { "twenties", "tens", "fives", "ones", 
			"quarters", "dimes", "nickels", "pennies" };

	public static void main(String[] args) {
		MakeChangeProject mcp = new MakeChangeProject();

		mcp.startUp();
	}

	public void startUp() {
		Scanner sc = new Scanner(System.in);
		int intPrice, intPaid, change;
		System.out.println("what was your total?");
		intPrice = (int) (getDouble(sc) * 100); 
		System.out.println("how much are you paying?"); 
		intPaid = (int) (getDouble(sc) * 100);
		change = intPaid - intPrice; 
		if (intPrice < intPaid) { 
			owedToUser(change);
			findDenomination(change);
		} else if (intPrice > intPaid) {
			owedToMCP(change);
		} else if (intPrice == intPaid) {
			goodBye();
		}
		sc.close();
	}

	public double getDouble(Scanner sc) {
		return sc.nextDouble();
	}

	public void owedToUser(double change) {
		System.out.printf("you over paid by: " + "$%,.2f", change / 100);
		System.out.println(" ");
	}

	public void owedToMCP(double change) {
		System.out.printf("You Still Owe :$%,.2f", -change / 100);
	}

	public void findDenomination(int change) {
		for (int i = 0; i < 8; i++) {
			int numberOfBills = change / denominations[i];
			if (numberOfBills > 0) {
				change = change % denominations[i];
				System.out.println("you receive " + numberOfBills + " " + denominationBills[i]);
			}
		}
	}

	public String goodBye() {
		System.out.println("thank you");
		return "Thank You!";
	}
}
//	public void findDenom(int change) {
//		int change1 = change;
//		change1 = twenty(change1);
//		change1 = ten(change1);
//		change1 = five(change1);
//		change1 = one(change1);
//		change1 = quarter(change1);
//		change1 = dime(change1);
//		change1 = nickel(change1);
//		change1 = penny(change1);
//	}
//
//	public int twenty(int change1) {
//		int twenty = change1 / 2000; // <---- twenty dollars = cents(in change) / $20 in cents
//
//		if (twenty > 0) { // if change(in cents)/$20.00(in cents) is greater than 0
//
//			change1 = change1 % 2000; // <----- get mod of change to move to next step.
//			System.out.println("you receive " + twenty + " twenties"); // <----change/2000 leaves the amount of 20s
//			return change1; // that will make change
//
//		} else {
// 			return change1;
//		}
//
//	}
//
//	public int ten(int change1) {
//		int ten = change1 / 1000;
//		if (ten > 0) {
//			change1 = change1 % 1000;
//			System.out.println("you receive " + ten + " tens");
//			return change1;
//		} else {
//			return change1;
//		}
//	}
//
//	public int five(int change1) {
//		int five = change1 / 500;
//		if (five > 0) {
//			change1 = change1 % 500;
//			System.out.println("you receive " + five + " fives");
//			return change1;
//		} else {
//			return change1;
//		}
//	}
//
//	public int one(int change) {
//		int one = change / 100;
//		if (one > 0) {
//			change = change % 100;
//			System.out.println("you receive " + one + " ones");
//			return change;
//		} else {
//			return change;
//		}
//	}
//
//	public int quarter(int change) {
//		int quarter = change / 25;
//		if (quarter > 0) {
//			change = change % 25;
//			System.out.println("you receive " + quarter + " quarters");
//			return change;
//		} else {
//			return change;
//		}
//	}
//
//	public int dime(int change) {
//		int dime = change / 10;
//		if (dime > 0) {
//			change = change % 10;
//			System.out.println("you receive " + dime + " dimes");
//			return change;
//		} else {
//			return change;
//		}
//	}
//
//	public int nickel(int change) {
//		int nickel = change / 5;
//		if (nickel > 0) {
//			change = change % 5;
//			System.out.println("you receive " + nickel + " nickels");
//			return change;
//		} else {
//			return change;
//		}
//	}
//
//	public int penny(int change) {
//		int penny = change;
//		if (penny > 0) {
//			change--;
//			System.out.println("you receive: " + penny + " pennies");
//			return change;
//		} else {
//			return change;
//		}
//	}
