package se.yrgo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import se.yrgo.dataaccess.RecordNotFoundException;
import se.yrgo.domain.Record;
import se.yrgo.service.RecordManagementService;
import se.yrgo.service.RecordManagementServiceLocal;


@Stateless
@Path("/records")
public class RecordResource {
	
	@Inject
	private RecordManagementServiceLocal service;
	
	@GET
	@Produces("application/JSON") 
	public List<Record> getAllRecords() {
		return service.getAllRecords();
	}
	
	@GET
	@Produces("application/JSON")
	@Path("{recordNo}") 
	public Response findRecordById(@PathParam("recordNo") int id) { 
		try { 
			Record result = service.findRecordByID(id); 
			return Response.ok(result).build();
			
		} catch (RecordNotFoundException e) {
			return Response.status(404).build(); 
		}
	}
	
	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Record createRecord(Record record) {
		service.registerRecord(record);
		return record;
	}
	
	
}
