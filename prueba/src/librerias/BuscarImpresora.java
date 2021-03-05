package librerias;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.JOptionPane;

import com.zebra.sdk.comm.Connection;
//import com.zebra.sdk.comm.TcpConnection;
//import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.comm.TcpConnection;
import com.zebra.sdk.printer.discovery.*;

//import com.zebra.sdk.printer.discovery.NetworkDiscoverer.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.io.*;
import java.net.*;

public class BuscarImpresora {
 
	PrintService printer;
	//Buscar impresoras //Posible que funcione
	public PrintService findPrintService(String printerName) {
		
		PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
		
		for (PrintService printService: printServices) {
			//System.out.println(printService.getName());

			if (printService.getName().trim().equals(printerName)) {
				System.out.println("Se encontro la impresora de ranulfo"+printerName);
				printer = printService;
				System.out.println("Seleccionaste"+printer);
				return printService;
			}
		}
		DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
		DocPrintJob pj = printer.createPrintJob();
		String ss=new String("Prueba de Impresion");
		byte[] bytes;
		bytes=ss.getBytes();
		Doc doc=new SimpleDoc(bytes,flavor,null);
		try {
			  //Mandamos a impremir el documento
			  pj.print(doc, null);
			}
			catch (PrintException e) {
			  System.out.println("Error al imprimir: "+e.getMessage());
			}
		
		return null;
	}
	
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
	
	public void findPrinter()  {
		
		
		//System.out.println("Esta funcionando esta wea");
		try {
			System.out.println("Buscando");
			NetworkDiscoverer.subnetSearch(discoveryhandler, "192.10.10.128");
		}catch(DiscoveryException e) {
			System.out.println("No funciono esta wea");
		}
	
		
	}
	
	 
	
	DiscoveryHandler discoveryhandler = new DiscoveryHandler() {
		//Lista de impresoras encontradas
		List <DiscoveredPrinter> printers = new ArrayList<DiscoveredPrinter>();
		
		
		//Cuando se encuentren impresoras se invocara este metodo
	@Override
	public void foundPrinter(DiscoveredPrinter printer) {
		// TODO Auto-generated method stub
		printers.add(printer);
		System.out.println("Impresora encontrada"+ printer);
		
	}
	
	
		//El metodo se invocara cuando finalize la busqueda
	@Override
	public void discoveryFinished() {
		// TODO Auto-generated method stub
		System.out.println("La busqueda ha finalizado" + printers.toString());
		if(printers==null) {
			System.out.println("CHales no hay impresoras");
			
		}
	}
	
	//Si ocurre un error en la busqueda este metodo se invocara
	@Override
	public void discoveryError(String arg0) {
		// TODO Auto-generated method stub
		System.out.println("OCURRIO UN ERROR DURANTE LA BUSQUEDA");
	}

	
	
};
}