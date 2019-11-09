import java.util.Scanner;

public class RecursiveOddCount {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of array elements: ");
		int n = s.nextInt();
		
		System.out.println("Enter array elements: ");
		int[] array = new int[n];
		for(int i=0; i<n; i++) {
			array[i] = s.nextInt();
		}
		
		int count = findOddCount(array,0);
		System.out.print("Odd count in array = "+count);
	}
	
	public static int findOddCount(int[] a, int index) {
		if(index >= a.length) {
			return 0;
		}
		if(a[index]%2 != 0) {
			return 1 + findOddCount(a, index + 1);
		}
		else
			return findOddCount(a, index+1);
	}
}

