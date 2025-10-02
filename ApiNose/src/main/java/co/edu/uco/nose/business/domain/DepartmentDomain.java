package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class DepartmentDomain extends Domain {
	private String name;
	private CountryDomain country;
	
	public DepartmentDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setCountry(new CountryDomain());
	}
	
	public DepartmentDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setCountry(new CountryDomain());
	}
	
	public DepartmentDomain(final UUID id, final String name, final CountryDomain country) {
		super(id);
		setName(name);
		setCountry(country);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public CountryDomain getCountry() {
		return country;
	}

	public void setCountry(final CountryDomain country) {
		this.country = (country == null) ? new CountryDomain() : country;
	}

	
}
