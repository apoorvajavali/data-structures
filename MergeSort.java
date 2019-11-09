
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {6,20,8,19,56,23,87,41,49,53};
		sortArray(arr);
	}
	
	public static void sortArray(int[] arr) {
		int len = arr.length;
		if(len < 2) 
			return;
		int mid = len/2;
		int[] left = new int[mid], right = new int[len-mid];
		for(int i=0; i<mid; i++) {
			left[i] = arr[i];
		}
		for(int j=0; j<len-mid; j++) {
			right[j] = arr[j+mid];
		}
		sortArray(left);
		sortArray(right);
		merge(left, right, arr);
	}
	
	public static void merge(int[] left, int right[], int[] arr) {
		int i=0, j=0, k=0;
		while(i<left.length && j<right.length) {
			if(left[i] > right[j]) {
				arr[k] = right[j];
				j++; k++;
			} else {
				arr[k] = left[i];
				i++; k++;
			}
		}
		if(i<left.length) {
			while(i<left.length) {
				arr[k] = left[i];
				i++; k++;
			}
		}else {
			while(j<right.length) {
				arr[k] = right[j];
				j++; k++;
			}
		}
		for(int a: arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}
