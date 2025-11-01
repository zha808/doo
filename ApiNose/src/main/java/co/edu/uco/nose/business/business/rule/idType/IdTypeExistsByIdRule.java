package co.edu.uco.nose.business.business.rule.idType;

import java.util.UUID;

import co.edu.uco.nose.business.business.rule.Rule;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.data.dao.factory.DAOFactory;

public class IdTypeExistsByIdRule implements Rule{
	
	private static final Rule INSTANCE = new IdTypeExistsByIdRule();
	
	private IdTypeExistsByIdRule() {
	}
	
	public static void executeRule(final Object... data) {
		INSTANCE.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		
		// .. mismas validaciones de las demas reglas
		// ... que data no llegue nulo
		// ...que data no tenga menos de 2 elementos
		
		var id = (UUID) data[0];
		var daoFactory = (DAOFactory) data[1];
		
		var idType = daoFactory.getIdType().findById(id);
		
		if(UUIDHelper.getUUIDHelper().isDefaultUUID(idType.getId())) {
			var userMessage = "El tipo de identificacion deseado no existe...";
			var technicalMessage = "El tipo de identificacion con id[".concat(id.toString()).concat("] no existe...");
			throw NoseException.create(userMessage,	technicalMessage);
		}
		
	}

}
