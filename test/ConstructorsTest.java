import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ConstructorsTest {

	Booking b1;
	Booking b2;
	Room room1;
	Room room2;
	Room room3;
	Room room4;
	ArrayList<Room> rooms1=new ArrayList<Room>();
	ArrayList<Room> rooms2=new ArrayList<Room>();
	
	
	@Before
	public void setup(){
		room1=new Room(1, 101, "50x50", false, 20.00,1,"Single");
		room2=new Room(2, 201, "50x50", false,  30.00,3,"Double");
		room3=new Room(3, 301, "50x50", true, 40.00,1,"Single");
		room4=new Room(4, 401, "50x50", true, -90.00,4,"Family");
		
		rooms1.add(room1);
		b1= new Booking("01/01/2018", 1, "John@gmail.com", 20.00,rooms1 );
		
		rooms2.add(room1);
		rooms2.add(room2);
		b2= new Booking("01/01/2019", 1, "Joan@gmail.com", 50.00,rooms2 );
	}
	
	
	// implemented some tests for Booking and Room constructors as guideline, same would be done for other class constructors
	@Test
	public void testBookingConstructorSetDate(){
		assertEquals("01/01/2018",b1.getDate());
	}
	
	@Test
	public void testBookingConstructorSetDuration(){
		assertEquals(1,b1.getDuration());
	}
	
	@Test
	public void testBookingConstructorSetEmail(){
		assertEquals("John@gmail.com",b1.getGuestEmail());
	}
	
	@Test
	public void testBookingConstructorSetPrice(){
		assertEquals(20.00,b1.getCost(),2);
	}
	
	@Test
	public void testBookingConstructorSetRooms(){
		assertEquals(rooms1,b1.getRooms());
	}
	
	@Test
	public void testRoomConstructorOccupied(){
		assertFalse(room1.checkIfOccupied());
	}
	@Test
	public void testRoomConstructorUnDamaged(){
		assertTrue(room1.checkifUndamaged());
	}
	
	@Test
	public void testRoomConstructorPrice(){
		assertEquals(20.00,room1.getPrice(),2);
	}
	@Test
	public void testRoomConstructorInvalidPrice(){
		assertEquals(50.00,room4.getPrice(),2);
	}
	
	@Test
	public void testRoomConstructorType(){
		assertEquals("Single",room1.getType());
	}
	
	@Test
	public void testRoomSetIsOccupied(){
		room1.setIsOccupied(true);
		assertTrue(room1.checkIfOccupied());
	}
	
	@Test
	public void testRoomSetIsDamaged(){
		room1.setIsDamaged(true);
		assertFalse(room1.checkifUndamaged());
	}
	
	@Test
	public void testIfAvailable(){
		room1.addBookedDate("01/01/2013");
		assertFalse(room1.checkIfAvailable("01/01/2013"));
	}
	
	@Test
	public void testAddBookedDate(){
		room1.addBookedDate("01/01/2013");
		assertEquals(3,room1.getUnavailableDates().size());
	}
	
	@Test
	public void testClean(){
		room1.clean("daily");
		assertTrue(room1.getCleanDetails());
		assertEquals("daily",room1.getCleanedType());
	}
	
	@Test
	public void testRoomChangeInvalidPrice(){
		room1.changeRoomPrice(-2);
		assertEquals(50.00,room1.getPrice(),2);
	}
	
	@Test
	public void testRemoveBookedDate(){
		assertTrue(room1.getUnavailableDates().contains("01/01/2018"));
		room1.removeBookedDate("01/01/2018");
		assertFalse(room1.getUnavailableDates().contains("01/01/2018"));
	}
}
