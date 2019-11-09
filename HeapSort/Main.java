public class Main {

	public static void main(String[] args) {
		//Initializing an array of random numbers
		int[] arr = 
			{18, 30, 21, -1, 53, 65, 70, -1, -1, 25, 46, -1, 35, 61, 32, -1, 15, 8, 17, -1, 55};
		
		System.out.println("\nArray before buliding heap:");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
		
		Heap h = new Heap(arr);
		
		h.buildHeap();
		System.out.println("\nFirst element indicates size of heap:\nHeap after applying build heap:");
		h.printHeap();
		
		h.heapsort();
		System.out.println("\nHeap after applying heap sort:");
		h.printHeap();
	}
}

class Heap{
	public int[] heap;
	public int size;
	
	//Initialize heap with the given array
	Heap(int[] arr){
		this.heap = new int[arr.length+1];
		for(int i=1; i<arr.length+1; i++) {
			this.heap[i] = arr[i-1];
		}
	}
	
	//Calls methods to build a max heap
	public void buildHeap() {
		this.makeComplete();
		for(int i = this.size/2; i >= 1; i--)
			this.heapify(i);
	}
	
	//Makes heap complete by shifting null values to end i.e -1 and initializes heap size
	public void makeComplete() { 
		this.size = 0;
		int index = 1;
		for(int i=1; i<this.heap.length; i++) {
			if(this.heap[i] != -1) {
				int temp = this.heap[index];
				this.heap[index] = this.heap[i];
				this.heap[i] = temp;
				index++;
				this.size++;
			}
		}
		this.heap[0] = this.size;
	}
	
	//Heapify to obtain max heap
	public void heapify(int parent) { 	
    	int largest = parent;
    	int lchild = 2*parent;
        int rchild = 2*parent + 1;
        if (lchild <= this.size && this.heap[lchild] > this.heap[largest]) 
            largest = lchild; 
  
        if (rchild <= this.size && this.heap[rchild] > this.heap[largest]) 
            largest = rchild; 
  
        if (largest != parent) 
        { 
            int temp = this.heap[parent]; 
            this.heap[parent] = this.heap[largest]; 
            this.heap[largest] = temp;
            this.heapify(largest);
        } 
    } 
	
	//Sorts the heap
	public void heapsort() {
		for(int i=this.size; i>=1; i--) {
			int temp = this.heap[i]; 
	        this.heap[i] = this.heap[1]; 
	        this.heap[1] = temp;
	        this.size--;
        	this.heapify(1);
		}
	}
	
	//Prints the heap
	public void printHeap() {
		for(int i=0; i<this.heap.length; i++) {
			System.out.print(this.heap[i] + " ");
		}
		System.out.print("\n");
	}
	  
}
