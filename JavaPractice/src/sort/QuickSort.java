package sort;

public class QuickSort {

	/**
	 * 交换数组中的i和j上的值
	 * 
	 * @param array
	 * @param i
	 * @param j
	 */
	public static void swap(int array[], int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	/**
	 * 从left到right进行一次快速排序。 pivot之前的比array[pivot]小 pivot之后的比array[pivot]大
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	public static int partition(int array[], int left, int right) {
		int pivot = left;
		while (left < right) {
			while (pivot < right) {
				if (array[right] >= array[pivot]) {
					right--;
				} else {
					swap(array, pivot, right);
					pivot = right;
					break;
				}
			}
			while (pivot > left) {
				if (array[left] < array[pivot]) {
					left++;
				} else {
					swap(array, pivot, left);
					pivot = left;
					break;
				}
			}
		}
		return pivot;
	}

	/**
	 * 分治思想
	 * 
	 * @param array
	 * @param left
	 * @param right
	 */
	public static int[] quickSort(int array[], int left, int right) {
		if (left < right) {
			int pivot = partition(array, left, right);
			printArray(array);
			quickSort(array, left, pivot - 1);
			quickSort(array, pivot + 1, right);
		}
		return array;
	}

	public static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		int[] old_array = { 11, 3, 20, 1, 8 };
		int[] new_array = quickSort(old_array, 0, old_array.length - 1);
		printArray(new_array);
	}
}
