package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class TelemetryClient implements Client{

	private boolean onlineStatus;
	private final Random connectionEventsSimulator;

	private TelemetryConnection telemetryConnection;
	public TelemetryClient() {
		connectionEventsSimulator =  new Random(42);
	}

	public TelemetryConnection getTelemetryConnection() {
		return telemetryConnection;
	}

	public boolean getOnlineStatus()
	{
		return onlineStatus;
	}
	public void connect(String telemetryServerConnectionString)
	{
		if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString))
		{
			throw new IllegalArgumentException("telemetryServerConnectionString should not be empty or null");
		}

		// simulate the operation on a real modem
		this.telemetryConnection = new TelemetryConnection(connectionEventsSimulator);
		onlineStatus = connectionEventsSimulator.nextInt(10) <= 8;
	}

	public void disconnect() {
		telemetryConnection = null;
		onlineStatus = false;
	}

}
