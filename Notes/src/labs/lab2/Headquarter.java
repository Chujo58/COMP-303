package labs.lab2;


/**
 * Represents corporate headquarters for the grocery stores
 * */
public class Headquarter
{
	private String aCountry;
	private final Integer aEstablishedYear;
	
	/**
	 * @param pCountry: country of headquarters
	 * @param pEstablishedYear: established year
	 * @pre pCountry != null && pEstablishedYear != null
	 * */
	public Headquarter(String pCountry, Integer pEstablishedYear) {
		assert pCountry != null && pEstablishedYear != null;
		aCountry = pCountry;
		aEstablishedYear = pEstablishedYear;
	}
	
	public boolean equals(Object pObject) {
		if (pObject == null) { //if pObject null then can't be equal
			return false;
		}
		else if (pObject.getClass() != getClass()) { //if pObject not of correct class we can't compare
			return false;
		}
		else {
			return aCountry.equals(((Headquarter) pObject).aCountry) && 
					aEstablishedYear.equals(((Headquarter) pObject).aEstablishedYear);
		}
	}
	
	public int hashCode() {
		return aCountry.hashCode() + aEstablishedYear.hashCode();
	}
	
	public void relocate(String newLocation) {
		aCountry = newLocation;
	}
	
	public String getCountry() {
		return aCountry;
	}
	
	public Integer getEstablishedYear() {
		return aEstablishedYear;
	}
}
