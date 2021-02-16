package librerias;

import javax.swing.JOptionPane;

import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.discovery.*;

public class BuscarImpresora {

	
	
	public void  search() {
		  try {
	             for (DiscoveredPrinterDriver printer : UsbDiscoverer.getZebraDriverPrinters()) {
	                 System.out.println(printer);
	             }
	 
	             for (DiscoveredUsbPrinter usbPrinter : UsbDiscoverer.getZebraUsbPrinters(new ZebraPrinterFilter())) {
	                 System.out.println(usbPrinter);
	             }
	           
	             
	             
	         } catch (ConnectionException e) {
	             //JOptionPane.showMessageDialog(null, "No se encontraron impreoras conectadas"+ "Por favor conecta la Impresora" );
	             JOptionPane.showMessageDialog(null, "No se encontraron Impresoras Conectadas", "Error en busqueda", 0);
	         }
	}
}