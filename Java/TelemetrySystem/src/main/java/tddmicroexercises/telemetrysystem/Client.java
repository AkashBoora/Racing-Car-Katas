package tddmicroexercises.telemetrysystem;

public interface Client {
	public boolean getOnlineStatus();
	public void connect(String telemetryServerConnectionString);
	public void disconnect();
}
