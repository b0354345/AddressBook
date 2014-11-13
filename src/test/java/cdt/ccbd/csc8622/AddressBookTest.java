package cdt.ccbd.csc8622;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author localadmin
 *
 */
public class AddressBookTest {
	private AddressBook ab;
	private Entry entry;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ab = new AddressBook();
		 entry = new Entry("aa", "bb", "cc", "dd", "ee");
		ab.addEntry(entry);
	}

	/**
	 * Test 'addEntry' method when the address book is empty
	 */
	@Test
	public void testAddEntryForEmptyAddressBook()
	{
		AddressBook emptyAB = new AddressBook();
		Entry ent = new Entry("aaa", "bbb", "ccc", "ddd", "eee");
		emptyAB.addEntry(ent);
		assertFalse(emptyAB.getIds().isEmpty());
		assertFalse(emptyAB.getEntries().isEmpty());
	}
	
	/**
	 * Test 'addEntry' method when the address book is not empty
	 */
	@Test
	public void testAddEntryForNonEmptyAddressBook()
	{
		Entry ent = new Entry("aaa", "bbb", "ccc", "ddd", "eee");
		ab.addEntry(ent);
		assertEquals(ab.getIds().size(), 2);
		assertEquals(ab.getEntries().size(), 2);
	}
	
	/**
	 * Try add an entry who is already in the address book
	 */
	@Test(expected= IllegalArgumentException.class)
	public void testAddEntryWhenEntryAlreadyInAddressBook()
	{
		ab.addEntry(entry);
	}
	
	/**
	 * Test 'searchByFirstname' method
	 */
	@Test
	public void testSearchByFirstname()
	{
		Entry ent = new Entry("aaa", "bbb", "ccc", "ddd", "eee");
		Entry ent1 = new Entry("firstname", "bbb", "ccc", "ddd", "eee");
		ab.addEntry(ent);
		ab.addEntry(ent1);
		List<Entry> list = ab.searchByFirstname("firstname");
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getFirstname(), "firstname");	
	}
	
	/**
	 * Test 'searchBySurname' method
	 */
	@Test
	public void testSearchBySurname()
	{
		Entry ent = new Entry("aaa", "lastname1", "ccc", "ddd", "eee");
		Entry ent1 = new Entry("aa", "lastname2", "ccc", "ddd", "eee");
		ab.addEntry(ent);
		ab.addEntry(ent1);
		List<Entry> list = ab.searchBySurname("lastname1");
		List<Entry> list1 = ab.searchBySurname("lastname3");
		assertEquals(list.size(), 1);
		assertEquals(list1.size(), 0);	
		assertEquals(list.get(0).getSurname(), "lastname1");
	}
	
	/**
	 * Test 'searchByAddress' method
	 */
	@Test
	public void testSearchByAddress()
	{
		Entry ent = new Entry("aaa", "bbb", "address1", "ddd", "eee");
		Entry ent1 = new Entry("aa", "bb", "address2", "ddd", "eee");
		Entry ent2 = new Entry("aa", "bb", "address1", "ddd", "eee");
		ab.addEntry(ent);
		ab.addEntry(ent1);
		ab.addEntry(ent2);
		List<Entry> list = ab.searchByAddress("address1");
		List<Entry> list1 = ab.searchBySurname("address4");
		assertEquals(list.size(), 2);
		assertEquals(list1.size(), 0);	
		assertEquals(list.get(0).getAddress(), "address1");
		assertEquals(list.get(1).getAddress(), "address1");	
	}
	
	/**
	 * Test 'searchByPhonenumber' method
	 */
	@Test
	public void testSearchByPhonenumaber()
	{
		Entry ent = new Entry("aaa", "bbb", "ccc", "123", "eee");
		Entry ent1 = new Entry("aa", "bb", "ccc", "231", "eee");
		Entry ent2 = new Entry("aa", "bb", "ccc", "123", "eee");
		ab.addEntry(ent);
		ab.addEntry(ent1);
		ab.addEntry(ent2);
		List<Entry> list = ab.searchByPhonenumber("123");
		List<Entry> list1 = ab.searchByPhonenumber("222");
		assertEquals(list.size(), 2);
		assertEquals(list1.size(), 0);	
		assertEquals(list.get(0).getPhonenumber(), "123");
		assertEquals(list.get(1).getPhonenumber(), "123");	
	}
	
	/**
	 * Test 'searchByPhonenumber' method
	 */
	@Test
	public void testSearchByDob()
	{
		Entry ent = new Entry("aaa", "bbb", "ccc", "ddd", "99");
		Entry ent1 = new Entry("aa", "bb", "cc", "dd", "99");
		Entry ent2 = new Entry("aaaa", "bbbb", "cccc", "dddd", "99");
		ab.addEntry(ent);
		ab.addEntry(ent1);
		ab.addEntry(ent2);
		List<Entry> list = ab.searchByDOB("99");
		List<Entry> list1 = ab.searchByDOB("999");
		assertEquals(list.size(), 3);
		assertEquals(list1.size(), 0);	
		assertEquals(list.get(0).getDob(), "99");
		assertEquals(list.get(1).getDob(), "99");	
		assertEquals(list.get(2).getDob(), "99");
	}
	
	/**
	 * Test 'updateEntry' method for updating first name. 
	 */
	@Test
	public void testUpdateEntryForFirtsname()
	{
		Entry ent = new Entry("oldname", "bbb", "ccc", "ddd", "99");
		ab.addEntry(ent);
		String id = ent.getId();		
		ab.updateEntry(id, "name", "newname");
		assertEquals(ab.getEntry(id).getFirstname(), "newname");
	}
	
	/**
	 * Test 'updateEntry' method for updating surname. 
	 */
	@Test
	public void testUpdateEntryForSurname()
	{
		Entry ent = new Entry("aaa", "oldsurname", "ccc", "ddd", "99");
		String id = ent.getId();
		ab.addEntry(ent);
		ab.updateEntry(id, "surname", "newsurname");
		assertEquals(ab.getEntry(id).getSurname(), "newsurname");
	}
	
	/**
	 * Test 'updateEntry' method for updating address. 
	 */
	@Test
	public void testUpdateEntryForAddress()
	{
		Entry ent = new Entry("aaa", "bbb", "oldaddress", "ddd", "99");
		ab.addEntry(ent);
		String id = ent.getId();
		ab.updateEntry(id, "address", "newaddress");
		assertEquals(ab.getEntry(id).getAddress(), "newaddress");
	}
	
	/**
	 * Test 'updateEntry' method for updating phone number. 
	 */
	@Test
	public void testUpdateEntryForPhonenumber()
	{
		Entry ent = new Entry("aaa", "bbb", "ccc", "oldnumber", "99");
		ab.addEntry(ent);
		String id = ent.getId();
		ab.updateEntry(id, "phone number", "neewnumber");
		assertEquals(ab.getEntry(id).getPhonenumber(), "neewnumber");
	}
	
	/**
	 * Test 'updateEntry' method for updating date of birth. 
	 */
	@Test
	public void testUpdateEntryForDOB()
	{
		Entry ent = new Entry("aaa", "bbb", "ccc", "ddd", "olddob");
		ab.addEntry(ent);
		String id = ent.getId();
		ab.updateEntry(id, "date of birth", "newdob");
		assertEquals(ab.getEntry(id).getDob(), "newdob");
	}
	
	/**
	 * Test 'updateEntry' method for entry not stored in the address book . 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUpdateEntryForEntryNotInAddressBook()
	{
		Entry ent = new Entry("aa", "bb", "cc", "dd", "ee");
		Entry ent1 = new Entry("aaa", "bbb", "ccc", "ddd", "eee");
		Entry ent2 = new Entry("aaaa", "bbbb", "cccc", "dddd", "eeee");
		ab.addEntry(ent);
		ab.addEntry(ent1);		
		ab.updateEntry(ent2.getId(), "name", "newname");
	}
	
	/**
	 * Test 'updateEntry' method for invalid property name. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUpdateEntryForInvalidProperty()
	{
		Entry ent = new Entry("aa", "bb", "cc", "dd", "ee");
		Entry ent1 = new Entry("aaa", "bbb", "ccc", "ddd", "eee");
		ab.addEntry(ent);
		ab.addEntry(ent1);		
		ab.updateEntry(ent.getId(), "wrongproperty", "newname");
	}
	
	/**
	 * Test 'toString' method that returns string representation of address book object
	 */
	@Ignore
	@Test
	public void testTostring()
	{
		String str = "ID: " + entry.getId() + 
				"\nFirst name: aa\nLast name: bb\n"
				+ "Address: cc\nPhone number: dd\nDOB: ee";

		Entry ent1 = new Entry("aaa", "bbb", "ccc", "ddd", "eee");
		String str1 = "ID: " + ent1.getId() +
				"\nFirst name: aaa\nLast name: bbb\n"
				+ "Address: ccc\nPhone number: ddd\nDOB: eee";
		AddressBook ab1 = new AddressBook();		
		System.out.println(str);
		System.out.println();
		System.out.println(ab.toString());
		ab1.addEntry(ent1);
		assertTrue(ab.toString().equals(str));
		assertTrue(ab1.toString().equals(str1));
	}
}
