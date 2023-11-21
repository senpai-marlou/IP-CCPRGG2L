import java.util.InputMismatchException;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {

		System.out.println("--Enter your lottery pick: 1 - 100--");
		System.out.println("  --10 Lucky Numbers per Ticket--");
		System.out.println("");
		GetLotto();

	}

	public static void GetLotto() {

		Scanner scan = new Scanner(System.in);

		boolean[] neededNumbers = new boolean[100];

		int tempCount = 1;
		int count = 1;
		boolean inputError = false;
		System.out.println("Enter your ticket number: " + count++);

		int ticketNumber = scan.nextInt();

		if (ticketNumber == 0) {
			System.out.println("");
			System.out.println("Invalid First Number.");
			System.out.print("Try Again? [Y/N]: ");
			String CatchError = scan.nextLine();
			String Invalid = scan.nextLine();
			if (Invalid.equalsIgnoreCase("Y") || Invalid.equalsIgnoreCase("Yes")) {
				System.out.println("");
				GetLotto();
			}
		}

		while (ticketNumber != 0 && ticketNumber <= 100) {
			try {
				neededNumbers[ticketNumber - 1] = true;
				tempCount += 1;
				ticketNumber = scan.nextInt();
				if (ticketNumber != 0
						&& (tempCount == 10 || tempCount == 20 || tempCount == 30 || tempCount == 40 || tempCount == 50
								|| tempCount == 60 || tempCount == 70 || tempCount == 80 || tempCount == 90)) {
					System.out.println("Enter your ticket number: " + count++);
				} else if (tempCount == 100) {
					System.out.print("Maximum input of number reached. To exit, enter 0: ");
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Input must be a number.");
				inputError = true;
				break;
			}
		}

		if (ticketNumber > 100) {
			System.out.println("Error: Input number must be 1 - 100 only.");
			System.out.print("Try Again? [Y/N]: ");
			String CatchError = scan.nextLine();
			String missed1 = scan.nextLine();
			if (missed1.equalsIgnoreCase("Y") || missed1.equalsIgnoreCase("Yes")) {
				neededNumbers = new boolean[] {};
				System.out.println("");
				GetLotto();
			}
		}

		if (inputError) {
			System.out.print("Try Again? [Y/N]: ");
			String CatchError = scan.nextLine();
			String missed1 = scan.nextLine();
			if (missed1.equalsIgnoreCase("Y") || missed1.equalsIgnoreCase("Yes")) {
				neededNumbers = new boolean[] {};
				System.out.println("");
				GetLotto();
			}
		}

		boolean allCovered = true;

		for (int i = 0; i < neededNumbers.length; i++) {
			if (!neededNumbers[i]) {
				allCovered = false;
				System.out.println("");
				System.out.println("You did not cover all of the numbers.");
				System.out.print("Do you want to find out what number you missed? [Y/N]: ");
				String missed = scan.next();
				System.out.println("");
				if (missed.equalsIgnoreCase("Y") || missed.equalsIgnoreCase("Yes")) {
					for (int j = 0; j < neededNumbers.length; j++) {
						if (!neededNumbers[j]) {
							if (!neededNumbers[j] && j < 9) {
								System.out.print(" ");
							}
							System.out.print(j + 1 + " ");
						} else {
							System.out.print("-- ");
						}
						if (j == 9 || j == 19 || j == 29 || j == 39 || j == 49 || j == 59 || j == 69 || j == 79
								|| j == 89) {
							System.out.println("");
						}
					}
					System.out.println("");
				}
				System.out.println("");
				System.out.print("Start Over Again? [Y/N]: ");
				String tryagain = scan.next();
				if (tryagain.equalsIgnoreCase("Y") || tryagain.equalsIgnoreCase("Yes")) {
					System.out.println("");
					neededNumbers = new boolean[] {};
					GetLotto();
				} else if (tryagain.equalsIgnoreCase("N") || tryagain.equalsIgnoreCase("No")) {
					allCovered = false;
					System.out.println("");
					System.out.print("Nice Try.");
					break;
				}
			}
		}
		if (allCovered == false) {
			System.exit(0);
		} else if (allCovered == true) {
			System.out.println("");
			System.out.print("All numbers are covered by the tickets.");
		}
	}
}
