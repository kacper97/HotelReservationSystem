import java.util.ArrayList;

public class Room {

	 private int roomFloorNumber;
	 private int roomNumber;
	 private String cleanedType;
	 private Boolean isCleaned;
	 private ArrayList<String> unavailableDates;
	 private String roomSize;
	 private Boolean hasBalcony;
	 private double price;
	 private double capacity;
	private Boolean isDamaged;
	 private String type;
	private Boolean isOccupied;

	 
	 

		
	
	public Room(int roomFloorNumber, int roomNumber, String roomSize, Boolean hasBalcony, double price, double capacity,
			String type) {
		super();
		this.roomFloorNumber = roomFloorNumber;
		this.roomNumber = roomNumber;
		this.roomSize = roomSize;
		this.hasBalcony = hasBalcony;
		
		if(price>0){
		this.price = price;
		}
		else{
			this.price=50.00; //default
		}
		this.capacity = capacity;
		this.type = type;
		
		unavailableDates=new ArrayList<String>();
		isDamaged=false;
		isOccupied=false;
	}


	public boolean checkIfOccupied() {  
		return isOccupied;
	}
	
	
	public void setIsOccupied(boolean occupied) {
		isOccupied=occupied; // sets it to occupied
		
	}
	public boolean checkifUndamaged() {  
	   return !isDamaged;
	}
	
	public double getPrice() {
		return price;
	}


	public void setIsDamaged(Boolean isDamaged) {
		this.isDamaged = isDamaged;
	}


	public boolean checkIfAvailable(String date) {  
												// wants to go through all unavailable dates, if date chosen isnt there then return true
	if (unavailableDates.contains(date)){
		return false;
	}
	else{
		return true;
	}
	}

	public void setCleanStatus(boolean cleaned) {
		isCleaned=cleaned;
	}
	
	
	public String getType() {
		return type;
	}
	
	
	public String getCleanedType() {
		return cleanedType;
	}


	public ArrayList<String> getUnavailableDates() {
		return unavailableDates;
	}


	public void addBookedDate(String dateOfBooking) {
		unavailableDates.add(dateOfBooking);
	}
	
	public void clean(String type) {
		setCleanStatus(true);
		setCleanedType(type);
	}
	
	private void setCleanedType(String type) {
		this.cleanedType=type;
	}

	public boolean getCleanDetails() {
		return isCleaned;
	}
	
	public String getRoomDetails() {
		return "Floor: "+roomFloorNumber +",Room Number: "+ roomNumber+",Price: "+price+",Capacity: " +capacity +",Size: "+ roomSize+ ", Balcony?: "+hasBalcony;
	}
	
	public void changeRoomPrice(double price) {
		if(price>0){
		this.price = price;
	}
	else{
		this.price=50.00; //default
	}
	}
	
	public String getTypeDetails() {
		return "Type: "+type+", Price: "+price;
	}
	
	public void removeBookedDate(String dateOfBooking) {
		unavailableDates.remove(dateOfBooking);
	}

}

	