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
	 * 
	 */
}
