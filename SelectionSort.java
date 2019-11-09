
public class SelectionSort {
	public static void main(String[] args) {
		
		int[] a = {2,6,1,5,7,0,10,-1};
		sort(a);
		for(int i=0; i<a.length; i++)
			System.out.print(a[i] + " ");
		
	}
	
	static void sort(int[] a) {
		for(int i=0; i<a.length-1; i++) {
			int smallIndex = i;
			for(int j=i+1; j<a.length; j++) {
				if(a[j] < a[smallIndex]) {
					smallIndex = j;
				}
			}
			int temp = a[i];
			a[i] = a[smallIndex];
			a[smallIndex] = temp;
		}
	}
}
