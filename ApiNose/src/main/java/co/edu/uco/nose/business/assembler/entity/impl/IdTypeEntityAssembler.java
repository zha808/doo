package co.edu.uco.nose.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.IdTypeDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.IdTypeEntity;

public final class IdTypeEntityAssembler implements EntityAssembler<IdTypeEntity, IdTypeDomain> {
	
	private static final EntityAssembler<IdTypeEntity, IdTypeDomain> INSTANCE = new IdTypeEntityAssembler();
	
	private IdTypeEntityAssembler() {
		
	}
	
	public static EntityAssembler<IdTypeEntity, IdTypeDomain> getIdTypeEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public IdTypeEntity toEntity(IdTypeDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new IdTypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new IdTypeEntity(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public IdTypeDomain toDomain(IdTypeEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new IdTypeEntity(UUIDHelper.getUUIDHelper().getDefault()));
		return new IdTypeDomain(entityTmp.getId(), entityTmp.getName());
	}

	@Override
	public List<IdTypeEntity> toEntity(List<IdTypeDomain> domainList) {
		var idTypeEntityList = new ArrayList<IdTypeEntity>();
		
		for (var idTypeDomain : domainList) {
			idTypeEntityList.add(toEntity(idTypeDomain));
		}
		return idTypeEntityList;
	}

}
