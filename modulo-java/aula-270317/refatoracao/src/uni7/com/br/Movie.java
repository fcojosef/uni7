package uni7.com.br;

public class Movie extends Rent{
	private int classification;
	
	public double getTotalFee(){
		return isOverdue() ? 1.3 * rentalFee : rentalFee;
	}
}
