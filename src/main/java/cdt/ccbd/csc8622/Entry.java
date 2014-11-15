package cdt.ccbd.csc8622;

import org.apache.commons.lang.RandomStringUtils;

/**
 * Entry class represents encapsulates properties of an entry (person) that can
 * be stored in an address book.
 * 
 * @author Saleh Mohamed
 * @version 13/11/2014
 */
public class Entry {

	private static final int ID_LENGTH = 10;
	private final String id;
	private String firstname;
	private String surname;
	private String address;
	private String phonenumber;
	private String dob;

	/**
	 * Constructor for instantiating objects of type 'Entry'
	 */
	public Entry(String firstname, String surname, String address,
			String phonenumber, String dob) {
		this.firstname = firstname;
		this.surname = surname;
		this.address = address;
		this.phonenumber = phonenumber;
		this.dob = dob;
		this.id = RandomStringUtils.randomAlphanumeric(ID_LENGTH);
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}

	/**
	 * @param phonenumber
	 *            the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = "ID: " + id + "\nFirst name: " + firstname
				+ "\nLast name: " + surname + "\nAddress: " + address
				+ "\nPhone number: " + phonenumber + "\nDOB: " + dob;
		return str;
	}
}
