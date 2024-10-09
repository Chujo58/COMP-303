package labs.lab2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestCEO
{
	CEO ceo = CEO.instance();
	@Test
	public void testSingleInstance() 
	{
		CEO otherCeo = CEO.instance();
		assertTrue(otherCeo == ceo);
	}
	
	@Test
	public void testUpdateCEO() 
	{
		String newNameString = "NewName"; 
		String newNationalityString = "NewNationality";
		
		ceo.updateCEO(newNameString, newNationalityString);
		assertEquals(newNameString, ceo.getName());
		assertEquals(newNationalityString, ceo.getNationality());
	}
}

