package se.yrgo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import se.yrgo.dataaccess.RecordDataAccess;
import se.yrgo.dataaccess.RecordNotFoundException;
import se.yrgo.domain.Record;

@Stateless
public class RecordManagementServiceImplementation implements RecordManagementService, RecordManagementServiceLocal {
	@Inject 
	private RecordDataAccess dao;
	
	@Override
	public void registerRecord(Record record) {
		dao.insert(record);
	}
	
	@Override
	public List<Record> getAllRecords() {
		return dao.findAll();
	}

	@Override
	public List<Record> searchByTitle(String title) {
		return dao.findByTitle(title);
	}

	@Override
	public Record findRecordByID(int id) throws RecordNotFoundException {
		
		return dao.findByID(id);
	}

}
