import java.text.DecimalFormat;

public class Weight {
	private final int OUNCES_IN_POUND = 16;
	private int pounds;
	private double ounces;
	public Weight(int pounds, double ounces) {
		this.pounds = pounds;
		this.ounces = ounces;
	}
	
	
	public boolean lessThan(Weight suppliedWeight) {
		int totalWeight = (int) (this.toOunces(this.pounds) + this.ounces);
		if(totalWeight < suppliedWeight.toOunces(suppliedWeight.pounds) + suppliedWeight.ounces ) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void addTo(Weight enteredWeight) {
		this.pounds+= enteredWeight.pounds;
		this.ounces+= enteredWeight.ounces;
		this.normalize();
	}
	
	public void divide(int divisor) {
		this.pounds = this.pounds/divisor;
		this.normalize();
	}
	public String toString() {
		DecimalFormat df = new DecimalFormat("###.###");
		return this.pounds + " lbs " + df.format(this.ounces) + " oz";
	}
	private double toOunces(int pounds) {
		return (pounds * this.OUNCES_IN_POUND);
	}
	private void normalize() {
		if(this.ounces > this.OUNCES_IN_POUND) {
			int poundsToBeAdded = (int) (this.ounces/this.OUNCES_IN_POUND);
			this.pounds+= poundsToBeAdded;
			this.ounces = this.ounces % this.OUNCES_IN_POUND;
		}
	}
	
}

