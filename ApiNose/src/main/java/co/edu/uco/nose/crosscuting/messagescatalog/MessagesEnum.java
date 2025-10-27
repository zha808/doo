package co.edu.uco.nose.crosscuting.messagescatalog;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public enum MessagesEnum {
	
	USER_ERROR_SQL_CONNECTION_IS_EMPTY("Conexion contra la fuente de informacion deseada vacia", 
			"La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada esta vacio. "
			+ "Por favor intente de nuevo y si el problema persiste, contacto al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY("Conexion contra la fuente de informacion deseada nula", 
			"La conexion requerida para llevar a cabo la operacion contra la base de datos llego nula."),
	
	USER_ERROR_SQL_CONNECTION_IS_CLOSED("Conexion contra la fuente de informacion deseada cerrada", 
			"La conexion requerida para llevar a cabo la operacion contra la fuente de informacion deseada esta cerrada. "
			+ "Por favor intente de nuevo y si el problema persiste, contacto al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED("Conexion contra la fuente de informacion deseada cerrada", 
			"La conexion requerida para llevar a cabo la operacion contra la base de datos esta cerrada."),
	
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado validando el estado de la conexion contra la fuente de datos deseado", 
			"Se ha presentado un problema inesperado tratando de validar el estado de la conexion requerida "
			+ "para llevar a cabo la operacion contra la fuente de datos deseada. Por favor intente de nuevo y "
			+ "si el problema persiste, contacto al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validanDo si la "
			+ "conexion contra la base de datos estaba abierta", 
			"Se presento un error de tipo SQL.Exception al validar si la conexion contra la base de datos. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."),
	
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS("Problema inesperado validando el estado de la transaccion", 
			"Se ha presentado un problema inesperado tratando de validar el estado de la transaccion. Por favor intente de nuevo y "
			+ "si el problema persiste, contacto al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS("Error inesperado validando si la transaccion estaba iniciada", 
			"Se presento un error de tipo SQL.Exception al validar si la transaccion estaba iniciada. "
			+ "Por favor valide la consola de errores para revisar con detalle el problema presentado."), 
	
	USER_ERROR_TRANSACTION_IS_NOT_STARTED ("Transaccion no iniciada", 
			"La transaccion requerida para llevar a cabo la operacion contra la fuente de informacion deseada no ha sido iniciada. "
			+ "Por favor intente de nuevo y si el problema persiste, contacto al administrador de la aplicacion"),
	TECHNICAL_ERROR_TRANSACTION_IS_NOT_STARTED ("Transaccion no iniciada",
			"La transaccion requerida para llevar a cabo la operacion contra la fuente de informacion deseada no ha sido iniciada. "
					+ "Por favor intente de nuevo y si el problema persiste, contacto al administrador de la aplicacion"), 
	USER_ERROR_TRANSACTION_IS_STARTED("Transaccion iniciada", 
			"La transaccion requerida para llevar a cabo la operacion contra la fuente de informacion deseada ha sido iniciada. "
			+ "Por favor intente de nuevo y si el problema persiste, contacto al administrador de la aplicacion"),
	TECHNICAL_ERROR_TRANSACTION_IS_STARTED ("Transaccion iniciada",
			"La transaccion requerida para llevar a cabo la operacion contra la fuente de informacion deseada ha sido iniciada. "
				+ "Por favor intente de nuevo y si el problema persiste, contacto al administrador de la aplicacion"), 
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS_IS_CLOSED("Transaccion cerrada",
			"La transaccion requerida para llevar a cabo la operacion contra la fuente de datos se encuentra cerrada. "
			+ "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS_IS_CLOSED("Error validando estado cerrado de transaccion",
			"Se presento un error al validar si la transaccion estaba cerrada. Revise la traza de errores para mas detalles."),
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS_IS_NOT_OPEN("Transaccion no iniciada",
			"La transaccion requerida para llevar a cabo la operacion contra la fuente de datos no se encuentra iniciada. "
			+ "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS_IS_NOT_OPEN("Error validando estado de transaccion no iniciada",
			"Se presento un error al validar si la transaccion estaba iniciada. Revise la traza de errores para mas detalles."),
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_OPEN("Transaccion ya iniciada",
			"La transaccion ya se encuentra iniciada y no puede iniciarse nuevamente. "
			+ "Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion"),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_OPEN("Error validando estado de transaccion ya iniciada",
			"Se presento un error al validar que la transaccion no estuviera iniciada antes de la operacion. Revise la traza de errores para mas detalles."),
	
	// DAO - City
	USER_ERROR_CITY_FIND_ALL("Ocurrió un problema al ejecutar la consulta de ciudades",
		"Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema"),
	TECHNICAL_ERROR_CITY_FIND_ALL("Error SQL ejecutando CityDAO.findAll",
		"Error SQL ejecutando el query en CitySqlServerDAO.findAll. Revise la traza de errores para mas detalles."),
	USER_ERROR_CITY_FIND_ALL_UNEXPECTED("Ocurrió un problema INESPERADO al ejecutar la consulta de ciudades",
		"Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema"),
	TECHNICAL_ERROR_CITY_FIND_ALL_UNEXPECTED("Error inesperado ejecutando CityDAO.findAll",
		"Error inesperado ejecutando el query en CitySqlServerDAO.findAll. Revise la traza de errores para mas detalles."),
	USER_ERROR_CITY_FIND_BY_ID("Ocurrió un problema al ejecutar la consulta de ciudad",
		"Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema"),
	TECHNICAL_ERROR_CITY_FIND_BY_ID("Error SQL ejecutando CityDAO.findById",
		"Error SQL ejecutando el query en CitySqlServerDAO.findById. Revise la traza de errores para mas detalles."),
	
	// DAO - Country
	USER_ERROR_COUNTRY_FIND_ALL("Ocurrió un problema al ejecutar la consulta de paises",
		"Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema"),
	TECHNICAL_ERROR_COUNTRY_FIND_ALL("Error SQL ejecutando CountryDAO.findAll",
		"Error SQL ejecutando el query en CountrySqlServerDAO.findAll. Revise la traza de errores para mas detalles."),
	USER_ERROR_COUNTRY_FIND_ALL_UNEXPECTED("Ocurrió un problema INESPERADO al ejecutar la consulta de paises",
		"Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema"),
	TECHNICAL_ERROR_COUNTRY_FIND_ALL_UNEXPECTED("Error inesperado ejecutando CountryDAO.findAll",
		"Error inesperado ejecutando el query en CountrySqlServerDAO.findAll. Revise la traza de errores para mas detalles."),
	USER_ERROR_COUNTRY_FIND_BY_ID("Ocurrió un problema al ejecutar la consulta de pais",
		"Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema"),
	TECHNICAL_ERROR_COUNTRY_FIND_BY_ID("Error SQL ejecutando CountryDAO.findById",
		"Error SQL ejecutando el query en CountrySqlServerDAO.findById. Revise la traza de errores para mas detalles."),
	
	// DAO - State
	USER_ERROR_STATE_FIND_ALL("Ocurrió un problema al ejecutar la consulta de estados",
		"Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema"),
	TECHNICAL_ERROR_STATE_FIND_ALL("Error SQL ejecutando StateDAO.findAll",
		"Error SQL ejecutando el query en StateSqlServerDAO.findAll. Revise la traza de errores para mas detalles."),
	USER_ERROR_STATE_FIND_ALL_UNEXPECTED("Ocurrió un problema INESPERADO al ejecutar la consulta de estados",
		"Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema"),
	TECHNICAL_ERROR_STATE_FIND_ALL_UNEXPECTED("Error inesperado ejecutando StateDAO.findAll",
		"Error inesperado ejecutando el query en StateSqlServerDAO.findAll. Revise la traza de errores para mas detalles."),
	USER_ERROR_STATE_FIND_BY_ID("Ocurrió un problema al ejecutar la consulta de estado",
		"Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema"),
	TECHNICAL_ERROR_STATE_FIND_BY_ID("Error SQL ejecutando StateDAO.findById",
		"Error SQL ejecutando el query en StateSqlServerDAO.findById. Revise la traza de errores para mas detalles."),
	
	// DAO - IdType
	USER_ERROR_IDTYPE_FIND_ALL("Ocurrió un problema al ejecutar la consulta de tipos de identificacion",
		"Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema"),
	TECHNICAL_ERROR_IDTYPE_FIND_ALL("Error SQL ejecutando IdTypeDAO.findAll",
		"Error SQL ejecutando el query en IdTypeSqlServerDAO.findAll. Revise la traza de errores para mas detalles."),
	USER_ERROR_IDTYPE_FIND_ALL_UNEXPECTED("Ocurrió un problema INESPERADO al ejecutar la consulta de tipos de identificacion",
		"Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema"),
	TECHNICAL_ERROR_IDTYPE_FIND_ALL_UNEXPECTED("Error inesperado ejecutando IdTypeDAO.findAll",
		"Error inesperado ejecutando el query en IdTypeSqlServerDAO.findAll. Revise la traza de errores para mas detalles."),
	USER_ERROR_IDTYPE_FIND_BY_ID("Ocurrió un problema al ejecutar la consulta de tipo de identificacion",
		"Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema"),
	TECHNICAL_ERROR_IDTYPE_FIND_BY_ID("Error SQL ejecutando IdTypeDAO.findById",
		"Error SQL ejecutando el query en IdTypeSqlServerDAO.findById. Revise la traza de errores para mas detalles."),
	
	// Mapper messages (added for ApiNose mappers)
	USER_ERROR_CITY_MAPPER("Ocurrió un problema al mapear la ciudad desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir CityEntity. Verifique los nombres de las columnas y el esquema de la consulta."),
	TECHNICAL_ERROR_CITY_MAPPER("Error técnico mapeando CityMapper",
		"Se presentó un error técnico al mapear el ResultSet a CityEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_CITY_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear la ciudad",
		"Se presentó un error inesperado al mapear el ResultSet a CityEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_CITY_MAPPER_UNEXPECTED("Error inesperado mapeando CityMapper",
		"Se presentó un error inesperado al mapear el ResultSet a CityEntity. Revise la traza de errores para más detalle."),

	USER_ERROR_COUNTRY_MAPPER("Ocurrió un problema al mapear el país desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir CountryEntity. Verifique los nombres de las columnas y el esquema de la consulta."),
	TECHNICAL_ERROR_COUNTRY_MAPPER("Error técnico mapeando CountryMapper",
		"Se presentó un error técnico al mapear el ResultSet a CountryEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_COUNTRY_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el país",
		"Se presentó un error inesperado al mapear el ResultSet a CountryEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_COUNTRY_MAPPER_UNEXPECTED("Error inesperado mapeando CountryMapper",
		"Se presentó un error inesperado al mapear el ResultSet a CountryEntity. Revise la traza de errores para más detalle."),

	USER_ERROR_STATE_MAPPER("Ocurrió un problema al mapear el estado desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir StateEntity. Verifique los nombres de las columnas y el esquema de la consulta."),
	TECHNICAL_ERROR_STATE_MAPPER("Error técnico mapeando StateMapper",
		"Se presentó un error técnico al mapear el ResultSet a StateEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_STATE_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el estado",
		"Se presentó un error inesperado al mapear el ResultSet a StateEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_STATE_MAPPER_UNEXPECTED("Error inesperado mapeando StateMapper",
		"Se presentó un error inesperado al mapear el ResultSet a StateEntity. Revise la traza de errores para más detalle."),

	USER_ERROR_IDTYPE_MAPPER("Ocurrió un problema al mapear el tipo de identificacion desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir IdTypeEntity. Verifique los nombres de las columnas y el esquema de la consulta."),
	TECHNICAL_ERROR_IDTYPE_MAPPER("Error técnico mapeando IdTypeMapper",
		"Se presentó un error técnico al mapear el ResultSet a IdTypeEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_IDTYPE_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el tipo de identificacion",
		"Se presentó un error inesperado al mapear el ResultSet a IdTypeEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_IDTYPE_MAPPER_UNEXPECTED("Error inesperado mapeando IdTypeMapper",
		"Se presentó un error inesperado al mapear el ResultSet a IdTypeEntity. Revise la traza de errores para más detalle."),

	USER_ERROR_USER_MAPPER("Ocurrió un problema al mapear el usuario desde el ResultSet",
		"Error al intentar extraer los campos del ResultSet para construir UserEntity. Verifique los nombres de las columnas y el esquema de la consulta."),
	TECHNICAL_ERROR_USER_MAPPER("Error técnico mapeando UserMapper",
		"Se presentó un error técnico al mapear el ResultSet a UserEntity. Revise la traza de errores para más detalle."),
	USER_ERROR_USER_MAPPER_UNEXPECTED("Ocurrió un problema INESPERADO al mapear el usuario",
		"Se presentó un error inesperado al mapear el ResultSet a UserEntity. Por favor contacte al administrador del sistema."),
	TECHNICAL_ERROR_USER_MAPPER_UNEXPECTED("Error inesperado mapeando UserMapper",
		"Se presentó un error inesperado al mapear el ResultSet a UserEntity. Revise la traza de errores para más detalle."), 
	USER_ERROR_USER_FIND_ALL("", ""), TECHNICAL_ERROR_USER_FIND_ALL("", ""), 
	USER_ERROR_USER_UPDATE("", ""), TECHNICAL_ERROR_USER_UPDATE("", ""), 
	USER_ERROR_USER_DELETE("",  ""), TECHNICAL_ERROR_USER_DELETE("",  ""), 
	USER_ERROR_USER_CREATE("", ""), TECHNICAL_ERROR_USER_CREATE("", ""), 
	USER_ERROR_USER_CREATE_UNEXPECTED("", ""), TECHNICAL_ERROR_USER_CREATE_UNEXPECTED("", ""), 
	USER_ERROR_USER_FIND_ALL_UNEXPECTED("", ""), TECHNICAL_ERROR_USER_FIND_ALL_UNEXPECTED("", ""),;

	
	private String title;
	private String content;
	
	
	private MessagesEnum(final String title, final String content) {
		setTitle(title);
		setContent(content);
	}


	public String getTitle() {
		return title;
	}


	private void setTitle(final String title) {
		this.title = TextHelper.getDefaultWithTrim(title);
	}


	public String getContent() {
		return content;
	}


	private void setContent(String content) {
		this.content = TextHelper.getDefaultWithTrim(content);
	}
	
}