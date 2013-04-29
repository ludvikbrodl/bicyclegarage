package model;

/**
 * Main-method used to start the application.
 * 
 * @param args
 */

class Address {
	private int streetNumber;
	private String streetName;
	private int zipcode;
	private String cityName;

	public Address(String streetName, int streetNumber, int zipcode,
			String cityName) {
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.zipcode = zipcode;
		this.cityName = cityName;

	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNbr) {
		streetNumber = streetNbr;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {

	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
