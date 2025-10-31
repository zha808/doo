package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class UserEntity {
	
	private UUID id;
	private String idNumber;
	private String firstName;
	private String secondName;
	private String lastName;
	private String secondLastName;
	private String email;
	private String phoneNumber;
	private IdTypeEntity identificationType;
	private CityEntity city;
	private boolean emailConfirmed;
	private boolean emailConfirmedIsDefaultvalue;
	private boolean phoneConfirmed;
	private boolean phoneConfirmedIsDefaultvalue;
	
	public UserEntity() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setIdNumber(TextHelper.getDefault());
		setFirstName(TextHelper.getDefault());
		setSecondName(TextHelper.getDefault());
		setLastName(TextHelper.getDefault());
		setSecondLastName(TextHelper.getDefault());
		setEmail(TextHelper.getDefault());
		setPhoneNumber(TextHelper.getDefault());
		setIdentificationType(new IdTypeEntity());
		setCity(new CityEntity());
		setEmailConfirmed(false);
		setEmailConfirmedIsDefaultvalue(true);
		setPhoneConfirmed(false);
		setPhoneConfirmedIsDefaultvalue(true);
	}
	
	public UserEntity(UUID id) {
		setId(id);
		setIdNumber(TextHelper.getDefault());
		setFirstName(TextHelper.getDefault());
		setSecondName(TextHelper.getDefault());
		setLastName(TextHelper.getDefault());
		setSecondLastName(TextHelper.getDefault());
		setEmail(TextHelper.getDefault());
		setPhoneNumber(TextHelper.getDefault());
		setIdentificationType(new IdTypeEntity());
		setCity(new CityEntity());
		setEmailConfirmed(false);
		setEmailConfirmedIsDefaultvalue(true);
		setPhoneConfirmed(false);
		setPhoneConfirmedIsDefaultvalue(true);
	}
	
	public UserEntity(UUID id, String idNumber, String firstName, String secondName, String lastName, String secondLastName, String email, String phoneNumber,
			IdTypeEntity identificationType, CityEntity city, boolean emailConfirmed, boolean phoneConfirmed) {
		setId(id);
		setIdNumber(idNumber);
		setFirstName(firstName);
		setSecondName(secondName);
		setLastName(lastName);
		setSecondLastName(secondLastName);
		setEmail(email);
		setPhoneNumber(phoneNumber);
		setIdentificationType(identificationType);
		setCity(city);
		setEmailConfirmed(emailConfirmed);
		setEmailConfirmedIsDefaultvalue(false);
		setPhoneConfirmed(phoneConfirmed);
		setPhoneConfirmedIsDefaultvalue(false);
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
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

	public void setSecondLastName(final String secondLastName) {
		this.secondLastName = TextHelper.getDefaultWithTrim(secondLastName);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = TextHelper.getDefaultWithTrim(email);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = TextHelper.getDefaultWithTrim(phoneNumber);
	}

	public IdTypeEntity getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(final IdTypeEntity identificationType) {
		this.identificationType = (ObjectHelper.isNull(identificationType) ? new IdTypeEntity() : identificationType);
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(final CityEntity city) {
		this.city = (ObjectHelper.isNull(city) ? new CityEntity() : city);
	}

	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}

	public void setEmailConfirmed(final boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
		setEmailConfirmedIsDefaultvalue(false);
	}
	
	public boolean isEmailConfirmedIsDefaultvalue() {
		return emailConfirmedIsDefaultvalue;
	}
	
	private void setEmailConfirmedIsDefaultvalue(final boolean emailConfirmedIsDefaultvalue) {
		this.emailConfirmedIsDefaultvalue = emailConfirmedIsDefaultvalue;
	}

	public boolean isPhoneConfirmed() {
		return phoneConfirmed;
	}

	public void setPhoneConfirmed(final boolean phoneConfirmed) {
		this.phoneConfirmed = phoneConfirmed;
		setPhoneConfirmedIsDefaultvalue(false);
	}
	
	public boolean isPhoneConfirmedIsDefaultvalue() {
		return phoneConfirmedIsDefaultvalue;
	}
	
	private void setPhoneConfirmedIsDefaultvalue(final boolean phoneConfirmedIsDefaultvalue) {
		this.phoneConfirmedIsDefaultvalue = phoneConfirmedIsDefaultvalue;
	}

}
