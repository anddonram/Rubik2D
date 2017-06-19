package rubik;

public interface Cubo {
	public void muestraMatriz();

	public void muestraMatrizOriginal();

	public void rotacionAbajoAgujas();

	public void rotacionArribaAgujas();

	public void rotacionFrenteAgujas();

	public void rotacionDerechaAgujas();

	public void rotacionFondoAgujas();

	public void rotacionIzquierdaAgujas();

	public Integer[][] getMatriz();
}
