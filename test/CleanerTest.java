import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CleanerTest {
    Cleaner c1;
	Room room1;
	Booking b1;
	
	@Before
	public void setup(){
		c1=new Cleaner(0, "name1", "address1", "email1", "branch1", false, "pass1");
		
		room1=new Room(1, 101, "50x50", false, 1, 20.00,"Single");
		
		
	}
	
	@Test
	public void testCleanRoomOccupiedAndDirty(){
		room1.setIsOccupied(true);
		room1.setCleanStatus(false);
		c1.cleanRoom(room1);
		
		assertTrue(room1.getCleanDetails());
		assertEquals("daily",room1.getCleanedType());
	}
	
	@Test
	public void testCleanRoomNotOccupiedAndDirty(){
		room1.setIsOccupied(false);
		room1.setCleanStatus(false);
		c1.cleanRoom(room1);
		
		assertTrue(room1.getCleanDetails());
		assertEquals("deep clean",room1.getCleanedType());
	}
}


