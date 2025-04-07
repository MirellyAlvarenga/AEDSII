package br.aedsii.business;

public class MergeSort<T extends Comparable<T>> implements IOrdenator<T> {

	private T[] dadosOrdenados;
	private long comparacoes;
	private long movimentacoes;
	private long inicio;
	private long termino;

	public MergeSort() {
		comparacoes = 0;
		movimentacoes = 0;
	}

	@Override
	public T[] ordenar(T[] dados) {
		dadosOrdenados = dados.clone(); // evita modificar o array original
		comparacoes = 0;
		movimentacoes = 0;
		iniciar();

		mergeSort(dadosOrdenados, 0, dadosOrdenados.length - 1);

		terminar();
		return dadosOrdenados;
	}

	private void mergeSort(T[] array, int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSort(array, inicio, meio);
			mergeSort(array, meio + 1, fim);
			merge(array, inicio, meio, fim);
		}
	}

	private void merge(T[] array, int inicio, int meio, int fim) {
		int n1 = meio - inicio + 1;
		int n2 = fim - meio;

		T[] esquerda = (T[]) new Comparable[n1];
		T[] direita = (T[]) new Comparable[n2];

		for (int i = 0; i < n1; i++) {
			esquerda[i] = array[inicio + i];
			movimentacoes++;
		}

		for (int j = 0; j < n2; j++) {
			direita[j] = array[meio + 1 + j];
			movimentacoes++;
		}

		int i = 0, j = 0;
		int k = inicio;

		while (i < n1 && j < n2) {
			comparacoes++;
			if (esquerda[i].compareTo(direita[j]) <= 0) {
				array[k] = esquerda[i];
				i++;
			} else {
				array[k] = direita[j];
				j++;
			}
			movimentacoes++;
			k++;
		}

		while (i < n1) {
			array[k] = esquerda[i];
			movimentacoes++;
			i++;
			k++;
		}

		while (j < n2) {
			array[k] = direita[j];
			movimentacoes++;
			j++;
			k++;
		}
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
