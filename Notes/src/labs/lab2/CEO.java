package labs.lab2;

public class CEO
{
	
	private final Integer aID = 0;
	private String aName;
	private String aNationality;
	private final Integer aYearAppointment; //If this can't change, maybe get the year of creation of the headquarters?
	

	/**
	 * @pre pID != null && (pName != null || pName.length() != 0) && (pNationality!= null || pNationality.length() != 0) 
				&& pYearAppointment != null;
	 * */
	private CEO(String pName, String pNationality, Integer pYearAppointment)
	{
		assert pName != null && pNationality!= null && pYearAppointment != null;
		aName = pName;
		aNationality = pNationality;
		aYearAppointment = pYearAppointment;
	}
	
	/**
	 * @pre newName != null && newNationality != null
	 * */
	public void updateCEO(String pNewName, String pNewNationality) 
	{
		assert pNewName != null && pNewNationality != null && pNewName.length() != 0  && pNewNationality.length() != 0;
		aName = pNewName;
		aNationality = pNewNationality;
	}
	
	public String getName() {
		return aName;
	}
	
	public String getNationality() {
		return aNationality;
	}
	
	private static CEO INSTANCE = new CEO("Name", "Nationality", Integer.valueOf(1990));
	
	/**
	 * Returns the only instance of CEO class.
	 * */
	public static CEO instance() 
	{
		return INSTANCE;
	}
	
	/**
	 * Returns the only instance of CEO class with a new name and nationality.
	 * */
	public static CEO instance(String pName, String pNationality)
	{	
		INSTANCE.updateCEO(pName, pNationality);
		return INSTANCE;
	}
}
