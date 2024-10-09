package labs.lab2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestHeadquarter
{
	private Headquarter headquarter = new Headquarter("France", Integer.valueOf(1985));
	@Test
	public void testEquals_CountryTrue() {
		Headquarter testHeadquarter = new Headquarter("France", Integer.valueOf(1985));
		assertEquals(true, headquarter.equals(testHeadquarter));
	}
	
	@Test
	public void testEquals_CountryFalse() {
		Headquarter testHeadquarter = new Headquarter("Canada", Integer.valueOf(1985));
		assertEquals(false, headquarter.equals(testHeadquarter));
	}
	
	@Test
	public void testEquals_YearTrue() {
		Headquarter testHeadquarter = new Headquarter("France", Integer.valueOf(1985));
		assertEquals(true, headquarter.equals(testHeadquarter));
	}
	
	@Test
	public void testEquals_YearFalse() {
		Headquarter testHeadquarter = new Headquarter("France", Integer.valueOf(1990));
		assertEquals(false, headquarter.equals(testHeadquarter));
	}
	
	@Test
	public void testRelocate() {
		String newLocation = "Canada";
		headquarter.relocate(newLocation);
		assertEquals(newLocation, headquarter.getCountry());
	}
}
