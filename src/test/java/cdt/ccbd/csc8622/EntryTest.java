/**
 * 
 */
package cdt.ccbd.csc8622;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the 'Entry' class 
 * @author Saleh Mohamed
 * @version 13/11/2014
 */
public class EntryTest{
	private Entry entry;
	/**
	 * Setup method is used to instantiate an Entry object before running 
	 * test methods.
	 */
	@Before
	public void setup()
	{
		String firstname = "John";
		String surname = "Brown";
		String address = "10 Downing Street";
		String phonenumber = "01913456778";
		String dob = "20/12/1980";
		entry = new Entry(firstname, surname, address, phonenumber, dob);
	}
	
	/**
	 * Test "getFirstname" method
	 */
	@Test
	public void testGetFirstname()
	{
		String firstname = entry.getFirstname();
		assertEquals(firstname, "John");
	}
	
	/**
	 * Test "setFirstname" method
	 */
	@Test
	public void testSetFirstname()
	{
		entry.setFirstname("Mike");
		assertEquals(entry.getFirstname(), "Mike");
	}
	
	/**
	 * Test "getSurname" method
	 */
	@Test
	public void testGetSurname()
	{
		String surname = entry.getSurname();
		assertEquals(surname, "Brown");
	}
	
	/**
	 * Test "setSurname" method
	 */
	@Test
	public void testSetSurname()
	{
		entry.setSurname("Tosh");
		assertEquals(entry.getSurname(), "Tosh");
	}
		
	/**
	 * Test "getAddress" method
	 */
	@Test
	public void testGetAddress()
	{
		String address = entry.getAddress();
		assertEquals(address, "10 Downing Street");
	}
	
	/**
	 * Test "setAddress" method
	 */
	@Test
	public void testSetAdress()
	{
		entry.setAddress("21 Simon side terrace");
		assertEquals(entry.getAddress(), "21 Simon side terrace");
	}
	
	/**
	 * Test "getGetPhonenumber" method
	 */
	@Test
	public void testGetPhonenumber()
	{
		String phonumber = entry.getPhonenumber();
		assertEquals(phonumber, "01913456778");
	}
	
	/**
	 * Test "setPhonenumber" method
	 */
	@Test
	public void testSetPhonenumber()
	{
		entry.setPhonenumber("02071235648");
		assertEquals(entry.getPhonenumber(), "02071235648");
	}
	
	/**
	 * Test "getGetDob" method
	 */
	@Test
	public void testGetDob()
	{
		String dob = entry.getDob();
		assertEquals(dob, "20/12/1980");
	}
	
	/**
	 * Test "setPhonenumber" method
	 */
	@Test
	public void testSetDob()
	{
		entry.setDob("01/01/2001");
		assertEquals(entry.getDob(), "01/01/2001");
	}
		
}
