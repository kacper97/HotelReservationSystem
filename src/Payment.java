import java.util.Random;

public class Payment {
	
	private Boolean isCash;
	private String paymentTime;
	private Boolean paymentVerififed;
	private double amount;
	private int paymentId;
	private double change;
	
	private int  createPayment(boolean isCash,String paymentTime,double amount ) {
		this.isCash =isCash;
		this.paymentTime=paymentTime;
		this.amount=amount;
		Random rand=new Random();    // get random num for payment id (system should ensure it is not already in database) 
		this.paymentId= rand.nextInt(100000);
		this.paymentVerififed=true;
		return paymentId;
	}
	
	public void payByCard(boolean isCash) {
		//payment is made by card 
		//can't be implemented in the system, as a seperate card system is used.
	}

	public double getChangeDue() {
		return change;
	}
	
}
