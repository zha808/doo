package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.CountryDomain;
import co.edu.uco.nose.entity.CountryEntity;

public final class CountryEntityAssembler implements EntityAssembler<CountryEntity, CountryDomain> {
	
	private static final EntityAssembler<CountryEntity, CountryDomain> INSTANCE = new CountryEntityAssembler();
	
	private CountryEntityAssembler() {
		
	}
	
	public static EntityAssembler<CountryEntity, CountryDomain> getCountryEntityAssembler() {
		return INSTANCE;
	}

	@Override
	public CountryEntity toEntity(CountryDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountryDomain toDomain(CountryEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
