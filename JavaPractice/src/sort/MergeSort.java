package sort;

public class MergeSort {

	public void sort(int[] array, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(array, l, m);
			sort(array, m + 1, r);
			merge(array, l, m, r);
		}
	}

	public void merge(int[] array, int l, int m, int r) {
		int L[] = new int[m - l + 1];
		int R[] = new int[r - m];

		for (int i = 0; i < L.length; i++) {
			L[i] = array[l + i];
		}
		for (int j = 0; j < R.length; j++) {
			R[j] = array[m + 1 + j];
		}
		printArray(L);
		printArray(R);
		int i = 0, j = 0, k = l;
		while (i < L.length && j < R.length) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < L.length) {
			array[k] = L[i];
			i++;
			k++;
		}
		while (j < R.length) {
			array[k] = R[j];
			j++;
			k++;
		}
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n-----------");
	}

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] array = { 1, 4, 5, 2, 10, 8 };
		ms.sort(array, 0, array.length - 1);
		MergeSort.printArray(array);
	}
}
