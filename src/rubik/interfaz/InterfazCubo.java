package rubik.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import rubik.Cubo;
import rubik.CuboImpl;

public class InterfazCubo extends JFrame {
	private static final long serialVersionUID = 1L;
	public static List<Color> colores = new ArrayList<Color>();

	public InterfazCubo() {
		super("Rubik");
		colores.add(Color.RED);
		colores.add(Color.BLUE);
		colores.add(Color.GREEN);
		colores.add(Color.YELLOW);
		colores.add(Color.WHITE);
		colores.add(Color.ORANGE);
		PanelCubo pCubo = new PanelCubo();
		add(pCubo);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class PanelCubo extends JPanel {
		private static final long serialVersionUID = 2L;
		private int nMovs = 0;
		private Cubo cubo = new CuboImpl();
		private JButton[] botones = new JButton[9];
		private BotonRotar[] rotadores = new BotonRotar[8];
		private BotonVista[] vista = new BotonVista[4];

		private void colorea(int i) {
			int cont = 0;
			for (int f = 3; f < 6; f++)
				for (int c = i; c < 3 + i; c++)
					botones[cont++]
							.setBackground(colores.get(cubo.getMatriz()[f][c]));
		}

		public PanelCubo() {
			super(new BorderLayout());
			JPanel jpc = new JPanel(new GridLayout(3, 3));
			add(jpc, BorderLayout.CENTER);
			for (int i = 0; i < 9; i++) {
				JButton boton = new JButton();
				boton.setEnabled(false);
				jpc.add(boton);
				botones[i] = boton;
				colorea(0);
			}
			rotadores[0] = new BotonRotar(0);
			add(rotadores[0], BorderLayout.NORTH);
			rotadores[1] = new BotonRotar(1);
			add(rotadores[1], BorderLayout.NORTH);
			rotadores[2] = new BotonRotar(2);
			add(rotadores[2], BorderLayout.EAST);
			rotadores[3] = new BotonRotar(3);
			add(rotadores[3], BorderLayout.EAST);
			rotadores[4] = new BotonRotar(4);
			add(rotadores[4], BorderLayout.SOUTH);
			rotadores[5] = new BotonRotar(5);
			add(rotadores[5], BorderLayout.SOUTH);
			rotadores[6] = new BotonRotar(6);
			add(rotadores[6], BorderLayout.WEST);
			rotadores[7] = new BotonRotar(7);
			add(rotadores[7], BorderLayout.WEST);
			vista[0] = new BotonVista(0);
			add(vista[0], BorderLayout.NORTH);
			vista[1] = new BotonVista(1);
			add(vista[1], BorderLayout.EAST);
			vista[2] = new BotonVista(2);
			add(vista[2], BorderLayout.SOUTH);
			vista[3] = new BotonVista(3);
			add(vista[3], BorderLayout.WEST);
		}
	}
}
