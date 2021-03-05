package librerias;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//import com.sun.tools.javac.comp.Check;



public class LoadDriver implements ActionListener   {
	 String g ="^XA\r\n";
	 String f = "\r\n^XZ";
	
	 Object[][] datos;
	String CANT;
	String Codigo;
	String descripcion;
	String descripcion2;
	String Origen;
	String cubo = "^FO10,10^GB790,1200,3^FS";
	String S;
	int i =0;
	ResultSet RS;
	JButton b;
	JScrollPane sp;
	
	//NuevoFrame
	JFrame frame2;
	JFrame table;
	JTable tabla;
	 ArrayList<JCheckBox> cuadritos = new ArrayList<JCheckBox>();
	DefaultTableModel model= new DefaultTableModel();
	
			//Constructor
	public LoadDriver() {
		table = new JFrame();
		tabla = new JTable();
		frame2 = new JFrame();
		sp= new JScrollPane(tabla);
		frame2.setSize(500,500);
		frame2.setVisible(true);
		b = new JButton("Crear Tabla");
		b.addActionListener(this);
		frame2.add(b);
		table.setSize(500, 500);
	
		
		
		
		String [] columnNames = new String[]{ "CANT", "Codigo", "descripcion", "Descripcion-2", "Origen", "Imprimir"};
			//Constructor
		
		try {
			//Obtener conection 
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.10.10.122:3306/productos", "Duy", "1234");
			//Crear un statement
			Statement stmt = conn.createStatement(); 
			//Ejecutar query
			 RS = stmt.executeQuery("SELECT * FROM facturas" );
			//Crear Checkbox por cada row del QUERY
			 
			 while(RS.next()  ) {
				 		//Guardar datos en un string
				 	CANT = RS.getString("CANT");
				 	Codigo = RS.getString("Codigo");
				 	descripcion = RS.getString("descripcion");
				 	descripcion2= RS.getString("descripcion-2");
				 	Origen = RS.getString("Origen");
				 	
				 	datos      = new Object[][]{
				          {CANT, Codigo, descripcion, descripcion2, Origen,false}
				          };
			         
				         
				 					
			}
			 
			}catch (Exception exc) {
				JOptionPane.showMessageDialog(null, "La conecixion no se pudo realizar", "Error de conecxion ", 0);
				exc.printStackTrace();
			}
		

	        // Establecemos el modelo
	        tabla.setModel(model);

	      
	      
	        table.add(sp);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//new MyTable();
		System.out.println(datos[0][1]);
		table.setVisible(true);
		System.out.println("creando tabla");
	}
	
}















