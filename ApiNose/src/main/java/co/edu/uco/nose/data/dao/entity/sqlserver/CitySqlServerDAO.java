package co.edu.uco.nose.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.mapper.CityMapper;
import co.edu.uco.nose.data.dao.sql.CitySql;
import co.edu.uco.nose.entity.CityEntity;

public final class CitySqlServerDAO extends SqlConnection implements CityDAO {

	public CitySqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public List<CityEntity> findAll() {
		var cities = new ArrayList<CityEntity>();
		
		try (var preparedStatement = this.getConnection().prepareStatement(CitySql.FIND_ALL)) {
			
			try (var resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					
					var city = CityMapper.map(resultSet);
					cities.add(city);
					
				}
			} catch (final SQLException exception) {
				var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_CITY_FIND_ALL.getContent();
				var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_CITY_FIND_ALL.getContent();
				throw NoseException.create(exception, userMessage, technicalMessage);
			} catch (final Exception exception) {
				var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_CITY_FIND_ALL_UNEXPECTED.getContent();
				var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_CITY_FIND_ALL_UNEXPECTED.getContent();
				throw NoseException.create(exception, userMessage, technicalMessage);
			}
			
		} catch (final SQLException exception) {
			var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_CITY_FIND_ALL.getContent();
			var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_CITY_FIND_ALL.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_CITY_FIND_ALL_UNEXPECTED.getContent();
			var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_CITY_FIND_ALL_UNEXPECTED.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return cities;
	}

	@Override
	public List<CityEntity> findByFilter(final CityEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityEntity findById(final UUID id) {

		var city = new CityEntity();
		
		try (var preparedStatement = this.getConnection().prepareStatement(CitySql.FIND_BY_ID)) {
			preparedStatement.setObject(1, id);
			
			try (var resultSet = preparedStatement.executeQuery()) {
				
				if (resultSet.next()) {
					
					city = CityMapper.map(resultSet);
					
				}
				
			} catch (final SQLException exception) {
				var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_CITY_FIND_BY_ID.getContent();
				var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_CITY_FIND_BY_ID.getContent();
				throw NoseException.create(exception, userMessage, technicalMessage);
			
			} catch (final Exception exception) {
				var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_CITY_FIND_BY_ID.getContent();
				var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_CITY_FIND_BY_ID.getContent();
				throw NoseException.create(exception, userMessage, technicalMessage);
			
			}
			
		} catch (final SQLException exception) {
			var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_CITY_FIND_BY_ID.getContent();
			var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_CITY_FIND_BY_ID.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.USER_ERROR_CITY_FIND_BY_ID.getContent();
			var technicalMessage = co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum.TECHNICAL_ERROR_CITY_FIND_BY_ID.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return city;
	}

}