package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CountryEntity extends Entity {
	private String name;
	
	public CountryEntity() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
	}
	
	public CountryEntity(UUID id) {
		super(id);
		setName(TextHelper.getDefault());
	}
	
	public CountryEntity(UUID id, final String name) {
		super(id);
		setName(name);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
	
}
