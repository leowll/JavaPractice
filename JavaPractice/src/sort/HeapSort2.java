package sort;

public class HeapSort2 {
	public void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}

	public void heapify(int[] arr, int i, int maxLen) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;
		if (left < maxLen && arr[largest] < arr[left]) {
			largest = left;
		}
		if (right < maxLen && arr[largest] < arr[right]) {
			largest = right;
		}

		if (largest != i) {
			swap(arr, i, largest);
			heapify(arr, largest, maxLen);
		}
	}

	public void buildMaxHeap(int[] arr, int maxLen) {
		int m = arr.length / 2;
		for (int i = m; i >= 0; i--) {
			heapify(arr, i, maxLen);
		}
	}

	public void heapSort(int[] arr) {
		int maxLen = arr.length;
		buildMaxHeap(arr, maxLen);
		//printArray(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			swap(arr, 0, i);
			//printArray(arr);
			maxLen--;
			heapify(arr, 0, maxLen);
			//printArray(arr);
		}

	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}

	public static void main(String args[]) {
		int arr[] = { 10, 8, 2, 11, 3, 20 };
		HeapSort2 hs = new HeapSort2();
		hs.heapSort(arr);
		HeapSort2.printArray(arr);
	}
}
