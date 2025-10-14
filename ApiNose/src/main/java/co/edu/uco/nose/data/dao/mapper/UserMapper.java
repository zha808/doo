package co.edu.uco.nose.data.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.CityEntity;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.IdTypeEntity;
import co.edu.uco.nose.entity.StateEntity;
import co.edu.uco.nose.entity.UserEntity;

public class UserMapper {
	
	public UserEntity map(ResultSet resultSet) throws SQLException {
		
		var idType = new IdTypeEntity();
		idType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idTipoIdentificacion")));
		idType.setName(resultSet.getString("nombreTipoIdentificacion"));
		
		var country = new CountryEntity();
		country.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idPaisDepartamentoCiudadResidencia")));
		country.setName(resultSet.getString("nombrePaisDepartamentoCiudadResidencia"));
		
		var state = new StateEntity();
		state.setCountry(country);
		state.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idDepartamentoCiudadResidencia")));
		state.setName(resultSet.getString("nombreDepartamentoCiudadResidencia"));
		
		var city = new CityEntity();
		city.setDepartment(state);
		city.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idCiudadResidencia")));
		city.setName(resultSet.getString("nombreCiudadResidencia"));
		
		var user = new UserEntity();
		user.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("id")));
		user.setIdentificationType(idType);
		user.setFirstName(resultSet.getString("primerNombre"));
		user.setSecondName(resultSet.getString("segundoNombre"));
		user.setLastName(resultSet.getString("primerApellido"));
		user.setSecondLastName(resultSet.getString("segundoApellido"));
		user.setCity(city);
		user.setEmail(resultSet.getString("correoElectronico"));
		user.setPhoneNumber(resultSet.getString("numeroTelefonoMovil"));
		user.setPhoneConfirmed(resultSet.getBoolean("numeroTelefonoMovilConfirmado"));
		user.setEmailConfirmed(resultSet.getBoolean("correoElectronicoConfirmado"));
		
		return user;
	}
}
