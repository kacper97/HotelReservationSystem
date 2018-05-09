import java.util.ArrayList;

public class Manager extends Employee {

	public Manager(int employeeId, String name, String address, String email,  String currentBranch,
			boolean hasManagerClearance, String password) {
		super(employeeId, name, address, email,  currentBranch, password);
	this.setManagerClearance(true);
	}

	public void changeRoomPrice(ArrayList<Room> rooms, double price){
		// pseudo : manager enters type in system and system returns room objects for that type
		// for this implementation I will just pass in the list of rooms of that type as a parameter, as no system driver and database implemented
		// system will prompt for price input, for this i will pass it as parameter
		
		System.out.println(rooms.get(0).getTypeDetails());  // in full system this would be printed on system screen
															// all rooms in list have same type and price, simply print this
		
		String nums="";  // print all room number details for rooms involved in change price
		
		for (Room room:rooms){
			nums+=room.getRoomDetails()+",\n";
		}
		System.out.println("Rooms Involved: \n"+nums);
		
		for(Room room:rooms){
		 room.changeRoomPrice(price);
		}
		System.out.println("Prices Changed!\nNew Details: "+rooms.get(0).getTypeDetails());
		nums="";
		for (Room room:rooms){
			nums+=room.getRoomDetails()+",\n";
		}
		System.out.println("Rooms Changed: \n"+nums);
		
	}
	
	
}
