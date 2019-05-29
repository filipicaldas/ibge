package aed2.structure;

public class HashTable<T> {
	/**
	 * O tamanho da Hash Table.
	 */
	private int size;
	/**
	 * A lista do tipo T.
	 */
	private List<T>[] lists;

	/**
	 * Construtor.
	 * @param size O tamanho da lista.
	 */
	public HashTable(int size){
		this.size = size;
		list = new List<>[size];
		while(--size >= 0) lists[size] = new List<>();	
	}

	/**
	 * Função hash que gera a chave da tabela.
	 * @param id O identificador do item.
	 * @return A chave da tabela.
	 */
	private int hash(long id){ 
		return id%size;
	}

	/**
	 * Adiciona o item na tabela.
	 * @param newItem O item.
	 * @return A hash da tabela.
	 */
	public int put(T newItem){
		long id = newItem.id();
		int hash = hash(id);
		List<T> list = lists[id];

		if(list.get(id) == null) {
			list.append(newItem);
			return hash;
		}

		return -1;
	}

	/**
	 * Retorna um item pelo identificador.
	 * @param id O identificador do item.
	 * @return O item.
	 */
	public T get(long id){
		T aux = null;
		List<T> list = lists[hash(id)];

		if(!list.isEmpty()) aux = list.get(id);

		return aux;
	}

	/**
	 * Imprime todos os items das listas que estão na tabela.
	 */
	public void print(){
		for(int i=0; i<M; i++) {
			lists[i].print();
		}
	}
}