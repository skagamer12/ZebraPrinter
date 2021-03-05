package librerias;

import java.util.Map;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.TcpConnection;
import com.zebra.sdk.printer.discovery.DiscoveryPacketDecodeException;
import com.zebra.sdk.printer.discovery.DiscoveryUtil;

public class DiscoveryUtilExample {
    public static void main(String[] args) {
        // Instantiate connection for ZPL TCP port at given address
        Connection connection = new TcpConnection("192.10.10.128", TcpConnection.DEFAULT_ZPL_TCP_PORT);

        try {
            // Open the connection - physical connection is established here.
            connection.open();

            Map<String, String> discoveryData = DiscoveryUtil.getDiscoveryDataMap(connection);

            System.out.println("The printer's firmware version is: " + discoveryData.get("FIRMWARE_VER"));

        } catch (ConnectionException e) {
            // Handle communications error here.
            e.printStackTrace();
        } catch (DiscoveryPacketDecodeException e) {
            e.printStackTrace();
        } finally {
            // Close the connection to release resources.
            try {
                connection.close();
            } catch (ConnectionException e) {
                e.printStackTrace();
            }
        }
    }
}
