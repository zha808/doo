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
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.mapper.CountryMapper;
import co.edu.uco.nose.data.dao.entity.sql.CountrySql;
import co.edu.uco.nose.entity.CountryEntity;

public final class CountrySqlServerDAO extends SqlConnection implements CountryDAO {
	
	public CountrySqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public List<CountryEntity> findAll() {
		
		return findByFilter(new CountryEntity());
	}

	@Override
	public List<CountryEntity> findByFilter(CountryEntity filterEntity) {
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
	public CountryEntity findById(final UUID id) {
		return findByFilter(new CountryEntity(id)).stream().findFirst().orElse(new CountryEntity());
	}
	
	private String createSentenceFindByFilter(final CountryEntity filterEntity, final List<Object> parameterList) {
		
		var sql = new StringBuilder(CountrySql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final CountryEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new CountryEntity());
		
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"c.id = ?", filterEntityValidated.getId());		

		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
				"c.nombre= ?", filterEntityValidated.getName());
		
		
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
	
	private List<CountryEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listCountry = new ArrayList<CountryEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listCountry.add(CountryMapper.map(resultSet));
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
		
		return listCountry;
	}

}
