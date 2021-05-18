package se.yrgo.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import se.yrgo.domain.Record;

@Stateless
@Alternative  
public class RecordDataAccessTestingVersion implements RecordDataAccess {

	@Override
	public void insert(Record newRecord) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Record> findAll() {
		Record rec1 = new Record("Abba", "Collected", "Pop", "0600753337776");
		Record rec2 = new Record("Charlie Parker", "Bird in LA", "Jazz", "0602507408459");
		Record rec3 = new Record("Nirvana", "Nevermind", "Rock", "0720642442517");
		
		List<Record> records = new ArrayList<>();
		records.add(rec1);
		records.add(rec2);
		records.add(rec3);
		
		return records;
	}

	@Override
	public List<Record> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Record findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
