package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls
{
    private final String DiagnosticChannelConnectionString = "*111#";
    private final TelemetryClient telemetryClient;
	private String diagnosticInfo = "";

    public TelemetryDiagnosticControls(TelemetryClient telemetryClient) {
            this.telemetryClient = telemetryClient;
    }

    public String getDiagnosticInfo(){
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo){
        this.diagnosticInfo = diagnosticInfo;
    }

    public void checkTransmission() throws Exception {
        diagnosticInfo = "";
        telemetryClient.disconnect();
        int retryLeft = 3;
        while (!telemetryClient.getOnlineStatus() && retryLeft > 0) {
            telemetryClient.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if(!telemetryClient.getOnlineStatus())
        {
            throw new Exception("Unable to connect.");
        }
        Connection connection = telemetryClient.getTelemetryConnection();
        connection.send(TelemetryConnection.DIAGNOSTIC_MESSAGE);
        connection.receive();
    }
}
