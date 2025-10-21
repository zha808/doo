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
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.mapper.CityMapper;
import co.edu.uco.nose.data.dao.entity.sql.CitySql;
import co.edu.uco.nose.entity.CityEntity;

public final class CitySqlServerDAO extends SqlConnection implements CityDAO {

	public CitySqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public List<CityEntity> findAll() {
		return findByFilter(new CityEntity()); 
	}

	@Override
	public List<CityEntity> findByFilter(final CityEntity filterEntity) {
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
	public CityEntity findById(final UUID id) {

		return findByFilter(new CityEntity(id)).stream().findFirst().orElse(new CityEntity());
	}

	
	private String createSentenceFindByFilter(final CityEntity filterEntity, final List<Object> parameterList) {
		
		var sql = new StringBuilder(CitySql.FIND_BY_FILTER);

		createWhereClauseFindByFilter(sql, parameterList, filterEntity);
		
		return sql.toString();
	}
	
	private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parameterList, final CityEntity filterEntity) {
		
		var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new CityEntity());
		
		final var conditions = new ArrayList<String>();
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
				"c.id = ?", filterEntityValidated.getId());		

		addCondition(conditions, parameterList, !TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
				"c.nombre= ?", filterEntityValidated.getName());
		
		addCondition(conditions, parameterList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getState().getId()),
				"c.departamento = ?", filterEntityValidated.getState().getId());	
		
		
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
	
	private List<CityEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
		var listCity = new ArrayList<CityEntity>();
		
		try (var resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				listCity.add(CityMapper.map(resultSet));
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
		
		return listCity;
	}

}
