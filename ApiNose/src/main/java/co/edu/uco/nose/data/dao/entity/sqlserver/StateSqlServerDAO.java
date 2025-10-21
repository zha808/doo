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
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.data.dao.entity.mapper.StateMapper;
import co.edu.uco.nose.data.dao.entity.sql.StateSql;
import co.edu.uco.nose.entity.StateEntity;

public final class StateSqlServerDAO extends SqlConnection implements StateDAO{

	public StateSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public List<StateEntity> findAll() {
		return findByFilter(new StateEntity());
	}

	@Override
	public List<StateEntity> findByFilter(StateEntity filterEntity) {
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
	public StateEntity findById(final UUID id) {
		return findByFilter(new StateEntity(id)).stream().findFirst().orElse(new StateEntity());
	}
	

	private String createSentenceFindByFilter(final StateEntity filterEntity, final List<Object> parameterList) {
		
		var sql = new StringBuilder(StateSql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final StateEntity  filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new StateEntity ());
		
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"e.id = ?", filterEntityValidated.getId());		

		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
				"e.nombre= ?", filterEntityValidated.getName());
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getCountry().getId()),
				"e.pais = ?", filterEntityValidated.getCountry().getId());		
		
		
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
	
	private List<StateEntity > executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listState = new ArrayList<StateEntity >();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listState.add(StateMapper.map(resultSet));
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
		
		return listState;
	}

}