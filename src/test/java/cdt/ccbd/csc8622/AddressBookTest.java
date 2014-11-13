/**
 * 
 */
package cdt.ccbd.csc8622;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
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
		ab.printEntries();
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
}
