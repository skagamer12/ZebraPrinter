package librerias;

import java.util.ArrayList;
import java.util.List;

import com.zebra.sdk.printer.discovery.DiscoveredPrinter;
import com.zebra.sdk.printer.discovery.DiscoveryException;
import com.zebra.sdk.printer.discovery.DiscoveryHandler;
import com.zebra.sdk.printer.discovery.NetworkDiscoverer;

public class NetworkDiscovererExample {
    public static void main(String[] args) {
        DiscoveryHandler discoveryHandler = new DiscoveryHandler() {
            List<DiscoveredPrinter> printers = new ArrayList<DiscoveredPrinter>();

            public void foundPrinter(DiscoveredPrinter printer) {
                printers.add(printer);
            }

            public void discoveryFinished() {
                for (DiscoveredPrinter printer : printers) {
                    System.out.println(printer);
                }
                System.out.println("Discovered " + printers.size() + " printers.");
            }

            public void discoveryError(String message) {
                System.out.println("Ocurrio un error buscando impresoras  : " + message);
            }
        };
        try {
            System.out.println("Comenzando busqueda de impresoras .");
            NetworkDiscoverer.findPrinters(discoveryHandler);
        } catch (DiscoveryException e) {
            e.printStackTrace();
        }
    }
}