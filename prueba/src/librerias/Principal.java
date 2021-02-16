package librerias;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;


public class Principal implements ActionListener{
	
	JFrame frame;
	JButton bP; 
	ImageIcon icon = new ImageIcon("C:\\Users\\israel\\eclipse-workspace\\prueba\\images\\impresora.png");
	BuscarImpresora bi = new BuscarImpresora();
	
	
	
	public Principal() {
		// TODO Auto-generated constructor stub
		frame = new JFrame("IMPRESORA TICKETS");
		frame.setIconImage(icon.getImage());
		bP = new JButton();
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		bP.setSize(100, 50);
		bP.addActionListener(this);
		
		frame.add(bP);
		
		 
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Principal principal = new Principal();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		bi.search();
		
		
		
	}

}
