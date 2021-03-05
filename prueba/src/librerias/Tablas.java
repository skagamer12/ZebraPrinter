package librerias;

import java.awt.FlowLayout;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tablas {

	JFrame frame;
	JTable tabla;
	JScrollPane sp;
	DefaultTableModel model = new DefaultTableModel();
	
	
	//DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();

	public Tablas(){
		tabla = new JTable(model);
		sp =new JScrollPane(tabla);
		frame = new JFrame();
		 tabla.setBounds(12, 12, 100, 100);
		 sp.setBounds(100, 100, 500, 500);
		 frame.add(tabla);
		 frame.setVisible(true);
		 frame.setSize(500, 500);
		 frame.setLayout(new FlowLayout());
		
		String [] columNames = new String[] {"CANT","Codigo","Descripcion","Descripcion-2","Origen","Imprimir",};
		
		String[] data = {"1","1","1","1","1","1"};
			/*for(int i=0;i<=5;i++) {
				
			}*/
		model.addColumn(columNames);
		 model.addRow(data);
		
		 
		 
		
	
	}
}
