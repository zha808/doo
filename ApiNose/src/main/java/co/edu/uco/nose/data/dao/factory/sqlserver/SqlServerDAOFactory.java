package co.edu.uco.nose.data.dao.factory.sqlserver;

import java.util.Properties;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
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

import java.io.InputStream;
import java.sql.DriverManager;


public final class SqlServerDAOFactory extends DAOFactory {
	
	private JdbcTemplate jdbcTemplate;
	
	public SqlServerDAOFactory() {
		openConnection();
		jdbcTemplate = new JdbcTemplate();
	}
	
	private static final String PROPERTIES_FILE = "/application.properties";
	
	@Override
	protected void openConnection() {
		
		try (InputStream input = SqlConnectionHelper.class.getResourceAsStream(PROPERTIES_FILE)){
			Properties prop = new Properties();
			
            prop.load(input);

            String url = prop.getProperty("spring.datasource.url");
            String username = prop.getProperty("spring.datasource.username");
            String password = prop.getProperty("spring.datasource.password");
            
            this.connection = DriverManager.getConnection(url, username, password);
		} catch (final Exception exception) {
			var userMessage = "Error en la conexión a la base de datos.";
			var technicalMessage = "Error en la conexión a la base de datos. Detalles técnicos: " + exception.getMessage();
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
