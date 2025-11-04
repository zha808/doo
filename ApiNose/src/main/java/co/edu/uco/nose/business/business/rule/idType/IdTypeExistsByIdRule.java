package co.edu.uco.nose.business.business.rule.idType;

import java.util.UUID;

import co.edu.uco.nose.business.business.rule.Rule;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
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
		
		if (ObjectHelper.isNull(data)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = "No se recibieron los parametros requeridos para ejecutar la regla de IdTypeExistsByIdRule.";
			throw NoseException.create(userMessage,	technicalMessage);
		}
		
		if (data.length < 2) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada...";
			var technicalMessage = "Se requerian dos parametros y llegó una cantidad menor a esta ejecutar la regla de IdTypeExistsByIdRule";
			throw NoseException.create(userMessage,	technicalMessage);
		}
		
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
