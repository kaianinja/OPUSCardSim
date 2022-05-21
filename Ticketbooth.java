
public class Ticketbooth {

	Tickets theTickets;
	OPUSCard theOPUSCard[];

	// default constructor
	public Ticketbooth() {

	}

	// constructor to set the initial value of each attribute
	public Ticketbooth(Tickets theTickets, OPUSCard theOPUSCard[]) {
		this.theOPUSCard = theOPUSCard;
		this.theTickets = theTickets;
	}

	// method which will return the number of OPUS cards in a ticketbooth.
	public int totalOPUS() {
		return theOPUSCard.length;
	}

	// method that returns true if the total value of tickets of two Ticketbooth
	// objects are equal, false otherwise
	public boolean valueEquals(Ticketbooth newTicketbooth) {
		return this.theTickets.ticketsTotal() == newTicketbooth.theTickets.ticketsTotal();
	}

	// method that returns true if the number of each type of tickets of two
	// Ticketbooth objects are equal, false otherwise.
	public boolean numTicketEquals(Ticketbooth newTicketbooth) {
		return this.theTickets.equals(newTicketbooth.theTickets);
	}

	// method which will add a new OPUS Card to a ticketbooth and returns the total
	// number of OPUS cards in the ticketbooth after addition.
	public int addCard(OPUSCard newOPUS) {
		// creating new array of type OPUSCard that contains an extra space.
		OPUSCard addOPUS[] = new OPUSCard[theOPUSCard.length + 1];
		// Copying th OPUS Card
		for (int i = 0; i < addOPUS.length - 1; i++)
			addOPUS[i] = theOPUSCard[i];
		// adding new opus card in the array
		addOPUS[addOPUS.length - 1] = newOPUS;
		// Changing original OPUSCard[] reference to match the new one.
		this.theOPUSCard = addOPUS;
		// returning the number of OPUSCards.
		return addOPUS.length;
	}

//method which will remove a card from the ticketbooth and return true if removal was successful.
	public boolean removeCard(int deleteOPUS) {
		// Making a new array that has a space less than the original one.
		OPUSCard removeOPUS[] = new OPUSCard[theOPUSCard.length - 1];
		// behavior when there are no cards
		if (removeOPUS.length < 0)
			return false;
		else {
			// using different variables to represent the index of each OPUSCard
			int f = 0;
			// loop to copy elements from original card to the new one.
			for (int i = 0; i < theOPUSCard.length; i++) {
				if (i == deleteOPUS) {
					// skipping the removed
					continue;
				} else {
					removeOPUS[f] = theOPUSCard[i];
					f++;
				}
			}
			// replacing old card by the new one
			this.theOPUSCard = removeOPUS;
			return true;
		}

	}

	// accessor method adapted to Ticketbooth, to update expiry date of an opus card
	public void setExpiryDate(int i, int month, int year) {
		theOPUSCard[i].setExpiryMonth(month);
		theOPUSCard[i].setExpiryYear(year);
	}

	// adding tickets to a ticketbooth
	public void addTicketboothTickets(int addRegularNum, int addJuniorNum, int addSeniorNum, int addDailyNum,
			int addWeeklyNum) {
		this.theTickets.addTickets(addRegularNum, addJuniorNum, addSeniorNum, addDailyNum, addWeeklyNum);
	}

	// Method which will return true if the total value of tickets in two
	// ticketbooths are equal
	public boolean equals(Ticketbooth newTicketbooth) {
		return this.valueEquals(newTicketbooth) && this.numTicketEquals(newTicketbooth);
	}

	// method which will clearly indicate the number of each ticket in the
	// ticketbooth
	// as well as the details of each opus card in the ticketbooth.
	public String toString() {
		String totalString = "";
		totalString = this.theTickets.toString();
		// program behavior when there are no opus cards in the ticketbooth.
		if (this.theOPUSCard.length <= 0)
			totalString += "\nNo OPUS cards";
		else
			for (int k = 0; k < theOPUSCard.length; k++)
				totalString += "\n" + this.theOPUSCard[k].toString();
		return totalString;
	}

	// method which will return a string with just the breakdown of the tickets.
	public String ticketBreakdown() {
		return this.theTickets.toString();
	}

}
