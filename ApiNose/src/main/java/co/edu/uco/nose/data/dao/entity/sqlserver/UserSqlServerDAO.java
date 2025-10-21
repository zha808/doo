package co.edu.uco.nose.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.data.dao.entity.mapper.UserMapper;
import co.edu.uco.nose.data.dao.entity.sql.UserSql;
import co.edu.uco.nose.entity.UserEntity;

public final class UserSqlServerDAO extends SqlConnection implements UserDAO {

	
	public UserSqlServerDAO(final Connection connection) {
		super(connection);
	}
	
	
	@Override
	public void create(final UserEntity entity) {
		
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = this.getConnection().prepareStatement(UserSql.CREATE)) {
			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setObject(2, entity.getIdentificationType().getId());
			preparedStatement.setString(3, entity.getIdNumber());
			preparedStatement.setString(4, entity.getFirstName());
			preparedStatement.setString(5, entity.getSecondName());
			preparedStatement.setString(6, entity.getLastName());
			preparedStatement.setString(7, entity.getSecondLastName());
			preparedStatement.setObject(8, entity.getCity().getId());
			preparedStatement.setString(9, entity.getEmail());
			preparedStatement.setString(10, entity.getPhoneNumber());
			preparedStatement.setBoolean(11, entity.isEmailConfirmed());
			preparedStatement.setBoolean(12, entity.isPhoneConfirmed());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_USER_CREATE.getContent();
			var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_USER_CREATE.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_USER_CREATE_UNEXPECTED.getContent();
			var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_USER_CREATE_UNEXPECTED.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public List<UserEntity> findAll() {
		
		return findByFilter(new UserEntity());
	}

	@Override
	public List<UserEntity> findByFilter(UserEntity filterEntity) {
		
		var parameterList = new ArrayList<Object>();
		var sql = createSentenceFindByFilter(filterEntity, parameterList);

		try (var preparedStatement = this.getConnection().prepareStatement(sql)) {            		
			
			for (var index = 0; index < parameterList.size(); index++) {
				preparedStatement.setObject(index + 1, parameterList.get(index));
			}
			
			return executeSentenceFindByFilter(preparedStatement);
			
		} catch (final NoseException exception) {
			throw exception;
		} catch (final SQLException exception) {
			var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_USER_FIND_ALL.getContent();
			var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_USER_FIND_ALL.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_USER_FIND_ALL_UNEXPECTED.getContent();
			var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_USER_FIND_ALL.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public UserEntity findById(final UUID id) {
		
		return findByFilter(new UserEntity(id)).stream().findFirst().orElse((new UserEntity()));

	}

	@Override
	public void update(final UserEntity entity) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = this.getConnection().prepareStatement(UserSql.UPDATE)) {
			preparedStatement.setObject(1, entity.getId());
			preparedStatement.setObject(2, entity.getIdentificationType().getId());
			preparedStatement.setString(3, entity.getIdNumber());
			preparedStatement.setString(4, entity.getFirstName());
			preparedStatement.setString(5, entity.getSecondName());
			preparedStatement.setString(6, entity.getLastName());
			preparedStatement.setString(7, entity.getSecondLastName());
			preparedStatement.setObject(8, entity.getCity().getId());
			preparedStatement.setString(9, entity.getEmail());
			preparedStatement.setString(10, entity.getPhoneNumber());
			preparedStatement.setBoolean(11, entity.isEmailConfirmed());
			preparedStatement.setBoolean(11, entity.isPhoneConfirmed());
			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_USER_UPDATE.getContent();
			var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_USER_UPDATE.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_USER_UPDATE.getContent();
			var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_USER_UPDATE.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
	}

	@Override
	public void delete(final UUID id) {
		SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
		
		try (var preparedStatement = this.getConnection().prepareStatement(UserSql.DELETE)) {
			
			preparedStatement.setObject(1, id);			
			preparedStatement.executeUpdate();
			
		} catch (final SQLException exception) {
			var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_USER_DELETE.getContent();
			var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_USER_DELETE.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_USER_DELETE.getContent();
			var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_USER_DELETE.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
	}
	
	private String createSentenceFindByFilter(final UserEntity filterEntity, final List<Object> parameterList) {
		
		var sql = new StringBuilder(UserSql.FIND_BY_FILTER);
		
		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final UserEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new UserEntity());
		
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"u.id = ?", filterEntityValidated.getId());		
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getIdentificationType().getId()),
				"u.tipoIdentificacion = ?", filterEntityValidated.getIdNumber());
		
		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getFirstName()),
				"u.primerNombre = ?", filterEntityValidated.getFirstName());
		
		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getSecondName()),
				"u.segundoNombre = ?", filterEntityValidated.getSecondName());
		
		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getLastName()),
				"u.primerApellido = ?", filterEntityValidated.getLastName());
		
		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getSecondLastName()),
				"u.segundoApellido = ?", filterEntityValidated.getSecondLastName());
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getCity().getId()),
				"u.ciudadResidencia = ?", filterEntityValidated.getCity().getId());
		
		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getEmail()),
				"u.correoElectronico = ?", filterEntityValidated.getEmail());
		
		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getPhoneNumber()),
				"u.numeroTelefonoMovil = ?", filterEntityValidated.getPhoneNumber());
		
		addCondition(conditions, parameterList, !filterEntityValidated.isEmailConfirmed(),
				"u.correoElectronicoConfirmado = ?", filterEntityValidated.isEmailConfirmed());
		
		addCondition(conditions, parameterList, !filterEntityValidated.isPhoneConfirmed(),
				"u.numeroTelefonoMovilConfirmado = ?", filterEntityValidated.isPhoneConfirmed());
		
		if (!conditions.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(String.join(" AND ", conditions));
		}
	}
	
	private void addCondition(final List<String> conditions, final List<Object> parameterList,
			final boolean condition, final String clause, final Object value) {
		if (condition) {
			conditions.add(clause);
			parameterList.add(value);
		}
	}
	
	private List<UserEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listUser = new ArrayList<UserEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listUser.add(UserMapper.map(resultSet));
			}
		} catch (final SQLException exception) {
			var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_USER_FIND_ALL.getContent();
			var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_USER_FIND_ALL.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return listUser;
	}
}