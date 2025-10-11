package co.edu.uco.nose.crosscuting.helper;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;

public class SqlConnectionHelper {
	private static final String PROPERTIES_FILE = "/application.properties";

    public static Connection getConnection() {
        try (InputStream input = SqlConnectionHelper.class.getResourceAsStream(PROPERTIES_FILE)) {
            Properties prop = new Properties();
            prop.load(input);

            String url = prop.getProperty("spring.datasource.url");
            String username = prop.getProperty("spring.datasource.username");
            String password = prop.getProperty("spring.datasource.password");
            String driver = prop.getProperty("spring.datasource.driverClassName");

            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
        	var userMessage = "Error connecting to the database";
            var technicalMessage = "Technical details: " + e.getMessage();
            throw NoseException.create(e, userMessage, technicalMessage);
    	}
    }
    
    public static Connection setConnection(Connection connection) {
		if(ObjectHelper.isNull(connection)) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		
		try {
			if(connection.isClosed()) {
				var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
				var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
				throw NoseException.create(userMessage, technicalMessage);
			}
		} catch (Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		return connection;
	}
	
	public void validateTransaction(Connection connection) {

		try {
			if (connection.getAutoCommit()) {
				var userMessage = MessagesEnum.USER_ERROR_SQL_TRANSACTION_NOT_INITIATE.getContent();
				var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_TRANSACTION_NOT_INITIATE.getContent();
				throw NoseException.create(userMessage, technicalMessage);
            }
            
        } catch (Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }
    
	public static void ensureTransactionIsNotStarted(Connection connection) {

		try {
			if (!connection.getAutoCommit()) {
				var userMessage = MessagesEnum.USER_ERROR_SQL_TRANSACTION_NOT_INITIATE.getContent();
				var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_TRANSACTION_NOT_INITIATE.getContent();
				throw NoseException.create(userMessage, technicalMessage);
            }
            
        } catch (Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }
    
	public static void ensureTransactionIsStarted(Connection connection) {

		try {
			if (!connection.getAutoCommit()) {
				var userMessage = MessagesEnum.USER_ERROR_SQL_TRANSACTION_NOT_INITIATE.getContent();
				var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_TRANSACTION_NOT_INITIATE.getContent();
				throw NoseException.create(userMessage, technicalMessage);
            }
            
        } catch (Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }
    
	public static void ensureConnectionIsOpen(Connection connection) {

		try {
			if (connection.getAutoCommit()) {
				var userMessage = MessagesEnum.USER_ERROR_SQL_TRANSACTION_NOT_INITIATE.getContent();
				var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_TRANSACTION_NOT_INITIATE.getContent();
				throw NoseException.create(userMessage, technicalMessage);
            }
            
        } catch (Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }
    
}
