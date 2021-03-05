package librerias;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class ButtonCellEditor extends AbstractCellEditor implements TableCellEditor {

 /** Componente que estamos editando. */
 private Component currentValue;

 @Override
 public Component getTableCellEditorComponent(final JTable table, Object value, boolean isSelected, final int row, int column) {

  JButton button = null;



  currentValue = button;

  return button;
 }

 @Override
 public Object getCellEditorValue() {
  return currentValue;
 }

}