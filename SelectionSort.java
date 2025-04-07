package br.aedsii.business;

public class SelectionSort<T extends Comparable<T>> implements IOrdenator<T> {

	private T[] dadosOrdenados;
	private long comparacoes;
	private long movimentacoes;
	private long inicio;
	private long termino;

	public SelectionSort() {
		comparacoes = 0;
		movimentacoes = 0;
	}

	@Override
	public T[] ordenar(T[] dados) {
		dadosOrdenados = dados;
		comparacoes = 0;
		movimentacoes = 0;
		iniciar();

		int n = dadosOrdenados.length;

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				comparacoes++;
				if (dadosOrdenados[j].compareTo(dadosOrdenados[minIndex]) < 0) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(i, minIndex);
			}
		}

		terminar();
		return dadosOrdenados;
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
		return (termino - inicio) / 1_000_000.0;
	}
}
