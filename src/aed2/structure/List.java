package aed2.structure;

/**
 * Define a classe Lista de items do tipo T (no nosso caso será Pessoa).
 */
public class List<T> {
    /**
     * Primeira célula (HEAD) do tipo T. 
     */
    private Cell<T> first;
    /**
     * Ultima célula (TAIL) do tipo T.
     */
	private Cell<T> last;

    /**
     * Construtor.
     */
	public List() {
        /** Esta célula é a sentinela. */
		first = new Cell<T>();
		last = first;
	}

    /**
     * Adiciona novos itens do tipo T no final da lista.
     * @param newItem O item a ser adicionado.
     */
	public void append(T newItem) {
		Cell<T> aux = new Cell<T>();		
		last.next = aux;
		aux.item = newItem;
		last = last.next;
	}

    /**
     * Remove itens pelo identificador.
     * @param id O identificador.
     * @return O item.
     */
    public T remove(long id) {
        Cell<T> aux, antecessor;
        antecessor = first;
        aux = first.next;
        T item = null;

        while (aux != null) {
            if (aux.item.id() == id) {
                antecessor.next = aux.next;
                
                if (aux == last) last = antecessor;
                
                item = aux.item;
            } else {
                antecessor = aux;
                aux = aux.next;
            }
        }

        return item;
    }
    
    /**
     * Encontra um item pelo identificador.
     * @param id O identificador.
     * @return O item.
     */
    public T get(long id) {
        Cell<T> aux;
        aux = first.next;
        T item = null;

        while (aux != null) {
            if (aux.item.id() == id) item = aux.item;
            else aux = aux.next;
        }

        return item;
    }

    /**
     * Retorna TRUE se a lista estiver vazia e FALSE se não estiver vazia.
     * @return O estado da lista.
     */
    public Boolean isEmpty() {
        return first == last;
    }

    /**
     * Imprime todos os itens da lista.
     */
    public void print() {
        Cell<T> aux;
        aux = first.next;

        if (aux == null) {
            System.out.println("The list is empty.");
        } else {
            while (aux != null) {
                System.out.println(aux.item);
                aux = aux.next;
            }
        }
    }    
}