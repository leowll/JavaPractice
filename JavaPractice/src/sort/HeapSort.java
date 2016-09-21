package sort;

public class HeapSort {

	public static int getLeftChild(int i) {
		return 2 * i + 1;
	}

	public static int getRightChild(int i) {
		return 2 * i + 2;
	}

	public static int getParent(int heapSize) {
		return (int) Math.floor((heapSize - 1) / 2);
	}

	public static void swap(int array[], int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	/**
	 * 把一个节点和它的左右节点调整为最大堆
	 * @param array
	 * @param index
	 * @param heapSize
	 */
	public static void maxHeapify(int array[], int index, int heapSize) {
		int iMax, iLeft, iRight;
		while (true) {
			iMax = index;
			iLeft = getLeftChild(index);
			iRight = getRightChild(index);

			if (iLeft < heapSize && array[iLeft] < array[iMax]) {
				iMax = iLeft;
			}
			if (iRight < heapSize && array[iRight] < array[iMax]) {
				iMax = iRight;
			}

			if (iMax != index) {
				swap(array, iMax, index);
				index = iMax;
			} else {
				break;
			}
		}

	}
	/**
	 * 建立最大堆
	 * 从最底层的堆开始往上层循环
	 * @param array
	 */
	public static void buildMaxHeap(int array[]) {
		int i;
		int iParent = getParent(array.length);//最后一个堆的根节点
		for (i = iParent; i >= 0; i--) {
			maxHeapify(array, i, array.length);
		}
	}

	public static int[] heapSort(int array[]) {
		buildMaxHeap(array);
		for (int i = array.length - 1; i >= 0; i--) {
			swap(array, 0, i);
			maxHeapify(array, 0, i);
		}
		return array;
	}

	public static void main(String[] args) {
		int[] old_array = { 11, 3, 20, 1, 8 };
		int[] new_array = heapSort(old_array);
		for (int i : new_array) {
			System.out.print(i + " ");
		}
	}

}
