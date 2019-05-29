package aed2.structure;

/**
 * Classe que define a celula.
 */
public class Cell<T> {
		/**
		 * O item da celula.
		 */
		T item;
		/**
		 * A próxima célula.
		 */
		Cell<T> next;
		
		/**
		 * Construtor.
		 * @param item O item.
		 */
		Cell(T item){
			this.item = item;
			next = null;
		}
}