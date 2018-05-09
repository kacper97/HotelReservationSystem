import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ReceptionistTest {

	Receptionist r1;
	Guest g1;
	Room room1;
	Room room2;
	Room room3;
	Room room4;
	Booking b1;
	ArrayList<Room> rooms1=new ArrayList<Room>();
	ArrayList<Room> rooms2=new ArrayList<Room>();
	
	@Before
	public void setup(){
		
		g1= new Guest("name1", "address1", "email1", 34567, "Registered", 0000,true);
		
		room1=new Room(1, 101, "50x50", false, 20.00,1,"Single");
		room2=new Room(2, 201, "50x50", false,  30.00,3,"Double");
		room3=new Room(3, 301, "50x50", true, 40.00,1,"Single");
		room4=new Room(4, 401, "50x50", true, 50.00,4,"Family");
		
		rooms1.add(room1);
		rooms1.add(room2);
		rooms1.add(room3);
		
		 r1=new Receptionist(1, "name1", "address1", "email1", "branch1", false, "password1");
		 b1=r1.makeBooking(g1, "01/01/2019", 1, "email1", 29.99, "Single", rooms1);
	}
	
	@Test
	public void testMakeBookingDateAddedToRoom(){		
		assertFalse(room1.checkIfAvailable("01/01/2019"));
	}
	
	@Test
	public void testMakeBookingRefAddedToGuest(){		
		assertEquals(g1.getBookingReferences().size(),1);
	}
	
	@Test
	public void testMakeBookingPayNowBooking(){		
		assertEquals(b1.isPayOnCheckout(),false);
	}
	
	@Test
	public void testCancelBookingAmountPaidReturned(){
		b1.updateBalanceDue(19.99);
		g1.updateAmountPaid(19.99);
		r1.cancelBooking(g1, b1);
		
		assertEquals(0,g1.getAmountPaidInTotal(),2);
	}
	
	@Test
	public void testCancelBookingGuestRemovedBookingRef(){
		r1.cancelBooking(g1, b1);
		
		assertFalse(g1.getBookingReferences().contains(b1.getReferenceID()));
	}
	
	@Test
	public void testCancelBookingRoomAvailableAgain(){
		r1.cancelBooking(g1, b1);
		
		assertTrue(room1.checkIfAvailable("01/01/2019"));
	}
	
	@Test
	public void testGetAvailableRooms(){
		ArrayList<Room> roomsReturned=r1.getAvailableRooms("01/01/2019", rooms1);
		
		assertEquals(room2,roomsReturned.get(0));
		assertEquals(2,roomsReturned.size());
		}
	
	
	@Test
	public void testCheckGuestInRoomNotOccupied(){
		r1.checkGuestIn(b1, g1);
		assertTrue(b1.getRooms().get(0).checkIfOccupied());
		assertTrue(g1.getHasKey());
	}
	
	@Test
	public void testCheckGuestInRoomOccupiedAlready(){
		b1.getRooms().get(0).setIsOccupied(true);
		r1.checkGuestIn(b1, g1);
		assertFalse(g1.getHasKey());
	}
	
	
	@Test
	public void testCheckGuestOutKeyTaken(){
		r1.checkGuestOut(b1, g1);
		assertFalse(g1.getHasKey());
	}
	
	@Test
	public void testCheckGuestOutNoRoomsDamaged(){
		g1.setAmountPaidInTotal(100);
		b1.setDeposit(10.00);
		double origAmount=g1.getAmountPaidInTotal();
		r1.checkGuestOut(b1, g1);
	
		assertEquals(origAmount-10,g1.getAmountPaidInTotal(),2);
	}
	
	@Test
	public void testCheckGuestOutOneRoomDamaged(){
		g1.setAmountPaidInTotal(100);
		b1.setDeposit(10.00);
		room1.setIsDamaged(true);
		double origAmount=g1.getAmountPaidInTotal();
		r1.checkGuestOut(b1, g1);
	
		assertEquals(origAmount,g1.getAmountPaidInTotal(),2);
	}
	
	@Test
	public void testCheckGuestOutRoomCleanStatus(){
		r1.checkGuestOut(b1, g1);
	
		assertFalse(room1.getCleanDetails());
	}
	@Test
	public void testCheckGuestOutRoomOccupiedStatus(){
		r1.checkGuestOut(b1, g1);
	
		assertFalse(room1.checkIfOccupied());
	}
}
