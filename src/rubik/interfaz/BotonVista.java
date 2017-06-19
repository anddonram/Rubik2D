package rubik.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BotonVista extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;
	private int vista;

	public BotonVista(int i) {
		this.vista = i;
	}

	public void actionPerformed(ActionEvent arg0) {

	}

}
