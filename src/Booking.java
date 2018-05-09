import java.util.ArrayList;
import java.util.Random;


public class Booking {

	
	private String dateOfBooking;
	private int duration;
	private double balanceDue;
	private double referenceID;
	private String guestEmail;
	private boolean bookingPayOnCheckout;
	private ArrayList<Room> rooms;
	private double totalCost;
	private double depositPaid;
	
	
	
	public Booking(String dateOfBooking, int duration,  String guestEmail, double totalCost, ArrayList<Room> rooms) {
		this.dateOfBooking = dateOfBooking;
		this.duration = duration;
		this.balanceDue = totalCost;
		this.guestEmail = guestEmail;
		this.totalCost = totalCost;
		Random rand=new Random();    // get random num for reference id (system should ensure it is not already in database) 
		this.referenceID= rand.nextInt(100000);
		
		for (Room room:rooms){
			room.addBookedDate(dateOfBooking);
		}
		
		this.bookingPayOnCheckout=true;
		this.rooms=rooms;
		this.depositPaid=0.0;
		
	}
	
	/**
	 * @return the balanceDue
	 */
	public double getBalanceDue(){
		return balanceDue;
	}
	
	public void updateBalanceDue(double amount){
		if(balanceDue-amount<0){
			System.out.println("Cannot pay more than is due!");
		}
		else{
		balanceDue-=amount;
		}
	}
	
	/**
	 * @return the bookingPayOnCheckout
	 */
	public boolean isPayOnCheckout(){
	return bookingPayOnCheckout;
	}

	/**
	 * @return the referenceID
	 */
	public double getReferenceID() {
		return referenceID;
	}

	/**
	 * @return the depositPaid
	 */
	public double getDeposit() {
		return depositPaid;
	}

	/**
	 * @param bookingPayOnCheckout the bookingPayOnCheckout to set
	 */
	public void setBookingPayOnCheckout(boolean bookingPayOnCheckout) {
		this.bookingPayOnCheckout = bookingPayOnCheckout;
	}
	
	public String getBookingDetails(){
		String details="Date: "+dateOfBooking+", Duration: "+duration+
				"\nReference ID: "+referenceID+", Email: "+guestEmail+
				"\n Total: "+totalCost+", Balance Due: "+balanceDue+
				"\n Pay On Checkout? "+bookingPayOnCheckout+
				"\n Rooms: ";
		for(int i=0;i<rooms.size();i++){
			details+=rooms.get(i).getRoomDetails()+",";
		}
		return details;
	}
	
	public void addRoom(Room room){
		if(rooms.contains(room)){
			System.out.println("Room already included in booking!");
		}
		else{
		rooms.add(room);
		}
	}
	
	
	public double getAmountPaid(){
		return totalCost-balanceDue;
	}
	
	public void removeRooms(){
		for(Room room:rooms){
			room.removeBookedDate(dateOfBooking);
		}
		rooms.clear();
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public String getDate() {
		return dateOfBooking;
	}

	public int getDuration() {
		return duration;
	}

	public String getGuestEmail() {
		return guestEmail;
	}

	public double getCost() {
		return totalCost;
	}

	public void setDeposit(double d) {
		depositPaid=d;
		
	}

	
	
	
	
}
