package co.edu.uco.nose.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.data.dao.mapper.StateMapper;
import co.edu.uco.nose.data.dao.sql.StateSql;
import co.edu.uco.nose.entity.StateEntity;

public final class StateSqlServerDAO extends SqlConnection implements StateDAO{

	public StateSqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public List<StateEntity> findAll() {
		var states = new ArrayList<StateEntity>();
		
		try (var preparedStatement = this.getConnection().prepareStatement(StateSql.FIND_ALL)) {
			
			try (var resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					
					var state = StateMapper.map(resultSet);
					states.add(state);
					
				}
			} catch (final SQLException exception) {
				var userMessage = "Ocurrió un problema al ejecutar la consulta de estados";
				var technicalMessage = "Error SQL ejecutando el query en .";
				throw NoseException.create(exception, userMessage, technicalMessage);
			} catch (final Exception exception) {
				var userMessage = "Ocurrió un problema INESPERADO al ejecutar la consulta de ";
				var technicalMessage = "Error INESPERADO SQL ejecutando el query en .";
				throw NoseException.create(exception, userMessage, technicalMessage);
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
		
		return states;
	}

	@Override
	public List<StateEntity> findByFilter(StateEntity filterEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateEntity findById(final UUID id) {
		var state = new StateEntity();
		
		try (var preparedStatement = this.getConnection().prepareStatement(StateSql.FIND_BY_ID)) {
			preparedStatement.setObject(1, id);
			
			try (var resultSet = preparedStatement.executeQuery()) {
				
				if (resultSet.next()) {
					
					state = StateMapper.map(resultSet);
					
				}
				
			} catch (final SQLException exception) {
				
				var userMessage = "Ocurrió un problema al ejecutar la consulta de estado";
				var technicalMessage = "Error SQL ejecutando el query en .";
				throw NoseException.create(exception, userMessage, technicalMessage);
				
			} catch (final Exception exception) {
				
				var userMessage = "Ocurrió un problema INESPERADO al ejecutar la consulta de estado";
				var technicalMessage = "Error INESPERADO SQL ejecutando el query en ";
				throw NoseException.create(exception, userMessage, technicalMessage);
				
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
		
		return state;
	}

}
