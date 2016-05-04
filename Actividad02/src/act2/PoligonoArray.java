package act2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author frasco2001
 *
 */
public class PoligonoArray extends PoligonoAbstract {
	Punto[] poligono;

	/**
	 * 
	 * @param x
	 */
	public PoligonoArray(Punto[] x) {
		this.poligono = x;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "[Poligono=" + Arrays.toString(poligono) + "]";
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public Punto[] getPoligono() {
		return poligono;
	}

	/**
	 * 
	 * @param poligono
	 */
	@Override
	public void setPoligono(Punto[] poligono) {
		this.poligono = poligono;
	}

}
