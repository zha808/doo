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
	
	// DAO - User
	USER_ERROR_USER_CREATE("Se ha presentado un problema tratando de registrar la informacion del nuevo usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se ha presentado un problema al tratar de ejecutar el proceso de creacion de un usuario"),
	TECHNICAL_ERROR_USER_CREATE("Error creando usuario",
		"Se ha presentado un error SQL al intentar crear un usuario. Revise la traza de errores para mas detalles."),
	USER_ERROR_USER_CREATE_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de crear un nuevo usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se ha presentado un problema inesperado al tratar de ejecutar el proceso de creacion de un usuario"),
	TECHNICAL_ERROR_USER_CREATE_UNEXPECTED("Error inesperado creando usuario",
		"Se ha presentado un error inesperado al intentar crear un usuario. Revise la traza de errores para mas detalles."),
	
	USER_ERROR_USER_FIND_ALL("Se ha presentado un problema tratando de consultar la informacion de los usuarios. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se ha presentado un problema al tratar de ejecutar el proceso de consulta de usuarios. Por favor verifique que la informacion este correcta"),
	TECHNICAL_ERROR_USER_FIND_ALL("Error ejecutando UserDAO.findAll",
		"Error ejecutando el query en UserSqlServerDAO.findAll. Revise la traza de errores para mas detalles."),
	USER_ERROR_USER_FIND_ALL_UNEXPECTED("Se ha presentado un problema INESPERADO tratando de consultar la informacion de los usuarios. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se ha presentado un problema INESPERADO al tratar de ejecutar el proceso de consulta de usuarios. Revise la traza de errores para mas detalles."),
	
	USER_ERROR_USER_FIND_BY_ID("Se ha presentado un problema tratando de consultar la informacion del usuario deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se ha presentado un problema al tratar de ejecutar el proceso de consulta del usuario deseado. Por favor verifique que la informacion este correcta"),
	TECHNICAL_ERROR_USER_FIND_BY_ID("Error ejecutando UserDAO.findById",
		"Error ejecutando el query en UserSqlServerDAO.findById. Revise la traza de errores para mas detalles."),
	
	USER_ERROR_USER_UPDATE("Se ha presentado un problema tratando de modificar la informacion del usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se ha presentado un problema al tratar de ejecutar el proceso de modificacion de un usuario"),
	TECHNICAL_ERROR_USER_UPDATE("Error modificando usuario",
		"Error SQL ejecutando el proceso de actualizacion de usuario. Revise la traza de errores para mas detalles."),
	
	USER_ERROR_USER_DELETE("Se ha presentado un problema tratando de eliminar la informacion del usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema",
		"Se ha presentado un problema al tratar de ejecutar el proceso de eliminacion de usuario"),
	TECHNICAL_ERROR_USER_DELETE("Error eliminando usuario",
		"Error SQL ejecutando el proceso de eliminacion de usuario. Revise la traza de errores para mas detalles.");

	
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