package librerias;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;

//import com.zebra.sdk.comm.ConnectionException;

//import com.zebra.sdk.printer.discovery.DiscoveryException;

//import com.zebra.sdk.comm.ConnectionException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;


public class Principal implements ActionListener{
	
	JFrame frame;
	JButton bP; 
	JTable tabla;
	
	public ArrayList<JCheckBox> cuadritos = new ArrayList<JCheckBox>();
	
	ImageIcon icon = new ImageIcon("C:\\Users\\israel\\Desktop\\prueba\\images\\impresora.png");
	BuscarImpresora bi = new BuscarImpresora();
	LoadDriver ldDr ;
	
	
	public Principal() {
		// TODO Auto-generated constructor stub
		frame = new JFrame("IMPRESORA TICKETS");
		
		bP = new JButton("Buscar Productos");

		
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		bP.setBounds(10, 10, 10, 10);
		
		bP.addActionListener(this);
		
		frame.add(bP);
		//frame.add(tabla);
		frame.setIconImage(icon.getImage());
		
		
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Principal();
		//new LoadDriver();
		new Tablas();
		//new MyTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			//Boton realiza busqueda de impresora
		//frame.dispose();
		
		//new Tablas();
		new LoadDriver();
		
		
		
		
	}

}
