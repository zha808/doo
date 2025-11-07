package co.edu.uco.nose.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.nose.business.facade.impl.UserFacadeImpl;
import co.edu.uco.nose.controller.dto.Response;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.CityDTO;
import co.edu.uco.nose.dto.IdTypeDTO;
import co.edu.uco.nose.dto.UserDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@GetMapping("/dummy")
	public UserDTO getUserDTODummy() {
		return new UserDTO();
	}
	
	@GetMapping
	public ResponseEntity<Response<UserDTO>> findAllUsers() {
		
		Response<UserDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
		try {
			var facade = new UserFacadeImpl();
			responseObjectData.setData(facade.findAllUsers());
			responseObjectData.addMessage("All users filtered succesfully");
		
			
		} catch (NoseException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
			exception.printStackTrace();
		} catch (Exception exception) {
			var userMessage = "Unexpected error";
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage);
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			exception.printStackTrace();
		}

		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<UserDTO>> findUserByID(@PathVariable UUID id) {
		
		Response<UserDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
		try {
			var facade = new UserFacadeImpl();
			var user = facade.findSpecificUser(id);
			responseObjectData.setData(new ArrayList<UserDTO>());
			
			if (!UUIDHelper.getUUIDHelper().isDefaultUUID(user.getId())) {
				responseObjectData.getData().add(user);
				responseObjectData.addMessage("User by ID filtered succesfully");
			} else {
				responseObjectData.addMessage("User not found");
			}	
			
		} catch (NoseException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
			exception.printStackTrace();
		} catch (Exception exception) {
			var userMessage = "Unexpected error";
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage);
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			exception.printStackTrace();
		}

		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
	@GetMapping("/$")
	public ResponseEntity<Response<UserDTO>> findUserByFilters(
			@PathVariable(name = "id", required= false) UUID id , 
			@PathVariable(name = "idNumber", required= false) String idNumber , 
			@PathVariable(name = "firstName", required= false) String firstName, 
			@PathVariable(name = "secondName", required= false) String secondName,
			@PathVariable(name = "lastName", required= false) String lastName,	
			@PathVariable(name = "secondLastName", required= false) String secondLastName,
			@PathVariable(name = "email", required= false) String email,
			@PathVariable(name = "phoneNumber", required= false) String phoneNumber,
			@PathVariable(name = "identificationType", required= false) UUID identificationType,
			@PathVariable(name = "city", required= false) UUID city,
			@PathVariable(name = "emailConfirmed", required= false) boolean emailConfirmed,
			@PathVariable(name = "phoneConfirmed", required= false) boolean phoneConfirmed
			){
		Response<UserDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
		try {
			
			var idTypeDTO = new IdTypeDTO(identificationType);
			var cityDTO = new CityDTO(city);
			
			var facade = new UserFacadeImpl();
			var userDto = new UserDTO(
					id, 
					idNumber,
					firstName, 
					secondName, 
					lastName, 
					secondLastName, 
					email, 
					phoneNumber, 
					idTypeDTO,
					cityDTO, 
					emailConfirmed,
					phoneConfirmed);
			var user = facade.findUsersByFilter(userDto);
			
			responseObjectData.setData(facade.findUsersByFilter(userDto));
			responseObjectData.addMessage("Users filtered succesfully");
			
		}catch (NoseException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
		} catch (Exception exception) {
			var userMessage = "Unexpected error";
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage);
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		}	
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
	@PostMapping
	public ResponseEntity<Response> registerNewUserInformation(@RequestBody UserDTO user) {
		Response<Void> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
		try {
			var facade = new UserFacadeImpl();
			facade.registerNewUserInformation(user);
			responseObjectData.addMessage("User registered succesfully");
		} catch (NoseException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
		} catch (Exception exception) {
			var userMessage = "Unexpected error";
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage);
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Response> updateUserInformation(@PathVariable UUID id, @RequestBody UserDTO user) {
		Response<Void> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		try {
			var facade = new UserFacadeImpl();
			facade.updateUserInformation(id, user);
			responseObjectData.addMessage("User updated succesfully");
		} catch (NoseException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
		} catch (Exception exception) {
			var userMessage = "Unexpected error";
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage);
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
		}
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Response> dropUserInformation(@PathVariable UUID id) {
		Response<Void> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
		try {
			var facade = new UserFacadeImpl();
			facade.dropUserInformation(id);
			responseObjectData.addMessage("User deleted succesfully");
		} catch (NoseException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
		} catch (Exception exception) {
			var userMessage = "Unexpected error";
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage);
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
}
