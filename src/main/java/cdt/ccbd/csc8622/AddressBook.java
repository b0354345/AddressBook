/**
 * 
 */
package cdt.ccbd.csc8622;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Saleh Mohamed
 *
 */
public class AddressBook {
	private List<String> ids = new ArrayList<String>();
	private Map<String, Entry> entries = new HashMap<String, Entry>();
	
	/**
	 * Constructor for creating an instance of  'AddressBook'
	 */
	public AddressBook()
	{
		
	}
	
	/**
	 * Method to add a new entry into this address book
	 * @param - Entry to be stored into the addressbook
	 */
	public void addEntry(Entry entry)
	{
		if (ids.contains(entry.getId())){
			throw new IllegalArgumentException("Entry already in the address book");
		}else
		{
			ids.add(entry.getId());
			entries.put(entry.getId(), entry);
		}
	}
	
	/**
	 * Print the content of the address book
	 */
	public void printEntries()
	{
		for (Map.Entry<String, Entry> entry : entries.entrySet()) {
		    System.out.println(entry.getValue() + "\n");
		}	
	}
	
	/**
	 * Search the address book by first name and return a list of 
	 * matched entries
	 * @return - List of entries
	 */
	public List<Entry> searchByFirstname(String name)
	{
		List<Entry> matchedEntries = new ArrayList<Entry>();
		Entry value = null;
		for (Map.Entry<String, Entry> entry : entries.entrySet()) {
			value = entry.getValue();
			if(value.getFirstname().equals(name))
				matchedEntries.add(value);				
		}
		return matchedEntries;
	}
	
	/**
	 * Search the address book by surname and return a list of 
	 * matched entries
	 * @return - List of entries
	 */
	public List<Entry> searchBySurname(String surname)
	{
		List<Entry> matchedEntries = new ArrayList<Entry>();
		Entry value = null;
		for (Map.Entry<String, Entry> entry : entries.entrySet()) {
			value = entry.getValue();
			if(value.getSurname().equals(surname))
				matchedEntries.add(value);				
		}
		return matchedEntries;
	}
	
	/**
	 * Search the address book by address and return a list of 
	 * matched entries
	 * @return - List of entries
	 */
	public List<Entry> searchByAddress(String address)
	{
		List<Entry> matchedEntries = new ArrayList<Entry>();
		Entry value = null;
		for (Map.Entry<String, Entry> entry : entries.entrySet()) {
			value = entry.getValue();
			if(value.getAddress().equals(address))
				matchedEntries.add(value);				
		}
		return matchedEntries;
	}
	
	/**
	 * Search the address book by phone number and return a list of 
	 * matched entries
	 * @return - List of entries
	 */
	public List<Entry> searchByPhonenumber(String number)
	{
		List<Entry> matchedEntries = new ArrayList<Entry>();
		Entry value = null;
		for (Map.Entry<String, Entry> entry : entries.entrySet()) {
			value = entry.getValue();
			if(value.getPhonenumber().equals(number))
				matchedEntries.add(value);				
		}
		return matchedEntries;
	}
	
	/**
	 * Search the address book by DOB and return a list of 
	 * matched entries
	 * @return - List of entries
	 */
	public List<Entry> searchByDOB(String dob)
	{
		List<Entry> matchedEntries = new ArrayList<Entry>();
		Entry value = null;
		for (Map.Entry<String, Entry> entry : entries.entrySet()) {
			value = entry.getValue();
			if(value.getDob().equals(dob))
				matchedEntries.add(value);				
		}
		return matchedEntries;
	}
	
	/**
	 * Return a map of all entries in the address book
	 * @return
	 */
	public Map<String, Entry> getEntries() {
		// TODO Auto-generated method stub
		return entries;
	}
	
	/**
	 * Return a list of all ids for the entry stored in the address book 
	 * @return
	 */
	public List<String> getIds() {
		// TODO Auto-generated method stub
		return ids;
	}
	
}
