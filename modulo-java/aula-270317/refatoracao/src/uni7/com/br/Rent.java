package uni7.com.br;

import java.util.Date;

public class Rent {
	private String title;
	private Date rentDate;
	private Date dueDate;
	protected double rentalFee;
	
	public boolean isOverdue(){
		Date now = new Date();
		return dueDate.before(now);
	}
	
	public double getTotalFee(){
		return 0;
	}
	
}
