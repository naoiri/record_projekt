package se.yrgo.dataaccess;

import java.util.List;

import javax.ejb.Local;

import se.yrgo.domain.Record;

@Local 
public interface RecordDataAccess {
	
	public void insert(Record newRecord);
	
	public List<Record> findAll();
	
	public List<Record> findByTitle(String title);
	
	public Record findByID(int id) throws RecordNotFoundException;
}
