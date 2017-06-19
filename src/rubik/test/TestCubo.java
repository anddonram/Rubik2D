package rubik.test;

import java.util.Arrays;
import java.util.Scanner;

import rubik.Cubo;
import rubik.CuboImpl;

public class TestCubo {
	public static void main(String[] args) {
		Cubo c = new CuboImpl();
		c.muestraMatrizOriginal();
		c.muestraMatriz();
		Scanner sc = new Scanner(System.in);
		while (!hasGanado(c)) {
			while (!leeMovimiento(c, sc))
				;
			c.muestraMatriz();
		}
		System.out.println("Has ganado!!!!");
		sc.close();
	}

	private static boolean leeMovimiento(Cubo c, Scanner sc) {
		boolean res = true;
		String s = sc.nextLine();
		if (s.equals("0"))
			c.rotacionFrenteAgujas();
		else if (s.equals("1"))
			c.rotacionDerechaAgujas();
		else if (s.equals("2"))
			c.rotacionFondoAgujas();
		else if (s.equals("3"))
			c.rotacionIzquierdaAgujas();
		else if (s.equals("4"))
			c.rotacionArribaAgujas();
		else if (s.equals("5"))
			c.rotacionAbajoAgujas();
		else if (s.equals("-0"))
			for (int i = 0; i < 3; i++)
				c.rotacionFrenteAgujas();
		else if (s.equals("-1"))
			for (int i = 0; i < 3; i++)
				c.rotacionDerechaAgujas();
		else if (s.equals("-2"))
			for (int i = 0; i < 3; i++)
				c.rotacionFondoAgujas();
		else if (s.equals("-3"))
			for (int i = 0; i < 3; i++)
				c.rotacionIzquierdaAgujas();
		else if (s.equals("-4"))
			for (int i = 0; i < 3; i++)
				c.rotacionArribaAgujas();
		else if (s.equals("-5"))
			for (int i = 0; i < 3; i++)
				c.rotacionAbajoAgujas();
		else if (s.equals("exit"))
			System.exit(0);
		else {
			System.out.println("No se pudo leer el movimiento");
			res = false;
		}
		return res;
	}

	private static boolean hasGanado(Cubo c) {
		return Arrays.deepEquals(c.getMatriz(), CuboImpl.ORIGINAL);
	}
}
