package york.eecs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import csvStuff.ParkingCSV;

class testParkingCSV {

	
	
	ParkingCSV  pcs = new ParkingCSV();
	
	
	
	
	@Test
	void testChangeStatus() {
		//fail("Not yet implemented");
		
		Assert.assertEquals(false,pcs.changeStatus("yukt@l", "122"));
		
		
	}
	

	@Test
	void testPayOff() {
		//fail("Not yet implemented");
		
		Assert.assertEquals(false,pcs.payOff("yuaskt@l"));
		
	}
	
	@Test
	void testPrice() {
		//fail("Not yet implemented");
		
		Assert.assertEquals("0",pcs.price("yukt@l"));
		
		
	}
	
	
	
	
	@Test
	void testBookingRemover() {
		//fail("Not yet implemented");
		
		Assert.assertEquals(false,pcs.bookingRemover("12212121", "yukt@l"));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	*/
}
