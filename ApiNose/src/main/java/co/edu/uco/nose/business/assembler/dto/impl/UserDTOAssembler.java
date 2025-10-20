package co.edu.uco.nose.business.assembler.dto.impl;

import static co.edu.uco.nose.business.assembler.dto.impl.CityDTOAssembler.getCityDTOAssembler;
import static co.edu.uco.nose.business.assembler.dto.impl.IdTypeDTOAssembler.getIdTypeDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.UserDTO;

public final class UserDTOAssembler implements DTOAssembler<UserDTO, UserDomain> {
	
	private static final DTOAssembler<UserDTO, UserDomain> INSTANCE = new UserDTOAssembler();
	
	private UserDTOAssembler() {
		
	}
	
	public static DTOAssembler<UserDTO, UserDomain> getUserDTOAssembler() {
		return INSTANCE;
	}

	@Override
	public UserDTO toDTO(final UserDomain domain) {
		var idTypeDtoTmp = getIdTypeDTOAssembler().toDTO(domain.getIdentificationType());
		var cityDtoTmp = getCityDTOAssembler().toDTO(domain.getCity());
		
		var domainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new UserDTO(domainTmp.getId(), domainTmp.getIdNumber(), domainTmp.getFirstName(), domainTmp.getSecondName(), domainTmp.getLastName(), domainTmp.getSecondLastName(),
				domainTmp.getEmail(), domainTmp.getPhoneNumber(), idTypeDtoTmp, cityDtoTmp);
	}

	@Override
	public UserDomain toDomain(UserDTO dto) {
		var idTypeDomainTmp = getIdTypeDTOAssembler().toDomain(dto.getIdentificationType());
		var cityDomainTmp = getCityDTOAssembler().toDomain(dto.getCity());
		
		var dtoTmp = ObjectHelper.getDefault(dto, new UserDTO(UUIDHelper.getUUIDHelper().getDefault()));
		return new UserDomain(dtoTmp.getId(), dtoTmp.getIdNumber(), dtoTmp.getFirstName(), dtoTmp.getSecondName(), dtoTmp.getLastName(), dtoTmp.getSecondLastName(),
				dtoTmp.getEmail(), dtoTmp.getPhoneNumber(), idTypeDomainTmp , cityDomainTmp);
	}

	@Override
	public List<UserDTO> toDTO(List<UserDomain> domainList) {
		var userDTOList = new ArrayList<UserDTO>();
		
		for (var userDomain : domainList) {
			userDTOList.add(toDTO(userDomain));
		}
		
		return userDTOList;
	}

}
