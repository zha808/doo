package co.edu.uco.nose.data.dao.factory.sqlserver;

import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.IdTypeDAO;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.data.dao.entity.sqlserver.CitySqlServerDAO;
import co.edu.uco.nose.data.dao.entity.sqlserver.CountrySqlServerDAO;
import co.edu.uco.nose.data.dao.entity.sqlserver.IdTypeSqlServerDAO;
import co.edu.uco.nose.data.dao.entity.sqlserver.StateSqlServerDAO;
import co.edu.uco.nose.data.dao.entity.sqlserver.UserSqlServerDAO;
import co.edu.uco.nose.data.dao.factory.DAOFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.DriverManager;


public class SqlServerDAOFactory extends DAOFactory {
	
	private JdbcTemplate jdbcTemplate;
	
	@Override
	protected void openConnection() {
		
		try {
			this.connection = DriverManager.getConnection("\"jdbc:sqlserver://localhost;databaseName=MyDatabase;user=MyUser;password=MyPassword;encrypt=true;trustServerCertificate=true;\"");
		} catch (final SQLException exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(userMessage, technicalMessage);
		}
	}

	@Override
	public CityDAO getCityDAO() {
		return new CitySqlServerDAO(connection);
	}

	@Override
	public CountryDAO getCountryDAO() {
		return new CountrySqlServerDAO(connection);
	}

	@Override
	public IdTypeDAO getIdType() {
		return new IdTypeSqlServerDAO(connection);
	}

	@Override
	public StateDAO getStateDAO() {
		return new StateSqlServerDAO(connection);
	}

	@Override
	public UserDAO getUserDAO() {
		return new UserSqlServerDAO(connection);
	}
	
}
