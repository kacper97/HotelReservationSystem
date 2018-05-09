import java.util.ArrayList;

public class Guest {

	private String name;
	private String address;
	private String email;
	private int mobile;
	private ArrayList<Double> bookingReferences=new ArrayList<Double>();   // **************
	private String type;
	
	private Boolean payNow;
	private Boolean hasKey;
	private double amountPaidInTotal;
	private String stayDetails;
	private int pin;
	private String paymentChoices;
	private Double cashReceived;
	
	
	public Guest(String name, String address, String email, int mobile, String type, int pin,boolean payNow) {
		
		this.name = name;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		
		if(type.equals("Registered") || type.equals("Not Registered")){
		this.type = type;
		}
		else{
			this.type="Not Registered"; //default 
		}
		
		this.pin = pin;
		this.payNow=payNow;
		hasKey=false;
		amountPaidInTotal=0.0;
		
	}

	public Boolean getHasKey() {
		return hasKey;
	}

	public String getGuestType() {
		return type;
	}
	
	public String getGuestDetails() {   
		return "Name: "+name+",Address: "+address+",Email: "+email+",Mobile: "+mobile;
	}
	
	public void addBookingReference(double ref) {
		if(bookingReferences.contains(ref)){
			System.out.println("Booking Reference Already Included");
		}
		else{
		bookingReferences.add(ref);
		}
	}
	
	public boolean ifPayNow() {
		return payNow;
	}

	public ArrayList<Double> getBookingReferences() {  
		return bookingReferences;
	}
	
	public void setHasKey(Boolean hasKey) {
		this.hasKey = hasKey;
	}
	
	public void updateAmountPaid(double amount) { 
		setAmountPaidInTotal(getAmountPaidInTotal() + amount);
	}
	
	public void removeBooking(double booking) {
		bookingReferences.remove(booking);
	}
	
	public String getStayDetails() {
		return stayDetails;
	}


	public int getPin() {
		return pin;
	}


	public double getAmountPaidInTotal() {
		return amountPaidInTotal;
	}

	public void setAmountPaidInTotal(double amountPaidInTotal) {
		this.amountPaidInTotal = amountPaidInTotal;
	}

	
}
