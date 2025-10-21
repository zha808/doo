package co.edu.uco.nose.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.StateEntity;

public final class StateMapper {
	
	public static StateEntity map(final ResultSet resultSet) {
		var state = new StateEntity();
		try {
			var country = CountryMapper.map(resultSet);
			
			state.setCountry(country);
			state.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idDepartamentoCiudadResidencia")));
			state.setName(resultSet.getString("nombreDepartamentoCiudadResidencia"));
		} catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		return state;
		
	}

}
