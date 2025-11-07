package co.edu.uco.nose.data.dao.entity.sql;

public class IdTypeSql {

	public static final String FIND_BY_FILTER = """
				SELECT u.id,
				ti.id AS idTipoIdentificacion,
				ti.nombre AS nombreTipoIdentificacion,
				u.numeroIdentificacion,
				u.primerNombre,
				u.segundoNombre,
				u.primerApellido,
				u.segundoApellido,
				c.id AS idCiudadResidencia,
				c.nombre AS nombreCiudadResidencia,
				d.id AS idDepartamentoCiudadResidencia,
				d.nombre AS nombreDepartamentoCiudadResidencia,
				p.id AS idPaisDepartamentoCiudadResidencia,
				p.nombre AS nombrePaisDepartamentoCiudadResidencia,
				u.correoElectronico,
				u.numeroTelefonoMovil,
				u.correoElectronicoConfirmado,
				u.numeroTelefonoMovilConfirmado
			 FROM Usuario AS u
			 INNER JOIN TipoIdentificacion AS ti ON u.tipoIdentificacion = ti.id
			 INNER JOIN Ciudad AS c ON u.ciudadResidencia = c.id
			 INNER JOIN Departamento AS d ON c.departamento = d.id
			 INNER JOIN Pais AS p ON d.pais = p.id
			""";
	
}