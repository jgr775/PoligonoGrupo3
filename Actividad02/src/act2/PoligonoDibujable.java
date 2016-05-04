package act2;

import java.util.ListIterator;

import javafx.scene.canvas.GraphicsContext;

public class PoligonoDibujable extends PoligonoDobleColaEnlazada{
	public PoligonoDibujable(){
		super();
	}
	
	public void draw(GraphicsContext gc) {

		ListIterator<Punto> it = this.vertices.iterator();
		Punto primero = it.next();
		Punto anterior = primero;
		Punto actual;
		while (it.hasNext()) {
			actual = it.next();
			gc.strokeLine(anterior.getX() * 50 + 320, anterior.getY() * 50 + 235, actual.getX() * 50 + 320,
					actual.getY() * 50 + 235);
			anterior = actual;
		}
		gc.strokeLine(anterior.getX() * 50 + 320, anterior.getY() * 50 + 235, primero.getX() * 50 + 320,
				primero.getY() * 50 + 235);
	}
}
