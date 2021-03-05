package librerias;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

 /** Nombre de las columnas. */
 private String[] columnNames;
 /** Datos. */
 private Object[][] data;

 /**
  * Constructor.
  * @param columnNames Nombres de las columnas
  * @param data Datos de la tabla
  */
 public MyTableModel(String[] columnNames, Object[][] data) {
  this.columnNames = columnNames;
  this.data = data;
 }

 @Override
 public String getColumnName(int column) {
  // Nombre de las columnas para la cabecera
  return columnNames[column];
 }

 @Override
 public int getRowCount() {
  // Devuelve el número de filas
  return data != null ? data.length : 0;
 }

 @Override
 public int getColumnCount() {
  // Devuelve el número de columnas
  return columnNames.length;
 }

 /**
  * Nos devolverá la clase que contiene cada columna,
  * es necesario para trabajar correctamente con los componentes
  * que mostraremos en la tabla.
  */
 @Override
 public Class getColumnClass(int columnIndex) {
  Class clazz = Object.class;

  Object aux = getValueAt(0, columnIndex);
  if (aux != null) {
   clazz = aux.getClass();
  }

  return clazz;
 }

 @Override
 public Object getValueAt(int rowIndex, int columnIndex) {
  // Devuelve el valor que se debe mostrar en la tabla en cada celda
  return data[rowIndex][columnIndex];
 }

    @Override
 public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
     // Si queremos que la tabla sea editable deberemos establecer estos valores
     data[rowIndex][columnIndex] = aValue;
     fireTableCellUpdated(rowIndex, columnIndex);
    }

 @Override
 public boolean isCellEditable(int rowIndex, int columnIndex) {
  // Permitimos editar todas las celdas de la tabla
  return true;
 }

 /**
  * Nos servira para limpiar la información de una fila
  * @param row
  */
 public void reset(int row) {

  for (int i = 0; i < data[row].length - 1; i++) {
   // Para las columnas con String
   if (getColumnClass(i) == String.class) {
    setValueAt("", row, i);
   } else if(getColumnClass(i) == Boolean.class) {
    setValueAt(false, row, i);
   }
  }

 }

}
