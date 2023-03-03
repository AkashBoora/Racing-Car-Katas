package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TelemetryConnectionTest {
	@Test
	public void validConnectionTest() {
		Connection connection = new TelemetryConnection(new Random(42));
		connection.send(TelemetryConnection.DIAGNOSTIC_MESSAGE);
		String recieivedMessage = connection.receive();
		Assertions.assertTrue(recieivedMessage.contains("LAST TX rate"));
	}
	@Test
	public void sendingConnectionWithoutMessage() {
		Connection connection = new TelemetryConnection(new Random(42));
		try {
			connection.send("");
		}catch (IllegalArgumentException e){
			Assertions.assertEquals("Message should not be empty.",e.getMessage());
		}
	}
	@Test
	public void sendingConnectionWithMessage() {
		Connection connection = new TelemetryConnection(new Random(42));
		connection.send("Test");
		String recieivedMessage = connection.receive();
		Assertions.assertEquals(recieivedMessage.length(),240);
	}
}
