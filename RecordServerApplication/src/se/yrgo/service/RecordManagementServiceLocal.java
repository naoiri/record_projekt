package se.yrgo.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import se.yrgo.dataaccess.RecordNotFoundException;
import se.yrgo.domain.Record;

@Local
public interface RecordManagementServiceLocal {
	
	public List<Record> getAllRecords();
	public void registerRecord(Record record);
	public List<Record> searchByTitle(String title);
	public Record findRecordByID(int id) throws RecordNotFoundException;

}
