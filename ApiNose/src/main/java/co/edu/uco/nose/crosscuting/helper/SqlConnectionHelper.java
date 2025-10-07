package co.edu.uco.nose.crosscuting.helper;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import co.edu.uco.nose.crosscuting.exception.NoseException;

public class SqlConnectionHelper {
	private static final String PROPERTIES_FILE = "/application.properties";

    public static Connection getConnection() {
        try (InputStream input = SqlConnectionHelper.class.getResourceAsStream(PROPERTIES_FILE)) {
            Properties prop = new Properties();
            prop.load(input);

            String url = prop.getProperty("db.url");
            String username = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");
            String driver = prop.getProperty("db.driverClassName");

            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
        	var userMessage = "Error connecting to the database";
            var technicalMessage = "Technical details: " + e.getMessage();
            throw NoseException.create(e, userMessage, technicalMessage);
    	}
    }
}
