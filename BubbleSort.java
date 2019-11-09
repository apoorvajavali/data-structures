
public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = {6,20,8,19,56,23,87,41,49,53};
		bubbleSort(arr);
	}
	
	static void bubbleSort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int a: arr) {
			System.out.print(a+ " ");
		}
	}

}
