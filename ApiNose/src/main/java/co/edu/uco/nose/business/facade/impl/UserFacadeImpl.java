package co.edu.uco.nose.business.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.business.assembler.dto.impl.UserDTOAssembler;
import co.edu.uco.nose.business.business.impl.UserBusinessImpl;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.business.facade.UserFacade;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.data.dao.factory.DAOFactory;
import co.edu.uco.nose.dto.UserDTO;

public final class UserFacadeImpl implements UserFacade {
	
	private DAOFactory daoFactory;
	
	public UserFacadeImpl() {
		this.daoFactory = daoFactory.getFactory();
	}

	@Override
	public void registerNewUserInformation(final UserDTO userDTO) {
		
		
		var daoFactory = DAOFactory.getFactory();
		var business = new UserBusinessImpl(daoFactory);
		
		try {
			
			daoFactory.initTransaction();
			
			var domain = UserDTOAssembler.getUserDTOAssembler().toDomain(userDTO);
			business.registerNewUserInformation(domain);
			
			daoFactory.commitTransaction();
		} catch(final NoseException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch(final Exception exception) {
			daoFactory.rollbackTransaction();
			
			var userMessage = "Se ha presentado un problema inesperado al registrar la información del nuevo usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema.";
			var technicalMessage = "Se ha presentado un problema inesperado al registrar la información del nuevo usuario. Por favor revise el log de errores para mayor detalle del problema.";
			throw NoseException.create(exception, userMessage, technicalMessage);
			
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void dropUserInformation(UUID id) {
		var daoFactory = DAOFactory.getFactory();
		var business = new UserBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			
			business.dropUserInformation(id);
			
			daoFactory.commitTransaction();
		} catch(final NoseException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch(final Exception exception) {
			daoFactory.rollbackTransaction();
			
			var userMessage = "Se ha presentado un problema inesperado al eliminar la información del usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema.";
			var technicalMessage = "Se ha presentado un problema inesperado al eliminar la información del usuario. Por favor revise el log de errores para mayor detalle del problema.";
			throw NoseException.create(exception, userMessage, technicalMessage);
			
		} finally {
			daoFactory.closeConnection();
		}
		
	}

	@Override
	public void updateUserInformation(final UUID id, final UserDTO userDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserDTO> findAllUsers() {
		return findUsersByFilter(new UserDTO());
	}

	@Override
	public List<UserDTO> findUsersByFilter(final UserDTO userFilters) {
		var daoFactory = DAOFactory.getFactory();
		var business = new UserBusinessImpl(daoFactory);
		
		try {
			var domainFilters = UserDTOAssembler.getUserDTOAssembler().toDomain(userFilters);
			var domainList = business.findUsersByFilter(domainFilters);
			
			var dtoList = UserDTOAssembler.getUserDTOAssembler().toDTO(domainList);
			return dtoList;
		} catch (final NoseException exception) {
			throw exception;
		} catch (final Exception exception) {
			var userMessage = "Se ha presentado un problema inesperado al consultar la información de los usuarios. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema.";
			var technicalMessage = "Se ha presentado un problema inesperado al consultar la información de los usuarios. Por favor revise el log de errores para mayor detalle del problema.";
			throw NoseException.create(exception, userMessage, technicalMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public UserDTO findSpecificUser(final UUID id) {
		return findUsersByFilter(new UserDTO(id)).stream().findFirst().orElse(new UserDTO());
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
