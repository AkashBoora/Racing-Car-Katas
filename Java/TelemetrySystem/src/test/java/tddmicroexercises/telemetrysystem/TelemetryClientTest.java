package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TelemetryClientTest {
	@Test
	public void telemetryClientTest(){
		Client client = new TelemetryClient();
		Assertions.assertEquals(false,client.getOnlineStatus());
		client.connect("*111#");
		Assertions.assertEquals(true,client.getOnlineStatus());
		client.disconnect();
		Assertions.assertEquals(false,client.getOnlineStatus());
	}

	@Test
	public void telemetryClientConnectionFailure(){
		Client client = new TelemetryClient();
		try {
			client.connect("");
		}catch (IllegalArgumentException e){
			Assertions.assertEquals("telemetryServerConnectionString should not be empty or null",e.getMessage());
		}

	}
}
