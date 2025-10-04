package co.edu.uco.nose.business.domain;

import java.util.UUID;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
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
	private IdTypeDomain identificationType;
	private CityDomain city;
	private boolean emailConfirmed;
	private boolean phoneConfirmed;
	
	public UserDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setIdNumber(TextHelper.getDefault());
		setFirstName(TextHelper.getDefault());
		setSecondName(TextHelper.getDefault());
		setLastName(TextHelper.getDefault());
		setSecondLastName(TextHelper.getDefault());
		setEmail(TextHelper.getDefault());
		setPhoneNumber(TextHelper.getDefault());
		setIdentificationType(new IdTypeDomain());
		setCity(new CityDomain());
		setEmailConfirmed(false);
		setPhoneConfirmed(false);
	}
	
	public UserDomain(UUID id) {
		super(id);
		setIdNumber(TextHelper.getDefault());
		setFirstName(TextHelper.getDefault());
		setSecondName(TextHelper.getDefault());
		setLastName(TextHelper.getDefault());
		setSecondLastName(TextHelper.getDefault());
		setEmail(TextHelper.getDefault());
		setPhoneNumber(TextHelper.getDefault());
		setIdentificationType(new IdTypeDomain());
		setCity(new CityDomain());
		setEmailConfirmed(false);
		setPhoneConfirmed(false);
	}
	
	public UserDomain(UUID id, String idNumber, String firstName, String secondName, String lastName, String secondLastName, String email, String phoneNumber,
			IdTypeDomain identificationType, CityDomain city) {
		super(id);
		setIdNumber(idNumber);
		setFirstName(firstName);
		setSecondName(secondName);
		setLastName(lastName);
		setSecondLastName(secondLastName);
		setEmail(email);
		setPhoneNumber(phoneNumber);
		setIdentificationType(identificationType);
		setCity(city);
		setEmailConfirmed(false);
		setPhoneConfirmed(false);
	}



	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = TextHelper.getDefaultWithTrim(idNumber);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = TextHelper.getDefaultWithTrim(firstName);
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = TextHelper.getDefaultWithTrim(secondName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = TextHelper.getDefaultWithTrim(lastName);
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = TextHelper.getDefaultWithTrim(secondLastName);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = TextHelper.getDefaultWithTrim(email);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = TextHelper.getDefaultWithTrim(phoneNumber);
	}

	public IdTypeDomain getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(IdTypeDomain identificationType) {
		this.identificationType = (ObjectHelper.isNull(identificationType) ? new IdTypeDomain() : identificationType);
	}

	public CityDomain getCity() {
		return city;
	}

	public void setCity(CityDomain city) {
		this.city = (ObjectHelper.isNull(city) ? new CityDomain() : city);
	}

	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public boolean isPhoneConfirmed() {
		return phoneConfirmed;
	}

	public void setPhoneConfirmed(boolean phoneConfirmed) {
		this.phoneConfirmed = phoneConfirmed;
	}
	
}
