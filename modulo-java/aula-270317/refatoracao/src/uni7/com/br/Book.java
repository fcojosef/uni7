package uni7.com.br;

public class Book extends Rent{
	private String author;
	
	public double getTotalFee(){
		return isOverdue() ? 1.2 * rentalFee : rentalFee;
	}
}
