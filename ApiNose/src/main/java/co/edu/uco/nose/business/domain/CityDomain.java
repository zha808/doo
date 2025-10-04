package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CityDomain extends Domain{
	private String name;
	private StateDomain department;
	
	public CityDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDepartment(new StateDomain());
	}
	
	public CityDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setDepartment(new StateDomain());
	}
	
	
	public CityDomain(final UUID id, final String name, final StateDomain country) {
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

	public StateDomain getDepartment() {
		return department;
	}

	public void setDepartment(final StateDomain department) {
		this.department = (department == null) ? new StateDomain() : department;
	}

}
