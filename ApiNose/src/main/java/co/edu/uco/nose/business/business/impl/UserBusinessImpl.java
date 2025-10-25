package co.edu.uco.nose.business.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.business.assembler.dto.impl.UserDTOAssembler;
import co.edu.uco.nose.business.assembler.entity.impl.UserEntityAssembler;
import co.edu.uco.nose.business.business.UserBusiness;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.data.dao.factory.DAOFactory;

public final class UserBusinessImpl implements UserBusiness {
	
	private DAOFactory daoFactory;
	
	public UserBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registerNewUserInformation(final UserDomain userDomain) {
		// 1. Validar que la informacion sea consistente a nivel de tipo de dato, longitud, obligatoriedad, formato, rango, reglas propias del objeto
		// 2. Validar que no exista previamente otro usuario con el mismo tipo y numero de identificacion
		// 3. Validar que no exista previamente otro usuario con el mismo correo electronico
		// 4. Validar que no exista previamente otro usuario con el mismo numero de telefono celular
		// 5. Generar un identificador para el nuevo usuario, asegurando que no exista

		var id = UUIDHelper.getUUIDHelper().generateNewUUID();
		var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);
		userEntity.setId(id);
		// 6. Registrar la informacion del nuevo usuario
		daoFactory.getUserDAO().create(userEntity);
		
	}

	@Override
	public void dropUserInformation(final UUID id) {
		daoFactory.getUserDAO().delete(id);
		
	}

	@Override
	public void updateUserInformation(final UUID id, final UserDomain userDomain) {
		// TODO
		var user = daoFactory.getUserDAO().findById(id);
		
		daoFactory.getUserDAO().update(user);
		
	}

	@Override
	public List<UserDomain> findAllUsers() {
		return findUsersByFilter(new UserDomain());
	}

	@Override
	public List<UserDomain> findUsersByFilter(final UserDomain userFilters) {
		var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userFilters);
		var userEntityList = daoFactory.getUserDAO().findByFilter(userEntity);
		var userDomainList = new ArrayList<UserDomain>();
		
		for (var user : userEntityList) {
			userDomainList.add(UserEntityAssembler.getUserEntityAssembler().toDomain(user));
		}
		
		return userDomainList;
	}

	@Override
	public UserDomain findSpecificUser(final UUID id) {
		return findUsersByFilter(new UserDomain(id)).stream().findFirst().orElse(new UserDomain());
	}

	@Override
	public void confirmMobileNumber(final UUID id, final int confirmationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmEmail(final UUID id, final int confirmationCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMobileNumberConfirmation(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendEmailConfirmation(final UUID id) {
		// TODO Auto-generated method stub
		
	}
	
}
