package co.edu.uco.nose.business.domain;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class UserDomain extends Domain{
	private String idNumber;
	private String firstName;
	private String secondName;
	private String lastName;
	private String secondLastName;
	private String email;
	private String phoneNumber;
	private IdentificationTypeDomain identificationType;
	private CityDomain city;
	
	public UserDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setIdNumber(TextHelper.getDefault());
		
		
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public IdentificationTypeDomain getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(IdentificationTypeDomain identificationType) {
		this.identificationType = identificationType;
	}

	public CityDomain getCity() {
		return city;
	}

	public void setCity(CityDomain city) {
		this.city = city;
	}
	
	
}
