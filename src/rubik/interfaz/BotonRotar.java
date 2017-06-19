package rubik.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BotonRotar extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	private int rot;

	public BotonRotar(int i) {
		this.rot = i;
	}

	public void actionPerformed(ActionEvent e) {

	}

}
