package librerias;

import java.awt.FlowLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//import librerias.ButtonCellEditor;
//import librerias.ButtonCellRenderer;
//import librerias.MyTableModel;

public class MyTable extends JTable {
	
	JFrame frame;
	LoadDriver ld;
	JScrollPane sp;
 /**
  * Constructor.
  */
 public MyTable() {
	 
	frame=new JFrame();
	frame.setVisible(true);
	frame.setLayout(new FlowLayout());
	frame.setSize(500,500);
	
	sp= new JScrollPane(this);
  this.setRowHeight(30);

  

  String [] columnNames = new String[]{ "CANT", "Codigo", "descripcion", "Descripcion-2", "Origen", "Imprimir"};
        Object [][] data      = new Object[][]{
          {"5", "78AP-S", "bonito", "Barato", "0",false}
          };

        MyTableModel model = new MyTableModel(columnNames, data);

        // Establecemos el modelo
        this.setModel(model);

      
      
        frame.add(sp);
 }

}