package co.edu.uco.nose.business.assembler.dto.impl;

import static co.edu.uco.nose.business.assembler.dto.impl.StateDTOAssembler.getStateDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.CityDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.CityDTO;
import co.edu.uco.nose.dto.StateDTO;

public final class CityDTOAssembler implements DTOAssembler<CityDTO, CityDomain> {

	private static final DTOAssembler<CityDTO, CityDomain> INSTANCE = new CityDTOAssembler();
	
	private CityDTOAssembler() {
		
	}
	
	public static DTOAssembler<CityDTO, CityDomain> getCityDTOAssembler() {
		return INSTANCE;
	}
	
	@Override
	public CityDTO toDTO(CityDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new CityDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var countryDtoTmp = getStateDTOAssembler().toDTO(domainTmp.getState());
		
		return new CityDTO(domainTmp.getId(), domainTmp.getName(), countryDtoTmp);
	}

	@Override
	public CityDomain toDomain(CityDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new CityDTO(UUIDHelper.getUUIDHelper().getDefault()));
		var stateDomainTmp = getStateDTOAssembler().toDomain(dtoTmp.getState());
		
		return new CityDomain(dtoTmp.getId(), dtoTmp.getName(), stateDomainTmp);
	}

	@Override
	public List<CityDTO> toDTO(List<CityDomain> domainList) {
		var cityDTOList = new ArrayList<CityDTO>();
		
		for (var city : domainList) {
			cityDTOList.add(toDTO(city));
		}
		
		return cityDTOList;
	}
	
}
