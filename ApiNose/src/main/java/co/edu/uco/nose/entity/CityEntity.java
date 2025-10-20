package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;


public final class CityEntity {
	private UUID id;
	private String name;
	private StateEntity department;
	
	public CityEntity() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setState(new StateEntity());
	}
	
	public CityEntity(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setState(new StateEntity());
	}

	
	public CityEntity(final UUID id, final String name, final StateEntity country) {
		setId(id);
		setName(name);
		setState(country);
	} 
	
	public UUID getId() {
		return id;
	}
	
	public void setId(final UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public StateEntity getState() {
		return department;
	}

	public void setState(final StateEntity department) {
		this.department = (department == null) ? new StateEntity() : department;
	}
	
}
