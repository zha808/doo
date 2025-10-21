package co.edu.uco.nose.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.data.dao.entity.IdTypeDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.mapper.IdTypeMapper;
import co.edu.uco.nose.data.dao.entity.sql.IdTypeSql;
import co.edu.uco.nose.entity.IdTypeEntity;

public final class IdTypeSqlServerDAO extends SqlConnection implements IdTypeDAO {

	public IdTypeSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public List<IdTypeEntity> findAll() {
		return findByFilter(new IdTypeEntity());
	}

	@Override
	public List<IdTypeEntity> findByFilter(final IdTypeEntity filterEntity) {
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
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
	}

	@Override
	public IdTypeEntity findById(final UUID id) {
		return findByFilter(new IdTypeEntity(id)).stream().findFirst().orElse(new IdTypeEntity());
	}
	

	private String createSentenceFindByFilter(final IdTypeEntity filterEntity, final List<Object> parameterList) {
		
		var sql = new StringBuilder(IdTypeSql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final IdTypeEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new IdTypeEntity());
		
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"i.id = ?", filterEntityValidated.getId());		

		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
				"i.nombre= ?", filterEntityValidated.getName());
		
		
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
	
	private List<IdTypeEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listIdType = new ArrayList<IdTypeEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listIdType.add(IdTypeMapper.map(resultSet));
			}
		} catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return listIdType;
	}


}