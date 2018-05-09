public class Employee {

	private int employeeId;
	private String name;
	private String address;
	private String email;
	private String currentBranch;
	private boolean hasManagerClearance;
	private String password;
	private boolean loggedIn;
	/**
	 * @param employeeId
	 * @param name
	 * @param address
	 * @param email
	 * @param startDate
	 * @param currentBranch
	 * @param password
	 */
	public Employee(int employeeId, String name, String address, String email,  String currentBranch,
			 String password) {
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
		this.email = email;
		this.currentBranch = currentBranch;
		this.hasManagerClearance = false;
		this.password = password;
		this.loggedIn=false;
	}
	
	public boolean checkIfManagerClearance(){
		return hasManagerClearance;
	
	}
	
	public void setManagerClearance(boolean clearance){
		hasManagerClearance=clearance;
	}
	
	public void setLoggedInStatus(boolean status){
		loggedIn=status;
	}
	
	
	
}
