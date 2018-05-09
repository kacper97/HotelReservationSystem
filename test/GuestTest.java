import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GuestTest {

	Guest g1;
	Guest g2;
	
	@Before
	public void setup(){
		g1=new Guest("name1", "address1", "email1", 98765, "Registered", 1234, true);
		g2=new Guest("name2", "address2", "email2", 92234, "Invalid", 2234, true);
	}
	
	@Test
	public void testConstructorKey(){
		assertFalse(g1.getHasKey());
	}
	@Test
	public void testConstructorType(){
		assertEquals("Registered",g1.getGuestType());
	}
	@Test
	public void testConstructorInvalidType(){
		assertEquals("Not Registered",g2.getGuestType());
	}
	
	@Test
	public void testDetails(){
		assertEquals("Name: name1,Address: address1,Email: email1,Mobile: 98765",g1.getGuestDetails());
	}
	
	@Test
	public void testAddBookingReference(){
		assertEquals(0,g1.getBookingReferences().size());
		g1.addBookingReference(1234);
		assertEquals(1,g1.getBookingReferences().size());
	}
	
	@Test
	public void testAddBookingDuplicateReference(){
		g1.addBookingReference(1234);
		assertEquals(1,g1.getBookingReferences().size());
		g1.addBookingReference(1234);
		assertEquals(1,g1.getBookingReferences().size());
	}
	
	@Test 
	public void testConstructorIfPayNow(){
		assertTrue(g1.ifPayNow());
	}
	
	@Test
	public void testGetBookingReferences(){
		g1.addBookingReference(1234);
		assertEquals(1,g1.getBookingReferences().size());
		assertEquals(1234,g1.getBookingReferences().get(0),2);
	}
	
	@Test
	public void testSetHasKey(){
		g1.setHasKey(true);
		assertTrue(g1.getHasKey());
	}
	
	@Test
	public void testUpdateAmountPositive(){
		g1.setAmountPaidInTotal(100);
		g1.updateAmountPaid(20);
		assertEquals(120,g1.getAmountPaidInTotal(),2);
	}
	@Test
	public void testUpdateAmountNegative(){
		g1.setAmountPaidInTotal(100);
		g1.updateAmountPaid(-20);
		assertEquals(80,g1.getAmountPaidInTotal(),2);
	}
	
	@Test
	public void testRemoveBooking(){
		g1.addBookingReference(1234.0);
		assertTrue(g1.getBookingReferences().contains(1234.0));
		g1.removeBooking(1234.0);
		assertFalse(g1.getBookingReferences().contains(1234.0));
		
	}
	
	@Test
	public void testConstructorGetPin(){
		assertEquals(1234,g1.getPin());
	}
	
	@Test
	public void testConstructorGetAmountPaid(){
		assertEquals(0,g1.getAmountPaidInTotal(),2);
	}
	
	@Test
	public void testSetAmountPaid(){
		g1.setAmountPaidInTotal(10.00);
		assertEquals(10.00,g1.getAmountPaidInTotal(),2);
	}
}
