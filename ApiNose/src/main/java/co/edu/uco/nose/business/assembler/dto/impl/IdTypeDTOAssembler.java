package co.edu.uco.nose.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.IdTypeDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.IdTypeDTO;

public final class IdTypeDTOAssembler implements DTOAssembler<IdTypeDTO, IdTypeDomain> {

	private static final DTOAssembler<IdTypeDTO, IdTypeDomain> INSTANCE = new IdTypeDTOAssembler();
	
	private IdTypeDTOAssembler() {
		
	}
	
	public static DTOAssembler<IdTypeDTO, IdTypeDomain> getIdTypeDTOAssembler() {
		return INSTANCE;
	}
	
	@Override
	public IdTypeDTO toDTO(IdTypeDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new IdTypeDomain(UUIDHelper.getUUIDHelper().getDefault())); 
		return new IdTypeDTO(domainTmp.getId(), domainTmp.getName());
	}

	@Override
	public IdTypeDomain toDomain(IdTypeDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new IdTypeDTO(UUIDHelper.getUUIDHelper().getDefault()));
		return new IdTypeDomain(dtoTmp.getId(), dtoTmp.getName());
	}

	@Override
	public List<IdTypeDTO> toDTO(List<IdTypeDomain> domainList) {
		var userDTOList = new ArrayList<IdTypeDTO>();
		
		for (var idType : domainList) {
			userDTOList.add(toDTO(idType));
		}
		
		return userDTOList;
	}

}
