package act2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

import utils.DoublyLinkedList;

public class PoligonoDobleColaEnlazada extends PoligonoAbstract {

	private static final int MAX = 100;
	protected DoublyLinkedList<Punto> vertices;

	public PoligonoDobleColaEnlazada(DoublyLinkedList<Punto> vertices) {
		this.vertices = vertices;
	}

	public PoligonoDobleColaEnlazada(Punto[] x) {
		this.vertices = new DoublyLinkedList<Punto>();
		for (Punto punto : x) {
			this.vertices.add(punto);
		}
	}

	public PoligonoDobleColaEnlazada() {
		this.vertices = new DoublyLinkedList<Punto>();
	}

	public boolean addVertice(Punto p) {
		if (this.vertices.size() >= MAX)
			return false;
		this.vertices.add(p);
		return true;
	}

	public LinkedList<Punto[]> triangulacion() {
		LinkedList<Punto[]> triangulos = new LinkedList<Punto[]>();
		DoublyLinkedList<Punto> verticesC = (DoublyLinkedList<Punto>) vertices.clone();
		ListIterator<Punto> it = verticesC.iterator();
		ListIterator<Punto> itAux;
		Punto current, izq, dch, aux;
		boolean triangle;
		while (verticesC.size() != 3) {
			triangle = true;
			if (!it.hasNext())
				it = verticesC.iterator();
			current = it.next();
			it.previous();
			if (!it.hasPrevious()) {
				izq = verticesC.getLast();
				it.next();
			} else {
				izq = it.previous();
				it.next();
				it.next();
			}
			if (!it.hasNext())
				dch = verticesC.getFirts();
			else {
				dch = it.next();
				it.previous();
			}
			if (!this.area_triangulo_signo(izq, current, dch))
				continue;
			itAux = verticesC.iterator();
			while (itAux.hasNext()) {
				aux = itAux.next();
				if (aux.equals(izq) || aux.equals(dch) || aux.equals(current))
					continue;
				if (this.area_triangulo_signo(izq, current, aux) && this.area_triangulo_signo(current, dch, aux)
						&& this.area_triangulo_signo(dch, izq, aux)) {
					triangle = false;
					break;
				}
			}
			if (!triangle)
				continue;
			Punto[] triangulo = { izq, current, dch };
			triangulos.add(triangulo);
			it.previous();
			it.remove();
		}
		it = verticesC.iterator();
		Punto[] triangulo = { it.next(), it.next(), it.next() };
		triangulos.add(triangulo);
		return triangulos;
	}

	private boolean area_triangulo_signo(Punto a, Punto b, Punto c) {
		if ((((a.getX() * b.getY()) - (a.getY() * b.getX()) + (a.getY() * c.getX()) - (a.getX() * c.getY())
				+ (b.getX() * c.getY()) - (c.getX() * b.getY())) / 2.0) <= 0)
			return false;
		return true;
	}

	public Punto[] toArray() {
		Punto[] toReturn = new Punto[this.vertices.size()];
		ListIterator<Punto> it = this.vertices.iterator();
		int i = 0;
		while (it.hasNext()) {
			toReturn[i] = it.next();
			i++;
		}
		return toReturn;
	}

	@Override
	public String toString() {
		return "[Poligono=" + Arrays.toString(this.toArray()) + "]";
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public Punto[] getPoligono() {
		return this.toArray();
	}

	/**
	 * 
	 * @param poligono
	 */
	@Override
	public void setPoligono(Punto[] poligono) {
		this.vertices = new DoublyLinkedList<Punto>();
		for (Punto punto : poligono) {
			this.vertices.add(punto);
		}
	}

}
