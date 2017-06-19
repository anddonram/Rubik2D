package rubik;

import java.util.Arrays;
import java.util.Random;

/*posicion de los centros
 * 			2
 * 1	0front/5fond	3
 * 			4
 * */
//la posición de los colores de los vértices es desde frente, la esquina inferior izquierda
//idem para aristas (de frente, la de abajo)
/*posicion de los vertices
 * 2/6		3/7	
 * 				
 * 0/4		1/5
 * */
/*posicion de las aristas
 * 		6		3/11	7
 * 		1/9				2/10
 *		4		0/8		5
 * */
public class CuboImpl implements Cubo {
	private Integer[][] matriz;
	public static final Integer[][] ORIGINAL = {
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 },
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 },
			{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 },
			{ 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3 },
			{ 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3 },
			{ 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, };

	public CuboImpl() {
		matriz = new Integer[][] { { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 },
				{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 },
				{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 },
				{ 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3 },
				{ 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3 },
				{ 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3 },
				{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
				{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
				{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, };
		desordena();

	}

	public Integer[][] getMatriz() {
		return matriz;
	}

	public void rotacionFrenteAgujas() {
		giraMatriz(0);

	}

	public void rotacionDerechaAgujas() {
		giraMatriz(1);
	}

	public void rotacionFondoAgujas() {
		giraMatriz(2);

	}

	public void rotacionIzquierdaAgujas() {
		giraMatriz(3);

	}

	public void rotacionArribaAgujas() {
		int aux0 = matriz[3][0];
		int aux1 = matriz[3][1];
		int aux2 = matriz[3][2];
		for (int i = 3; i < matriz[3].length; i++)
			matriz[3][i - 3] = matriz[3][i];
		matriz[3][9] = aux0;
		matriz[3][10] = aux1;
		matriz[3][11] = aux2;

		int ver = matriz[0][0];
		int aris = matriz[0][1];
		matriz[0][0] = matriz[2][0];
		matriz[0][1] = matriz[1][0];
		matriz[2][0] = matriz[2][2];
		matriz[1][0] = matriz[2][1];
		matriz[2][2] = matriz[0][2];
		matriz[2][1] = matriz[1][2];
		matriz[1][2] = aris;
		matriz[0][2] = ver;
		copiaMatriz(0);

	}

	public void rotacionAbajoAgujas() {
		int aux0 = matriz[5][9];
		int aux1 = matriz[5][10];
		int aux2 = matriz[5][11];
		for (int i = matriz[5].length - 1; i >= 3; i--)
			matriz[5][i] = matriz[5][i - 3];
		matriz[5][0] = aux0;
		matriz[5][1] = aux1;
		matriz[5][2] = aux2;

		int ver = matriz[6][0];
		int aris = matriz[6][1];
		matriz[6][0] = matriz[8][0];
		matriz[6][1] = matriz[7][0];
		matriz[8][0] = matriz[8][2];
		matriz[7][0] = matriz[8][1];
		matriz[8][2] = matriz[6][2];
		matriz[8][1] = matriz[7][2];
		matriz[7][2] = aris;
		matriz[6][2] = ver;
		copiaMatriz(0);

	}

	private void giraMatriz(Integer i) {
		int ver = matriz[3][3 * i];
		int aris = matriz[3][1 + 3 * i];
		matriz[3][3 * i] = matriz[5][3 * i];
		matriz[3][1 + 3 * i] = matriz[4][3 * i];
		matriz[4][3 * i] = matriz[5][1 + 3 * i];
		matriz[5][3 * i] = matriz[5][2 + 3 * i];
		matriz[5][1 + 3 * i] = matriz[4][2 + 3 * i];
		matriz[5][2 + 3 * i] = matriz[3][2 + 3 * i];
		matriz[4][2 + 3 * i] = aris;
		matriz[3][2 + 3 * i] = ver;

		int aux0 = matriz[3][(3 + 3 * i) % 12];
		int aux1 = matriz[4][(3 + 3 * i) % 12];
		int aux2 = matriz[5][(3 + 3 * i) % 12];
		matriz[3][(3 + 3 * i) % 12] = matriz[2][3 * i];
		matriz[4][(3 + 3 * i) % 12] = matriz[2][1 + 3 * i];
		matriz[5][(3 + 3 * i) % 12] = matriz[2][2 + 3 * i];
		matriz[2][3 * i] = matriz[5][(11 + 3 * i) % 12];
		matriz[2][1 + 3 * i] = matriz[4][(11 + 3 * i) % 12];
		matriz[2][2 + 3 * i] = matriz[3][(11 + 3 * i) % 12];
		matriz[3][(11 + 3 * i) % 12] = matriz[6][3 * i];
		matriz[4][(11 + 3 * i) % 12] = matriz[6][1 + 3 * i];
		matriz[5][(11 + 3 * i) % 12] = matriz[6][2 + 3 * i];
		matriz[6][3 * i] = aux2;
		matriz[6][1 + 3 * i] = aux1;
		matriz[6][2 + 3 * i] = aux0;
		copiaMatriz(i);
	}

	private void desordena() {
		Random rnd = new Random();
		for (int i = 0; i < 20; i++) {
			switch (rnd.nextInt(6)) {
			case 0:
				rotacionArribaAgujas();
				break;
			case 1:
				rotacionFrenteAgujas();
				break;
			case 2:
				rotacionIzquierdaAgujas();
				break;
			case 3:
				rotacionFondoAgujas();
				break;
			case 4:
				rotacionDerechaAgujas();
				break;
			case 5:
				rotacionAbajoAgujas();
				break;
			}
		}
	}

	private void copiaMatriz(Integer i) {
		switch (i) {
		case 0:
			matriz[2][5] = matriz[2][6] = matriz[0][9] = matriz[0][2];
			matriz[1][5] = matriz[2][7] = matriz[1][9] = matriz[0][1];
			matriz[0][5] = matriz[2][8] = matriz[2][9] = matriz[0][0];

			matriz[0][3] = matriz[0][8] = matriz[2][11] = matriz[2][0];
			matriz[1][3] = matriz[0][7] = matriz[1][11] = matriz[2][1];
			matriz[2][3] = matriz[0][6] = matriz[0][11] = matriz[2][2];

			matriz[0][4] = matriz[1][8] = matriz[2][10] = matriz[1][0];
			matriz[2][4] = matriz[1][6] = matriz[0][10] = matriz[1][2];

			matriz[8][3] = matriz[8][8] = matriz[6][11] = matriz[6][0];
			matriz[8][4] = matriz[7][8] = matriz[6][10] = matriz[7][0];
			matriz[8][5] = matriz[6][8] = matriz[6][9] = matriz[8][0];

			matriz[7][3] = matriz[8][7] = matriz[7][11] = matriz[6][1];
			matriz[7][5] = matriz[6][7] = matriz[7][9] = matriz[8][1];

			matriz[6][3] = matriz[8][6] = matriz[8][11] = matriz[6][2];
			matriz[6][4] = matriz[7][6] = matriz[8][10] = matriz[7][2];
			matriz[6][5] = matriz[6][6] = matriz[8][9] = matriz[8][2];
			break;
		case 1:
			matriz[2][6] = matriz[0][9] = matriz[0][2] = matriz[2][5];
			matriz[2][7] = matriz[1][9] = matriz[0][1] = matriz[1][5];
			matriz[2][8] = matriz[2][9] = matriz[0][0] = matriz[0][5];

			matriz[0][8] = matriz[2][11] = matriz[2][0] = matriz[0][3];
			matriz[0][7] = matriz[1][11] = matriz[2][1] = matriz[1][3];
			matriz[0][6] = matriz[0][11] = matriz[2][2] = matriz[2][3];

			matriz[1][8] = matriz[2][10] = matriz[1][0] = matriz[0][4];
			matriz[1][6] = matriz[0][10] = matriz[1][2] = matriz[2][4];

			matriz[8][8] = matriz[6][11] = matriz[6][0] = matriz[8][3];
			matriz[7][8] = matriz[6][10] = matriz[7][0] = matriz[8][4];
			matriz[6][8] = matriz[6][9] = matriz[8][0] = matriz[8][5];

			matriz[8][7] = matriz[7][11] = matriz[6][1] = matriz[7][3];
			matriz[6][7] = matriz[7][9] = matriz[8][1] = matriz[7][5];

			matriz[8][6] = matriz[8][11] = matriz[6][2] = matriz[6][3];
			matriz[7][6] = matriz[8][10] = matriz[7][2] = matriz[6][4];
			matriz[6][6] = matriz[8][9] = matriz[8][2] = matriz[6][5];
			break;
		case 2:
			matriz[2][5] = matriz[0][9] = matriz[0][2] = matriz[2][6];
			matriz[1][5] = matriz[1][9] = matriz[0][1] = matriz[2][7];
			matriz[0][5] = matriz[2][9] = matriz[0][0] = matriz[2][8];

			matriz[0][3] = matriz[2][11] = matriz[2][0] = matriz[0][8];
			matriz[1][3] = matriz[1][11] = matriz[2][1] = matriz[0][7];
			matriz[2][3] = matriz[0][11] = matriz[2][2] = matriz[0][6];

			matriz[0][4] = matriz[2][10] = matriz[1][0] = matriz[1][8];
			matriz[2][4] = matriz[0][10] = matriz[1][2] = matriz[1][6];

			matriz[8][3] = matriz[6][11] = matriz[6][0] = matriz[8][8];
			matriz[8][4] = matriz[6][10] = matriz[7][0] = matriz[7][8];
			matriz[8][5] = matriz[6][9] = matriz[8][0] = matriz[6][8];

			matriz[7][3] = matriz[7][11] = matriz[6][1] = matriz[8][7];
			matriz[7][5] = matriz[7][9] = matriz[8][1] = matriz[6][7];

			matriz[6][3] = matriz[8][11] = matriz[6][2] = matriz[8][6];
			matriz[6][4] = matriz[8][10] = matriz[7][2] = matriz[7][6];
			matriz[6][5] = matriz[8][9] = matriz[8][2] = matriz[6][6];
			break;
		case 3:
			matriz[2][5] = matriz[2][6] = matriz[0][2] = matriz[0][9];
			matriz[1][5] = matriz[2][7] = matriz[0][1] = matriz[1][9];
			matriz[0][5] = matriz[2][8] = matriz[0][0] = matriz[2][9];

			matriz[0][3] = matriz[0][8] = matriz[2][0] = matriz[2][11];
			matriz[1][3] = matriz[0][7] = matriz[2][1] = matriz[1][11];
			matriz[2][3] = matriz[0][6] = matriz[2][2] = matriz[0][11];

			matriz[0][4] = matriz[1][8] = matriz[1][0] = matriz[2][10];
			matriz[2][4] = matriz[1][6] = matriz[1][2] = matriz[0][10];

			matriz[8][3] = matriz[8][8] = matriz[6][0] = matriz[6][11];
			matriz[8][4] = matriz[7][8] = matriz[7][0] = matriz[6][10];
			matriz[8][5] = matriz[6][8] = matriz[8][0] = matriz[6][9];

			matriz[7][3] = matriz[8][7] = matriz[6][1] = matriz[7][11];
			matriz[7][5] = matriz[6][7] = matriz[8][1] = matriz[7][9];

			matriz[6][3] = matriz[8][6] = matriz[6][2] = matriz[8][11];
			matriz[6][4] = matriz[7][6] = matriz[7][2] = matriz[8][10];
			matriz[6][5] = matriz[6][6] = matriz[8][2] = matriz[8][9];
			break;
		}
	}

	public void muestraMatriz() {
		System.out.println("Inicio matriz");
		for (Integer[] fila : getMatriz())
			System.out.println(Arrays.toString(fila));
		System.out.println("Fin matriz");
	}
	public void muestraMatrizOriginal() {
		System.out.println("Inicio matriz original");
		for (Integer[] fila : ORIGINAL)
			System.out.println(Arrays.toString(fila));
		System.out.println("Fin matriz original");
	}
	public String toString() {
		return Arrays.deepToString(matriz);
	}

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Cubo) {
			Cubo c = (Cubo) o;
			res = Arrays.deepEquals(matriz, c.getMatriz());
		}
		return res;
	}

	public int hashCode() {
		return matriz.hashCode();
	}
}
