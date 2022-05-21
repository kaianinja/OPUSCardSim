
public class OPUSCard {

	// declaring variables
	private String type;
	private String name;
	private int expiryMonth;
	private int expiryYear;

	// default constructor
	public OPUSCard() {

	}

	// Constructor to set initial values of each attribute. If the month passed is
	// not between 1 and 12, it is set to 0.
	public OPUSCard(String newType, String newName, int newExpMonth, int newExpYear) {
		this.type = newType;
		this.name = newName;
		if (newExpMonth >= 1 && newExpMonth <= 12)
			this.expiryMonth = newExpMonth;
		else
			this.expiryMonth = 0;
		this.expiryMonth = newExpMonth;
		this.expiryYear = newExpYear;

	}

	// copy constructor
	public OPUSCard(OPUSCard copy) {
		this.type = copy.type;
		this.name = copy.name;
		this.expiryMonth = copy.expiryMonth;
		this.expiryYear = copy.expiryYear;
	}

	// accessor method
	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getExpiryMonth() {
		return expiryMonth;
	}

	public int getExpiryYear() {
		return expiryYear;
	}

	// mutator methods
	public void setExpiryMonth(int newExpMonth) {
		if (newExpMonth >= 1 && newExpMonth <= 12)
			this.expiryMonth = newExpMonth;
		else
			expiryMonth = 0;
	}

	public void setExpiryYear(int newExpYear) {
		expiryYear = newExpYear;
	}

	// method which will return a string indicating the type of opus card, the name
	// of the cardholder as well as the expiry date formated like so : mm/yyyy
	public String toString() {
		if (expiryMonth < 10)
			return type + "-" + name + "-0" + expiryMonth + "/" + expiryYear;
		else
			return type + "-" + name + "-" + expiryMonth + "/" + expiryYear;
	}

	// method which will return true if two objects of type OPUSCard are identical
	public boolean equals(OPUSCard newOpusCard)

	{
		return this.type == newOpusCard.type && this.name == newOpusCard.name && this.expiryMonth == newOpusCard.expiryMonth
				&& this.expiryYear == newOpusCard.expiryYear;
	}

}
