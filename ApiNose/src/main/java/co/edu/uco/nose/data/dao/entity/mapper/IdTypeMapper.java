package co.edu.uco.nose.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.entity.IdTypeEntity;

public final class IdTypeMapper {
	public static IdTypeEntity map(ResultSet resultSet) {
		
		var idType = new IdTypeEntity();
		
		try {
			idType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idTipoIdentificacion")));
			idType.setName(resultSet.getString("nombreTipoIdentificacion"));
			
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_IDTYPE_MAPPER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_IDTYPE_MAPPER.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_IDTYPE_MAPPER_UNEXPECTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_IDTYPE_MAPPER_UNEXPECTED.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		return idType;
		
	}
}