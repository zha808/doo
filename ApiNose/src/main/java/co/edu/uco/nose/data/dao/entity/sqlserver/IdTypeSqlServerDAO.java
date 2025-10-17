package co.edu.uco.nose.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.data.dao.entity.IdTypeDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.mapper.IdTypeMapper;
import co.edu.uco.nose.data.dao.sql.IdTypeSql;
import co.edu.uco.nose.entity.IdTypeEntity;

public final class IdTypeSqlServerDAO extends SqlConnection implements IdTypeDAO {

	public IdTypeSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public List<IdTypeEntity> findAll() {
		var idTypes = new ArrayList<IdTypeEntity>();
		
		try (var preparedStatement = this.getConnection().prepareStatement(IdTypeSql.FIND_ALL)) {
			
			try (var resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					
					var idType = IdTypeMapper.map(resultSet);
					idTypes.add(idType);
					
				}
			} catch (final SQLException exception) {
				var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_IDTYPE_FIND_ALL.getContent();
				var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_IDTYPE_FIND_ALL.getContent();
				throw NoseException.create(exception, userMessage, technicalMessage);
			} catch (final Exception exception) {
				var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_IDTYPE_FIND_ALL_UNEXPECTED.getContent();
				var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_IDTYPE_FIND_ALL_UNEXPECTED.getContent();
				throw NoseException.create(exception, userMessage, technicalMessage);
			}
			
		} catch (final SQLException exception) {
			var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_IDTYPE_FIND_ALL.getContent();
			var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_IDTYPE_FIND_ALL.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_IDTYPE_FIND_ALL_UNEXPECTED.getContent();
			var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_IDTYPE_FIND_ALL_UNEXPECTED.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return idTypes;
	}

	@Override
	public List<IdTypeEntity> findByFilter(final IdTypeEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdTypeEntity findById(final UUID id) {
		var idType = new IdTypeEntity();
		
		try (var preparedStatement = this.getConnection().prepareStatement(IdTypeSql.FIND_BY_ID)) {
			preparedStatement.setObject(1, id);
			
			try (var resultSet = preparedStatement.executeQuery()) {
				
				if (resultSet.next()) {
					
					idType = IdTypeMapper.map(resultSet);
					
				}
				
			} catch (final SQLException exception) {
				String userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_IDTYPE_FIND_BY_ID.getContent();
				String technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_IDTYPE_FIND_BY_ID.getContent();
				throw NoseException.create(exception, userMessage, technicalMessage);
				
			} catch (final Exception exception) {
				String userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_IDTYPE_FIND_BY_ID.getContent();
				String technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_IDTYPE_FIND_BY_ID.getContent();
				throw NoseException.create(exception, userMessage, technicalMessage);
			
			}
			
		} catch (final SQLException exception) {
			String userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_IDTYPE_FIND_BY_ID.getContent();
			String technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_IDTYPE_FIND_BY_ID.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			String userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_IDTYPE_FIND_BY_ID.getContent();
			String technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_IDTYPE_FIND_BY_ID.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return idType;
	}


}