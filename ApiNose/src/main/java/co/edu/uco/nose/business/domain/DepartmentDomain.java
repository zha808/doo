package co.edu.uco.nose.business.domain;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class DepartmentDomain extends Domain {
	private String name;
	private CountryDomain country;
	
	public DepartmentDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setCountry(ObjectHelper.getDefault(null, null));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public CountryDomain getCountry() {
		return country;
	}

	public void setCountry(final CountryDomain country) {
		this.country = country;
	}

	
}
