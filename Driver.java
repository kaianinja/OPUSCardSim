
// -------------------------------------------------------
// Assignment #4
// Written by: Cleopatr-Aliak Manoukian 40211001
// For COMP 248 Section ECDX-LAB � Fall 2021
// -------------------------------------------------------
import java.util.Scanner;

public class Driver {
	/*
	 * This program is used to display and modify the elements of ticketbooths and
	 * their elements. This includes opus cards and tickets that figure in the
	 * ticketbooth. 3 classes, other than the driver, are used to define methods and
	 * use them in either another class, or the driver. We can remove opus cards
	 * from a ticketbooth, modify their expiry date, add opus cards to the
	 * ticketbooths, display all or one ticketbooths, list ticketbooths who have
	 * equal elements and exit the program. Through all of the choices, the user has
	 * to enter input which is verified using loops.
	 */

	public static void main(String[] args) {

		Scanner key = new Scanner(System.in);
//welcome message
		System.out.println(
				"======================================================================================\n    Welcome to Concordia 2021 Fall Geek's Ticketbooth application\n======================================================================================");

		// initializing variables
		int choice, nestedChoice, newMonth, newYear, index;
		String newType, newName;
		Ticketbooth Ticketbooth0, Ticketbooth1, Ticketbooth2, Ticketbooth3, Ticketbooth4;
		Tickets Tickets0, Tickets1, Tickets2, Tickets3, Tickets4;
		boolean isInvalid=false;

		// Creating the Tickets that will belong in each ticketbooth
		Tickets0 = new Tickets(5, 1, 0, 1, 1);
		Tickets1 = new Tickets(Tickets0);
		Tickets2 = new Tickets(5, 5, 5, 5, 5);
		Tickets3 = new Tickets(0, 1, 1, 1, 1);
		Tickets4 = new Tickets(Tickets3);

		// Creating OPUSCard arrays for each of the Ticketbooths, and creating all
		// OPUSCards that will go in the OPUSCard arrays
		OPUSCard[] opus0 = new OPUSCard[1];
		opus0[0] = new OPUSCard("STM", "M. Cleo", 8, 2027);

		OPUSCard[] opus1 = new OPUSCard[1];
		opus1[0] = new OPUSCard("STL", "M. Toz", 7, 2013);

		OPUSCard[] opus2 = new OPUSCard[3];
		opus2[0] = new OPUSCard("STL", "M. Khra", 10, 2022);
		opus2[1] = new OPUSCard("RTL", "Mlle. Camion", 12, 2021);
		opus2[2] = new OPUSCard("REM", "D. Estille", 3, 2022);

		OPUSCard[] opus3 = new OPUSCard[0];

		OPUSCard[] opus4 = new OPUSCard[0];

		// creating ticketbooths with the previously created tickets and opuscards
		Ticketbooth0 = new Ticketbooth(Tickets0, opus0);
		Ticketbooth1 = new Ticketbooth(Tickets1, opus1);
		Ticketbooth2 = new Ticketbooth(Tickets2, opus2);
		Ticketbooth3 = new Ticketbooth(Tickets3, opus3);
		Ticketbooth4 = new Ticketbooth(Tickets4, opus4);

		// Creating an array of type ticketbooth to store all the ticketbooths in
		Ticketbooth[] allBooths = { Ticketbooth0, Ticketbooth1, Ticketbooth2, Ticketbooth3, Ticketbooth4 };

		// loop to restart the choices every time an option has been completed
		while (true) {

			// menu
			System.out.println("What would you like to do?");
			System.out.println("\t1.  See the content of all Ticketbooths");
			System.out.println("\t2.  See the content of one Ticketbooth");
			System.out.println("\t3.  List Ticketbooths with the same amount of tickets' values");
			System.out.println("\t4.  List Ticketbooths with same Tickets amount");
			System.out.println(
					"\t5.  List Ticketbooths with the same amount of tickets values and same number of OPUS cards");
			System.out.println("\t6.  Add an OPUS card to an existing Ticketbooth");
			System.out.println("\t7.  Remove an existing OPUS card from a Ticketbooth");
			System.out.println("\t8.  Update the expiry date of an existing OPUS card");
			System.out.println("\t9.  Add Tickets to a Ticketbooth");
			System.out.println("\t0.  To quit");
			System.out.println();

			// loop to force the user to enter a valid number
			while (true) {
				System.out.print("Please enter your choice and press <Enter>:");
				choice = key.nextInt();
				if (choice < 0 || choice > 9)
					System.out.print("Invalid choice. Please choose a number between 0 and 9\n");
				else
					break;
			}
			System.out.println();
			// switch loop that will be executed according to the choice the user makes.
			switch (choice) {
			// printing all Ticketbooths as well as their content
			case 1:
				for (int i = 0; i < allBooths.length; i++) {
					System.out.println("Ticketbooth #" + i + ":");
					System.out.print(allBooths[i].toString());
					System.out.println("\n");
				}

				break;

			// displaying contents of a ticketbooth that the user chooses.
			case 2:
				// loop forcing user to enter a valid number
				while (true) {
					System.out.print("Which Ticketbooth would you like to see?(enter 0-4)");
					nestedChoice = key.nextInt();
					if (nestedChoice < 0 || nestedChoice > 4)
						System.out.println("Sorry. There is no Ticketbooth " + nestedChoice
								+ " .Please choose a number between 0 and 4");
					else
						break;
				}
				// displaying content of chosen ticketbooth
				System.out.println(allBooths[nestedChoice].toString());
				break;
			// displaying pairs of ticketbooths that have the same value as well as the said
			// value
			case 3:
				// for loop representing the first ticketbooth being compared
				for (int i = 0; i < 5; i++)
					// all the ticketbooths the previous one is going to be compared to. f starts at
					// i+1 to avoid repetition
					for (int f = i + 1; f < 5; f++)
						if (allBooths[i].valueEquals(allBooths[f]))
							System.out.println("Ticketbooths " + (i) + " and " + (f) + " both have "
									+ allBooths[f].theTickets.ticketsTotal());
				break;

			// Displaying all ticketbooth pairs that have the same amount of tickets as well
			// as the said distribution of tickets.
			case 4:
				// Same concept as case 3, but a different method is used to compare the ticket
				// distribution instead of the total value.
				for (int i = 0; i < 5; i++) {
					for (int f = i; f < 5; f++)
						if (allBooths[f].numTicketEquals(allBooths[i]) && i != f)
							System.out.println("Ticketbooths " + (i) + " and " + (f) + " both have:\n"
									+ allBooths[i].theTickets.toString());
					System.out.println();
				}
				break;

			// Displaying all ticketbooths that are equal according to the definition of
			// equal in Ticketooth class
			case 5:
				System.out.println(
						"List of Ticketbooths with the same amount of tickets values and same number of OPUS cards:\n");
				for (int i = 0; i < 5; i++)
					for (int f = i; f < 5; f++)
						if (allBooths[i].equals(allBooths[f]) && f != i)
							System.out.println("Ticketbooths" + i + "and" + f);
				break;

			// adding an OPUS card to the Ticketbooth chosen
			case 6:

				while (true) {
					System.out.print("Which ticketbooth would you like to add an OPUS card to?(0-4)");
					nestedChoice = key.nextInt();
					if (nestedChoice < 0 || nestedChoice > 4)
						System.out.print("Invalid Choice. Please choose a number between 0 and 4");
					else
						break;
				}
				// Asking for the OPUS Card info and displaying the number of opus cards in the
				// ticketbooth after the addition
				System.out.print("What is the type of the OPUS Card(STL,STM,RTM...)?");
				newType = key.next();
				// Absorbing the newline used before so that the following nexLine works( to be
				// able to use spaces)
				key.nextLine();
				System.out.print("What is the name of the OPUS cardholder?");
				newName = key.nextLine();
				System.out.print("What is the expiry month?");
				newMonth = key.nextInt();
				System.out.print("What is the expiry year?");
				newYear = key.nextInt();
				// Creating the new OPUSCard
				OPUSCard addOPUS = new OPUSCard(newType, newName, newMonth, newYear);
				for(int d=0;d<allBooths[nestedChoice].theOPUSCard.length;d++)
					if (allBooths[nestedChoice].theOPUSCard[d].equals(addOPUS))
						isInvalid=true;
				if(isInvalid==true)
				{
					System.out.println("The OPUSCard you entered already exists. Please choose another option.");
					isInvalid=false;
					break;
				}
						
				// Adding the opusCard
				allBooths[nestedChoice].addCard(addOPUS);
				System.out.print("You now have " + allBooths[nestedChoice].totalOPUS() + " OPUS Card(s)");
				
				break;
			// Removing an Opus card and saying if it was successful or not
			case 7:
				// Checking validity of user input
				while (true) {
					System.out.print("Which ticketbooth would you like to remove an OPUS card from?(0-4)");
					nestedChoice = key.nextInt();
					if (nestedChoice < 0 || nestedChoice > 4)
						System.out.print("Invalid Choice. Please choose a number between 0 and 4");
					else
						break;
				}
				// Behavior when there is no OPUS Card in the Ticketbooth
				if (allBooths[nestedChoice].totalOPUS() <= 0) {
					System.out.println("Sorry, this ticketbooth does not contain any OPUS Cards");
					break;
				}

				while (true) {
					System.out.print("What is the index of the card you would like to remove? (0 to "
							+ (allBooths[nestedChoice].totalOPUS() - 1) + ")");
					index = key.nextInt();
					if (index < 0 || index > (allBooths[nestedChoice].totalOPUS() - 1))
						System.out.print("Invalid entry. Please choose a number between 0 and"
								+ (allBooths[nestedChoice].totalOPUS() - 1) + ")");
					else
						break;
				}
				// removing the OPUS card when possible
				if (allBooths[nestedChoice].removeCard(index))
					System.out.print("Successfully removed");
				else
					System.out.print("The card was not removed.");
				break;

			// Updating expiry date of an OPUS Card in the ticketbooth
			case 8:

				// Verifying validity of user input
				while (true) {
					System.out.print("Which ticketbooth would you like to update a card from?(0-4)");
					nestedChoice = key.nextInt();
					if (nestedChoice > 4 || nestedChoice < 0)
						System.out.print("Invalid entry. Please try again.");
					else
						break;

				}
				while (true) {
					System.out.print("Which OPUS card would you like to update the expiry date of? (0 to"
							+ (allBooths[nestedChoice].totalOPUS() - 1) + ")");
					index = key.nextInt();
					if (index < 0 || index > (allBooths[nestedChoice].totalOPUS() - 1))
						System.out.print("Sorry, but there is no card number " + index);
					else
						break;

				}
				System.out.print("What is the new expiry Month?");
				newMonth = key.nextInt();
				System.out.print("What is the new expiry Year");
				newYear = key.nextInt();
				// Changing expiry date
				allBooths[nestedChoice].setExpiryDate(index, newMonth, newYear);
				break;

			case 9:
				// Checking user input validity
				while (true) {
					System.out.println("Which ticketbooth would you like to add tickets to?(0 to 4)");
					nestedChoice = key.nextInt();
					if (nestedChoice < 0 || nestedChoice > 4)
						System.out.println("Sorry. There is no Ticketbooth " + nestedChoice + ".Try again.");
					else
						break;
				}
				// Getting the number of tickets the user wants to add
				System.out.print(
						"How may regular, junior, senior daily and weekly tickets would you like to add?(enter five numbers. Follow each one by a space)");
				int reg = key.nextInt();
				int jun = key.nextInt();
				int sen = key.nextInt();
				int day = key.nextInt();
				int week = key.nextInt();
				// Adding number of tickets required
				allBooths[nestedChoice].theTickets.addTickets(reg, jun, sen, day, week);
				// Displaying the new ticket distribution after the addition
				System.out.println("You now have $" + allBooths[nestedChoice].theTickets.ticketsTotal());
				break;
			// Exiting program
			case 0:
				// Closing message
				System.out.print("Thank you for using Concordia Fall Geek's Ticketbooth application");
				// closing scanner as it will no longer be used.
				key.close();
				System.exit(0);

			}
			// New line after each restart of the big while loop.
			
			System.out.println("\n");
		}
	}

}
