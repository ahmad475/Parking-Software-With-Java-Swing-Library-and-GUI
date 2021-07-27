package york.eecs.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import csvStuff.Spaces;
//import york.eecs.source.BubbleSort;
//import york.eecs.source.HeapSort;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
class testSpaces {

	
	Spaces sp= new Spaces();
	
	
	@Before
	public void setUp() throws Exception {
		sp = new Spaces();
	}
	
	
	@Test
	void testRemoveSpace() {
		//fail("Not yet implemented");
		
		Assert.assertEquals(true,sp.removespace("501"));
		
		
	}

		
	
	@Test
	void testAddSpace() {
		//fail("Not yet implemented");
		
		Assert.assertEquals(true,sp.addSpace("501"));
		
		
	}

	@Test
	void isSpace() {
		//fail("Not yet implemented");
		
		Assert.assertEquals(false,sp.isSpace("50100"));
		
		
	}
	
	@Test
	void testOccupiedSpace() {
		//fail("Not yet implemented");
		
		Assert.assertEquals(false,sp.isOccupied("501"));
		
		
	}
	
		
}
