package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;


public final class CityEntity extends Entity {
	private String name;
	private StateEntity department;
	
	public CityEntity() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDepartment(new StateEntity());
	}
	
	public CityEntity(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setDepartment(new StateEntity());
	}

	
	public CityEntity(final UUID id, final String name, final StateEntity country) {
		super(id);
		setName(name);
		setDepartment(country);
	} 
	
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public StateEntity getDepartment() {
		return department;
	}

	public void setDepartment(final StateEntity department) {
		this.department = (department == null) ? new StateEntity() : department;
	}
	
}
