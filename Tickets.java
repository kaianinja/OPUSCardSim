public class Tickets {

//declaring variables	

	private int regularNum;
	private int juniorNum;
	private int seniorNum;
	private int dailyNum;
	private int weeklyNum;

//declaring constants
	private static final double regularPrice = 3.50;
	private static final double juniorPrice = 2.50;
	private static final double seniorPrice = 1;
	private static final double dailyPrice = 10;
	private static final double weeklyPrice = 40;

//default constructor
	public Tickets() {

	}

//constructor with 5 integer parameters to set the number of each integer in ticketbooth.
	public Tickets(int newRegularNum, int newJuniorNum, int newSeniorNum, int newDailyNum, int newWeeklyNum) {
		this.regularNum = newRegularNum;
		this.juniorNum = newJuniorNum;
		this.seniorNum = newSeniorNum;
		this.dailyNum = newDailyNum;
		this.weeklyNum = newWeeklyNum;
	}

//copy constructor
	public Tickets(Tickets copy) {
		this.regularNum = copy.regularNum;
		this.juniorNum = copy.juniorNum;
		this.seniorNum = copy.seniorNum;
		this.dailyNum = copy.dailyNum;
		this.weeklyNum = copy.weeklyNum;
	}

//method that allows to increase the number of each tickets by the indicated number
	public void addTickets(int addRegularNum, int addJuniorNum, int addSeniorNum, int addDailyNum, int addWeeklyNum) {
		this.regularNum += addRegularNum;
		this.juniorNum += addJuniorNum;
		this.seniorNum += addSeniorNum;
		this.dailyNum += addDailyNum;
		this.weeklyNum += addWeeklyNum;
	}

//method that returns total value of tickets
	public double ticketsTotal() {
		double total = regularNum * regularPrice + juniorNum * juniorPrice + seniorNum * seniorPrice
				+ dailyNum * dailyPrice + weeklyNum * weeklyPrice;
		return total;
	}

//accessor methods for each type of ticket
	public int getRegularNum() {
		return regularNum;
	}

	public int getJuniorNum() {
		return juniorNum;
	}

	public int getSeniorNum() {
		return seniorNum;
	}

	public int getDailyNum() {
		return dailyNum;
	}

	public int getWeeklyNum() {
		return weeklyNum;

	}

//mutator methods for each type of tickets.
	public void setRegularNum(int regular) {
		this.regularNum = regular;
	}

	public void setJuniorNum(int junior) {
		this.juniorNum = junior;
	}

	public void setSeniorNum(int senior) {
		this.seniorNum = senior;
	}

	public void setDailyNum(int daily) {
		this.dailyNum = daily;
	}

	public void setWeeklyNum(int weekly) {
		this.weeklyNum = weekly;
	}

//method that returns a string clearly indicating the count of each ticket in the Ticketbooth.
	public String toString() {
		return "Regular tickets: " + regularNum + "\nJunior Tickets: " + juniorNum + "\nSenior Passes: " + seniorNum
				+ "\nDaily Tickets: " + dailyNum + "\nWeekly Tickets: " + weeklyNum;
	}

//method which will return true if two ibjects of type Tickets have the same breakdown of Tickets and false otherwise.
	public boolean equals(Tickets newTickets) {
		return (this.regularNum == newTickets.regularNum && this.juniorNum == newTickets.juniorNum
				&& this.seniorNum == newTickets.seniorNum && this.dailyNum == newTickets.dailyNum
				&& this.weeklyNum == newTickets.weeklyNum);
	}

}
