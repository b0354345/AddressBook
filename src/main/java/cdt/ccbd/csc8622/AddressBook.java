package cdt.ccbd.csc8622;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class can be used to create instances of AddresBook where
 * entries can be stored and searched.
 * @author Saleh Mohamed
 * @version 13/11/2014
 */
public class AddressBook {
	private List<String> ids = new ArrayList<String>();
	private Map<String, Entry> entries = new HashMap<String, Entry>();
	
	/**
	 * Parameterless constructor for creating an instance of  'AddressBook'
	 */
	public AddressBook(){}
	
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
	 * This method takes a stored entry id, a string indicating a specific property of
	 * the entry to be updated, and a new value for that property.
	 * @param id
	 * @param property
	 * @param value
	 * @throws IllegalArgumentException if the id supplied is not in the address book or 
	 * the string property supplied does not much to any of the entry's properties. 
	 */
	public void updateEntry(String id, String property, String value) {
		if (!ids.contains(id))
			throw new IllegalArgumentException("Entry not in the address book");
		Entry ent = getEntry(id);
		if (property.toLowerCase().equals("name"))
			ent.setFirstname(value);
		else if (property.toLowerCase().equals("surname"))
			ent.setSurname(value);
		else if (property.toLowerCase().equals("address"))
			ent.setAddress(value);
		else if (property.toLowerCase().equals("phone number"))
			ent.setPhonenumber(value);
		else if (property.toLowerCase().equals("date of birth"))
			ent.setDob(value);
		else
			throw new IllegalArgumentException("Invalid second argument");
	}
	
	/**
	 * Return an entry corresponding to a given id
	 */
	public Entry getEntry(String id) 
	{
		Entry ent = null;
		for (Map.Entry<String, Entry> entry : entries.entrySet())
		{
			if (entry.getKey().equals(id))
				ent = entry.getValue();
			break;
		}
		return ent;
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
