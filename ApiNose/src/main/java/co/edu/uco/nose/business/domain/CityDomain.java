package co.edu.uco.nose.business.domain;

import java.util.UUID;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CityDomain extends Domain{
	private String name;
	private StateDomain state;
	
	public CityDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setState(new StateDomain());
	}
	
	public CityDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setState(new StateDomain());
	}
	
	public CityDomain(final UUID id, final String name, final StateDomain state) {
		super(id);
		setName(name);
		setState(state);
	} 
	
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public StateDomain getState() {
		return state;
	}

	public void setState(final StateDomain state) {
		this.state = (state == null) ? new StateDomain() : state;
	}

}
