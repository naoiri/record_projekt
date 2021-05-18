package se.yrgo.service;

import java.util.List;

import javax.ejb.Remote;

import se.yrgo.domain.Record;

@Remote
public interface RecordManagementService {
	
	public List<Record> getAllRecords();
	public void registerRecord(Record record);
	public List<Record> searchByTitle(String title);

}
