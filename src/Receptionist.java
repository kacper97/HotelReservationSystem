import java.util.ArrayList;

public class Receptionist extends Employee{

	public Receptionist(int employeeId, String name, String address, String email, String currentBranch,
			boolean hasManagerClearance, String password) {
		super(employeeId, name, address, email,  currentBranch, password);
	
	}
	
	public Booking makeBooking(Guest guest,String date, int duration, String email, double totalCost, String roomType,ArrayList<Room> allRooms){
		// receptionist would get details in person from guest, and determine if they are registered 
		// for this code, i pass the guest object in, this would be created in system when details are input
		// allRooms only passed as parameter for testing as no system database implemented
		// there would be no parameters in real system
		
		String type=guest.getGuestType();
		String details=guest.getGuestDetails();
		System.out.println("Type: "+type+", Details"+details);
		
		if(type.equals("Registered")){ // only want to create booking if registration into database by system was successful
			
		ArrayList<Room> roomsAvail=getAvailableRooms(date,allRooms);
		ArrayList<Room> roomsChosen=new ArrayList<Room>();
		for(Room room: roomsAvail){
			if (room.getType().equals(roomType)){
				roomsChosen.add(room);
				break;
			}
		}
		
		Booking booking=new Booking(date,duration,email,totalCost,roomsChosen);
		guest.addBookingReference(booking.getReferenceID());
		
		if (!guest.ifPayNow()){
			booking.setBookingPayOnCheckout(true);
		}
		else{
			booking.setBookingPayOnCheckout(false);
		}
		
		System.out.println(booking.getBookingDetails());
		return booking;
		}
		else{
			System.out.println("System could not register guest previously! Booking Incomplete");
		}
		return null;
	}
	
	
	
	public void cancelBooking(Guest guest, Booking booking){
		// reference given by guest which system uses to search database for booking
		// For this test code implementation i pass guest and booking as parameters
		
		// system would search bookings in database for booking with reference, 
		// for this code i pass it in as parameter
		System.out.println(booking.getBookingDetails());
		double paid= booking.getAmountPaid();
		guest.updateAmountPaid(-paid);  // in real life the receptionist gives the guest back money 
		booking.removeRooms();
		
		guest.removeBooking(booking.getReferenceID());
	}
	
	
	public ArrayList<Room> getAvailableRooms(String date, ArrayList<Room> rooms){
		ArrayList<Room> roomsAvail=new ArrayList<Room>();
		
		// Pseudo: system called to return rooms with that date available 
		// for each room object , it will loop through unavailable dates, and return the rooms in list that dont contain the chosen date as unavailable
		// for the testing of this code, all rooms are passed through as parameter and the search is done here
		
		for(Room room:rooms){    // this would be done by system using database, for test purpose i implement it here 
			if(room.checkIfAvailable(date)){{
				roomsAvail.add(room);
			}
		}
		}
		
		return roomsAvail; 
		
	}
	
	public void checkGuestIn(Booking booking,Guest guest){
		// system would find booking from ref number provided by guest, for this the booking and guest are passed as parameters
		
		System.out.println(booking.getBookingDetails());
		for(Room room:booking.getRooms()){
			if(room.checkIfOccupied()){
				System.out.println("System error - room already occupied!");
			}
			else{
			room.setIsOccupied(true);
			guest.setHasKey(true);
			}
		}
		
	}

	public void checkGuestOut(Booking booking,Guest guest){
		// system would find booking and room from key card reader, for this the booking and guest are passed as parameters
		// in real system they are found in database 
		
		guest.setHasKey(false);
		System.out.println(guest.getGuestDetails());
		
		boolean undamaged=true;
		for(Room room:booking.getRooms()){   // if any of the rooms are damaged
			if(!room.checkifUndamaged()){
				undamaged=false;
				break;
			}
		}
		
		if(undamaged){
			guest.updateAmountPaid(- booking.getDeposit());
		}
		
		for(Room room:booking.getRooms()){   // set all rooms to unoccupied and dirty
		room.setCleanStatus(false);
		room.setIsOccupied(false);
		}
		
	}
}
