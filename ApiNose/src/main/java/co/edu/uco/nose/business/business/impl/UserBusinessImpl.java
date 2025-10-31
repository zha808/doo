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
		
		var userFilter = new UserDomain(userDomain.getId());
		var userUUID = findUsersByFilter(userFilter);
		while (userExists(userDomain.getId())) {
			userDomain.setId(UUIDHelper.getUUIDHelper().generateNewUUID());
		}
		
		userFilter = new UserDomain();
		userFilter.setIdentificationType(userDomain.getIdentificationType());
		userFilter.setIdNumber(userDomain.getIdNumber());
		
		if (!findUsersByFilter(userFilter).isEmpty()) {
			throw new IllegalArgumentException("Ya existe otro usuario con el mismo tipo y numero de identificacion");
		}
		
		userFilter = new UserDomain();
		userFilter.setEmail(userDomain.getEmail());
		if (!findUsersByFilter(userFilter).isEmpty()) {
			throw new IllegalArgumentException("Ya existe otro usuario con el mismo correo electronico");
		}
		
		userFilter = new UserDomain();
		userFilter.setPhoneNumber(userDomain.getPhoneNumber());
		if (!findUsersByFilter(userFilter).isEmpty()) {
			throw new IllegalArgumentException("Ya existe otro usuario con el mismo numero de telefono celular");
		}

		var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);
		userEntity.setId(userDomain.getId());
		daoFactory.getUserDAO().create(userEntity);
		
	}

	@Override
	public void dropUserInformation(final UUID id) {
		daoFactory.getUserDAO().delete(id);
		
	}

	@Override
	public void updateUserInformation(final UUID id, final UserDomain userDomain) {
		var user = daoFactory.getUserDAO().findById(id);
		daoFactory.getUserDAO().update(user);
	}

	@Override
	public List<UserDomain> findAllUsers() {
		var userEntityList = daoFactory.getUserDAO().findAll();
		var userDomainList = new ArrayList<UserDomain>();
		for (var userEntity : userEntityList) {
			userDomainList.add(UserEntityAssembler.getUserEntityAssembler().toDomain(userEntity));
		}
		return userDomainList;
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
		var userEntity = daoFactory.getUserDAO().findById(id);
		return UserEntityAssembler.getUserEntityAssembler().toDomain(userEntity);
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
	
	public boolean userExists(final UUID id) {
		var userFilter = new UserDomain(id);
		var userList = findUsersByFilter(userFilter);
		return !userList.isEmpty();
	}
	
}
