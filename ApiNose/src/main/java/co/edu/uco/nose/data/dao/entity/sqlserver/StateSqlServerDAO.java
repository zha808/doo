package co.edu.uco.nose.data.dao.entity.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.entity.StateEntity;

public final class StateSqlServerDAO extends SqlConnection implements StateDAO{

	protected StateSqlServerDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<StateEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateEntity> findByFilter(StateEntity fitlerEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
