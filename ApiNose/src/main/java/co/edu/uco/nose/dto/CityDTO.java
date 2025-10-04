package co.edu.uco.nose.dto;

import java.util.UUID;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public class CityDTO {
	private UUID id;
	private String name;
	private StateDTO state;
	
	public CityDTO() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setState(new StateDTO());
	}
	
	public CityDTO(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setState(new StateDTO());
	}
	
	public CityDTO(final UUID id, final String name, final StateDTO state) {
		setId(id);
		setName(name);
		setState(state);
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(final UUID id) {
		this.id = UUIDHelper.getUUIDHelper() .getDefault(id);;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
	public StateDTO getState() {
		return state;
	}
	
	public void setState(final StateDTO state) {
		this.state = state == null ? new StateDTO() : state;
	}

}
