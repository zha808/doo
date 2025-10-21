package co.edu.uco.nose.test;

import co.edu.uco.nose.business.facade.impl.UserFacadeImpl;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.CityDTO;
import co.edu.uco.nose.dto.CountryDTO;
import co.edu.uco.nose.dto.IdTypeDTO;
import co.edu.uco.nose.dto.StateDTO;
import co.edu.uco.nose.dto.UserDTO;

public class TestUserRegistration {
	public static void main(String[] args) {
		
		try {
			var idType = new IdTypeDTO();
			idType.setId(UUIDHelper.getUUIDHelper().getFromString("86ef14dd-4160-4cd5-9339-56366ecfb14a"));
			//idType.setId(UUIDHelper.getUUIDHelper().generateNewUUID());
			idType.setName("Cédula de ciudadanía");
			
			var country = new CountryDTO();
			country.setId(UUIDHelper.getUUIDHelper().getFromString("86ef14dd-4160-4cd5-9339-56366ecfb1bd"));
			//country.setId(UUIDHelper.getUUIDHelper().generateNewUUID());
			country.setName("Colombia");
			
			var state = new StateDTO();
			state.setId(UUIDHelper.getUUIDHelper().getFromString("86ef14dd-4160-4cd5-9339-56366ecfb1bc"));
			//state.setId(UUIDHelper.getUUIDHelper().generateNewUUID());
			state.setName("Cundinamarca");
			state.setCountry(country);
			
			var city = new CityDTO();
			city.setId(UUIDHelper.getUUIDHelper().getFromString("86ef14dd-4160-4cd5-9339-56366ecfb1b5"));
			//city.setId(UUIDHelper.getUUIDHelper().generateNewUUID());
			city.setName("Bogotá");
			city.setState(state);
			
			var user = new UserDTO();
			//user.setId(UUIDHelper.getUUIDHelper().generateNewUUID());
			user.setIdNumber("111111111");
			user.setFirstName("Juan");
			user.setSecondName("Carlos");
			user.setLastName("Pérez");
			user.setSecondLastName("Gómez");
			user.setEmail("danilo");
			user.setPhoneNumber("3001234567");
			user.setIdentificationType(idType);
			user.setCity(city);
			user.setEmailConfirmed(false);
			user.setPhoneConfirmed(false);
						
			// Colocar todos los parametros, menos el id
			
			var facade = new UserFacadeImpl();
			facade.registerNewUserInformation(user);
			
			
			System.out.println("Gane el semestre");
		} catch (NoseException e) {
			System.err.println(e.getUserMessage());
			System.err.println(e.getTechnicalMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
