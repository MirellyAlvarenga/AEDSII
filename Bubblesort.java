package br.aedsii.business;
public class Bubblesort<T extends Comparable<T>> implements IOrdenator<T> {

	private T[] dadosOrdenados;
	private long comparacoes;
	private long movimentacoes;
	private long inicio;
	private long termino;
	
	public Bubblesort() {
		
		comparacoes = 0;
		movimentacoes = 0;
	}
	
	@Override
	public T[] ordenar (T[] dados) {

		dadosOrdenados = dados;
		
		comparacoes = 0;
		movimentacoes = 0;
		iniciar();
		
		for (int i = dadosOrdenados.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				comparacoes++;
				if (dadosOrdenados[j].compareTo(dadosOrdenados[j + 1]) > 0)
					swap (j, j + 1);
			}
		}
		
		terminar();
		
		return  dadosOrdenados;
	}
	
	private void swap(int i, int j) {
	      
		movimentacoes++;
		
		T temp = dadosOrdenados[i];
	    dadosOrdenados[i] = dadosOrdenados[j];
	    dadosOrdenados[j] = temp;
	}
	
	@Override
	public long getComparacoes() {
		return comparacoes;
	}
	
	@Override
	public long getMovimentacoes() {
		return movimentacoes;
	}
	
	private void iniciar() {
		inicio = System.nanoTime();
	}
	
	private void terminar() {
		termino = System.nanoTime();
	}
	
	@Override
	public double getTempoOrdenacao() {
		
		double tempoTotal;
		
	    tempoTotal = (termino - inicio) / 1_000_000;
	    return tempoTotal;
	}
}