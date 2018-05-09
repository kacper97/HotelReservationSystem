import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ManagerTest {

	Manager m1;
	Room room1;
	Room room2;
	Room room3;
	Room room4;
	Booking b1;
	ArrayList<Room> rooms1=new ArrayList<Room>();
	
	@Before
	public void setup(){
		m1=new Manager(0, "name1", "address1", "email1", "branch1", true, "pass1");
		
		room1=new Room(1, 101, "50x50", false, 20.00, 1,"Single");
		room2=new Room(2, 201, "50x50", false, 30.00,3,"Double");
		room3=new Room(3, 301, "50x50", true, 40.00,1,"Single");
		room4=new Room(4, 401, "50x50", true, 50.00,4,"Family");
		
		rooms1.add(room1);
		
	}
	
	@Test
	public void testChangeRoomPrice(){
		m1.changeRoomPrice(rooms1, 24.00);
		assertEquals(24.00,room1.getPrice(),2);
	}
	@Test
	public void testChangeRoomPriceMultiple(){
		rooms1.add(room3);
		m1.changeRoomPrice(rooms1, 24.00);
		assertEquals(24.00,room1.getPrice(),2);
		assertEquals(24.00,room3.getPrice(),2);
	}
}
