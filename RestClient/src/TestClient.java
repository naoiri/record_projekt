import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/*
 * Create a client project
 */

public class TestClient {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/RecordManagement/webservice/records/44")
								  .request("application/JSON")
								  .buildGet()
								  .invoke();
	
		System.out.println(response.readEntity(Record.class)); 
		response.close();
		
		//Create new employee
		Record recABBA = new Record();
		recABBA.setTitle("Collected");
		recABBA.setGenre("Pop");
		recABBA.setBarCode("0600753337776");
		
		Entity entityNahid = Entity.entity(recABBA, "application/JSON");
		
		response = client.target("http://localhost:8080/RecordManagement/webservice/records")
						 .request()
						 .buildPost(entityNahid)
						 .invoke();
		
		System.out.println(response.readEntity(Record.class).getId());
		response.close();
		
		response = client.target("http://localhost:8080/RecordManagement/webservice/records")
						 .request()
						 .buildGet()
						 .invoke();
		
		List<Record> records = response.readEntity(new GenericType<List<Record>>(){});
		for(Record record: records) {
			System.out.println(record);
		}
		response.close();

	}

}
