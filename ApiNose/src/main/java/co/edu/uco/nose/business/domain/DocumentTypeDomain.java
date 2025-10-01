package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class DocumentTypeDomain extends Domain {
	private String name;
	
	public DocumentTypeDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
	}
	
	public DocumentTypeDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
	}
	
	public DocumentTypeDomain(final UUID id, final String name) {
		super(id);
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
	
 }
