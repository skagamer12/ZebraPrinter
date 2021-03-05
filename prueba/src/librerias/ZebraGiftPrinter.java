package librerias;

import java.io.IOException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

public class ZebraGiftPrinter {

    public void getPrint(String zpl_data, String printer) throws IOException {
    	
    	//PrintService es la mpresora 
        PrintService myPrintService = findPrintService(printer);
        	//Crea un trabajo para imprimir
        DocPrintJob job = myPrintService.createPrintJob();
        	//Lenguaje en el que el trabajo sera enviado
        DocFlavor flvr = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        	//"documento" que sera enviado para imprimir
        Doc doc = new SimpleDoc(zpl_data.getBytes(), flvr, null);
        try {
        		//Imprime
            job.print(doc, null);
            System.out.println("Print Done!");
        } catch (PrintException e) {
            System.out.println(e.getCause());
        }
    }

    private static PrintService findPrintService(String printerName) {
    		
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(
                null, null);
        for (PrintService printService : printServices) {
            if (printService.getName().equals(printerName)) {
                System.out.println(printService);
                return printService;
            }
        }
        return null;
    }

    
}

//Codigo para llamar a imprimir
/*if(e.getSource()==bP) {
String g = " ^XA\r\n"
   		+ "^FO150,200^AQN,60,50^FDPRUEBA de IMPRESORA^FS \r\n"
   		+ "^FO150,300^AQN,60,50^FDPRUEBA de IMPRESORA^FS \r\n"
   		+ "^FO150,400^AQN,60,50^FDPRUEBA de IMPRESORA^FS \r\n"
   		+ "^FO150,500^AQN,60,50^FDPRUEBA de IMPRESORA^FS \r\n"
   		+ "^XZ";
   ZebraGiftPrinter gift = new ZebraGiftPrinter();
   try {
		gift.getPrint(g, "\\\\mtr-almacen\\ZDesigner GC420t (EPL)");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}    // name of network printer

}*/
