package york.eecs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import csvStuff.CSVManager;

class testCSVManager {
	
	
	CSVManager sv = new CSVManager();
	
/*	@Test
	void test() {
		fail("Not yet implemented");
	}
*/
	
	@Test
	void testOfficerRemover() {
		//fail("Not yet implemented");
		
		Assert.assertEquals(false,sv.officerRemover("yukt@l"));
		
		
	}
	
	
	
	
	
	@Test
	void testIsCustomer() {
		//fail("Not yet implemented");
		
		Assert.assertEquals(false,sv.isCustomer("yukt@l","aas"));
		
		
	}
	
	
	@Test
	void testIsOfficer() {
		//fail("Not yet implemented");
		
		Assert.assertEquals(false,sv.isOfficer("yukt@l","aas"));		
	}
	
	
	@Test
	void testIsadmin() {
		//fail("Not yet implemented");
		
		Assert.assertEquals(false,sv.isAdmin("yukt@l","aas"));
		
		
	}
	
	
	@Test
	void testIsOfficerEmail() {
		//fail("Not yet implemented");
		
		Assert.assertEquals(false,sv.isOfficerEmail("aas@yas"));
		
		
	}
	
	@Test
	void testCustomerRegistrar() {
		//fail("Not yet implemented");
		
		Assert.assertEquals(false,sv.customerRegistrar("fname", "lname", "t1@yorku.ca", "password"));
		
		
	}
	
	@Test
	void testOfficerRegistrar() {
		//fail("Not yet implemented");
		
		Assert.assertEquals(false,sv.officerRegistrar("fname", "lname", "t1@yorku.ca", "password"));
		
		
	}
	
	
	
	
	
}
