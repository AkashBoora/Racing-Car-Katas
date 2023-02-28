package tddmicroexercises.telemetrysystem;

public interface Connection {
	public void send(String message);
	public String receive();

}
