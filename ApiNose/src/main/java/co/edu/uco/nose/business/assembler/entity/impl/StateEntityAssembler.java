package co.edu.uco.nose.business.assembler.entity.impl;

import static co.edu.uco.nose.business.assembler.entity.impl.CountryEntityAssembler.getCountryEntityAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.StateDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.StateEntity;

public final class StateEntityAssembler implements EntityAssembler<StateEntity, StateDomain> {
	
	private static final EntityAssembler<StateEntity, StateDomain> INSTANCE = new StateEntityAssembler();
	
	private StateEntityAssembler() {
		
	}
	
	public static EntityAssembler<StateEntity, StateDomain> getStateEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public StateEntity toEntity(StateDomain domain) {
		var countryEntityTmp = getCountryEntityAssembler().toEntity(domain.getCountry());
		var domainTmp = ObjectHelper.getDefault(domain, new StateDomain(UUIDHelper.getUUIDHelper().getDefault()));
		
		return new StateEntity(domainTmp.getId(), domainTmp.getName(), countryEntityTmp);
	}

	@Override
	public StateDomain toDomain(StateEntity entity) {
		var countryDomainTmp = getCountryEntityAssembler().toDomain(entity.getCountry());
		var entityTmp = ObjectHelper.getDefault(entity, new StateEntity(UUIDHelper.getUUIDHelper().getDefault()));
		
		return new StateDomain(entityTmp.getId(), entityTmp.getName(), countryDomainTmp);
	}

	@Override
	public List<StateEntity> toEntity(List<StateDomain> domainList) {
		var stateEntityList = new ArrayList<StateEntity>();
		
		for (var stateDomain : domainList) {
			stateEntityList.add(toEntity(stateDomain));
			
		}
		
		return stateEntityList;
	}

}
