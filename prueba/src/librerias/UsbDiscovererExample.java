package librerias;

import com.zebra.sdk.comm.ConnectionException;
 import com.zebra.sdk.printer.discovery.DiscoveredPrinterDriver;
 import com.zebra.sdk.printer.discovery.DiscoveredUsbPrinter;
 import com.zebra.sdk.printer.discovery.UsbDiscoverer;
 import com.zebra.sdk.printer.discovery.ZebraPrinterFilter;
 
 public class UsbDiscovererExample {
 
     public static void main(String[] args) {
 
         try {
             for (DiscoveredPrinterDriver printer : UsbDiscoverer.getZebraDriverPrinters()) {
                 System.out.println(printer);
             }
 
             for (DiscoveredUsbPrinter usbPrinter : UsbDiscoverer.getZebraUsbPrinters(new ZebraPrinterFilter())) {
                 System.out.println(usbPrinter);
             }
         } catch (ConnectionException e) {
             System.out.println("No se encontraron Impresoras conectadas: " );
         }
 
         System.out.println("Busqueda de impresoras finalizada");
     }
 }