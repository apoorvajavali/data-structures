package dijkstra;

import java.util.*;

public class ShortestPathDijkstra {
	
	public static void main(String[] args) {
		int V = 10;
		int start = 0;
		int[][] Graph = new int[][] {
			{0,9,0,0,0,14,15,0,16,0},
			{0,0,24,0,0,4,0,0,12,0},
			{0,0,0,0,2,0,0,19,0,0},
			{0,0,6,0,0,0,0,6,0,0},
			{0,0,0,11,0,0,0,16,0,0},
			{0,0,18,0,30,0,5,0,0,0},
			{0,0,0,20,0,0,0,44,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,25},
			{0,0,17,0,0,0,0,0,0,0}
		};
		
		printVertices(V);
		System.out.println("\nEdges: ");
		for(int m=0; m<V; m++) {
			for(int n=0; n<10; n++) {
				if(Graph[m][n] != 0)
					System.out.println("("+m+", "+n+") -> "+Graph[m][n]);
			}
		}
		
		Dijkstra d = new Dijkstra(V);
		d.findShortestPath(Graph, start);
		System.out.println("\nAfter running Dijkstra's Algorithm with start vertex 0:\n");
		printVertices(V);
		System.out.println("\nShortest path tree Edges: ");
		for(int i=1; i<V; i++) {
			System.out.println("("+d.parent[i]+","+i+") -> "+Graph[d.parent[i]][i]);
		}
	}
	
	static void printVertices(int V) {
		System.out.print("Vertices: ");
		for(int i=0; i<V; i++) {
			System.out.print(i + " ");
		}
	}

}

class Dijkstra{
	int distance[]; 
    int[] spt; 
    PriorityQueue<Vertex> pq; 
    int V;
    int[][] graph;
    int[] parent;
    
    public Dijkstra(int V) {
    	this.V = V;
    	this.distance = new int[V];
    	this.spt = new int[V];
    	this.pq = new PriorityQueue<Vertex>(V, new Vertex());
    	this.parent = new int[V]; 
    } 
    
    public void findShortestPath(int[][] graph, int start) {
    	this.graph = graph;
    	
		for (int i = 0; i < V; i++) 
			distance[i] = Integer.MAX_VALUE; 
		
		pq.add(new Vertex(start, 0));
		
		distance[start] = 0; 
		parent[start] = -1;
		
		int k = 0;
		while (k < V) {
			int u = pq.remove().parent;
			
			spt[k] = u;
			
			find_adjacentVertices(u);
			
			k++;
		}
    }
    
    public void find_adjacentVertices(int u) {
    	int edge = -1; 
        int newDistance = -1; 
        
        for (int i = 0; i < V; i++) { 
            if(graph[u][i] != 0) {
            	int v = i;
            	  
                if (!sptcontains(v)) { 
                    edge = graph[u][i]; 
                    newDistance = distance[u] + edge; 
      
                    if (newDistance < distance[v]) {
                    	distance[v] = newDistance; 
                    	parent[v] = u;
                    }
                    
                    pq.add(new Vertex(v, distance[v])); 
                } 
            }
        } 
    }
    
    public boolean sptcontains(int v) {
    	for(int i=0; i<V; i++) {
    		if(spt[i] == v) 
    			return true;
    	}
    	return false;
    }
 
}

class Vertex implements Comparator<Vertex>{
	public int parent;
	public int distance;
	
	public Vertex(int p, int d) {
		parent = p;
		distance = d;
	}
	
	public Vertex() {}
	
	public int compare(Vertex v1, Vertex v2) 
    { 
        return Integer.compare(v1.distance, v2.distance); 
    } 
}
