import java.util.*; 
public class TopologicalSort {
	
	public static void main(String[] args) {
		int V = 10;
		int[][] Graph = new int[][] {
			{0,9,0,0,0,14,15,0,16,0}, // There is an edge from Vertex 0 to Vertex 8: i.e. E(0 -> 8) = 16
			{0,0,24,0,0,4,0,0,12,0},
			{0,0,0,0,2,0,0,19,0,0},
			{0,0,6,0,0,0,0,6,0,0},
			{0,0,0,0,0,0,0,16,0,0}, 
			{0,0,18,0,30,0,5,0,0,0},
			{0,0,0,20,0,0,0,44,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,25}, // There is no edge from Vertex 8 to Vertex 0: i.e E(8 -> 0) = 0
			{0,0,17,0,0,0,0,0,0,0}
		};
		
		System.out.println("\nDirected 'Acyclic' Graph:\n");
		printGraph(Graph, V);
		
		System.out.println("\nTopological Order of Directed 'Acyclic' Graph is: ");
		topologicalSort(V, Graph);
		
		System.out.println("\n\nAdded an edge of cost 16 from vertex 8 to vertex 0 to make the graph cyclic...");
		Graph[8][0] = 16;
		
		System.out.println("\nDirected 'Cyclic' Graph:\n");
		printGraph(Graph, V);
		
		System.out.println("\nTopological Order of Directed 'Cyclic' Graph is: ");
		topologicalSort(V, Graph);

	}
	
	static void printGraph(int[][] Graph, int V) {
		for(int i=0; i<V; i++) {
			for(int j=0; j<V; j++) {
				System.out.print(Graph[i][j] + "\t");
			}
			System.out.println("");
		}
	}
	
	static void printTopologicalOrder(Stack<Integer> stack) {
		while (!stack.empty()) 
			System.out.print(stack.pop() + " "); 
	}
	
	static void dfsTopologicalSort(int v, int[][] Graph, boolean visited[], Stack<Integer> stack, int V) { 
		visited[v] = true; 
		Integer i; 
		
		
		ArrayList<Integer> adjVertices = getAdjacentVertices(v, Graph, V);
		Iterator<Integer> it = adjVertices.iterator(); 
		while (it.hasNext()) { 
			i = it.next(); 
			if (visited[i] == false) {
				dfsTopologicalSort(i, Graph, visited, stack, V); 
			} else if (!stack.contains(i)) {
				printTopologicalOrder(stack);
				System.out.println("\nOrdering stopped! Cycle detected at " + v);
				System.exit(0);
			}
		} 
		
		stack.push(new Integer(v)); 
	} 

	static void topologicalSort(int V, int[][] Graph) { 
		Stack<Integer> stack = new Stack<Integer>(); 
		
		boolean visited[] = new boolean[V]; 
		for (int i = 0; i < V; i++) {
			visited[i] = false; 
		}
		
		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				dfsTopologicalSort(i, Graph, visited, stack, V); 
			}
		}
		
		printTopologicalOrder(stack);
	} 
	
	
	static ArrayList<Integer> getAdjacentVertices(int v, int[][] Graph, int V) {
		ArrayList<Integer> adjVertices = new ArrayList<Integer>();
		for (int i = 0; i < V; i++) { 
            if(Graph[v][i] != 0) {
            	adjVertices.add(i);
            }
		}
		return adjVertices;
	}

}