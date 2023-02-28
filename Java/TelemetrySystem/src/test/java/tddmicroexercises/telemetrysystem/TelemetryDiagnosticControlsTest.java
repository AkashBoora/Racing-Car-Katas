package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Test;

public class TelemetryDiagnosticControlsTest
{
    
	@Test
    public void checkTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
		TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls();
		telemetryDiagnosticControls.checkTransmission();
    }
}
