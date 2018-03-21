package e4b.InciManager_e4b;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import asw.database.entities.Incidence;
import asw.producers.KafkaProducer;


public class JsonTest {

	@Test
	public void test() {
		Incidence o = new Incidence();
		KafkaProducer kp = new KafkaProducer();
		String JSON="";
		try {
			JSON = kp.IncidenceToJson(o);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			fail();
		}
		
		try {
			assertEquals(kp.JsonToIncidence(JSON), o);
		} catch (JsonParseException e) {
			e.printStackTrace();
			fail();
		} catch (JsonMappingException e) {
			e.printStackTrace();
			fail();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		
	}

}
