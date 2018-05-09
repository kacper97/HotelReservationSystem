public class Cleaner extends Employee{

	public Cleaner(int employeeId, String name, String address, String email, String currentBranch,
			boolean hasManagerClearance, String password) {
		super(employeeId, name, address, email, currentBranch, password);
		
	}
	
	
	
	public void cleanRoom(Room room){ 
		// Cleaner manually cleans the room 
		boolean cleanedDetails=room.getCleanDetails();
		boolean occupied=room.checkIfOccupied();
		if (cleanedDetails==false){
			if(occupied==true){
				knock();  // manually done, representation here just to show process
				room.clean("daily");
			}
			else {
				room.clean("deep clean");
			}
			
		}
	}

	public void knock(){  // manual knock on door, representation here just to show process
		System.out.println("Cleaner Knocked On Door!");
	}
}
