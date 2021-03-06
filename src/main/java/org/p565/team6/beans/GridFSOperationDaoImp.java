package org.p565.team6.beans;

import java.io.IOException;
import java.io.InputStream;

import org.p565.team6.model.RegisterModel;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

import com.mongodb.gridfs.GridFSDBFile;

public class GridFSOperationDaoImp implements GridFSOperationDao {

	private GridFsOperations gridOperations;
	
	public GridFSOperationDaoImp(GridFsOperations gridOperations) {
		super();
		this.gridOperations = gridOperations;
	}

	@Override
	public boolean insertOneFile(InputStream inputStream,String identifier) throws IOException {
		// TODO Auto-generated method stub
			gridOperations.store(inputStream, identifier);
			return false;
	}

	@Override
	public GridFSDBFile searchOneFile(String identifier) {
		// TODO Auto-generated method stub
		GridFSDBFile gridFsdbFile = gridOperations.findOne(new Query(Criteria.where("filename").is(identifier)));
		return gridFsdbFile;
	}
	
	

}
